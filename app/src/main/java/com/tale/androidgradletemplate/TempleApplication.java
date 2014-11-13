package com.tale.androidgradletemplate;

import android.app.Application;
import android.content.Context;

import dagger.ObjectGraph;
import timber.log.Timber;

/**
 * Created by tale on 11/6/14.
 */
public class TempleApplication extends Application implements Injector {
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }

        buildObjectGraphAndInject();

    }

    public void buildObjectGraphAndInject() {
        objectGraph = ObjectGraph.create(new Object[]{new RootModule(this)});
        objectGraph.inject(this);
    }

    @Override
    public void inject(Object object) {
        objectGraph.inject(object);
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }

    public static TempleApplication get(Context context) {
        return (TempleApplication) context.getApplicationContext();
    }

    /**
     * A tree which logs important information for crash reporting.
     */
    private static class CrashReportingTree extends Timber.HollowTree {
        @Override
        public void i(String message, Object... args) {
            // TODO e.g., Crashlytics.log(String.format(message, args));
        }

        @Override
        public void i(Throwable t, String message, Object... args) {
            i(message, args); // Just add to the log.
        }

        @Override
        public void e(String message, Object... args) {
            i("ERROR: " + message, args); // Just add to the log.
        }

        @Override
        public void e(Throwable t, String message, Object... args) {
            e(message, args);

            // TODO e.g., Crashlytics.logException(t);
        }
    }
}
