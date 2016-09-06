package com.tylz.mmsapling.factory;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.tylz.mmsapling.R;
import com.tylz.mmsapling.utils.UIUtils;
import com.tylz.mmsapling.widgets.DividerItemDecoration;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.factory
 *  @文件名:   BaseTvFactory
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/5 16:24
 *  @描述：    TODO
 */
public class BaseViewFactory {
    public static TextView getBaseTextView() {
        TextView tv = new TextView(UIUtils.getContext());
        tv.setText("BaseTextView");
        tv.setTextSize(20);
        tv.setTextColor(0xFFFF0000);
        tv.setGravity(Gravity.CENTER);
        int padding = UIUtils.dip2px(10);
        tv.setPadding(padding, padding, padding, padding);
        tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                      ViewGroup.LayoutParams.WRAP_CONTENT));
        return tv;
    }

    public static ListView getBaseListView() {
        ListView listView = new ListView(UIUtils.getContext());

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                   ViewGroup.LayoutParams.MATCH_PARENT);
        listView.setLayoutParams(params);
        listView.setBackgroundColor(Color.WHITE);
        listView.setCacheColorHint(Color.TRANSPARENT);
        listView.setSelector(android.R.color.transparent);
        listView.setFadingEdgeLength(0);
        listView.setDividerHeight(0);
        listView.setBackgroundColor(UIUtils.getColor(R.color.bg));
        return listView;
    }

    public static RecyclerView getBaseRecyclerView(Context context) {
        RecyclerView recyclerView = new RecyclerView(UIUtils.getContext());
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                ViewGroup.LayoutParams.MATCH_PARENT));
        recyclerView.setLayoutManager(new LinearLayoutManager(UIUtils.getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(context,
                                                                 DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return recyclerView;
    }
}
