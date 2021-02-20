package com.sewageproject.base;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    public static String HTTP_BASE_URL = "http://jwushui.seater.cn:81/jeecg-boot/";//开发环境
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
