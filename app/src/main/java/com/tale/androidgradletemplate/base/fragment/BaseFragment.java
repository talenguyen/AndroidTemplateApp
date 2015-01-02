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

package com.tale.androidgradletemplate.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.tale.androidgradletemplate.base.activity.BaseActivity;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

/**
 * Created by tale on 11/8/14.
 */
public class BaseFragment extends Fragment {

    private ObjectGraph fragmentObjectGraph;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
        injectDependencies();
        onInjected();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        fragmentObjectGraph = null;
    }

    protected void onInjected() {

    }

    protected void injectDependencies() {
        final Object[] modules = getModules();
        if (modules != null && modules.length > 0) {
            fragmentObjectGraph = ((BaseActivity) getActivity()).getActivityObjectGraph().plus(modules);
            fragmentObjectGraph.inject(this);
        }
    }

    protected Object[] getModules() {
        return null;
    }

    protected void injectViews(View view) {
        ButterKnife.inject(this, view);
    }

}