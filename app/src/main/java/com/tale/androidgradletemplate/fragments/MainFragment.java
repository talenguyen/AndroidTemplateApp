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

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.fragments.base.BaseFragment;
import com.tale.androidgradletemplate.model.net.GitHubApi;
import com.tale.androidgradletemplate.model.net.NetModule;
import com.tale.androidgradletemplate.views.adapters.GitUserAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by TALE on 11/11/2014.
 */
public class MainFragment extends BaseFragment {

    @Inject
    GitHubApi gitHubApi;

    @InjectView(R.id.rvUsers)
    RecyclerView rvUsers;

    @Inject
    Activity activity;

    @Inject
    GitUserAdapter gitUserAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    protected void onInjected() {
        super.onInjected();
        rvUsers.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        rvUsers.setAdapter(gitUserAdapter);
        gitHubApi.getUsers()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((users) -> gitUserAdapter.changeDataSet(users));
    }

    @Override
    protected List<Object> getModules() {
        final List<Object> modules = new ArrayList<>();
        modules.add(new NetModule());
        return modules;
    }
}
