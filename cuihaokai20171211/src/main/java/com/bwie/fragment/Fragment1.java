package com.bwie.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.jane.mxlistview.view.XListView;
import com.bwie.bean.Good;
import com.bwie.bean.User;
import com.bwie.cuihaokai.R;
import com.bwie.util.NetStateUtil;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by cuiha on 2017/12/11.
 */

public class Fragment1 extends Fragment {

    private XListView xlv;
    private List<User.DataBean> list_user = null;
    private List<Good.DataBean> list_img = null;
    private List<Good.TuijianBean.ListBean> list_good = null;
    private ImageView img1;
    private GridView gv;
    private GridView gv2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f1, null);
        xlv = v.findViewById(R.id.xlv);
        initView(v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //判断网络
        boolean b = NetStateUtil.isConn(getActivity());
        if (b) {
            Toast.makeText(getActivity(), "网络正常！", Toast.LENGTH_SHORT).show();
            MyTask myTask = new MyTask();
            myTask.execute("http://120.27.23.105/product/getCatagory");
            MyTask2 myTask2 = new MyTask2();
            myTask2.execute("http://120.27.23.105/ad/getAd");

//            ImageLoader.getInstance().displayImage(list_img.get(0).getIcon(),img1);
        }

    }

    private void initView(View v) {
        img1 = (ImageView) v.findViewById(R.id.img1);
        gv = (GridView) v.findViewById(R.id.gv);
        gv2 = (GridView) v.findViewById(R.id.gv2);
    }

    //请求网络的工具类 请求第一个数据
    public class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(5000);
                connection.setConnectTimeout(5000);
                if (connection.getResponseCode() == 200) {
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String str;
                    StringBuilder builder = new StringBuilder();
                    while ((str = bufferedReader.readLine()) != null) {
                        builder.append(str);
                    }
                    bufferedReader.close();
                    return builder.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            User user = gson.fromJson(s, User.class);

            list_user = user.getData();
        }
    }


    //请求网络的工具类 请求第二个数据
    public class MyTask2 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(5000);
                connection.setConnectTimeout(5000);
                if (connection.getResponseCode() == 200) {
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String str;
                    StringBuilder builder = new StringBuilder();
                    while ((str = bufferedReader.readLine()) != null) {
                        builder.append(str);
                    }
                    bufferedReader.close();
                    return builder.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            Good good = gson.fromJson(s, Good.class);

            list_img = good.getData();
            list_good = good.getTuijian().getList();
        }
    }
}
