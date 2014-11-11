package com.tale.androidgradletemplate.managers;

import android.app.Application;
import android.content.SharedPreferences;

import com.tale.androidgradletemplate.TempleApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by tale on 11/8/14.
 */
@Module(
        library = true,
        complete = false
)
public class ManagerModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application app) {
        return app.getSharedPreferences(TempleApplication.class.getName(), MODE_PRIVATE);
    }

    @Provides
    @Singleton
    AppPref provideAppPref(SharedPreferences sharedPreferences) {
        return new AppPref(sharedPreferences);
    }
}
