package com.tale.androidgradletemplate.fragments;

import dagger.Module;

/**
 * Created by TALE on 11/11/2014.
 */
@Module(
        injects = {
                BottomControlFragment.class,
                SampleFragment.class
        },
        complete = false
)
public class FragmentModule {
}
