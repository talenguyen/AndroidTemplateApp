package com.tale.androidgradletemplate.espresso;

import android.app.Activity;

import com.squareup.spoon.Spoon;

/**
 * Created by TALE on 12/22/2014.
 */
public class SpoonUtil {

    public static void screenShot(Activity activity, String description) throws Exception {
        Thread.sleep(100);
        Spoon.screenshot(activity, description.replaceAll("[^a-zA-Z0-9_-]", "_"));
    }

}
