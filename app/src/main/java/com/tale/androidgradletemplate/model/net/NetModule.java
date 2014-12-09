package com.tale.androidgradletemplate.model.net;

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
public class NetModule {

    @Provides public GitHubApi provideGithubApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        return restAdapter.create(GitHubApi.class);
    }
}
