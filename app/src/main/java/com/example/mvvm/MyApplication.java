package com.example.mvvm;


import android.app.Application;

import com.example.mvvm.db.AppDatabase;

/**
 * Author: KomoriWu
 * Date: 2019/8/28 13:39
 * Description :
 */
public class MyApplication extends Application {
    private static MyApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        AppDatabase.getInstance();
    }

    public static MyApplication getApplication() {
        return sApplication;
    }
}
