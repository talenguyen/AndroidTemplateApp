package com.tale.androidgradletemplate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tale.androidgradletemplate.Event;
import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.utils.Toasts;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Created by TALE on 11/11/2014.
 */
public class BottomControlFragment extends BaseFragment {

    @Inject
    Toasts toasts;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom_control, container, false);
    }

    @Override
    protected void onInjected() {
        super.onInjected();
        toasts.showShort("onViewCreated");
    }

    @OnClick({R.id.btLeft, R.id.btRight})
    public void onButtonClick(Button button) {
        Event.ButtonClick.publish(button.getText().toString());
    }

}
