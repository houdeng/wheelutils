package com.desaysv.app_test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.desaysv.lib_base.utils.SPUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class test {

    private SPUtilsActivity spUtilsActivity;
    private SPUtils spUtils;

    @Rule
    public ActivityTestRule<SPUtilsActivity> mainActivityTestRule = new ActivityTestRule<>(SPUtilsActivity.class,true);

    @Before
    public void setup(){
    }

    @Test
    public void test1(){
    }
}
