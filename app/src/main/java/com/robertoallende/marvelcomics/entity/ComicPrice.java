package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;

public class ComicPrice implements Serializable {

    public String type; // A description of the price (e.g. print price, digital price).,
    public float price; // The price (all prices in USD).

}
