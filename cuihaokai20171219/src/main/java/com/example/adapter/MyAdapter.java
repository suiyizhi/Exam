package com.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cuihaokai20171219.Main2Activity;
import com.example.util.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by cuiha on 2017/12/19.
 */

public class MyAdapter extends PagerAdapter{

    private List<String> list;
    private Context context;

    public MyAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
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
    public Object instantiateItem(final ViewGroup container, int position) {
        ImageView view = new ImageView(context);
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageLoader.getInstance().displayImage(list.get(position%list.size()),view, ImageLoaderUtil.getOption());

        //图片设置监听
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转页面
                Intent intent = new Intent(context, Main2Activity.class);
                context.startActivity(intent);
            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
