package com.tale.androidgradletemplate;

import android.app.Application;

import com.tale.androidgradletemplate.managers.ManagerModule;
import com.tale.androidgradletemplate.network.NetworkModule;
import com.tale.androidgradletemplate.utils.Toasts;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * Created by tale on 11/6/14.
 */
@Module(
        library = true,
        includes = {
                ManagerModule.class,
                NetworkModule.class
        },
        injects = {
                TempleApplication.class
        })
public final class RootModule {
    private final Application app;

    public RootModule(Application app) {
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

    @Provides
    @Singleton
    EventBus provideBus() {
        return EventBus.getDefault();
    }

}
