package com.tale.androidgradletemplate.fragments.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by TALE on 11/11/2014.
 */
public class RxFragment extends BaseFragment {

    private CompositeSubscription compositeSubscriptionOnPause;

    @Override
    public void onPause() {
        if (compositeSubscriptionOnPause != null) {
            if (!compositeSubscriptionOnPause.isUnsubscribed()) {
                compositeSubscriptionOnPause.unsubscribe();
            }
            compositeSubscriptionOnPause.clear();
        }
        super.onPause();
    }

    protected void removeSubscriptionOnPause(Subscription subscription) {
        if (compositeSubscriptionOnPause == null) {
            return;
        }
        compositeSubscriptionOnPause.remove(subscription);
    }

    protected void takeCareSubscriptionOnPause(Subscription subscription) {
        if (compositeSubscriptionOnPause == null) {
            compositeSubscriptionOnPause = new CompositeSubscription();
        }
        compositeSubscriptionOnPause.add(subscription);
    }

    private CompositeSubscription compositeSubscriptionOnDestroy;

    @Override
    public void onDestroy() {
        if (compositeSubscriptionOnDestroy != null) {
            if (!compositeSubscriptionOnDestroy.isUnsubscribed()) {
                compositeSubscriptionOnDestroy.unsubscribe();
            }
            compositeSubscriptionOnDestroy.clear();
        }
        super.onDestroy();
    }

    protected void removeSubscriptionOnDestroy(Subscription subscription) {
        if (compositeSubscriptionOnDestroy == null) {
            return;
        }
        compositeSubscriptionOnDestroy.remove(subscription);
    }

    protected void takeCareSubscriptionOnDestroy(Subscription subscription) {
        if (compositeSubscriptionOnDestroy == null) {
            compositeSubscriptionOnDestroy = new CompositeSubscription();
        }
        compositeSubscriptionOnDestroy.add(subscription);
    }
}
