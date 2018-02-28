package com.bwie.cuihaokai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    /**
     * 请输入手机号
     */
    private EditText ed_tell;
    /**
     * 请输入密码
     */
    private EditText ed_pass;
    /**
     * 注册
     */
    private Button btn_login;
    //创建handler
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String data = (String) msg.obj;
            Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
            startActivity(intent);
            finish();

            if (msg.what == 2) {
                Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent2);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();

        //btn_login的监听事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断网络是否可用
                ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = manager.getActiveNetworkInfo();
                if (info != null && info.isAvailable()) {
                    //网络可用请求数据
                    //创建子线程
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            //请求数据
                            requestData();
                        }
                    }.start();
                } else {
                    Toast.makeText(MainActivity.this, "网络不可用", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void initView() {
        ed_tell = (EditText) findViewById(R.id.ed_tell);
        ed_pass = (EditText) findViewById(R.id.ed_pass);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    private void requestData() {
        String tell = ed_tell.getText().toString();
        String pass = ed_pass.getText().toString();
//                Message msg2 = Message.obtain();
//                msg2.what=2;
//                msg2.obj="注册成功";
//                handler.sendMessage(msg2);
        //HttpURLConnection请求数据
        try {
            URL url = new URL("http://120.27.23.105/user/reg" + "?mobile=" + tell + "&password=" + pass);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    builder.append(str);
                }
                bufferedReader.close();
                String string = builder.toString();
                //使用handler发送消息
                Message msg = Message.obtain();
                msg.obj = string;
                handler.sendMessage(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



