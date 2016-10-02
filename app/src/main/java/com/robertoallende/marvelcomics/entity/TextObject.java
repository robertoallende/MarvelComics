package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;

public class TextObject implements Serializable {

    public String type; // (string, optional): The canonical type of the text object (e.g. solicit text, preview text, etc.).,
    public String language; // (string, optional): The IETF language tag denoting the language the text object is written in.,
    public String text; // (string, optional): The text.

}
