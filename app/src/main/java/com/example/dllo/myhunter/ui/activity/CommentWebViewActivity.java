package com.example.dllo.myhunter.ui.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.dllo.myhunter.R;

/**
 * Created by zlw on 16/8/18.
 * 评论的WebView
 */
public class CommentWebViewActivity extends AbsBaseActivity {
    private WebView webView;
    private ImageView back;
    @Override
    protected int setLayout() {
        return R.layout.activity_comment_webview;
    }

    @Override
    protected void initViews() {

        webView = byView(R.id.comment_webview);
        back = byView(R.id.comment_webview_back);
    }

    @Override
    protected void initDatas() {

        Intent intent = getIntent();
        String path = intent.getStringExtra("path");
        //设置WebView属性,能够执行JavaScript脚本
        //设置web视图
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        //加载需要显示的网页
        webView.loadUrl(path);

        //这就表明当需要从一个网页跳转到另一个网页的时候,目标网页已然在当前的WebView中显示
        webView.setWebViewClient(new MyWebViewClient());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
