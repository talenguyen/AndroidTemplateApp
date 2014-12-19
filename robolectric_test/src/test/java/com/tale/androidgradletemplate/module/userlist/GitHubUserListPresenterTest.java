package com.tale.androidgradletemplate.module.userlist;

import com.tale.androidgradletemplate.model.pojo.GitUser;
import com.tale.androidgradletemplate.rx.ObservableHelper;
import com.tale.androidgradletemplate.rx.RxBinder;
import com.tale.androidgradletemplate.rx.RxSafer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import robolectric.RobolectricGradleTestRunner;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by TALE on 12/19/2014.
 */
@RunWith(RobolectricGradleTestRunner.class)
public class GitHubUserListPresenterTest {

    @Mock GitHubUserListModel model;
    @Mock GitHubUserListView view;
    @Mock RxSafer rxSafer;
    @Spy RxBinder rxBinder = new RxBinder() {
        @Override public <T> Observable<T> bind(Observable<T> observable, Scheduler scheduler) {
            return observable;
        }
    };

    GitHubUserListPresenter presenter;

    private static Observable<List<GitUser>> createMockUsersObservable(final List<GitUser> mockUsers) {
        return Observable.create(
                new Observable.OnSubscribe<List<GitUser>>() {
                    @Override public void call(Subscriber<? super List<GitUser>> subscriber) {
                        try {
                            ObservableHelper.onNext(subscriber, mockUsers);
                        } catch (Exception e) {
                            ObservableHelper.onError(subscriber, e);
                        } finally {
                            ObservableHelper.onCompleted(subscriber);
                        }

                    }
                }
        );
    }

    private static List<GitUser> createMockUsers(int size) {
        final List<GitUser> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            final GitUser user = new GitUser();
            user.id = i;
            user.login = "username_" + i;
            user.avatar_url = "avatar_url_" + i;
            users.add(user);
        }
        return users;
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter = new GitHubUserListPresenter(model, view, rxBinder, rxSafer);
    }

    @Test
    public void testOnStart() throws Exception {
        final List<GitUser> mockUsers = createMockUsers(5);
        final Observable<List<GitUser>> mockUsersObservable = createMockUsersObservable(mockUsers);
        when(model.getUsers()).thenReturn(mockUsersObservable); // Mock up return mockUsers when request for model.getUsers().

        presenter.onStart();
        // Call view.showLoadingProgress();
        verify(view).showLoadingProgress();
        // Call rxBinder.bind(mockUsersObservable, Schedules.newThread())
        verify(rxBinder).bind(mockUsersObservable, Schedulers.newThread());
        // Call rxSafer.addSubscription(anySubscription)
        verify(rxSafer).addSubscription(any(Subscription.class));
        // Call model.getUsers();
        verify(model).getUsers();
        // Call view.renderUsers(users); with users is return from above step.
        verify(view).renderUsers(mockUsers);
        // Call view.hideLoadingProgress();
        verify(view).hideLoadingProgress();
    }
}
