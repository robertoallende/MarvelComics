package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;
import java.util.List;

public class ComicDataContainer implements Serializable {

    public Integer offset; // The requested offset (number of skipped results) of the call.,
    public Integer limit; // The requested result limit.,
    public Integer total; // The total number of resources available given the current filter set.,
    public Integer count; // The total number of results returned by this call.,
    public List<Comic> results; // The list of comics returned by the call

}
