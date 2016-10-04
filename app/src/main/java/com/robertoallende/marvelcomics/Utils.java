package com.robertoallende.marvelcomics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Display;

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

    public static boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static Point getDisplayPoints(Activity context){
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    public static int getWidth(Activity context) {
        return getDisplayPoints(context).x;
    }

    public static int getHeight(Activity context) {
        return getDisplayPoints(context).y;
    }

    public static String checkNullString(String item) {
        if (item == null) {
            return "";
        }
        return item;
    }
}
