package com.robertoallende.marvelcomics.job;

import android.content.Context;
import android.util.Log;

import com.birbit.android.jobqueue.Params;
import com.robertoallende.marvelcomics.entity.Comic;
import com.robertoallende.marvelcomics.event.FetchComicListEvent;
import com.robertoallende.marvelcomics.model.ComicListLocalModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class FetchComicListLocalJob  extends MarvelComicsJob {

    Context mContext;

    public FetchComicListLocalJob(Context context) {
        super(new Params(LOCAL_PRIORITY).requireNetwork().groupBy(LOCAL_TASK).singleInstanceBy("fetch-comic-list"));
        mContext = context;
    }

    @Override
    public void onRun() throws Throwable {
        Log.v("MarvelComics", "------> To Get Local ComicList");
        ComicListLocalModel comicListLocalModel = ComicListLocalModel.getInstance(mContext);
        List<Comic> comicList = comicListLocalModel.recover();
        FetchComicListEvent fetchComicListEvent;

        if (comicList != null && comicList.size() > 0) {
            fetchComicListEvent = new FetchComicListEvent(true);
        } else {
            fetchComicListEvent = new FetchComicListEvent(false);
        }

        EventBus.getDefault().post(fetchComicListEvent);
    }
}
