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

package com.tale.androidgradletemplate.base.fragment;

import com.tale.androidgradletemplate.rx.RxBinder;

import rx.Observable;
import rx.Scheduler;
import rx.android.observables.AndroidObservable;

/**
 * Created by TALE on 11/11/2014.
 */
public class BaseBusRxFragment extends BaseBusFragment implements RxBinder {

    @Override public <T> Observable<T> bind(Observable<T> observable, Scheduler scheduler) {
        return AndroidObservable.bindFragment(this, observable).subscribeOn(scheduler);
    }

}
