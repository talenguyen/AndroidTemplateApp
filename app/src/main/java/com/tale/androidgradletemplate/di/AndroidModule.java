package com.tale.androidgradletemplate.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.tale.androidgradletemplate.TempleApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide any Android Dependencies here.
 */
@Module(
        library = true,
        complete = false
)
public class AndroidModule {

    @Provides @Singleton SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences(TempleApplication.class.getSimpleName(), Context.MODE_PRIVATE);
    }

}
