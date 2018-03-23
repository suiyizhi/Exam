package com.example.test01ui;

import android.app.Application;

import com.example.util.ImageloaderUtil;

/**
 * Created by cuiha on 2018/3/23.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageloaderUtil.initConfig(this);
    }
}
