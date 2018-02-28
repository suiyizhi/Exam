package com.example.cuihaokai20171219;

import android.app.Application;

import com.example.util.ImageLoaderUtil;

/**
 * Created by cuiha on 2017/12/19.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderUtil.initConfig(this);
    }
}
