package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;
import java.util.List;

public class CreatorList implements Serializable {

    public Integer available; // The number of total available creators in this list. Will always be greater than or equal to the "returned" value.,
    public Integer returned; //The number of creators returned in this collection (up to 20).,
    public String collectionURI; // The path to the full list of creators in this collection.,
    public List<CreatorSummary> items; // The list of returned creators in this collection.

}
