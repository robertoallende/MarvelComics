package com.robertoallende.marvelcomics.job;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

public abstract class MarvelComicsJob extends Job {
    public static int LOW = 0;
    public static int MID = 500;
    public static int HIGH = 1000;

    public static int NETWORK_PRIORITY = LOW;
    public static int LOCAL_PRIORITY = HIGH;

    public static String NETWORK_TASK = "network-task";
    public static String LOCAL_TASK = "local-task";

    protected MarvelComicsJob(Params params) {
        super(params);
    }

    @Override
    public void onAdded() {

    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }
}
