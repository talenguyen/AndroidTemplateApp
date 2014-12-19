package com.tale.androidgradletemplate.module.userlist;

import com.tale.androidgradletemplate.model.pojo.GitUser;

import java.util.List;

/**
 * View class for GitHubUserList UI.
 */
public interface GitHubUserListView {

    /**
     * Render users data on UI.
     *
     * @param users The list of {@link com.tale.androidgradletemplate.model.pojo.GitUser} to be rendered.
     */
    void renderUsers(List<GitUser> users);

    /**
     * Show loading progress on UI.
     */
    void showLoadingProgress();

    /**
     * Hide showing loading progress from UI.
     */
    void hideLoadingProgress();
}
