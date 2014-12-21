package com.tale.androidgradletemplate.net;

import android.os.SystemClock;

import com.tale.androidgradletemplate.model.net.GitHubService;
import com.tale.androidgradletemplate.model.pojo.GitUser;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

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
    public GitHubService provideGitHubApi() {
        return new GitHubService() {
            @Override public List<GitUser> getUsers() {
                List<GitUser> result = new ArrayList<>(MOCK_SIZE);
                for (int i = 0; i < MOCK_SIZE; i++) {
                    GitUser user = new GitUser();
                    user.avatar_url = "https://avatars.githubusercontent.com/u/1658142?v=3";
                    user.login = "talenguyen " + i;
                    result.add(user);
                }
                return result;
            }
        };
    }
}