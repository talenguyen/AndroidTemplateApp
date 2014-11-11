package com.tale.androidgradletemplate.activities;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by TALE on 11/11/2014.
 */
public class RxActivity extends BaseActivity {

    private CompositeSubscription compositeSubscription;

    @Override
    protected void onPause() {
        super.onPause();
        if (compositeSubscription != null) {
            if (!compositeSubscription.isUnsubscribed()) {
                compositeSubscription.unsubscribe();
            }
            compositeSubscription.clear();
        }
    }

    protected void removeSubscription(Subscription subscription) {
        if (compositeSubscription == null) {
            return;
        }
        compositeSubscription.remove(subscription);
    }

    protected void takeCareSubscription(Subscription subscription) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }
}
