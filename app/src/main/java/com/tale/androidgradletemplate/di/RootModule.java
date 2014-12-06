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

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tale on 11/6/14.
 */
@Module(
        library = true,
        includes = {
                ManagerModule.class,
                AndroidModule.class,
                NetworkModule.class
        })
public final class RootModule {
    private final Application app;

    public RootModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton Application provideApplication() {
        return app;
    }

}
