package com.example.dllo.myhunter.tools.network;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 实现类
 */
public class OkHttpImpl implements DlaNetwork {

    private OkHttpClient client;
    // 这样初始化的Handler不论在哪个线程new的,他都属于主线程
    private Handler handler = new Handler(Looper.getMainLooper());
    private Gson mGson;//用来解析数据

    OkHttpImpl() {
        mGson = new Gson();
        File cacheDir = Environment.getExternalStorageDirectory();//获取目录
        client = new OkHttpClient.Builder()
                //设置网络请求的缓存目录    参数1,缓存目录,参数2,缓存大小
                .cache(new Cache(cacheDir, 10 * 1024 * 1024))
                //连接超时的时间     5秒后请求取消
                .connectTimeout(5, TimeUnit.SECONDS)//参1: 时间   参2: 时间单位
                .build();

    }

    @Override
    public void startRequest(String url, final OnHttpCallback<String> callback) {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e);
                    }
                });
            }

            @Override//在子线程里    需要回调主线程
            public void onResponse(Call call, Response response) throws IOException {
                final String resultStr = response.body().string();//在子线程中  应该final
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(resultStr);
                    }
                });
            }
        });
    }

    @Override
    public <T> void startRequest(String url, final Class<T> clazz, final OnHttpCallback<T> callback) {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e);
                    }
                });
            }

            @Override//在子线程里    需要回调主线程
            public void onResponse(Call call, Response response) throws IOException {
                final String resultStr = response.body().string();//在子线程中  应该final
                final T resutEntity = mGson.fromJson(resultStr, clazz);// 解析
                Log.d("meiqingqiu", resultStr);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(resutEntity);//返回一个实体类
                    }
                });
            }
        });
    }

    @Override
    public void startRequest(String url, HashMap<String, String> hashMap, final OnHttpCallback<String> callback) {
        final Request request = new Request.Builder()
                .url(url)
                .headers(Headers.of(hashMap))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e);
                    }
                });
            }

            @Override//在子线程里    需要回调主线程
            public void onResponse(Call call, Response response) throws IOException {
                final String resultStr = response.body().string();//在子线程中  应该final
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(resultStr);
                    }
                });
            }
        });
    }

    @Override
    public <T> void startRequest(String url, HashMap<String, String> hashMap, final Class<T> clazz, final OnHttpCallback<T> callback) {
        final Request request = new Request.Builder()
                .url(url)
                .headers(Headers.of(hashMap))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e);
                    }
                });
            }

            @Override//在子线程里    需要回调主线程
            public void onResponse(Call call, Response response) throws IOException {
                final String resultStr = response.body().string();//在子线程中  应该final
                Log.d("OkHttpImpl", resultStr);
                final T resutEntity = mGson.fromJson(resultStr, clazz);// 解析
                Log.d("qingqiutou", resultStr);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(resutEntity);//返回一个实体类
                    }
                });
            }
        });
    }
}
