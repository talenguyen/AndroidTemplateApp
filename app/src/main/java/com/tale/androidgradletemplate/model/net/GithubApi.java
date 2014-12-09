package com.tale.androidgradletemplate.model.net;

import com.tale.androidgradletemplate.model.pojo.GithubUser;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by tale on 12/9/14.
 */
public interface GitHubApi {
    @GET("/users") public Observable<List<GithubUser>> getUsers();
}
