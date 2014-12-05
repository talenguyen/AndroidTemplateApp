/*
 * Copyright (c) 2014 Giang Nguyen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
