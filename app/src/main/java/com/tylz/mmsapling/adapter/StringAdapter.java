package com.tylz.mmsapling.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tylz.mmsapling.base.RecyclerViewAdapter;
import com.tylz.mmsapling.factory.BaseViewFactory;

import java.util.List;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.adapter
 *  @文件名:   StringAdapter
 *  @创建者:   陈选文
 *  @创建时间:  2016/7/23 19:19
 *  @描述：    TODO
 */
public class StringAdapter
        extends RecyclerViewAdapter<String>
{
    public StringAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        TextView tv = new TextView(UIUtils.getContext());
//        tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                                                      ViewGroup.LayoutParams.WRAP_CONTENT));
//        int padding = UIUtils.dip2px(10);
//        tv.setPadding(padding, padding, padding, padding);
//        tv.setTextColor(UIUtils.getColor(R.color.colorPrimary));
//        //      TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,12,UIUtils.getResources().getDisplayMetrics());
//        tv.setTextSize(18);
        TextView tv = BaseViewFactory.getBaseTextView();
        return new ViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView tv = (TextView) holder.itemView;
        tv.setText(mDatas.get(position));
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder
    {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
