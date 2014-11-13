package com.tale.androidgradletemplate.activities;

import android.os.Bundle;

import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.activities.base.BaseActivity;
import com.tale.androidgradletemplate.events.Event;
import com.tale.androidgradletemplate.fragments.BottomControlWithBusFragment;
import com.tale.androidgradletemplate.fragments.SampleFragmentBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by TALE on 11/11/2014.
 */
public class SampleWithBusActivity extends BaseActivity {

    @Inject
    EventBus bus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.flMainContainer, SampleFragmentBuilder.newSampleFragment("Main"))
                    .add(R.id.flBottomControlContainer, new BottomControlWithBusFragment())
                    .commit();
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_sample;
    }

    @Override
    protected void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    public void onEvent(Event.BottomControlEvent event) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
                .replace(R.id.flMainContainer, SampleFragmentBuilder.newSampleFragment(event.title))
                .commit();
    }

    @Override
    protected List<Object> getModules() {
        final List<Object> modules = new ArrayList<>();
        modules.add(new ActivityModule());
        return modules;
    }
}
