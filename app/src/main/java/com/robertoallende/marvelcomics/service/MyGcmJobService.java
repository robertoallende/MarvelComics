package com.robertoallende.marvelcomics.service;

import android.support.annotation.NonNull;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.scheduling.GcmJobSchedulerService;
import com.robertoallende.marvelcomics.MarvelComicsApp;

public class MyGcmJobService extends GcmJobSchedulerService {
    @NonNull
    @Override
    protected JobManager getJobManager() {
        return MarvelComicsApp.getInstance().getJobManager();
    }
}