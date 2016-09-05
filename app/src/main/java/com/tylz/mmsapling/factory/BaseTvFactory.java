package com.tylz.mmsapling.factory;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tylz.mmsapling.utils.UIUtils;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.factory
 *  @文件名:   BaseTvFactory
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/5 16:24
 *  @描述：    TODO
 */
public class BaseTvFactory {
    public static TextView getBaseTextView(){
        TextView tv = new TextView(UIUtils.getContext());
        tv.setText("BaseTextView");
        tv.setTextSize(20);
        tv.setTextColor(0xFFFF0000);
        tv.setGravity(Gravity.CENTER);
        tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        return tv;
    }
}
