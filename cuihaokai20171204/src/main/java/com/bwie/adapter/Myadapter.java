package com.bwie.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.bean.ReBean;
import com.bwie.cuihaokai.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by cuiha on 2017/12/4.
 */

public class Myadapter extends BaseAdapter {

    private List<ReBean.DataBean> list;
    private Context context;

    public Myadapter(List<ReBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
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
            view=View.inflate(context, R.layout.lv_item,null);
            holder=new ViewHolder();
            holder.img_view=view.findViewById(R.id.img_view);
            holder.tv_title=view.findViewById(R.id.tv_title);
            holder.tv_price=view.findViewById(R.id.tv_price);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }

        holder.tv_title.setText(list.get(i).getTitle());
        holder.tv_price.setText(list.get(i).getPrice()+"");

        String images = list.get(i).getImages();
        String[] split = images.split("\\|");
        Log.i("=====",split[0]);
        MyTask2 myTask2 = new MyTask2(holder.img_view);
        myTask2.execute(split[0]);

        return view;
    }

    class ViewHolder{
        private ImageView img_view;
        private TextView tv_title;
        private TextView tv_price;
    }

    public class MyTask2 extends AsyncTask<String, Void, Bitmap> {

        private ImageView img;

        public MyTask2(ImageView img) {
            this.img = img;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(5000);
                connection.setConnectTimeout(5000);
                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            img.setImageBitmap(bitmap);
        }
    }
}
