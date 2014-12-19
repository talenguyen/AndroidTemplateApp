package com.tale.androidgradletemplate.rx;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by tale on 12/6/14.
 */
public interface RxBinder {

    /**
     * Bind observable with Fragment/Activity life cycle. This usually implemented by Fragment/Activity.
     *
     * @param observable The source observable.
     * @param scheduler  Scheduler, where subscribeOn().
     * @param <T>
     * @return result observable after bind with Fragment/Activity life cycle.
     */
    <T> Observable<T> bind(Observable<T> observable, Scheduler scheduler);

}
