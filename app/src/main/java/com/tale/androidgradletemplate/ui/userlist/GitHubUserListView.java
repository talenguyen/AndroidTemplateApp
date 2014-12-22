package com.tale.androidgradletemplate.ui.userlist;

import com.tale.androidgradletemplate.data.GitUser;

import java.util.List;

/**
 * View class for GitHubUserList UI.
 */
public interface GitHubUserListView {

    /**
     * Render users data on UI.
     *
     * @param users The list of {@link com.tale.androidgradletemplate.data.GitUser} to be rendered.
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
