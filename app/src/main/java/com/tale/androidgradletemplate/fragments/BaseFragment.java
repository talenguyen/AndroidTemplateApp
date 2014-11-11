package com.tale.androidgradletemplate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.tale.androidgradletemplate.activities.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

/**
 * Created by tale on 11/8/14.
 */
public class BaseFragment extends Fragment {

    private ObjectGraph fragmentObjectGraph;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        injectDependencies();
        onInjected();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentObjectGraph = null;
    }

    protected void onInjected() {

    }

    protected void injectDependencies() {
        List<Object> modules = getModules();
        if (modules == null) {
            modules = new ArrayList<>();
        }
        modules.add(new FragmentModule());
        fragmentObjectGraph = ((BaseActivity) getActivity()).getActivityObjectGraph().plus(modules.toArray());
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

}
