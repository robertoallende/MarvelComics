package com.robertoallende.marvelcomics.entity;

import java.io.Serializable;

public class Image implements Serializable {

    private static String small = "portrait_small";	// 50x75px
    private static String medium = "portrait_medium"; // 100x150px
    private static String xlarge = "portrait_xlarge"; // 150x225px
    private static String fantastic = "portrait_fantastic"; // 168x252px
    private static String uncanny = "portrait_uncanny"; // 300x450px
    private static String incredible = "portrait_incredible"; // 216x324px


    public String path; // The directory path of to the image.,
    public String extension; // The file extension for the image.

    public String getFullUrl() {
        return path + "/" + uncanny + "." + extension;
    }

}
