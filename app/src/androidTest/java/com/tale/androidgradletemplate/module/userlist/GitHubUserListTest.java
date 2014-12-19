package com.tale.androidgradletemplate.module.userlist;

import android.test.ActivityInstrumentationTestCase2;

import com.tale.androidgradletemplate.activities.MainActivity;

/**
 * Created by TALE on 12/19/2014.
 */
public class GitHubUserListTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public GitHubUserListTest() {
        super("com.tale.androidgradletemplate.activities", MainActivity.class);
    }

    @Override public void setUp() throws Exception {
        super.setUp();
    }
}
