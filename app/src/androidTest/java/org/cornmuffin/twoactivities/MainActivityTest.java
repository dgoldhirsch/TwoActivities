package org.cornmuffin.twoactivities;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void sending() {
        onView(withId(R.id.editText_main)).perform(typeText("Howdy!"));
        onView(withId(R.id.editText_main)).perform(closeSoftKeyboard());
        onView(withId(R.id.button_main)).perform(click());

        onView(withId(R.id.button_second)).check(matches(isDisplayed())); // we're now in the second activity
        onView(withText("Howdy!")).check(matches(isDisplayed()));
    }

    @Test
    public void sendingWithoutAMessage() {
        onView(withId(R.id.button_main)).perform(click());

        onView(withId(R.id.button_main)).check(matches(isDisplayed())); // stays in main activity
        onView(withText("Please enter a message to be sent")).
                inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }
}
