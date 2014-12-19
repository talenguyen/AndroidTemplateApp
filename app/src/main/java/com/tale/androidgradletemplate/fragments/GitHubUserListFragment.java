/*
 * Copyright (c) 2014 Giang Nguyen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tale.androidgradletemplate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.fragments.base.RxFragment;
import com.tale.androidgradletemplate.model.pojo.GitUser;
import com.tale.androidgradletemplate.module.userlist.GitHubUserListModel;
import com.tale.androidgradletemplate.module.userlist.GitHubUserListPresenter;
import com.tale.androidgradletemplate.module.userlist.GitHubUserListView;
import com.tale.androidgradletemplate.rx.RxSafer;
import com.tale.androidgradletemplate.views.adapters.GitUserAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by TALE on 11/11/2014.
 */
public class GitHubUserListFragment extends RxFragment implements GitHubUserListView {

    @InjectView(R.id.rvUsers) RecyclerView rvUsers;

    @Inject GitUserAdapter gitUserAdapter;
    @Inject RxSafer rxSafer;
    @Inject GitHubUserListModel model;

    private GitHubUserListPresenter presenter;
    private MaterialDialog loadingProgressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override protected void onInjected() {
        super.onInjected();
        presenter = new GitHubUserListPresenter(model, this, this, rxSafer);
        rvUsers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvUsers.setAdapter(gitUserAdapter);

    }

    @OnClick(R.id.btRefresh) public void refresh() {
        presenter.onStart();
    }

    @Override public void onStart() {
        super.onStart();

    }

    @Override public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override public void renderUsers(List<GitUser> users) {
        gitUserAdapter.changeDataSet(users);
    }

    @Override public void showLoadingProgress() {
//        if (loadingProgressDialog == null) {
//            loadingProgressDialog = new MaterialDialog.Builder(getActivity()).customView(R.layout.dialog_progress).build();
//        }
//        if (!loadingProgressDialog.isShowing()) {
//            loadingProgressDialog.show();
//        }
    }

    @Override public void hideLoadingProgress() {
        if (loadingProgressDialog != null) {
            loadingProgressDialog.dismiss();
            loadingProgressDialog = null;
        }
    }

}
