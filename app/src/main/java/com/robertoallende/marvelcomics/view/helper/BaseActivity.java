package com.robertoallende.marvelcomics.view.helper;

import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private boolean visible = false;

    @Override
    protected void onResume() {
        super.onResume();
        visible = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        visible = false;
    }

    public boolean isVisible() {
        return visible;
    }
}