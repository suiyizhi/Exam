package com.bwie.cuihaokai;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.bwie.adapter.MyfragAdapter;
import com.bwie.fragment.Fragment1;
import com.bwie.fragment.Fragment2;
import com.bwie.fragment.Fragment3;
import com.bwie.fragment.Fragment4;
import com.bwie.fragment.Fragment5;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager view_pager;
    private RadioGroup radio_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //创建集合添加数据
        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        list.add(new Fragment4());
        list.add(new Fragment5());

        //设置适配器
        MyfragAdapter myfragAdapter = new MyfragAdapter(getSupportFragmentManager(), list);
        view_pager.setAdapter(myfragAdapter);
        //滑动监听
        view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radio_group.check(radio_group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //radio_group的监听
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbtn01:
                        view_pager.setCurrentItem(0);
                        break;
                    case R.id.rbtn02:
                        view_pager.setCurrentItem(1);
                        break;
                    case R.id.rbtn03:
                        view_pager.setCurrentItem(2);
                        break;
                    case R.id.rbtn04:
                        view_pager.setCurrentItem(3);
                        break;
                    case R.id.rbtn05:
                        view_pager.setCurrentItem(4);
                        break;
                }
            }
        });
    }
    //找控件
    private void initView() {
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        radio_group = (RadioGroup) findViewById(R.id.radio_group);
    }
}
