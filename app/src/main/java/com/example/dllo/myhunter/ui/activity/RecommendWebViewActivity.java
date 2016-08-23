package com.example.dllo.myhunter.ui.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dllo.myhunter.R;

/**
 * Created by dllo on 16/8/13.
 * 推荐页面二级跳转的webView页面
 */
public class RecommendWebViewActivity extends AbsBaseActivity {
    private String PATH = "path";
    private WebView webView;

    @Override
    protected int setLayout() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initViews() {
        webView = byView(R.id.recommend_webView);

    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        String path = intent.getStringExtra(PATH);
        //设置WebView属性,能够执行JavaScript脚本
        //设置web视图
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        //加载需要显示的网页
        webView.loadUrl(path);

        //这就表明当需要从一个网页跳转到另一个网页的时候,目标网页已然在当前的WebView中显示
        webView.setWebViewClient(new MyWebViewClient());

    }

    // webView视图
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);//根据传入的参数再去加载新的网页
            return true;//表示当前WebView可以处理打开的新网页的请求,不用借助系统浏览器
        }
    }

}
