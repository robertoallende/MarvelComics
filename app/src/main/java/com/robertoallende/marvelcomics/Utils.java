package com.robertoallende.marvelcomics;

import java.security.MessageDigest;

public class Utils {

    public static final String md5(final String toEncrypt) {
        // Following:
        // http://stackoverflow.com/questions/3934331/how-to-hash-a-string-in-android
        try {
            final MessageDigest digest = MessageDigest.getInstance("md5");
            digest.update(toEncrypt.getBytes());
            final byte[] bytes = digest.digest();
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(String.format("%02X", bytes[i]));
            }
            return sb.toString().toLowerCase();
        } catch (Exception exc) {
            return ""; // Impossibru!
        }
    }

}
