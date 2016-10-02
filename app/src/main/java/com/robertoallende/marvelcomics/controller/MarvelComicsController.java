package com.robertoallende.marvelcomics.controller;

import android.content.Context;

import com.birbit.android.jobqueue.JobManager;
import com.robertoallende.marvelcomics.MarvelComicsApp;

public class MarvelComicsController {

    protected JobManager mJobManager;
    private Context mContext;

    public MarvelComicsController(Context context) {
        mContext = context;
        mJobManager = MarvelComicsApp.getInstance().getJobManager();
    }

    public Context getContext() {
        return mContext;
    }
}
