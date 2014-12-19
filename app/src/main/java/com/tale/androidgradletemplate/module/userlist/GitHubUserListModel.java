package com.tale.androidgradletemplate.module.userlist;

import com.tale.androidgradletemplate.model.pojo.GitUser;

import java.util.List;

import rx.Observable;

/**
 * Created by TALE on 12/19/2014.
 */
public interface GitHubUserListModel {

    Observable<List<GitUser>> getUsers();

}
