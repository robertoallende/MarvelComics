package com.robertoallende.marvelcomics.view;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.birbit.android.jobqueue.JobManager;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.robertoallende.marvelcomics.MarvelComicsApp;
import com.robertoallende.marvelcomics.R;
import com.robertoallende.marvelcomics.controller.ComicController;
import com.robertoallende.marvelcomics.entity.Comic;
import com.robertoallende.marvelcomics.event.FetchComicListEvent;
import com.robertoallende.marvelcomics.model.ComicListLocalModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class ComicList extends BaseActivity {

    // private ComicAdapter comicAdapter;
    private boolean dataDirty = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataDirty = true;
        setContentView(R.layout.activity_comic_list);

        /*
        Init Adapter
        ListView listView = (ListView) findViewById(R.id.tweet_list);
        tweetAdapter = new TweetAdapter(getLayoutInflater());
        findViewById(R.id.send_tweet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text = (EditText) findViewById(R.id.edit_status);
                if(text.getText().toString().trim().length() > 0) {
                    sendTweet(text.getText().toString());
                    text.setText("");
                }
            }
        });
        listView.setAdapter(tweetAdapter);
        */

        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
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
        TextView textView = (TextView) findViewById(R.id.comic_list_text);
        String text = "";

        ComicListLocalModel comicListLocalModel = ComicListLocalModel.getInstance(this);
        List<Comic> comicList = comicListLocalModel.recover();

        if (comicList == null || comicList.size() == 0) {
            return;
        }

        for (Comic comic : comicList) {
            text += comic.title + "\n";
        }

        textView.setText(text);

    }

}
