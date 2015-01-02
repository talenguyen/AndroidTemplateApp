package com.tale.androidgradletemplate.model;

import android.os.SystemClock;

import com.tale.androidgradletemplate.data.GitUser;
import com.tale.androidgradletemplate.data.net.GitHubService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TALE on 12/16/2014.
 */
@Module(
        overrides = true,
        library = true
)
public class DebugModelModule {

    private static final int MOCK_SIZE = 5;

    @Provides @Singleton
    public GitHubService provideGitHubService() {
        return new GitHubService() {
            @Override public List<GitUser> getUsers() {
                return getMockUsers(MOCK_SIZE);
            }
        };
    }

    private List<GitUser> getMockUsers(int size) {
        SystemClock.sleep(3000);
        List<GitUser> result = new ArrayList<GitUser>(size);
        for (int i = 0; i < size; i++) {
            GitUser user = new GitUser();
            user.avatar_url = "https://avatars.githubusercontent.com/u/1658142?v=3";
            user.login = "talenguyen " + i;
            result.add(user);
        }
        return result;
    }
}