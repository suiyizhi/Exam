package com.example.util;


import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.example.test01ui.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by cuiha on 2018/3/23.
 */

public class ImageloaderUtil {
    public static void initConfig(Context context){
        File cachefile=context.getExternalCacheDir();
        Log.e("====",cachefile.toString());
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800)//缓存图片最大的长和宽
                .threadPoolSize(2)//线程池的数量
                .threadPriority(4)
                .memoryCacheSize(2 * 1024 * 1024)//设置内存缓存区大小
                .diskCacheSize(20 * 1024 * 1024)//设置sd卡缓存区大小
                .diskCache(new UnlimitedDiscCache(cachefile))//自定义缓存目录
                .writeDebugLogs()//打印日志内容
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//给缓存的文件名进行md5加密处理
                .build();
        ImageLoader.getInstance().init(build);
    }

    public static DisplayImageOptions getOption(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//使用内存缓存
                .cacheOnDisk(true)//使用磁盘缓存
                .showImageOnLoading(R.mipmap.ic_launcher)//设置正在下载的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//url为空或请求的资源不存在时
                .showImageOnFail(R.mipmap.ic_launcher)//下载失败时显示的图片
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片格式
                .build();
        return options;
    }
}
