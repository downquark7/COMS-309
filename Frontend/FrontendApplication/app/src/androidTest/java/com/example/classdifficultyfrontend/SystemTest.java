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

import java.util.Random;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class SystemTest {
    Random random = new Random();
    int randomNumber = random.nextInt(15) + 65;

    private static final int SIMULATED_DELAY_MS = 500;

    @Rule   // needed to launch the activity
    public ActivityTestRule<Login> activityRule = new ActivityTestRule<>(Login.class);

    @Test
    public void test_login() throws Exception{
        onView(withId(R.id.Username_input)).perform(typeText("testcreate"),closeSoftKeyboard());
        onView(withId(R.id.Pass_input)).perform(typeText("create"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textUser)).check(matches(withText("Username: " + "testcreate" + "\n" +
                "Authentication Method: " + "create" + "\n" +
                "Authentication Data: " + "create")));
    }

    @Rule   // needed to launch the activity
    public ActivityTestRule<User_Create> activitycreate = new ActivityTestRule<>(User_Create.class);

    @Test
    public void test_create_user_fail() throws Exception{
        onView(withId(R.id.Username_input)).perform(typeText("testcreate"),closeSoftKeyboard());
        onView(withId(R.id.Pass_input)).perform(typeText("create"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textUser)).check(matches(withText(" ")));
    }
    @Test
    public void test_create_user_succeed() throws Exception{
        onView(withId(R.id.Username_input)).perform(typeText("test" + randomNumber),closeSoftKeyboard());
        onView(withId(R.id.Pass_input)).perform(typeText("create"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textUser)).check(matches(withText("")));
    }


}
