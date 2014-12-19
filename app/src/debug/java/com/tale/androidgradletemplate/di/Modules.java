package com.tale.androidgradletemplate.di;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by TALE on 12/16/2014.
 */
public class Modules {
    private static List<Object> extraModules;

    public static void addExtra(Object extraModule) {
        Timber.d("addExtra");
        if (extraModule == null) {
            return;
        }
        if (extraModules == null) {
            extraModules = new ArrayList<Object>();
        }
        extraModules.add(extraModule);
    }

    public static void removeExtra(Object module) {
        if (extraModules != null) {
            extraModules.remove(module);
        }
    }

    public static void clearExtra() {
        if (extraModules != null) {
            extraModules.clear();
            extraModules = null;
        }
    }

    public static Object[] list(Application app) {
        Timber.d("list");
        if (extraModules == null || extraModules.size() == 0) {
            return new Object[]{
                    new RootModule(app),
                    new DebugModule()
            };
        } else {
            extraModules.add(new RootModule(app));
//            extraModules.add(new DebugModule());
            return extraModules.toArray();
        }
    }

    private Modules() {
        // No instances.
    }

}
