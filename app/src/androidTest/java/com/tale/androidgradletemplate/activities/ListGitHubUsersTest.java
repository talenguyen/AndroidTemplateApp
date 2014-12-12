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

package com.tale.androidgradletemplate.activities;

import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;

import com.squareup.spoon.Spoon;
import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.model.net.GitHubApi;
import com.tale.androidgradletemplate.model.pojo.GitHubUser;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onData;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

/**
 * Created by TALE on 12/1/2014.
 */
public class ListGitHubUsersTest extends ActivityInstrumentationTestCase2<MainActivity> {

    @Mock
    GitHubApi gitHubApi;
    private MainActivity activity;

    public ListGitHubUsersTest() {
        super("com.tale.androidgradletemplate.activities", MainActivity.class);
    }

    @Override protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);

        when(gitHubApi.getUsers()).thenReturn(mockUsers(5));

        activity = getActivity();
//        final ObjectGraph objectGraph = activity.getActivityObjectGraph().plus(new NetModuleTest(gitHubApi), new ActivityModule(activity));
        final Fragment fragment = activity.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
//        objectGraph.inject(fragment);
    }

    private Observable<List<GitHubUser>> mockUsers(final int size) {
        Observable<List<GitHubUser>> listObservable = Observable.create(new Observable.OnSubscribe<List<GitHubUser>>() {

            @Override
            public void call(Subscriber<? super List<GitHubUser>> subscriber) {
                if (size <= 0) {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onError(new IllegalArgumentException("Please check your param"));
                    }
                } else {
                    List<GitHubUser> result = new ArrayList<>(size);
                    for (int i = 0; i < size; i++) {
                        GitHubUser user = new GitHubUser();
                        user.avatar_url = "https://avatars.githubusercontent.com/u/1658142?v=3";
                        user.login = "talenguyen " + i;
                    }
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(result);
                        subscriber.onCompleted();
                    }
                }

            }
        });
        return listObservable;
    }

    public void testRecyclerViewDisplayed() throws Exception {
        Spoon.screenshot(activity, "Start_up");
        onData(is(instanceOf(GitHubUser.class))).atPosition(0).check(matches(isDisplayed()));
//        getInstrumentation().waitForIdleSync();
//        onView(withId(R.id.rvUsers)).check(matches(ExtViewMatcher.withChildCount(5)));
        Spoon.screenshot(activity, "After_check");
    }
}
