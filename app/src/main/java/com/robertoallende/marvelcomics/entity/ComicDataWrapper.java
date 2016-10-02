package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;

public class ComicDataWrapper implements Serializable {

    public Integer code; // The HTTP status code of the returned result.,
    public String status; // A string description of the call status.,
    public String copyright; // The copyright notice for the returned result.,
    public String attributionText; // The attribution notice for this result. Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API.,
    public String attributionHTML; // An HTML representation of the attribution notice for this result. Please display either this notice or the contents of the attributionText field on all screens which contain data from the Marvel Comics API.,
    public ComicDataContainer data; // The results returned by the call.,
    public String etag; // A digest value of the content returned by the call.

}
