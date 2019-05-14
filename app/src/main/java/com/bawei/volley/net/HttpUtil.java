package com.bawei.volley.net;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:请求数据
 * */public class HttpUtil {
     //实例化
     private static HttpUtil httpUtil=new HttpUtil();
     //单例
     public static HttpUtil util(){
         return httpUtil;
     }
     //构造
     private HttpUtil() {
    }

    //get请求数据  volley
    public void doHttpget(String  url, final CallBack back){
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                 back.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                  back.onFail(error.getMessage());
            }
        });
        //响应
        MyApplication.getQueue().add(request);
    }
    //post请求
    public void doHttpPost(String url, String phone, String pwd, final CallBack back){
         final Map<String,String>param=new HashMap<>();
         param.put("phone",phone);
         param.put("pwd",pwd);
         StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {
                   back.onSuccess(response);
             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {
                   back.onFail(error.getMessage());
             }
         });
         MyApplication.getQueue().add(request);
    }
    //接口
    public interface CallBack{
         void onSuccess(String result);
         void onFail(String msg);
    }
}
