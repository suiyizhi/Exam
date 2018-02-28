package com.example.zhaoliying;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager vp;
    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Toast.makeText(Main2Activity.this,"左右滑动可以切换!",Toast.LENGTH_SHORT).show();

        list = new ArrayList<>();
        list.add(R.mipmap.a1);
        list.add(R.mipmap.a2);
        list.add(R.mipmap.a3);
        list.add(R.mipmap.a4);
        list.add(R.mipmap.a5);
        list.add(R.mipmap.a6);
        list.add(R.mipmap.a7);
        list.add(R.mipmap.a8);
        list.add(R.mipmap.a9);
        list.add(R.mipmap.a10);
        list.add(R.mipmap.a11);
        list.add(R.mipmap.a12);

        Mypageradapter mypageradapter = new Mypageradapter(list, Main2Activity.this);
        vp.setAdapter(mypageradapter);

    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
    }
}
