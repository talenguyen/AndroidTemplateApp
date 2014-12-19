package com.tale.androidgradletemplate.presenter;

/**
 * Base presenter interface.
 */
public interface IPresenter {

    /**
     * Start to begin presenter job.
     */
    void onStart();

    /**
     * Stop to end presenter job.
     */
    void onStop();
}
