package com.tale.androidgradletemplate.rx;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by tale on 12/6/14.
 */
public class RxSafer {

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    /**
     * Add subscription to list then can un-subscribe in single shot later.
     *
     * @param subscription The subscription to be added.
     */
    public void addSubscription(Subscription subscription) {
        if (subscription == null) {
            return;
        }

        compositeSubscription.add(subscription);
    }

    /**
     * Remove subscription from list.
     *
     * @param subscription the subscription to be removed.
     */
    public void removeSubscription(Subscription subscription) {
        if (subscription == null) {
            return;
        }

        compositeSubscription.remove(subscription);
    }

    /**
     * Stops the receipt of notifications on the Subscriber that was registered when this Subscription was received.
     *
     * @see rx.subscriptions.CompositeSubscription#unsubscribe()
     */
    public void unSubscribe() {
        compositeSubscription.unsubscribe();
        compositeSubscription.clear();
    }

}
