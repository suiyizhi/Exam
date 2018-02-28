package com.bwie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bwie.bean.Good;
import com.bwie.bean.User;

import java.util.List;

/**
 * Created by cuiha on 2017/12/11.
 */

public class MyAdapter extends BaseAdapter{

    private List<User.DataBean> list_user;
    private List<Good.DataBean> list_img;
    private List<Good.TuijianBean.ListBean> list_good;
    private Context context;
    private final int SHANG=0;


    public MyAdapter(List<User.DataBean> list_user, List<Good.DataBean> list_img, List<Good.TuijianBean.ListBean> list_good, Context context) {
        this.list_user = list_user;
        this.list_img = list_img;
        this.list_good = list_good;
        this.context = context;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getCount() {
        return 3;
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
        return null;
    }
}
