package com.bawei.volley.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bawei.volley.R;
import com.bawei.volley.bean.Bean;
import com.bawei.volley.holder.holders;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class MyAdapter extends RecyclerView.Adapter<holders> {
    private ArrayList<Bean> list;
    private Context context;

    public MyAdapter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public holders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new holders(inflater.inflate(R.layout.view_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull holders holders, int i) {
        Bean bean=list.get(i);
        Glide.with(context).load(bean.getLogo()).into(holders.img);
        holders.tv.setText(bean.getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
