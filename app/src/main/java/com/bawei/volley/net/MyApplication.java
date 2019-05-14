package com.bawei.volley.net;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:响应
 * */public class MyApplication extends Application {

    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();

        queue = Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getQueue(){
        return queue;
    }
}
