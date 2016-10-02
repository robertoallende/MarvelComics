package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;
import java.util.List;

public class CharacterList implements Serializable {

    public Integer available; // The number of total available characters in this list. Will always be greater than or equal to the "returned" value.,
    public Integer returned; // The number of characters returned in this collection (up to 20).,
    public String collectionURI;  // The path to the full list of characters in this collection.,
    public List<CharacterSummary> items; // The list of returned characters in this collection.

}
