package com.robertoallende.marvelcomics.view;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.robertoallende.marvelcomics.R;
import com.robertoallende.marvelcomics.controller.ComicController;
import com.robertoallende.marvelcomics.entity.Comic;
import com.robertoallende.marvelcomics.event.FetchComicListEvent;
import com.robertoallende.marvelcomics.model.ComicListLocalModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class ComicListActivity extends BaseActivity {

    // private ComicAdapter comicAdapter;
    private boolean dataDirty = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataDirty = true;
        setContentView(R.layout.activity_comic_list);

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
                ComicListLocalModel comicListLocalModel = ComicListLocalModel.getInstance(weakActivity.get());
                List<Comic> comicList = comicListLocalModel.recover();
                return comicList;
            }

            @Override
            protected void onSuccess(List<Comic> comicList) {
                TextView textView = (TextView) findViewById(R.id.comic_list_text);
                String text = "";
                if (comicList == null || comicList.size() == 0) {
                    return;
                }

                for (Comic comic : comicList) {
                    text += comic.title + "\n";
                }

                textView.setText(text);
            }
        }.execute();
    }

}
