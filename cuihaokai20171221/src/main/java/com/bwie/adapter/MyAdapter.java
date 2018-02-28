package com.bwie.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.cuihaokai.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by cuiha on 2017/12/21.
 */

public class MyAdapter extends PagerAdapter{

    private String[] list;
    private Context context;
    private final DisplayImageOptions options;

    public MyAdapter(String[] list, Context context) {
        this.list = list;
        this.context = context;
        //图片缓存设置
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//使用内存缓存
                .cacheOnDisk(true)//使用磁盘缓存
                .showImageOnLoading(R.mipmap.ic_launcher)//设置正在下载的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//url为空或请求的资源不存在时
                .showImageOnFail(R.mipmap.ic_launcher)//下载失败时显示的图片
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片格式
                .build();
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView view = new ImageView(context);
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageLoader.getInstance().displayImage(list[position%list.length],view,options);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
