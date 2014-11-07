package com.tale.androidgradletemplate;

import android.app.Application;

import com.tale.androidgradletemplate.utils.Toasts;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tale on 11/6/14.
 */
@Module(
        library = true,
        includes = {
//                DataModule.class
        },
        injects = {
                TempleApplication.class
        })
public final class RootModule {
    private final TempleApplication app;

    public RootModule(TempleApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    Toasts provideToast() {
        return new Toasts(app);
    }

}