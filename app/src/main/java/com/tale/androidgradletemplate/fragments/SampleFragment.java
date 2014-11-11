package com.tale.androidgradletemplate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.tale.androidgradletemplate.R;
import com.tale.androidgradletemplate.activities.ActivityModule;
import com.tale.androidgradletemplate.utils.Toasts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by TALE on 11/11/2014.
 */
public class SampleFragment extends BaseFragment {

    @InjectView(R.id.tvEvent)
    TextView _TvEvent;

    @Inject
    Toasts toasts;

    @Arg
    String title;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentArgs.inject(this);
    }

    @Override
    protected void onInjected() {
        super.onInjected();
        _TvEvent.setText(title);
    }

    @Override
    protected List<Object> getModules() {
        final List<Object> modules = new ArrayList<>();
        modules.add(new ActivityModule());
        return modules;
    }
}
