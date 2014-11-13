package com.tale.androidgradletemplate.activities;

import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.activities.base.BaseActivity;

import butterknife.OnClick;

/**
 * Created by TALE on 11/13/2014.
 */
public class SampleMainActivity extends BaseActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_sample_main;
    }

    @OnClick(R.id.btBusSample)
    public void openBusSample() {
        startActivity(openActivityIntent(SampleWithBusActivity.class));
    }

    @OnClick(R.id.btRxSample)
    public void openRxSample() {
        startActivity(openActivityIntent(SampleWithRxActivity.class));
    }
}
