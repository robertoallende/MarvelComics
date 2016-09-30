package com.robertoallende.marvelcomics.service;

import android.support.annotation.NonNull;
import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.scheduling.FrameworkJobSchedulerService;
import com.robertoallende.marvelcomics.MarvelComicsApp;

public class MyJobService extends FrameworkJobSchedulerService {
    @NonNull
    @Override
    protected JobManager getJobManager() {
        return MarvelComicsApp.getInstance().getJobManager();
    }
}