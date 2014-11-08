package com.tale.androidgradletemplate.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.tale.androidgradletemplate.activities.BaseActivity;

import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

/**
 * Created by tale on 11/8/14.
 */
public class BaseFragment extends Fragment {

    private ObjectGraph fragmentObjectGraph;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        injectDependencies();
    }

    protected void injectDependencies() {
        final List<Object> modules = getModules();
        if (modules == null) {
            fragmentObjectGraph = ((BaseActivity) getActivity()).getActivityObjectGraph();
        } else {
            fragmentObjectGraph = ((BaseActivity) getActivity()).getActivityObjectGraph().plus(modules);
        }
        fragmentObjectGraph.inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        injectViews(view);
    }

    protected void injectViews(View view) {
        ButterKnife.inject(this, view);
    }

    protected List<Object> getModules() {
        return null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentObjectGraph = null;

    }

}
