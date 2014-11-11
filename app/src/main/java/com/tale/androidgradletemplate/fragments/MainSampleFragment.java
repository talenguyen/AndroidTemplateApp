package com.tale.androidgradletemplate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tale.androidgradletemplate.Event;
import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.activities.ActivityModule;
import com.tale.androidgradletemplate.utils.Toasts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import rx.Subscription;

/**
 * Created by TALE on 11/11/2014.
 */
public class MainSampleFragment extends BaseFragment {

    @InjectView(R.id.tvEvent)
    TextView _TvEvent;

    @Inject
    Toasts toasts;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        final Subscription subscription = Event.ButtonClick.subscribe((obj) -> toasts.showShort(String.valueOf(obj)));
    }

    @Override
    protected List<Object> getModules() {
        final List<Object> modules = new ArrayList<>();
        modules.add(new ActivityModule());
        return modules;
    }
}
