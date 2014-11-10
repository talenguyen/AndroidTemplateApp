package com.tale.androidgradletemplate.managers;

import android.content.SharedPreferences;

import com.tale.prettysharedpreferences.LongEditor;
import com.tale.prettysharedpreferences.PrettySharedPreferences;

/**
 * Created by tale on 11/8/14.
 */
public class AppPref extends PrettySharedPreferences {

    public AppPref(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public LongEditor<AppPref> isFirstInitialized() {
        return getLongEditor("isFirstInitialized");
    }

}
