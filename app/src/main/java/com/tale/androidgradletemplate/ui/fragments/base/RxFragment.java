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

package com.tale.androidgradletemplate.ui.fragments.base;

import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.android.app.AppObservable;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by TALE on 11/11/2014.
 */
public class RxFragment extends BaseFragment {

    private CompositeSubscription compositeSubscriptionOnPause;
    private CompositeSubscription compositeSubscriptionOnDestroy;

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

    protected <T> Observable<T> bind(Observable<T> observable, Scheduler scheduler) {
        return AppObservable.bindFragment(this, observable.subscribeOn(scheduler));
    }
}
