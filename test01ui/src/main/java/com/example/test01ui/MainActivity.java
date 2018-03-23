package com.example.test01ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.fragment.Fragment1;
import com.example.fragment.Fragment2;
import com.example.fragment.Fragment3;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame;
    private RadioGroup radio_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        初始化数据
        initView();
        final Fragment1 fragment1 = new Fragment1();
        final Fragment2 fragment2 = new Fragment2();
        final Fragment3 fragment3 = new Fragment3();
//        初始化
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment1).commit();
//        监听
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbtn1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment1).commit();
                        break;
                    case R.id.rbtn2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment2).commit();
                        break;
                    case R.id.rbtn3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment3).commit();
                        break;
                }
            }
        });
    }

    private void initView() {
        frame = (FrameLayout) findViewById(R.id.frame);
        radio_group = (RadioGroup) findViewById(R.id.radio_group);
    }
}
