package com.bwie.cuihaokai;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.adapter.MyAdapter;
import com.bwie.bean.User1;
import com.bwie.util.MyNetTask;
import com.bwie.util.NetStateUtil;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager view_pager;
    private TextView tv_title;
    private TextView tv;
    private Button btn_tiao;
    private String[] imgs;
    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int i = view_pager.getCurrentItem();
            i++;
            view_pager.setCurrentItem(i);
            sendEmptyMessageDelayed(0,1500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ArrayList<Integer> ints = new ArrayList<>();
        //判断网络
        if (NetStateUtil.isConn(MainActivity.this)){
            //吐司
            Toast.makeText(MainActivity.this,"网络正常！",Toast.LENGTH_SHORT).show();
            //请求数据
            getData();
        }else {
            //打开设置页面
            NetStateUtil.openDg(MainActivity.this);
        }

    }

    //找控件
    private void initView() {
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv = (TextView) findViewById(R.id.tv);
        btn_tiao = (Button) findViewById(R.id.btn_tiao);
    }

    //请求数据
    public void getData() {
        MyNetTask myNetTask = new MyNetTask(new MyNetTask.IcallBack() {
            @Override
            public void getJsonStr(String jsonstr) {
                Gson gson = new Gson();
                User1 user1 = gson.fromJson(jsonstr, User1.class);
                String images = user1.getData().getImages();
                imgs = images.split("\\|");
                tv_title.setText(user1.getData().getTitle());
                tv.setText(user1.getData().getSubhead());
                //设置适配器
                MyAdapter myAdapter = new MyAdapter(imgs, MainActivity.this);
                view_pager.setAdapter(myAdapter);
                //handler延时发送消息
                handler.sendEmptyMessageDelayed(0,1500);

                //点击监听
                btn_tiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //跳转
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        myNetTask.execute("http://120.27.23.105/product/getProductDetail?pid=1&source=android");
    }



}
