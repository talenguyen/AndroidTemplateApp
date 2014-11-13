package com.tale.androidgradletemplate.activities.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.tale.androidgradletemplate.TempleApplication;
import com.tale.androidgradletemplate.activities.ActivityModule;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

/**
 * Created by tale on 11/8/14.
 */
public abstract class BaseActivity extends ActionBarActivity {

    private ObjectGraph activityObjectGraph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int layoutId = getContentViewId();
        if (layoutId == 0) {
            final View contentView = getContentView();
            if (contentView != null) {
                setContentView(contentView);
                injectViews();
            }
        } else {
            setContentView(layoutId);
            injectViews();
        }

        injectDependencies();
    }

    /**
     * Create content view, this is fallback method to create content view if getContentViewId() method return 0.
     *
     * @return Content View.
     */
    protected View getContentView() {
        return null;
    }

    /**
     * Return layout's id to be set on setContentView(int layoutId) method.
     *
     * @return layout's id or 0 to use getContentView().
     */
    protected abstract int getContentViewId();

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

    public Intent openActivityIntent(Class<? extends Activity> activityClass) {
        return new Intent(this, activityClass);
    }
}