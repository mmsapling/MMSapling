package com.tylz.mmsapling.factory;

import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.tylz.mmsapling.R;
import com.tylz.mmsapling.utils.UIUtils;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.factory
 *  @文件名:   BaseTvFactory
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/5 16:24
 *  @描述：    TODO
 */
public class BaseViewFactory {
    public static TextView getBaseTextView(){
        TextView tv = new TextView(UIUtils.getContext());
        tv.setText("BaseTextView");
        tv.setTextSize(20);
        tv.setTextColor(0xFFFF0000);
        tv.setGravity(Gravity.CENTER);
        tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        return tv;
    }
    public static ListView getBaseListView(){
        ListView listView = new ListView(UIUtils.getContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                   ViewGroup.LayoutParams.MATCH_PARENT);
        listView.setLayoutParams(params);
        listView.setCacheColorHint(Color.TRANSPARENT);
        listView.setSelector(android.R.color.transparent);
        listView.setFadingEdgeLength(0);
        listView.setDividerHeight(0);
        listView.setBackgroundColor(UIUtils.getColor(R.color.bg));
        return listView;
    }
}
