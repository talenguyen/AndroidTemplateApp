package com.tale.androidgradletemplate.ui.userlist;

import com.tale.androidgradletemplate.data.GitUser;

import java.util.List;

import rx.Observable;

/**
 * Created by TALE on 12/19/2014.
 */
public interface GitHubUserListModel {

    Observable<List<GitUser>> getUsers();

}
