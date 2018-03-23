package com.example.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.util.ImageloaderUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by cuiha on 2018/3/23.
 */

public class Myadapter extends PagerAdapter {

    private List<String> list;
    private Context context;

    public Myadapter(List<String> list, Context context) {
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
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = new ImageView(context);
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageLoader.getInstance().displayImage(list.get(position%list.size()),view, ImageloaderUtil.getOption());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
