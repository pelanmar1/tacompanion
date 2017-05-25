package com.example.tacompanion.tacompanion;

/**
 * Created by Pedro Lanzagorta M on 11/30/2016.
 */
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Toast;

import com.example.tacompanion.tacompanion.activities.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LogInActivityTest {
    private String username;
    private String password;
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    @Before
    public void initValidString() {
        username="teacompaño@tacompanion.com";
        password="mostaza";
    }
    @Test
    public void logInTest() {
        onView(withId(R.id.et_username)).check(matches(isDisplayed()))
                .perform(replaceText(username), closeSoftKeyboard());
        onView(withId(R.id.et_password)).check(matches(isDisplayed()))
                .perform(replaceText(password), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()))
                .perform(click());
    }
}


