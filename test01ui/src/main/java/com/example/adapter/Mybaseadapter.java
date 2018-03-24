package com.example.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.User;
import com.example.test01ui.R;
import com.example.util.ImageloaderUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by cuiha on 2018/3/23.
 */

public class Mybaseadapter extends BaseAdapter {

    private List<User.NewslistBean> list;
    private Context context;
    private final DisplayImageOptions option;

    public Mybaseadapter(List<User.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
        option = ImageloaderUtil.getOption();
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
        if (view == null) {
            view = View.inflate(context, R.layout.lv_item, null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.title.setText(list.get(i).getTitle());
        ImageLoader.getInstance().displayImage(list.get(i).getPicUrl(),holder.img,option);
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView img;
        public TextView title;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.title = (TextView) rootView.findViewById(R.id.title);
        }

    }
}
