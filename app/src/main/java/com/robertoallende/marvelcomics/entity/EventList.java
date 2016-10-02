package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;
import java.util.List;

public class EventList implements Serializable {

    public Integer available; // The number of total available events in this list. Will always be greater than or equal to the "returned" value.,
    public Integer returned; // The number of events returned in this collection (up to 20).,
    public String collectionURI; // The path to the full list of events in this collection.,
    public List<EventSummary> items; // The list of returned events in this collection.

}
