package com.robertoallende.marvelcomics.controller;

import android.content.Context;

import com.robertoallende.marvelcomics.job.FetchComicListLocalJob;
import com.robertoallende.marvelcomics.job.FetchComicListRemoteJob;

public class ComicController extends MarvelComicsController {

    private static ComicController instance;

    public ComicController(Context context) {
        super(context);
    }

    public synchronized static ComicController getInstance(Context context) {
        if(instance == null) {
            instance = new ComicController(context);
        }
        return instance;
    }

    public void fetchComicList() {
        // Fetch comic list from localDB
        //mJobManager.addJobInBackground(new FetchComicListLocalJob(getContext()));

        // Fetch comic list from API
        mJobManager.addJobInBackground(new FetchComicListRemoteJob(getContext()));
    }

}
