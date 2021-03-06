package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;

public class StorySummary implements Serializable {

    public String resourceURI; // The path to the individual story resource.,
    public String name; // The canonical name of the story.,
    public String type; // The type of the story (interior or cover).

}
