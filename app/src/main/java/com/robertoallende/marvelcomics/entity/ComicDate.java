package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;
import java.util.Date;

public class ComicDate implements Serializable {

    public String type; // A description of the date (e.g. onsale date, FOC date).,
    public Date date; // The date.

}
