package com.robertoallende.marvelcomics.event;

public class FetchComicListEvent extends MarvelComicsEvent{

    public FetchComicListEvent(Boolean isSuccess) {
        super(isSuccess);
    }

}
