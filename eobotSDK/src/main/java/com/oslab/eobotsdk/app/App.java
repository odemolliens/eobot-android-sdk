package com.oslab.eobotsdk.app;

import android.app.Application;
import android.content.Context;

/**
 * App class - contains static context
 * Created by Demolliens Olivier - @odemolliens on 24/09/15.
 * Eobot
 */
public class App extends Application {

    /**
     * Context
     */
    private static Context mAppContext;

    /**
     * Get application context
     *
     * @return current app context
     */
    public static Context getAppContext() {
        return mAppContext;
    }

    /**
     * Setup app context
     */
    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
    }


}
