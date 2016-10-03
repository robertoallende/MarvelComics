package com.robertoallende.marvelcomics;

public class Config {

    public static final String APP_KEY = "marvel-comics";
    public static final String MARVEL_PUBLIC_KEY = "92fb31cc0e6a07e78112363fe463cabe";
    public static final String MARVEL_PRIVATE_KEY = "4e5dc5e6341bab5fb8e03f10054f328e00983e94";

    public static final String MARVEL_END_POINT = "http://gateway.marvel.com/";

    public static final String getHash(String ts) {
        return Utils.md5(ts + MARVEL_PRIVATE_KEY + MARVEL_PUBLIC_KEY);
    }

}
