package com.example.dllo.myhunter.ui.activity;

import android.graphics.drawable.AnimationDrawable;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.dllo.myhunter.R;

/**
 * Created by dllo on 16/8/13.
 * 推荐页面二级跳转的webView页面
 */
public class RecommendWebViewActivity extends AbsBaseActivity {
    private WebView webView;
    private String webViewUrl;

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
        //设置WebView属性,能够执行JavaScript脚本
        webView.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        webView.loadUrl(webViewUrl);
        //设置web视图
        webView.setWebViewClient(new HelloWebViewClient());
    }

    //Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
