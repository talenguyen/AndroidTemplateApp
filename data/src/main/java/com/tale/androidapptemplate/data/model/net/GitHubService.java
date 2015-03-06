package com.tale.androidapptemplate.data.model.net;

import com.tale.androidapptemplate.data.model.pojo.GitUser;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by tale on 12/9/14.
 */
public interface GitHubService {
    @GET("/users")
    public Observable<List<GitUser>> getUsers();
}
