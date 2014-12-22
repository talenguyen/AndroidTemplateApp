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

package com.tale.androidgradletemplate.data.events;

import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/**
 * Created by TALE on 11/11/2014.
 */
public enum RxEvent {
    NavigationRequest;

    private final PublishSubject<Object> publishSubject;

    RxEvent() {
        this.publishSubject = PublishSubject.create();
    }

    public void publish(Object obj) {
        publishSubject.onNext(obj);
    }

    public Subscription subscribe(Action1<Object> action) {
        return publishSubject.subscribe(action);
    }
}
