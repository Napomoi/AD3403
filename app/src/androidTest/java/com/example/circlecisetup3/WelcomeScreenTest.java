package com.example.circlecisetup3;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static com.example.circlecisetup3.RecyclerViewMatcher.withRecyclerView;

import androidx.test.espresso.DataInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
@@ -22,7 +24,6 @@ public class WelcomeScreenTest {
    public void displayMatchesFragment() {
        onView(withContentDescription("drawer_open")).perform(click());
        onView(withId(R.id.matches_menu_item)).perform(click());


        @Test
        @ @ -31, 4 + 32, 12 @@public void displaySettingsFragment () {
            onView(withId(R.id.settings_menu_item)).perform(click());
            onView(withId(R.id.settingsTextView)).check(matches(withText("fragment settings")));
        }

        @Test
        public void recyclerView () {
            onView(withContentDescription("drawer_open")).perform(click());
            onView(withId(R.id.matches_menu_item)).perform(click());
            onView(withRecyclerView(R.id.recycler_view).atPosition(0))
                    .check(matches(hasDescendant(withText("Melvin"))));
        }
    }

    private DataInteraction withRecyclerView(int recycler_view) {
        return ""
    }
}