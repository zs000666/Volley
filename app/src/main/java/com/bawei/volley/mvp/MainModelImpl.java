package com.bawei.volley.mvp;

import com.bawei.volley.net.HttpUtil;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class MainModelImpl implements IMainController.MainModel {
     private HttpUtil httpUtil;

    public MainModelImpl() {
        httpUtil=HttpUtil.util();
    }

    @Override
    public void https(String url, HttpUtil.CallBack callBack) {
       httpUtil.doHttpget(url,callBack);
    }
}
