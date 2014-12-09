package com.tale.androidgradletemplate.model.net;

import dagger.Module;
import dagger.Provides;

@Module(
        overrides = true,
        library = true
)
public class NetModuleTest {
    private final GitHubApi gitHubApi;

    public NetModuleTest(GitHubApi gitHubApi) {
        this.gitHubApi = gitHubApi;
    }

    @Provides
    public GitHubApi provideGitHubApi() {
        return gitHubApi;
    }
}