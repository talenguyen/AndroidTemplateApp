package com.tale.androidgradletemplate.model.net;

import com.tale.androidgradletemplate.model.pojo.GitHubUser;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by tale on 12/9/14.
 */
public interface GitHubService {
    @GET("/users")
    public Observable<List<GitHubUser>> getUsers();
}
