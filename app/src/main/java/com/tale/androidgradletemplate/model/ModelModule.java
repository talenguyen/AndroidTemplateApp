package com.tale.androidgradletemplate.model;

import com.tale.androidgradletemplate.model.net.GitHubService;
import com.tale.androidgradletemplate.module.userlist.GitHubUserListModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by tale on 12/9/14.
 */
@Module(
        library = true,
        complete = false
)
public class ModelModule {

    public ModelModule() {
    }

    @Provides @Singleton public GitHubService provideGitHubService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        return restAdapter.create(GitHubService.class);
    }

    @Provides @Singleton public GitHubUserListModel provideGitHubUserListModel(GitHubService gitHubService) {
        return new GitHubUserModel(gitHubService);
    }
}
