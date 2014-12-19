package com.tale.androidgradletemplate.module.userlist;

import com.tale.androidgradletemplate.model.pojo.GitUser;
import com.tale.androidgradletemplate.presenter.IPresenter;
import com.tale.androidgradletemplate.rx.RxBinder;
import com.tale.androidgradletemplate.rx.RxSafer;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by TALE on 12/19/2014.
 */
public class GitHubUserListPresenter implements IPresenter {

    private final GitHubUserListModel model;
    private final GitHubUserListView view;
    private final RxBinder rxBinder;
    private final RxSafer rxSafer;

    @Inject public GitHubUserListPresenter(GitHubUserListModel model, GitHubUserListView view, RxBinder rxBinder, RxSafer rxSafer) {
        this.model = model;
        this.view = view;
        this.rxBinder = rxBinder;
        this.rxSafer = rxSafer;
    }

    @Override public void onStart() {
        view.showLoadingProgress();
        final Subscription subscription = rxBinder.bind(model.getUsers(), Schedulers.newThread()).subscribe(
                new Observer<List<GitUser>>() {
                    @Override public void onCompleted() {
                        view.hideLoadingProgress();
                    }

                    @Override public void onError(Throwable e) {
                    }

                    @Override public void onNext(List<GitUser> users) {
                        view.renderUsers(users);
                    }
                }
        );
        rxSafer.addSubscription(subscription);
    }

    @Override public void onStop() {
        rxSafer.unSubscribe();
    }
}
