package com.tylz.mmsapling.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.adapter
 *  @文件名:   StringAdapter
 *  @创建者:   陈选文
 *  @创建时间:  2016/7/23 19:14
 *  @描述：    TODO
 */
public abstract  class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected List<T> mDatas;
    protected Context  mContext;
    public RecyclerViewAdapter(Context context, List<T> data){
        mContext = context;
        mDatas = data;
    }
    @Override
    public int getItemCount() {
        if(mDatas != null){
            return mDatas.size();
        }
        return 0;
    }
}
