package com.robertoallende.marvelcomics.job;

import android.content.Context;
import android.util.Log;

import com.birbit.android.jobqueue.Params;
import com.robertoallende.marvelcomics.MarvelComicsApp;
import com.robertoallende.marvelcomics.entity.Comic;
import com.robertoallende.marvelcomics.event.FetchComicListEvent;
import com.robertoallende.marvelcomics.model.ComicListLocalModel;
import com.robertoallende.marvelcomics.model.ComicListRemoteModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import timber.log.BuildConfig;
import timber.log.Timber;

public class FetchComicListRemoteJob extends MarvelComicsJob{

    private Context mContext;

    public FetchComicListRemoteJob(Context context) {
        super(new Params(NETWORK_PRIORITY).requireNetwork().groupBy(NETWORK_TASK).singleInstanceBy("fetch-comic-list"));
        mContext = context;
    }

    @Override
    public void onRun() throws Throwable {
        Timber timber = MarvelComicsApp.getInstance().getTimber();
        timber.d("To Get ComicList", "");

        ComicListLocalModel comicListLocalModel = ComicListLocalModel.getInstance(mContext);

        ComicListRemoteModel comicListRemoteModelModel = new ComicListRemoteModel();
        List<Comic> comicList = comicListRemoteModelModel.getComicList( comicListLocalModel.size()  );
        FetchComicListEvent fetchComicListEvent;

        timber.d("ComicList", comicList);

        if (comicList != null && comicList.size() > 0) {

            comicListLocalModel.save(comicList);
            fetchComicListEvent = new FetchComicListEvent(true);
        } else {
            fetchComicListEvent = new FetchComicListEvent(false);
        }

        EventBus.getDefault().post(fetchComicListEvent);
    }

}