package com.tale.androidgradletemplate.fragments.base;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by TALE on 11/11/2014.
 */
public class BaseBusRxFragment extends RxFragment {

    @Inject
    EventBus bus;

    @Override
    public void onResume() {
        super.onResume();
        if (bus != null) {
            bus.register(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (bus != null) {
            bus.unregister(this);
        }
    }
}
