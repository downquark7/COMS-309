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
    public class ToastMatcher extends TypeSafeMatcher<Root> {

        @Override    public void describeTo(Description description) {
            description.appendText("is toast");
        }

        @Override    public boolean matchesSafely(Root root) {
            int type = root.getWindowLayoutParams().get().type;
            if ((type == WindowManager.LayoutParams.TYPE_TOAST)) {
                IBinder windowToken = root.getDecorView().getWindowToken();
                IBinder appToken = root.getDecorView().getApplicationWindowToken();
                if (windowToken == appToken) {
                    //means this window isn't contained by any other windows.
                    return true;
                }
            }
            return false;
        }
    }
    Random rand = new Random();
    int randomNumber = rand.nextInt(15) + 65;

    private static final int SIMULATED_DELAY_MS = 500;
    @Rule
    public ActivityTestRule<ScheduleActivity> activityRule = new ActivityTestRule<>(ScheduleActivity.class);

    @Test
    public void test_days() throws Exception{
//        onView(withId(R.id.TextView))
    }
    @Test
    public void test_cells() throws Exception{
        //onView(withId())
        onView(withId(R.id.cellHourText)).perform(click());
    }
}
