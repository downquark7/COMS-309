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

import schedule.ScheduleActivity;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class NavigationTest {
    Random rand = new Random();
    int randomNumber = rand.nextInt(15) + 65;

    private static final int SIMULATED_DELAY_MS = 500;
    @Rule
    public ActivityTestRule<ScheduleActivity> activityRule = new ActivityTestRule<>(Login.class);

    @Test
    public void test_days() throws Exception{
//        onView(withId(R.id.TextView))
    }
    @Test
    public void test_cells() throws Exception{
        o//nView(withId())
        //onView(withId(R.id.cellHourText)).perform
    }
}
