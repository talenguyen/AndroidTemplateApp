package com.tale.androidgradletemplate.util;

import android.view.View;

import com.google.android.apps.common.testing.ui.espresso.PerformException;
import com.google.android.apps.common.testing.ui.espresso.UiController;
import com.google.android.apps.common.testing.ui.espresso.ViewAction;
import com.google.android.apps.common.testing.ui.espresso.action.GeneralLocation;
import com.google.android.apps.common.testing.ui.espresso.action.GeneralSwipeAction;
import com.google.android.apps.common.testing.ui.espresso.action.Press;
import com.google.android.apps.common.testing.ui.espresso.action.Swipe;
import com.google.android.apps.common.testing.ui.espresso.util.HumanReadables;
import com.google.android.apps.common.testing.ui.espresso.util.TreeIterables;

import org.hamcrest.Matcher;

import java.util.concurrent.TimeoutException;

import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isRoot;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

public class ViewActions {

    /**
     * Perform action of waiting for a specific view id.
     * <p/>
     * E.g.:
     * onView(isRoot()).perform(waitId(R.id.dialogEditor, Sampling.SECONDS_15));
     *
     * @param viewId
     * @param millis
     * @return
     */
    public static ViewAction waitId(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = withId(viewId);

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        // found view with required ID
                        if (viewMatcher.matches(child)) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                // timeout happens
                throw new PerformException.Builder()
                    .withActionDescription(this.getDescription())
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(new TimeoutException())
                    .build();
            }
        };
    }

    /**
     * Perform action of waiting for a specific time. Useful when you need
     * to wait for animations to end and Espresso fails at waiting.
     * <p/>
     * E.g.:
     * onView(isRoot()).perform(waitAtLeast(Sampling.SECONDS_15));
     *
     * @param millis
     * @return
     */
    public static ViewAction waitAtLeast(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return anything();
            }

            @Override
            public String getDescription() {
                return "wait for at least " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }

    public static ViewAction swipeTop() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.BOTTOM_CENTER, GeneralLocation.TOP_CENTER, Press.FINGER);
    }

    public static ViewAction swipeBottom() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.TOP_CENTER, GeneralLocation.BOTTOM_CENTER, Press.FINGER);
    }

    /**
     * Perform action of waiting until UI thread is free.
     * <p/>
     * E.g.:
     * onView(isRoot()).perform(waitUntilIdle());
     *
     * @return
     */
    public static ViewAction waitUntilIdle() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return anything();
            }

            @Override
            public String getDescription() {
                return "wait until UI thread is free";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
            }
        };
    }

}
