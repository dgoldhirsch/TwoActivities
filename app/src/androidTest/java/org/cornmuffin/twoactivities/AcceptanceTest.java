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
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class AcceptanceTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void sendingAMessageAndReplying() {
        // When I send a message...
        onView(withId(R.id.editText_main)).perform(typeText("Howdy!"));
        onView(withId(R.id.editText_main)).perform(closeSoftKeyboard());
        onView(withId(R.id.button_main)).perform(click());

        // Then, I'm sent to a page that solicits a reply.
        onView(withId(R.id.button_second)).check(matches(isDisplayed())); // we're now at the replying view
        onView(withText("Howdy!")).check(matches(isDisplayed()));

        // And then, when I submit a reply...
        onView(withId(R.id.editText_second)).perform(typeText("Nice to meet you!"));
        onView(withId(R.id.editText_second)).perform(closeSoftKeyboard());
        onView(withId(R.id.button_second)).perform(click());

        // I'm sent back to the original view of my message, this time with the reply.
        onView(withId(R.id.button_main)).check(matches(isDisplayed())); // we're back to the original view
        onView(withId(R.id.editText_main)).check(matches(isDisplayed())); // original message still shown
        onView(withId(R.id.text_message_reply)).check(matches(isDisplayed())); // reply shown, also
    }
}
