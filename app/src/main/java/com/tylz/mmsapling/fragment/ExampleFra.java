package com.tylz.mmsapling.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.activity.fragment
 *  @文件名:   ExampleFra
 *  @创建者:   陈选文
 *  @创建时间:  2016/7/23 16:21
 *  @描述：    TODO
 */
public class ExampleFra extends Fragment {
    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
//        View view = inflater.inflate(R.layout.fra_example, null);
//        mRecyclerView = (RecyclerView) view.findViewById(R.id.example_recyclerview);
        TextView view = new TextView(getActivity());
        view.setText(this.getClass().getSimpleName());
        view.setGravity(Gravity.CENTER);
        view.setTextSize(20);
        return view;
    }
}
