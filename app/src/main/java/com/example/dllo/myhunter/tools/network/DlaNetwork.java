package com.example.dllo.myhunter.tools.network;


public interface DlaNetwork {
    // 获取网络数据的返回是String类型的
    void startRequest(String url, OnHttpCallback<String> callback);
    // 获取网络数据的返回是实体类类型的
    <T> void startRequest(String url, Class<T> clazz, OnHttpCallback<T> callback);


}
