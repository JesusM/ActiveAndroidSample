package com.jesusm.activeandroidsample.app.jobs;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

/**
 * Created by Jesus on 28/04/14.
 */
public class ReadCarInfo extends Job {

    public ReadCarInfo(Params params ) {
        super(params);
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {

    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
