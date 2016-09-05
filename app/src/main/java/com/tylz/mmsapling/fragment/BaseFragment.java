package com.tylz.mmsapling.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.tylz.mmsapling.base.LoadingPager;
import com.tylz.mmsapling.utils.UIUtils;

import java.util.List;
import java.util.Map;


/*
 *  @项目名：  GooglePlay 
 *  @包名：    googleplay.code.fragment
 *  @文件名:   BaseFragment
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/3 22:31
 *  @描述：    TODO
 */
public abstract class BaseFragment
        extends Fragment
{
    private LoadingPager mPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        if(mPager == null){
            mPager = new LoadingPager(UIUtils.getContext()){

                @Override
                protected View onCreateSuccessView() {
                    return onSuccessView();
                }

                @Override
                protected LoadedResult onStartLoadData() {
                    return onLoadData();
                }
            };
        }else{
            ViewParent parent = mPager.getParent();
            if(parent != null && parent instanceof ViewGroup){
                ((ViewGroup)parent).removeView(mPager);
            }
        }

        return mPager;
    }
    public void loadData(){
        if(mPager != null){
            mPager.loadData();
        }
    }
    protected  abstract View onSuccessView();
    protected  abstract LoadingPager.LoadedResult onLoadData();
    protected LoadingPager.LoadedResult checkState(Object data)
    {
        if (data == null) { return LoadingPager.LoadedResult.EMPTY; }

        if (data instanceof List)
        {
            if (((List) data).size() == 0) { return LoadingPager.LoadedResult.EMPTY; }
        }

        if (data instanceof Map)
        {
            if (((Map) data).size() == 0) { return LoadingPager.LoadedResult.EMPTY; }
        }

        return LoadingPager.LoadedResult.SUCCESS;
    }

}
