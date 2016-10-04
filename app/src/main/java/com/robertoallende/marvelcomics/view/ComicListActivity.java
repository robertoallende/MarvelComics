package com.robertoallende.marvelcomics.view;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.robertoallende.marvelcomics.MarvelComicsApp;
import com.robertoallende.marvelcomics.R;
import com.robertoallende.marvelcomics.Utils;
import com.robertoallende.marvelcomics.controller.ComicController;
import com.robertoallende.marvelcomics.entity.Comic;
import com.robertoallende.marvelcomics.event.FetchComicListEvent;
import com.robertoallende.marvelcomics.model.ComicListLocalModel;
import com.robertoallende.marvelcomics.view.helper.ComicRecyclerViewAdapter;
import com.robertoallende.marvelcomics.view.helper.RecyclerViewActivity;
import com.robertoallende.marvelcomics.view.helper.SimpleBackgroundTask;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class ComicListActivity extends RecyclerViewActivity {

    // private ComicAdapter comicAdapter;
    private boolean dataDirty = true;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataDirty = true;
        setContentView(R.layout.activity_comic_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_comic_list);
        if (mRecyclerView != null) {
            int columnCount = getResources().getInteger(R.integer.grid_columns);
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, columnCount));
        }

        mRecyclerView.setAdapter(new ComicRecyclerViewAdapter(this, new ArrayList<Comic>()));

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dataDirty) {
                    return;
                }

                GridLayoutManager layoutManager = (GridLayoutManager) mRecyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();
                if (pastVisiblesItems + visibleItemCount >= totalItemCount) {
                    Timber timber = MarvelComicsApp.getInstance().getTimber();
                    timber.d("Geting more comics");
                    checkNetwork();
                    ComicController comicController = ComicController.getInstance(getApplicationContext());
                    comicController.fetchComicList();

                }
            }
        });

        checkNetwork();
        EventBus.getDefault().register(this);

    }

    @Subscribe
    public void onEventMainThread(FetchComicListEvent eventResult) {
        if (eventResult.isSuccess()) {
            onUpdateEvent();
        }
    }

    private void onUpdateEvent() {
        if(isVisible()) {
            refreshList();
        } else {
            dataDirty = true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            EventBus.getDefault().unregister(this);
        } catch (Throwable t){
            //this may crash if registration did not go through. just be safe
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ComicController comicController = ComicController.getInstance(this);
        comicController.fetchComicList();
        if(dataDirty) {
            refreshList();
            dataDirty = false;
        }
    }

    private void refreshList() {

        new SimpleBackgroundTask<List<Comic>>(this) {
            @Override
            protected List<Comic> onRun() {
                ComicListLocalModel comicListLocalModel = ComicListLocalModel.getInstance(getActivity());
                List<Comic> comicList = comicListLocalModel.recover();
                return comicList;
            }

            @Override
            protected void onSuccess(List<Comic> comicList) {
                if (mRecyclerView.getAdapter() != null) {
                    ComicRecyclerViewAdapter adapter = (ComicRecyclerViewAdapter) mRecyclerView.getAdapter();
                    adapter.replaceItems(comicList);
                } else {
                    mRecyclerView.setAdapter(new ComicRecyclerViewAdapter(getActivity(), comicList));
                }
            }
        }.execute();
    }

    public void checkNetwork() {
        if (! Utils.isOnline(this)) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout)
                    findViewById(R.id.activity_comic_list_coordinatorlayout);
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, getResources().getString(R.string.error_connection), Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }


}
