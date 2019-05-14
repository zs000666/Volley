package com.bawei.volley.mvp;

import com.bawei.volley.net.HttpUtil;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class MainProsenterImpl implements IMainController.MianProsenter {
     private IMainController.MianView view;
     private IMainController.MainModel model;
    @Override
    public void attach(IMainController.MianView view) {
         this.view=view;
         model=new MainModelImpl();
    }

    @Override
    public void patach() {
         if (view!=null){
             view=null;
         }
         if (model!=null){
             model=null;
         }
    }

    @Override
    public void requestShow(String result) {
        model.https(result, new HttpUtil.CallBack() {
            @Override
            public void onSuccess(String result) {
                view.showss(result);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

}
