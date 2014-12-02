package com.tale.androidgradletemplate.activities;

import android.test.ActivityInstrumentationTestCase2;

import com.tale.androidgradletemplate.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

/**
 * Created by TALE on 12/1/2014.
 */
public class SampleMainActivityTest extends ActivityInstrumentationTestCase2<SampleMainActivity> {

    public SampleMainActivityTest() {
        super("com.tale.androidgradletemplate.activities", SampleMainActivity.class);
    }

    @Override protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testButton() throws Exception {
        onView(withId(R.id.btBusSample)).check(matches(withText(R.string.txt_bus_sample)));
    }
}
