package com.tale.androidgradletemplate.module.userlist;

import com.google.android.apps.common.testing.ui.espresso.contrib.CountingIdlingResource;
import com.tale.androidgradletemplate.model.net.GitHubService;
import com.tale.androidgradletemplate.model.pojo.GitUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TALE on 12/19/2014.
 */
public class CountingIdlingResourceGitHubService implements GitHubService {
    private final CountingIdlingResource gitHubServiceIdlingResource;

    public CountingIdlingResourceGitHubService(CountingIdlingResource gitHubServiceIdlingResource) {
        this.gitHubServiceIdlingResource = gitHubServiceIdlingResource;
    }

    @Override public List<GitUser> getUsers() {
        try {
            gitHubServiceIdlingResource.increment();
            return getMockUsers(7);
        } finally {
            gitHubServiceIdlingResource.decrement();
        }
    }

    private List<GitUser> getMockUsers(int size) {
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
