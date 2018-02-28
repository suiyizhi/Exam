package com.example.zhaoliying;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by cuiha on 2018/1/22.
 */

public class Mypageradapter extends PagerAdapter{

    private List<Integer> list;
    private Context context;


    public Mypageradapter(List<Integer> list, Context context) {
        super();
        this.list = list;
        this.context = context;
    }

    /**
     * 由于只返回了集合里面的4张图片,,,如果想要轮播,,就需要无限大的数量
     */
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;// 无线大的数值
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(list.get(position % list.size()));
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
