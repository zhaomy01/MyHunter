package com.example.dllo.myhunter.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


public class MyApp extends Application {
    private static Context context;
    private static SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        sp = context.getSharedPreferences("MyHunter",MODE_PRIVATE);
    }

    public static Context getContext() {
        return context;
    }
    public static SharedPreferences getSp() {
        return sp;
    }
}
