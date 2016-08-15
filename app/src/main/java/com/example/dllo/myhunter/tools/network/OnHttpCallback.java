package com.example.dllo.myhunter.tools.network;


public interface OnHttpCallback<T>{

    void onSuccess(T response);
    void onError(Throwable ex);

}
