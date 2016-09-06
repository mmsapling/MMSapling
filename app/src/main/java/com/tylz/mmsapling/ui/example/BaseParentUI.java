package com.tylz.mmsapling.ui.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.tylz.mmsapling.R;
import com.tylz.mmsapling.base.LoadingPager;

import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.ui.example
 *  @文件名:   BaseParentUI
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/5 16:16
 *  @描述：    TODO
 */
public abstract class BaseParentUI
        extends AppCompatActivity
{
    @Bind(R.id.toolbar)
    Toolbar      mToolbar;
    @Bind(R.id.appbar)
    AppBarLayout mAppbar;
    @Bind(R.id.fl_content)
    FrameLayout  mFlContent;
    LoadingPager mLoadingPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_base);
        ButterKnife.bind(this);
        initData();
        mLoadingPager = new LoadingPager(this) {
            @Override
            protected View onCreateSuccessView() {
                return onSuccessView();
            }

            @Override
            protected LoadedResult onStartLoadData() {
                return onLoadData();
            }
        };
        mFlContent.addView(mLoadingPager);
        loadData();

    }

    protected void loadData() {
        if (mLoadingPager != null) {
            mLoadingPager.loadData();
        }
    }

    protected void initData() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    protected abstract LoadingPager.LoadedResult onLoadData();

    protected abstract View onSuccessView();

    protected LoadingPager.LoadedResult checkState(Object data)
    {
        if (data == null) { return LoadingPager.LoadedResult.EMPTY; }

        if (data instanceof List) {
            if (((List) data).size() == 0) { return LoadingPager.LoadedResult.EMPTY; }
        }

        if (data instanceof Map) {
            if (((Map) data).size() == 0) { return LoadingPager.LoadedResult.EMPTY; }
        }

        return LoadingPager.LoadedResult.SUCCESS;
    }
}
