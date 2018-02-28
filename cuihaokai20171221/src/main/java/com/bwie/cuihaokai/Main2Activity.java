package com.bwie.cuihaokai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.bawei.jane.mxlistview.view.XListView;
import com.bwie.adapter.MyBaseadapter;
import com.bwie.bean.User2;
import com.bwie.util.MyNetTask;
import com.google.gson.Gson;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private XListView xlv;
    private List<User2.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        xlv = findViewById(R.id.xlv);
        //访问数据
        getData();
        //xlv设置支持上下拉
        xlv.setPullLoadEnable(true);
        xlv.setPullRefreshEnable(true);
        //设置监听
        xlv.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                getData();
                xlv.stopRefresh();
            }

            @Override
            public void onLoadMore() {
                //吐司
                Toast.makeText(Main2Activity.this,"加载更多",Toast.LENGTH_SHORT).show();
                xlv.stopLoadMore();
            }
        });

        xlv.requestFocus();
        //设置长按监听
        xlv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                data.remove(i);
                MyBaseadapter myBaseadapter2 = new MyBaseadapter(data, Main2Activity.this);
                xlv.setAdapter(myBaseadapter2);
                return true;
            }
        });
    }

    public void getData(){
        MyNetTask myNetTask = new MyNetTask(new MyNetTask.IcallBack() {
            @Override
            public void getJsonStr(String jsonstr) {
                Gson gson = new Gson();
                User2 user2 = gson.fromJson(jsonstr, User2.class);
                data = user2.getData();
                //设置适配器
                MyBaseadapter myBaseadapter = new MyBaseadapter(data, Main2Activity.this);
                xlv.setAdapter(myBaseadapter);
            }
        });
        myNetTask.execute("http://120.27.23.105/product/getProductCatagory?cid=1");
    }
}
