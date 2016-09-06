package com.tylz.mmsapling.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tylz.mmsapling.R;

/*
 *  @项目名：  CoordinatorLayoutDemo 
 *  @包名：    com.tylz.coordinatorlayoutdemo
 *  @文件名:   DetailFragment
 *  @创建者:   陈选文
 *  @创建时间:  2016/7/23 13:57
 *  @描述：    TODO
 */
public class DetailFra
        extends Fragment
{
    public static DetailFra newInstance(String info) {
        Bundle    args     = new Bundle();
        DetailFra fragment = new DetailFra();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View     view   = inflater.inflate(R.layout.fra_detail, null);
        TextView tvInfo = (TextView) view.findViewById(R.id.tvInfo);
        tvInfo.setText(getArguments().getString("info"));
        return view;
    }
}
