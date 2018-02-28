package com.bwie.util;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by cuiha on 2017/12/21.
 */

public class MyNetTask extends AsyncTask<String,Void,String>{

    public IcallBack icallBack;

    public MyNetTask(IcallBack icallBack) {
        this.icallBack = icallBack;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            if (connection.getResponseCode()==200){
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String str;
                while ((str=bufferedReader.readLine())!=null){
                    builder.append(str);
                }
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
        icallBack.getJsonStr(s);
    }

    public interface IcallBack{
        void getJsonStr(String jsonstr);
    }
}
