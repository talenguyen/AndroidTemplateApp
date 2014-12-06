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

package com.tale.androidgradletemplate.activities;

import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.activities.base.BaseActivity;

import butterknife.OnClick;

/**
 * Created by TALE on 11/13/2014.
 */
public class SampleMainActivity extends BaseActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_sample_main;
    }

    @OnClick(R.id.btBusSample)
    public void openBusSample() {
        startActivity(openActivityIntent(SampleWithBusActivity.class));
    }

    @OnClick(R.id.btRxSample)
    public void openRxSample() {
        startActivity(openActivityIntent(SampleWithRxActivity.class));
    }
}
