package com.tale.androidgradletemplate.rx;

import rx.Subscriber;

/**
 * Created by tale on 12/6/14.
 */
public class ObservableHelper {

    public static <T> void onNext(Subscriber<T> subscriber, T t) {
        assert subscriber != null;

        if (!subscriber.isUnsubscribed()) {
            subscriber.onNext(t);
        }
    }

    public static void onError(Subscriber subscriber, Throwable throwable) {
        assert subscriber != null;

        if (!subscriber.isUnsubscribed()) {
            subscriber.onError(throwable);
        }
    }

    public static void onCompleted(Subscriber subscriber) {
        assert subscriber != null;

        if (!subscriber.isUnsubscribed()) {
            subscriber.onCompleted();
        }
    }
}
