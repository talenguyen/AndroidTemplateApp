package com.tale.androidgradletemplate.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tale on 11/6/14.
 */
@Module(
        library = true,
        includes = {
                ManagerModule.class,
                AndroidModule.class,
                NetworkModule.class
        })
public final class RootModule {
    private final Application app;

    public RootModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton Application provideApplication() {
        return app;
    }

}
