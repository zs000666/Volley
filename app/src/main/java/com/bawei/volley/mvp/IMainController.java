package com.bawei.volley.mvp;

import com.bawei.volley.net.HttpUtil;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:契约
 * */public interface IMainController {
     // M
     public interface MainModel{
         void https(String url,HttpUtil.CallBack callBack);
     }
     // V
     public interface MianView{
         void showss(String res);
     }
     // P
     public interface MianProsenter{
         void attach(MianView view);
         void patach();
         void requestShow(String url);
     }
}
