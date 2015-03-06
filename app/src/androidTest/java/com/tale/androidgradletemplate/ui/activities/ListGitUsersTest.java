/*
 * Copyright (c) 2014 Giang Nguyen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tale.androidgradletemplate.ui.activities;

import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.espresso.ExtViewMatcher;
import com.tale.androidgradletemplate.util.ViewActions;

import static   android.support.test.espresso.Espresso.onView;
import static   android.support.test.espresso.assertion.ViewAssertions.matches;
import static   android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static   android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static   android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by TALE on 12/1/2014.
 */
public class ListGitUsersTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;

    public ListGitUsersTest() {
        super("com.tale.androidgradletemplate.ui.activities", MainActivity.class);
    }

    @Override protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testRecyclerViewDisplayed() throws Exception {
        onView(isRoot()).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(isRoot()).perform(ViewActions.waitAtLeast(4000));
        onView(withId(R.id.rvUsers)).check(matches(ExtViewMatcher.withChildCount(5)));
    }
}
