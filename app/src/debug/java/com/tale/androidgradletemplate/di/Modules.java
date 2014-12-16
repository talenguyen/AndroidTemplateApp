package com.tale.androidgradletemplate.di;

import android.app.Application;

/**
 * Created by TALE on 12/16/2014.
 */
public class Modules {
    public static Object[] list(Application app) {
        return new Object[]{
                new RootModule(app),
                new DebugModule()
        };
    }

    private Modules() {
        // No instances.
    }
}
