package com.tale.androidgradletemplate.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.tale.androidgradletemplate.TempleApplication;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

/**
 * Created by tale on 11/8/14.
 */
public class BaseActivity extends ActionBarActivity {

    private ObjectGraph activityObjectGraph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectViews();
        injectDependencies();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityObjectGraph = null;
    }

    protected void injectDependencies() {
        final TempleApplication application = TempleApplication.get(this);

        List<Object> modules = getModules();
        if (modules == null) {
            modules = new ArrayList<>();
        }
        modules.add(new ActivityModule());
        activityObjectGraph = application.getObjectGraph().plus(modules.toArray());
        activityObjectGraph.inject(this);
    }

    public ObjectGraph getActivityObjectGraph() {
        return activityObjectGraph;
    }

    protected void injectViews() {
        ButterKnife.inject(this);
    }

    protected List<Object> getModules() {
        return null;
    }
}