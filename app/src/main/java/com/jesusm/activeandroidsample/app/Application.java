package com.jesusm.activeandroidsample.app;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Jesus on 28/04/14.
 */
public class Application extends android.app.Application{

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initActiveAndroid();
    }

    private void initActiveAndroid() {
        ActiveAndroid.initialize(this);
    }
}
