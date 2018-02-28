package com.example.cuihaokai20171219;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    private WebView web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        //加载页面
        web_view.loadUrl("https://www.baidu.com");
        WebSettings settings = web_view.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        //设置在本页面打开
        web_view.setWebViewClient(new WebViewClient());
    }

    private void initView() {
        web_view = (WebView) findViewById(R.id.web_view);
    }
}
