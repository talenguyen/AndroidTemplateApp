package com.tale.androidgradletemplate.di;

import com.tale.androidgradletemplate.model.DebugModelModule;

import dagger.Module;

/**
 * Created by TALE on 12/16/2014.
 */
@Module(
        addsTo = RootModule.class,
        includes = {
                DebugModelModule.class,
        },
        overrides = true
)
public class DebugModule {
}
