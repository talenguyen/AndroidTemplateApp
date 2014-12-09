package com.tale.androidgradletemplate.espresso;

import android.view.View;
import android.view.ViewGroup;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Giang on 12/9/2014.
 */
public class ExtViewMatcher {

    public static Matcher<View> withChildCount(int childCount) {
        return new TypeSafeMatcher<View>() {
            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof ViewGroup)) {
                    return false;
                }
                return ((ViewGroup) view).getChildCount() == childCount;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(String.format("getChildCount() return: %d", childCount));
            }
        };
    }
}
