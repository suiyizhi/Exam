package com.bwie.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.bean.User2;
import com.bwie.cuihaokai.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by cuiha on 2017/12/21.
 */

public class MyGridAdapter extends BaseAdapter {

    private List<User2.DataBean.ListBean> list;
    private Context context;
    private final DisplayImageOptions options;

    public MyGridAdapter(List<User2.DataBean.ListBean> list, Context context) {
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
            view = View.inflate(context, R.layout.item2, null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }

        holder.tv_tit.setText(list.get(i).getName());
        ImageLoader.getInstance().displayImage(list.get(i).getIcon(),holder.img,options);

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView img;
        public TextView tv_tit;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.tv_tit = (TextView) rootView.findViewById(R.id.tv_tit);
        }

    }
}
