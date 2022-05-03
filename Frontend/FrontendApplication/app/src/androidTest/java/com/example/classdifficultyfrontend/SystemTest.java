package com.example.classdifficultyfrontend;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringEndsWith.endsWith;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class SystemTest {

    private static final int SIMULATED_DELAY_MS = 500;

    @Rule   // needed to launch the activity
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test_login() throws Exception{
        onView(withId(R.id.Username_input)).perform(typeText("testcreate"),closeSoftKeyboard());
        onView(withId(R.id.Pass_input)).perform(typeText("create"),closeSoftKeyboard());
        onView(withId(R.id.Pass_input)).perform(typeText("create"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textUser)).check(matches(withText(" ")));
    }


}
