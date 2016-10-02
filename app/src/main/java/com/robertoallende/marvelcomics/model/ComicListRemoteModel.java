package com.robertoallende.marvelcomics.model;

import android.provider.Settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robertoallende.marvelcomics.Config;
import com.robertoallende.marvelcomics.entity.Comic;
import com.robertoallende.marvelcomics.entity.ComicDataWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ComicListRemoteModel {

    private Gson mGson;
    private Retrofit mRetrofit;

    public ComicListRemoteModel() {

        mGson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Config.MARVEL_END_POINT)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .build();

    }

    public List<Comic> getComicList() {
        Response<ComicDataWrapper> callResult = null;
        MarvelApi marvelApi = mRetrofit.create(MarvelApi.class);

        String ts = String.valueOf(System.currentTimeMillis());
        Call<ComicDataWrapper> call = marvelApi.getComicList(ts, Config.MARVEL_PUBLIC_KEY, Config.getHash(ts));

        try {
            callResult = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (callResult == null || callResult.body() == null || callResult.body().data == null ||
                callResult.body().data.results == null) {
            return null;
        }

        return callResult.body().data.results;
    }

}
