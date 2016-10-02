package com.robertoallende.marvelcomics.model;

import com.robertoallende.marvelcomics.entity.ComicDataWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelApi {


    @GET("/v1/public/comics")
    Call<ComicDataWrapper> getComicList(@Query("ts") String ts,
                                        @Query("apikey") String apiKey,
                                        @Query("hash") String hash);


}
