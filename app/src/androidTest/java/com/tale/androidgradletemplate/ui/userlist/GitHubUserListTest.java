package com.tale.androidgradletemplate.ui.userlist;

import android.test.ActivityInstrumentationTestCase2;

import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.espresso.ExtViewActions;
import com.tale.androidgradletemplate.espresso.ExtViewMatcher;
import com.tale.androidgradletemplate.espresso.SpoonUtil;
import com.tale.androidgradletemplate.ui.MainActivity;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isRoot;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

/**
 * Created by TALE on 12/19/2014.
 */
public class GitHubUserListTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;

    public GitHubUserListTest() {
        super("com.tale.androidgradletemplate.ui", MainActivity.class);
    }

    @Override public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testOnStart_ShowLoadingThenRenderUserListThenHideLoading() throws Exception {
//        onView(withId(R.id.btRefresh)).perform(ViewActions.click());
        String tag = "1. Root view visible, progress showing";
        onView(withText(R.string.loading)).check(matches(isDisplayed()));
        SpoonUtil.screenShot(activity, tag);
        tag = "2. RecyclerView is shown with mock up data loaded.";
        onView(isRoot()).perform(ExtViewActions.waitAtLeast(3000));
        onView(withId(R.id.rvUsers)).check(matches(ExtViewMatcher.withChildCount(5)));
        SpoonUtil.screenShot(activity, tag);
    }

}
