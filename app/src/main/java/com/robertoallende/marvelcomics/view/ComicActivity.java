package com.robertoallende.marvelcomics.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.robertoallende.marvelcomics.R;
import com.robertoallende.marvelcomics.entity.Comic;

public class ComicActivity extends AppCompatActivity {

    private static String COMIC = "COMIC";

    public static Intent makeIntent(Context context, Comic comic){
        Intent intent = new Intent(context, ComicActivity.class);
        intent.putExtra(COMIC, comic);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
