package com.tale.androidgradletemplate.activities;

import android.os.Bundle;

import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.fragments.BottomControlFragment;
import com.tale.androidgradletemplate.fragments.MainSampleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TALE on 11/11/2014.
 */
public class SampleActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sample);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.flMainContainer, new MainSampleFragment())
                    .add(R.id.flBottomControlContainer, new BottomControlFragment())
                    .commit();
        }
    }

    @Override
    protected List<Object> getModules() {
        final List<Object> modules = new ArrayList<>();
        modules.add(new ActivityModule());
        return modules;
    }
}
