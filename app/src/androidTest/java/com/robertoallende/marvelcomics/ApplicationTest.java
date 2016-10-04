package com.robertoallende.marvelcomics;

import android.app.Application;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import com.robertoallende.marvelcomics.view.ComicListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }


    @Rule
    public ActivityTestRule<ComicListActivity> mActivityRule = new ActivityTestRule<>(
            ComicListActivity.class);

    @Test
    public void navigateApp() {

        onView(withId(R.id.recycler_view_comic_list)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, click()));

        Espresso.pressBack();

    }
}