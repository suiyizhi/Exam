package com.example.cuihaokai20171219;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.adapter.MyAdapter;
import com.example.adapter.MyBaseAdapter;
import com.example.bean.User;
import com.example.util.MyNetTask;
import com.example.util.NetStateUtil;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager view_pager;
    private ListView list_view;
    //创建handler
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
    private PullToRefreshScrollView psv;
    private List<User.DataBean> list=new ArrayList<>();
    private String pathurl="http://www.93.gov.cn/93app/data.do?channelId=0&startNum=";
    private int pageindex=1;
    private String path=pathurl+pageindex;
    private int type=1;
    private MyBaseAdapter myBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        initView();
        //初始化数据
        List<String> list_img = new ArrayList<>();
        list_img.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513657000147&di=281dabc2c044222e816828a9bd1fc6c2&imgtype=0&src=http%3A%2F%2Fpic29.photophoto.cn%2F20131204%2F0034034499213463_b.jpg");
        list_img.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513657000147&di=1dcd3b5ab1ac810b8aaee27562160ae1&imgtype=0&src=http%3A%2F%2Fpic23.photophoto.cn%2F20120530%2F0020033092420808_b.jpg");
        list_img.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513657000147&di=3d8d47040c6cb8e3aa4f32f2e4015d66&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3Dcfb53f93c3177f3e0439f44e18a651b2%2F6609c93d70cf3bc7814060c9db00baa1cd112a56.jpg");
        list_img.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513657000147&di=fe8edb75698762c3c6e51124138f73b5&imgtype=0&src=http%3A%2F%2Fpic21.photophoto.cn%2F20111106%2F0020032891433708_b.jpg");
        //设置适配器
        MyAdapter myAdapter = new MyAdapter(list_img, MainActivity.this);
        view_pager.setAdapter(myAdapter);
        //使用handler轮播
        handler.sendEmptyMessageDelayed(0,1500);

        //判断网络
        if (NetStateUtil.isConn(MainActivity.this)){
            Toast.makeText(MainActivity.this,"网络正常!",Toast.LENGTH_SHORT).show();

            //请求数据
            getData();
            initPsv();
        }else {
            //打开提示框
            NetStateUtil.openDg(MainActivity.this);
        }

    }



    //找控件
    private void initView() {
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        list_view = (ListView) findViewById(R.id.list_view);
        psv = findViewById(R.id.psv);
    }


    private void initPsv() {
        psv.setMode(PullToRefreshBase.Mode.BOTH);
        //设置监听
        psv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                type=1;
                pageindex=1;
                path=pathurl+pageindex;
                getData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                type=2;
                pageindex++;
                path=pathurl+pageindex;
                getData();
            }
        });
    }

    //获取数据
    public void getData(){
        MyNetTask netTask = new MyNetTask(new MyNetTask.IcallBack() {
            @Override
            public void getJsonstr(String jsonstr) {
                Gson gson = new Gson();
                User user = gson.fromJson(jsonstr, User.class);
                if (type==1){
                    list.clear();
                }
                //添加数据
                list.addAll(user.getData());
                setAdapter();
                //关闭刷新布局
                psv.onRefreshComplete();
            }
        });
        netTask.execute(path);
    }

    //设置适配器
    public void setAdapter(){
        if (myBaseAdapter==null){
            myBaseAdapter = new MyBaseAdapter(list, MainActivity.this);
            list_view.setAdapter(myBaseAdapter);
        }else {
            myBaseAdapter.notifyDataSetChanged();
        }
    }
}
