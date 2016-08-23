package com.example.dllo.myhunter.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.dllo.myhunter.R;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dllo on 16/8/13.
 * 推荐页面二级跳转的webView页面
 */
public class RecommendWebViewActivity extends AbsBaseActivity implements View.OnClickListener {
    private WebView webView;
    private ImageView collection, share, back;
    private ProgressBar progressBar;
    private ProgressDialog dialog;


    @Override
    protected int setLayout() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initViews() {
        webView = byView(R.id.recommend_webView);
        collection = byView(R.id.webView_collection);
        share = byView(R.id.webview_share);
        back = byView(R.id.webview_back);
        progressBar = byView(R.id.loading);


    }

    @Override
    protected void initDatas() {
        WebChromeClient client = new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {

                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }
            }
        };
        webView.setWebChromeClient(client);


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

        share.setOnClickListener(this);
        collection.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.webView_collection:
                break;
            case R.id.webview_share:
                showShare();

                break;
            case R.id.webview_back:
                finish();
                break;
        }
    }

    // webView视图
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);//根据传入的参数再去加载新的网页
            return true;//表示当前WebView可以处理打开的新网页的请求,不用借助系统浏览器
        }
    }

    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }

}
