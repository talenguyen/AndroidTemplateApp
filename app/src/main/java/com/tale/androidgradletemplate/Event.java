package com.tale.androidgradletemplate;

import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/**
 * Created by TALE on 11/11/2014.
 */
public enum Event {
    ButtonClick(PublishSubject.create());

    PublishSubject<Object> publishSubject;

    Event(PublishSubject<Object> publishSubject) {
        this.publishSubject = publishSubject;
    }

    public void publish(Object obj) {
        publishSubject.onNext(obj);
    }

    public Subscription subscribe(Action1<Object> action) {
        return publishSubject.subscribe(action);
    }
}
