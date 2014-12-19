package com.tale.androidgradletemplate.model;

import com.tale.androidgradletemplate.model.net.GitHubService;
import com.tale.androidgradletemplate.model.pojo.GitUser;
import com.tale.androidgradletemplate.module.userlist.GitHubUserListModel;
import com.tale.androidgradletemplate.rx.ObservableHelper;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by TALE on 12/19/2014.
 */
public class GitHubUserModel implements GitHubUserListModel {

    private final GitHubService gitHubService;

    public GitHubUserModel(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @Override public Observable<List<GitUser>> getUsers() {
        return Observable.create(
                (Subscriber<? super List<GitUser>> subscriber) -> {
                    try {
                        final List<GitUser> users = gitHubService.getUsers();
                        ObservableHelper.onNext(subscriber, users);
                    } catch (Exception e) {
                        ObservableHelper.onError(subscriber, e);
                    } finally {
                        ObservableHelper.onCompleted(subscriber);
                    }
                }
        );
    }
}
