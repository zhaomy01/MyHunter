package com.example.dllo.myhunter.tools.network;

import java.util.HashMap;

/**
 * OkHttp 静态内部类形式的单例模式
 */
public class DlaHttp implements DlaNetwork {

    private static final class SingletonHolder {
        private static final DlaHttp INSTANCE = new DlaHttp();
    }

    public static DlaHttp getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //生成一个借口类型的对象
    private DlaNetwork tool;

    private DlaHttp() {
        //多态方法
        tool = new OkHttpImpl();//对修改封闭  对扩展开放

    }
    /**
     * 对外提供方法用于获取网络数据
     */
    public void startRequest(String url, final OnHttpCallback<String> callback) {
        tool.startRequest(url, callback);
    }

    public <T> void startRequest(String url, final Class<T> clazz, final OnHttpCallback<T> callback) {
        tool.startRequest(url, clazz, callback);

    }

    @Override
    public void startRequest(String url, HashMap<String, String> hashMap, OnHttpCallback<String> callback) {
        tool.startRequest(url,hashMap,callback);
    }

    @Override
    public <T> void startRequest(String url, HashMap<String, String> hashMap, Class<T> clazz, OnHttpCallback<T> callback) {
        tool.startRequest(url,hashMap,clazz,callback);
    }

}
