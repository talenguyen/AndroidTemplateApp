package com.tale.androidgradletemplate.events;

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
