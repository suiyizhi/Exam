package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.User;
import com.example.cuihaokai20171219.R;
import com.example.util.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by cuiha on 2017/12/19.
 */

public class MyBaseAdapter extends BaseAdapter {

    private List<User.DataBean> list;
    private Context context;
    private final DisplayImageOptions option;

    public MyBaseAdapter(List<User.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        //初始化图片设置
        option = ImageLoaderUtil.getOption();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view==null){
            view = View.inflate(context, R.layout.item, null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.tv.setText(list.get(i).getTITLE());
        ImageLoader.getInstance().displayImage(list.get(i).getIMAGEURL(),holder.img,option);
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView img;
        public TextView tv;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
}
