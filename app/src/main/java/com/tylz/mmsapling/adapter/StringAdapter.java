package com.tylz.mmsapling.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tylz.mmsapling.R;
import com.tylz.mmsapling.base.RecyclerViewAdapter;

import java.util.List;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.adapter
 *  @文件名:   StringAdapter
 *  @创建者:   陈选文
 *  @创建时间:  2016/7/23 19:19
 *  @描述：    TODO
 */
public class StringAdapter extends RecyclerViewAdapter<String> {
    public StringAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                                     .inflate(R.layout.item_str, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView tv = (TextView) holder.itemView;
        tv.setText(mDatas.get(position));
    }
    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
