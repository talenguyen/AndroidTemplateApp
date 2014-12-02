package com.tale.androidgradletemplate.fragments.base;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by TALE on 11/11/2014.
 */
public class BaseBusFragment extends BaseFragment {

    @Inject
    protected EventBus bus;

    private boolean isBusEventRegistered;

    protected void registerForBusEvent() {
        bus.register(this);
        isBusEventRegistered = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (isBusEventRegistered) {
            bus.unregister(this);
        }
    }
}
