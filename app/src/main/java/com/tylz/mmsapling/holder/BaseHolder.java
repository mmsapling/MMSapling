package com.tylz.mmsapling.holder;

import android.view.View;

/*
 *  @项目名：  GooglePlay 
 *  @包名：    googleplay.code.holder
 *  @文件名:   BaseHolder
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/4 16:00
 *  @描述：    TODO
 */
public abstract class BaseHolder<T> {
    protected View mRootView;
    protected T    mData;
    public BaseHolder(){
        mRootView = initView();
        mRootView.setTag(this);
    }

    protected abstract View initView();

    public View getRootView() {
        return mRootView;
    }
    public void setData(T data){
        this.mData = data;
        refreshUI(data);
    }
    protected  abstract  void refreshUI(T data);
}
