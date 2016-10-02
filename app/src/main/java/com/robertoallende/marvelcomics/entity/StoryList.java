package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;
import java.util.List;

public class StoryList implements Serializable {

    public Integer available; // The number of total available stories in this list. Will always be greater than or equal to the "returned" value.,
    public Integer returned; // The number of stories returned in this collection (up to 20).,
    public String collectionURI; // The path to the full list of stories in this collection.,
    List<StorySummary> items; // The list of returned stories in this collection.

}
