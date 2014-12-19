package com.tale.androidgradletemplate.model.net;

import com.tale.androidgradletemplate.model.pojo.GitUser;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by tale on 12/9/14.
 */
public interface GitHubService {
    @GET("/users")
    public List<GitUser> getUsers();
}
