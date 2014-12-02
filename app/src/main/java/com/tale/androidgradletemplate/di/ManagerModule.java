package com.tale.androidgradletemplate.di;

import android.app.Application;
import android.content.SharedPreferences;

import com.tale.androidgradletemplate.prefs.AppPref;
import com.tale.androidgradletemplate.utils.Toasts;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * Provide controller dependencies here. Ex. Bus, Toast...
 */
@Module(
        library = true,
        complete = false
)
public class ManagerModule {

    @Provides @Singleton AppPref provideAppPref(SharedPreferences sharedPreferences) {
        return new AppPref(sharedPreferences);
    }

    @Provides @Singleton Toasts provideToast(Application app) {
        return new Toasts(app);
    }

    @Provides @Singleton EventBus provideBus() {
        return EventBus.getDefault();
    }
}
