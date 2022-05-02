package com.example.classdifficultyfrontend;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class SystemTest {

    public void test_login() throws Exception{
        onView(withId(R.id.Username_input)).perform(typeText("testcreate"),closeSoftKeyboard());
        onView(withId(R.id.Pass_input)).perform(typeText("create"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textUser)).check(matches(withText(" ")));
    }


}
