package com.tale.androidgradletemplate.base;

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
