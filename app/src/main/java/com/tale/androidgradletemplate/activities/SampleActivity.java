package com.tale.androidgradletemplate.activities;

import android.os.Bundle;

import com.tale.androidgradletemplate.Event;
import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.fragments.BottomControlFragment;
import com.tale.androidgradletemplate.fragments.SampleFragmentBuilder;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by TALE on 11/11/2014.
 */
public class SampleActivity extends RxActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sample);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.flMainContainer, SampleFragmentBuilder.newSampleFragment("Main"))
                    .add(R.id.flBottomControlContainer, new BottomControlFragment())
                    .commit();
        }

        final Subscription subscription = Event.NavigationRequest.subscribe((requestId) -> showSampleFragment(String.valueOf(requestId)));
        takeCareSubscription(subscription);
    }

    private void showSampleFragment(String title) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
                .replace(R.id.flMainContainer, SampleFragmentBuilder.newSampleFragment(title))
                .commit();
    }

    @Override
    protected List<Object> getModules() {
        final List<Object> modules = new ArrayList<>();
        modules.add(new ActivityModule());
        return modules;
    }
}
