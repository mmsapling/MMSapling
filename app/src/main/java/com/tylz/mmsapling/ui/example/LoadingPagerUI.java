package com.tylz.mmsapling.ui.example;

import android.os.SystemClock;
import android.view.View;

import com.tylz.mmsapling.base.LoadingPager;
import com.tylz.mmsapling.factory.BaseViewFactory;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.ui.example
 *  @文件名:   LoadingPagerActivity
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/5 15:35
 *  @描述：    TODO
 */
public class LoadingPagerUI
        extends BaseParentUI
{

    @Override
    protected void initData() {
        mToolbar.setTitle("LoadingPager");
        super.initData();
    }

    @Override
    protected LoadingPager.LoadedResult onLoadData() {
        SystemClock.sleep(1000);
        return LoadingPager.LoadedResult.SUCCESS;
    }

    @Override
    protected View onSuccessView() {
        return BaseViewFactory.getBaseTextView();
    }
}
