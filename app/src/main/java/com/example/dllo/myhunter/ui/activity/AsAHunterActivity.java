package com.example.dllo.myhunter.ui.activity;


import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dllo.myhunter.R;

/**
 * 成为猎人页面
 */
public class AsAHunterActivity extends AbsBaseActivity {
    private String url ="http://web.breadtrip.com/m/club/join_city_hunter/";
    private WebView asahunter_webview;


    @Override
    protected int setLayout() {
        return R.layout.activity_asahunter;
    }

    @Override
    protected void initViews() {
        asahunter_webview = byView(R.id.asahunter_webview);
    }

    @Override
    protected void initDatas() {
        //设置WebView属性,能够执行JavaScript脚本
        //设置web视图
        asahunter_webview.getSettings().setJavaScriptEnabled(true);
        asahunter_webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        //加载需要显示的网页
        asahunter_webview.loadUrl(url);

        //这就表明当需要从一个网页跳转到另一个网页的时候,目标网页已然在当前的WebView中显示
        asahunter_webview.setWebViewClient(new MyWebViewClient());

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
