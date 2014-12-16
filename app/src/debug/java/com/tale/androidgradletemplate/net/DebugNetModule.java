package com.tale.androidgradletemplate.net;

import com.tale.androidgradletemplate.model.net.GitHubApi;
import com.tale.androidgradletemplate.model.pojo.GitHubUser;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by TALE on 12/16/2014.
 */
@Module(
        overrides = true,
        library = true
)
public class DebugNetModule {

    private static final int MOCK_SIZE = 5;

    @Provides
    public GitHubApi provideGitHubApi() {
        return new GitHubApi() {
            @Override public Observable<List<GitHubUser>> getUsers() {
                Observable<List<GitHubUser>> listObservable = Observable.create(
                        (Subscriber<? super List<GitHubUser>> subscriber) -> {
                            List<GitHubUser> result = new ArrayList<>(MOCK_SIZE);
                            for (int i = 0; i < MOCK_SIZE; i++) {
                                GitHubUser user = new GitHubUser();
                                user.avatar_url = "https://avatars.githubusercontent.com/u/1658142?v=3";
                                user.login = "talenguyen " + i;
                                result.add(user);
                            }
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onNext(result);
                                subscriber.onCompleted();
                            }
                        }
                );
                return listObservable;
            }
        };
    }
}