package com.bwie.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.bwie.bean.User2;
import com.bwie.cuihaokai.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.List;

/**
 * Created by cuiha on 2017/12/21.
 */

public class MyBaseadapter extends BaseAdapter {

    private List<User2.DataBean> list;
    private Context context;
    private final DisplayImageOptions options;

    public MyBaseadapter(List<User2.DataBean> list, Context context) {
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
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
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
        //设置值
        holder.tv.setText(list.get(0).getName());
        List<User2.DataBean.ListBean> list_02 = this.list.get(0).getList();
        MyGridAdapter myGridAdapter = new MyGridAdapter(list_02, context);
        holder.grid_view.setAdapter(myGridAdapter);
        holder.grid_view.setClickable(false);
//        holder.grid_view.setPressed(false);
        holder.grid_view.setEnabled(false);

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv;
        public GridView grid_view;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.grid_view = (GridView) rootView.findViewById(R.id.grid_view);
        }

    }
}
