package com.tale.androidgradletemplate.di;

import com.tale.androidgradletemplate.net.DebugNetModule;

import dagger.Module;

/**
 * Created by TALE on 12/16/2014.
 */
@Module(
        addsTo = RootModule.class,
        includes = {
                DebugNetModule.class,
        },
        overrides = true
)
public class DebugModule {
}
