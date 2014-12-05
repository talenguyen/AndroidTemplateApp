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
        if (compositeSubscriptionOnPause != null) {
            if (!compositeSubscriptionOnPause.isUnsubscribed()) {
                compositeSubscriptionOnPause.unsubscribe();
            }
            compositeSubscriptionOnPause.clear();
        }
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        if (compositeSubscriptionOnDestroy != null) {
            if (!compositeSubscriptionOnDestroy.isUnsubscribed()) {
                compositeSubscriptionOnDestroy.unsubscribe();
            }
            compositeSubscriptionOnDestroy.clear();
        }
        super.onDestroy();
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
