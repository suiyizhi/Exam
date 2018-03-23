package com.example.util;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by cuiha on 2018/3/23.
 */

public class MyNetTask extends AsyncTask<String,Void,String> {

    private Icallback icallback;

    public MyNetTask(Icallback icallback) {
        this.icallback = icallback;
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
                StringBuilder builder = new StringBuilder();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
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
        icallback.getjson(s);
    }

    public interface Icallback{
        public void getjson(String jsonstr);
    }
}
