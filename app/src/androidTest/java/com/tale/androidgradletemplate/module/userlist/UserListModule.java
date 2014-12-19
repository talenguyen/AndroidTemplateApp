package com.tale.androidgradletemplate.module.userlist;

import com.tale.androidgradletemplate.model.net.GitHubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TALE on 12/19/2014.
 */
@Module(
        library = true,
        complete = false,
        injects = {
                GitHubUserListTest.class
        },
        overrides = true
)
public class UserListModule {
    private final CountingIdlingResourceGitHubService idlingResourceGitHubService;

    public UserListModule(CountingIdlingResourceGitHubService idlingResourceGitHubService) {
        this.idlingResourceGitHubService = idlingResourceGitHubService;
    }

    @Provides @Singleton
    public GitHubService provideGitHubService() {
        return idlingResourceGitHubService;
    }
}
