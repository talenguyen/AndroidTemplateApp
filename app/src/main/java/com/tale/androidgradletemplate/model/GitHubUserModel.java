package com.tale.androidgradletemplate.model;

import com.tale.androidgradletemplate.model.net.GitHubService;
import com.tale.androidgradletemplate.model.pojo.GitUser;
import com.tale.androidgradletemplate.module.userlist.GitHubUserListModel;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by TALE on 12/19/2014.
 */
public class GitHubUserModel implements GitHubUserListModel {

    @Inject GitHubService gitHubService;

    @Override public Observable<List<GitUser>> getUsers() {
        return gitHubService.getUsers();
    }
}
