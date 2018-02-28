package com.bwie.cuihaokai;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bwie.adapter.Myadapter;
import com.bwie.bean.ReBean;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ShowActivity extends AppCompatActivity {

    private ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        list_view = findViewById(R.id.list_view);
        MyTask myTask = new MyTask();
        myTask.execute("http://120.27.23.105/product/getProducts?pscid=1&page=1&sort=0");
    }

    //自定义一个AsyncTask的类
    public class MyTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            try {
                //创建httpClient
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(strings[0]);
                HttpResponse response = httpClient.execute(httpGet);
                HttpEntity httpEntity = response.getEntity();
                String string = EntityUtils.toString(httpEntity);
                return string;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Gson gson = new Gson();
            ReBean reBean = gson.fromJson(s, ReBean.class);
            Myadapter myadapter = new Myadapter(reBean.getData(), ShowActivity.this);
            list_view.setAdapter(myadapter);
        }
    }
}
