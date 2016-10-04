package com.robertoallende.marvelcomics.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.robertoallende.marvelcomics.MarvelComicsApp;
import com.robertoallende.marvelcomics.R;
import com.robertoallende.marvelcomics.Utils;
import com.robertoallende.marvelcomics.entity.CharacterList;
import com.robertoallende.marvelcomics.entity.CharacterSummary;
import com.robertoallende.marvelcomics.entity.Comic;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

public class ComicActivity extends AppCompatActivity {

    private static String COMIC = "COMIC";
    private Comic mComic;

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

        Bundle extras = getIntent().getExtras();
        mComic = (Comic) extras.getSerializable(COMIC);
        if (mComic != null) {
            TextView titleView = (TextView) findViewById(R.id.comic_activity_title);
            //TextView descriptionView = (TextView) findViewById(R.id.comic_activity_description);

            titleView.setText(Utils.checkNullString(mComic.title));
            // descriptionView.setText(Html.escapeHtml());

            WebView webView = (WebView) findViewById(R.id.webView);
            webView.loadDataWithBaseURL(null, Utils.checkNullString(mComic.description), "text/html", "utf-8", null);



            CharacterList characters = mComic.characters;
            if (characters != null && characters.items != null && characters.items.size() > 0) {
                TextView charactersTitleView = (TextView) findViewById(R.id.comic_activity_characters_title);
                charactersTitleView.setVisibility(View.VISIBLE);

                String charactersList = "";
                for (CharacterSummary character : characters.items) {
                    charactersList += " " + character.name + "\n";
                }
                TextView charactersView = (TextView) findViewById(R.id.comic_activity_characters);
                charactersView.setText(charactersList);
            }

        }

        CoordinatorLayout coordinatorLayout = (CoordinatorLayout)
                findViewById(R.id.comic_activity_layout);



        Timber timber = MarvelComicsApp.getInstance().getTimber();
        timber.d("MARVELCOMICS - SIZE: " + String.valueOf( Utils.getWidth(this) ));

        ImageView imageView = (ImageView) findViewById(R.id.comic_header);
        Picasso.with(this)
                .load(mComic.thumbnail.getFullUrl())
                .placeholder(R.drawable.marvel_portrait_uncanny)
                .resize(Utils.getWidth(this), 0)
                .into(imageView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
