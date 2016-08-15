package com.example.dllo.myhunter.tools.network;


import java.util.HashMap;

public interface DlaNetwork {
    // 获取网络数据的返回是String类型的
    void startRequest(String url, OnHttpCallback<String> callback);

    // 获取网络数据的返回是实体类类型的
    <T> void startRequest(String url, Class<T> clazz, OnHttpCallback<T> callback);

    void startRequest(String url, HashMap<String, String> hashMap, OnHttpCallback<String> callback);

    <T> void startRequest(String url, HashMap<String, String> hashMap, Class<T> clazz, OnHttpCallback<T> callback);

}
