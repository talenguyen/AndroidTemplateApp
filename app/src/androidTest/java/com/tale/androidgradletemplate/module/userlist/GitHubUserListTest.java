package com.tale.androidgradletemplate.module.userlist;

import android.test.ActivityInstrumentationTestCase2;

import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.contrib.CountingIdlingResource;
import com.squareup.spoon.Spoon;
import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.activities.MainActivity;
import com.tale.androidgradletemplate.di.Modules;
import com.tale.androidgradletemplate.espresso.ExtViewMatcher;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

/**
 * Created by TALE on 12/19/2014.
 */
public class GitHubUserListTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    private CountingIdlingResourceGitHubService countingIdlingResourceGitHubService;
    private UserListModule extraModule;
    private CountingIdlingResource countingIdlingResource;

    public GitHubUserListTest() {
        super("com.tale.androidgradletemplate.activities", MainActivity.class);
//        countingIdlingResource = new CountingIdlingResource("GitHubUserListTest");
//        countingIdlingResourceGitHubService = new CountingIdlingResourceGitHubService(countingIdlingResource);
//        extraModule = new UserListModule(countingIdlingResourceGitHubService);
//        Modules.addExtra(extraModule);
    }

    @Override public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
//        registerIdlingResources(countingIdlingResource);
    }

    public void testOnStart_ShowLoadingThenRenderUserListThenHideLoading() throws Exception {
        Spoon.screenshot(activity, "Before_check");
        onView(withId(R.id.btRefresh)).perform(ViewActions.click());
//        // Check show loading.
//        Spoon.screenshot(activity, "check_show_loading");
//        Espresso.onView(ViewMatchers.withText(R.string.loading)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
//        // Check hide loading.
//        Spoon.screenshot(activity, "check_hide_loading");
//        Espresso.onView(ViewMatchers.withText(R.string.loading)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())));
//        // Check user list is displayed.
//        Spoon.screenshot(activity, "check_display_user_list");
        onView(withId(R.id.rvUsers)).check(matches(ExtViewMatcher.withChildCount(7)));
        Spoon.screenshot(activity, "After_check");
    }

    @Override public void tearDown() throws Exception {
        super.tearDown();
        Modules.clearExtra();
    }
}
