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

package com.tale.androidgradletemplate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.events.RxEvent;
import com.tale.androidgradletemplate.fragments.base.BaseFragment;
import com.tale.androidgradletemplate.utils.Toasts;

import javax.inject.Inject;

import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * Created by TALE on 11/11/2014.
 */
public class BottomControlWithRxFragment extends BaseFragment {

    @Inject
    Toasts toasts;

    @Inject
    EventBus bus;

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
        RxEvent.NavigationRequest.publish(button.getText().toString());
    }

}
