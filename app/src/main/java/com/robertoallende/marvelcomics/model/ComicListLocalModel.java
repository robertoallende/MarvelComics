package com.robertoallende.marvelcomics.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.robertoallende.marvelcomics.Config;
import com.robertoallende.marvelcomics.entity.Comic;

import java.util.List;

public class ComicListLocalModel {

    private static ComicListLocalModel instance;
    private SharedPreferences mPrefs;
    private Context mContext;

    public ComicListLocalModel(Context context) {
        mContext = context;
        mPrefs = mContext.getSharedPreferences(Config.APP_KEY, Context.MODE_PRIVATE);
    }

    public synchronized static ComicListLocalModel getInstance(Context context) {
        if(instance == null) {
            instance = new ComicListLocalModel(context);
        }
        return instance;
    }

    public void save(List<Comic> results) {
        String resultAsJSON;

        List<Comic> comicList = recover();
        if (comicList != null && comicList.size() > 0) {
            comicList.addAll(results);
            resultAsJSON = new Gson().toJson(comicList);
        } else {
            resultAsJSON = new Gson().toJson(results);
        }
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(Config.APP_KEY, resultAsJSON);
        editor.apply();

    }

    public List<Comic> recover() {
        String resultAsJSON = mPrefs.getString(Config.APP_KEY, "");
        List<Comic>  result =
                new Gson().fromJson(resultAsJSON, new TypeToken<List<Comic>>() {
                }.getType());
        return result;
    }

    public int size() {
        List<Comic> comicList = recover();
        if (comicList == null) {
            return 0;
        }
        return comicList.size();
    }

}
