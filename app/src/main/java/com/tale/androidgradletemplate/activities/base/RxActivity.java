package com.tale.androidgradletemplate.activities.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by TALE on 11/11/2014.
 */
public abstract class RxActivity extends BaseActivity {

    private CompositeSubscription compositeSubscriptionOnPause;
    private CompositeSubscription compositeSubscriptionOnDestroy;

    @Override
    protected void onPause() {
        super.onPause();
        if (compositeSubscriptionOnPause != null) {
            if (!compositeSubscriptionOnPause.isUnsubscribed()) {
                compositeSubscriptionOnPause.unsubscribe();
            }
            compositeSubscriptionOnPause.clear();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (compositeSubscriptionOnDestroy != null) {
            if (!compositeSubscriptionOnDestroy.isUnsubscribed()) {
                compositeSubscriptionOnDestroy.unsubscribe();
            }
            compositeSubscriptionOnDestroy.clear();
        }
    }

    protected void removeOnPauseSubscription(Subscription subscription) {
        if (compositeSubscriptionOnPause == null) {
            return;
        }
        compositeSubscriptionOnPause.remove(subscription);
    }

    protected void removeOnDestroySubscription(Subscription subscription) {
        if (compositeSubscriptionOnDestroy == null) {
            return;
        }
        compositeSubscriptionOnDestroy.remove(subscription);
    }

    protected void takeCareSubscriptionOnPause(Subscription subscription) {
        if (compositeSubscriptionOnPause == null) {
            compositeSubscriptionOnPause = new CompositeSubscription();
        }
        compositeSubscriptionOnPause.add(subscription);
    }

    protected void takeCareSubscriptionOnDestroy(Subscription subscription) {
        if (compositeSubscriptionOnDestroy == null) {
            compositeSubscriptionOnDestroy = new CompositeSubscription();
        }
        compositeSubscriptionOnDestroy.add(subscription);
    }
}
