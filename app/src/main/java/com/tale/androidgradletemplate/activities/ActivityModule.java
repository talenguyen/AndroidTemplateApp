package com.tale.androidgradletemplate.activities;

import dagger.Module;

/**
 * Created by TALE on 11/11/2014.
 */
@Module(
        injects = {
                SampleMainActivity.class,
                SampleWithRxActivity.class,
                SampleWithBusActivity.class
        },
        complete = false
)
public class ActivityModule {
}
