package com.robertoallende.marvelcomics.event;

public abstract class MarvelComicsEvent {

    private Boolean mSuccess;

    public MarvelComicsEvent(Boolean isSuccess) {
        this.mSuccess = isSuccess;
    }

    public Boolean isSuccess() {
        return mSuccess;
    }

}
