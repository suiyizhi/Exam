package com.bwie.cuihaokai;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by cuiha on 2017/12/21.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化设置
        File cachefile=getExternalCacheDir();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(480, 800)//缓存图片最大的长和宽
                .threadPoolSize(2)//线程池的数量
                .threadPriority(4)
                .memoryCacheSize(2*1024*1024)//设置内存缓存区大小
                .diskCacheSize(20*1024*1024)//设置sd卡缓存区大小
                .diskCache(new UnlimitedDiscCache(cachefile))//自定义缓存目录
                .writeDebugLogs()//打印日志内容
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//给缓存的文件名进行md5加密处理
                .build();
        ImageLoader.getInstance().init(configuration);
    }
}
