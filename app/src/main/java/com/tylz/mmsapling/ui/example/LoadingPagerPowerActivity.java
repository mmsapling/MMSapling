package com.tylz.mmsapling.ui.example;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.tylz.mmsapling.R;
import com.tylz.mmsapling.base.LoadingPager;
import com.tylz.mmsapling.factory.BaseTvFactory;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.ui.example
 *  @文件名:   LoadingPagerPowerActivity
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/5 16:53
 *  @描述：    TODO
 */
public class LoadingPagerPowerActivity
        extends AppCompatActivity
{
    @Bind(R.id.fl_loading)
    FrameLayout  mFlLoading;
    @Bind(R.id.fl_error)
    FrameLayout  mFlError;
    @Bind(R.id.fl_empty)
    FrameLayout  mFlEmpty;
    @Bind(R.id.fl_success)
    FrameLayout  mFlSuccess;
    @Bind(R.id.toolbar)
    Toolbar      mToolbar;
    @Bind(R.id.appbar)
    AppBarLayout mAppbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_loading_pager_power);
        ButterKnife.bind(this);
        init();
        initData();
    }

    private void initData() {
        mFlLoading.addView(new LoadingFrame(this));
        mFlEmpty.addView(new EmptyFrame(this));
        mFlError.addView(new ErrorFrame(this));
        mFlSuccess.addView(new SuccessFrame(this));
    }

    protected void init() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitle("强大的LoadingPager");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    class LoadingFrame
            extends LoadingPager
    {

        public LoadingFrame(Context context) {
            super(context);
            loadData();
        }

        @Override
        protected View onCreateSuccessView() {
            return null;
        }

        @Override
        protected LoadedResult onStartLoadData() {
            return null;
        }
    }

    class EmptyFrame
            extends LoadingPager
    {

        public EmptyFrame(Context context) {
            super(context);
            loadData();
        }

        @Override
        protected View onCreateSuccessView() {
            return null;
        }

        @Override
        protected LoadedResult onStartLoadData() {
            SystemClock.sleep(2000);
            return LoadedResult.EMPTY;
        }
    }

    class ErrorFrame
            extends LoadingPager
    {

        public ErrorFrame(Context context) {
            super(context);
            loadData();
        }

        @Override
        protected View onCreateSuccessView() {
            return null;
        }

        @Override
        protected LoadedResult onStartLoadData() {
            SystemClock.sleep(2000);
            return LoadedResult.ERROR;
        }
    }
    class SuccessFrame
            extends LoadingPager
    {

        public SuccessFrame(Context context) {
            super(context);
            loadData();
        }

        @Override
        protected View onCreateSuccessView() {
            return BaseTvFactory.getBaseTextView();
        }

        @Override
        protected LoadedResult onStartLoadData() {
            SystemClock.sleep(2000);
            return LoadedResult.SUCCESS;
        }
    }
}
