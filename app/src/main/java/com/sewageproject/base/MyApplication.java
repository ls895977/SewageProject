package com.sewageproject.base;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Context application;

    public static Context getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
