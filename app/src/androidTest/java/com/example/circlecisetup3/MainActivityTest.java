package com.example.circlecisetup3;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.widget.DatePicker;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkingSubmitButton(){
        onView(withId(R.id.nameField)).perform(replaceText("Donald Mains"));
        onView(withId(R.id.emailAddress)).perform(replaceText("dmains@gmail.com"));
        onView(withId(R.id.userName)).perform(replaceText("dmains"));
        onView(withId(R.id.occupation)).perform(replaceText("Student"));
        onView(withId(R.id.description)).perform(replaceText("I am cuddly"));
        onView(withId(R.id.dobButton)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2000,1,2));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.submitButton)).perform(click());
        //onView(withId(R.id.welcomeText)).check(matches(withText("Thank you for signing up donaldmains!")));

    }

    @Test
    public void checkingSubmissionPass(){
        onView(withId(R.id.nameField)).perform(replaceText("Donald Mains"));
        onView(withId(R.id.emailAddress)).perform(replaceText("dmains@gmail.com"));
        onView(withId(R.id.userName)).perform(replaceText("dmains"));
        onView(withId(R.id.occupation)).perform(replaceText("Student"));
        onView(withId(R.id.description)).perform(replaceText("I am cuddly"));
        onView(withId(R.id.dobButton)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2000,1,2));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.nameField)).check(matches(withText("Donald Mains")));
    }

    @Test
    public void checkingBackButtonAndReset() {
        onView(withId(R.id.nameField)).perform(replaceText("Donald Mains"));
        onView(withId(R.id.emailAddress)).perform(replaceText("dmains@gmail.com"));
        onView(withId(R.id.userName)).perform(replaceText("dmains"));
        onView(withId(R.id.occupation)).perform(replaceText("Student"));
        onView(withId(R.id.description)).perform(replaceText("I am cuddly"));
        onView(withId(R.id.dobButton)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 1, 1));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.nameField)).check(matches(withText("")));
        onView(withId(R.id.userName)).check(matches(withText("")));
        onView(withId(R.id.emailAddress)).check(matches(withText("")));
        onView(withId(R.id.occupation)).check(matches(withText("")));
        onView(withId(R.id.description)).check(matches(withText("")));
    }

    @Test
    public void checkingMustHaveValidEmail() {
        onView(withId(R.id.nameField)).perform(replaceText("donald mains"));
        onView(withId(R.id.userName)).perform(replaceText("donaldUserName"));
        onView(withId(R.id.occupation)).perform(replaceText("Student"));
        onView(withId(R.id.description)).perform(replaceText("I am cuddly"));
        onView(withId(R.id.dobButton)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 1, 1));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withText("dmains@gmail.com")).check(doesNotExist());
    }

    @Test
    public void checkingMustHaveName() {
        onView(withId(R.id.userName)).perform(replaceText("donaldUserName"));
        onView(withId(R.id.emailAddress)).perform(replaceText("dmains@gmail.com"));
        onView(withId(R.id.occupation)).perform(replaceText("Student"));
        onView(withId(R.id.description)).perform(replaceText("I am cuddly"));
        onView(withId(R.id.dobButton)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 1, 1));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withText("Donald Mains")).check(doesNotExist());
    }

    @Test
    public void checkingMustHaveUserName() {
        onView(withId(R.id.nameField)).perform(replaceText("donald mains"));
        onView(withId(R.id.emailAddress)).perform(replaceText("dmains@gmail.com"));
        onView(withId(R.id.occupation)).perform(replaceText("Student"));
        onView(withId(R.id.description)).perform(replaceText("I am cuddly"));
        onView(withId(R.id.dobButton)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 1, 1));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withText("donaldUserName")).check(doesNotExist());
    }

    @Test
    public void checkingMustHaveDescription() {
        onView(withId(R.id.nameField)).perform(replaceText("Donald Mains"));
        onView(withId(R.id.emailAddress)).perform(replaceText("dmains@gmail.com"));
        onView(withId(R.id.userName)).perform(replaceText("donaldUserName"));
        onView(withId(R.id.occupation)).perform(replaceText("Student"));
        onView(withId(R.id.dobButton)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 1, 1));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withText("I am cuddly")).check(doesNotExist());
    }

    @Test
    public void checkingMustHaveOccupation() {
        onView(withId(R.id.nameField)).perform(replaceText("Donald Mains"));
        onView(withId(R.id.emailAddress)).perform(replaceText("dmains@gmail.com"));
        onView(withId(R.id.userName)).perform(replaceText("donaldUserName"));
        onView(withId(R.id.description)).perform(replaceText("I am cuddly"));
        onView(withId(R.id.dobButton)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 1, 1));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withText("Student")).check(doesNotExist());
    }

    @Test
    public void checkingOldEnoughTo18() {
        onView(withId(R.id.nameField)).perform(replaceText("Donald Mains"));
        onView(withId(R.id.emailAddress)).perform(replaceText("dmains@gmail.com"));
        onView(withId(R.id.userName)).perform(replaceText("donaldUserName"));
        onView(withId(R.id.description)).perform(replaceText("I am cuddly"));
        onView(withId(R.id.occupation)).perform(replaceText("Student"));
        onView(withId(R.id.dobButton)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2022, 4, 10));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withText("4/22/2020")).check(doesNotExist());
    }


}