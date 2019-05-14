package com.bawei.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.volley.adapter.MyAdapter;
import com.bawei.volley.bean.Bean;
import com.bawei.volley.mvp.IMainController;
import com.bawei.volley.mvp.MainProsenterImpl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMainController.MianView {

    private RecyclerView rlv;
    private IMainController.MainModel model;
    private IMainController.MianProsenter prosenter;
private String url="http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10";
    private ArrayList<Bean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件
        rlv = findViewById(R.id.rlv);
        //设置布局管理
        rlv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //绑定
        prosenter=new MainProsenterImpl();
        prosenter.attach(this);
        prosenter.requestShow(url);
    }
    //解
    @Override
    protected void onDestroy() {
        super.onDestroy();
        prosenter.patach();
    }
    //展示
    @Override
    public void showss(String res) {
        try {
            JSONObject object=new JSONObject(res);
            JSONArray result1 = object.getJSONArray("result");
            list = new ArrayList<>();
            for (int i = 0; i <result1.length() ; i++) {
                JSONObject obj= (JSONObject) result1.get(i);
                String address = obj.getString("address");
                String logo = obj.getString("logo");
                list.add(new Bean(address,logo));
            }
            MyAdapter adapter=new MyAdapter(list,MainActivity.this);
            rlv.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
