package com.tylz.mmsapling.ui;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.tylz.mmsapling.R;
import com.tylz.mmsapling.fragment.DetailFra;
import com.tylz.mmsapling.utils.UIUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.ui
 *  @文件名:   TabLayoutUI
 *  @创建者:   陈选文
 *  @创建时间:  2016/7/23 21:28
 *  @描述：    TODO
 */
public class TabLayoutUI
        extends AppCompatActivity
{
    @Bind(R.id.ivImage)
    ImageView               mIvImage;
    @Bind(R.id.toolbar)
    Toolbar                 mToolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @Bind(R.id.sliding_tabs)
    TabLayout               mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager               mViewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.ui_tab_layout);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mCollapsingToolbar.setTitle(UIUtils.getString(R.string.app_name));
        mIvImage.setImageResource(R.mipmap.title);
        setupViewPager(mViewpager);
        setupTab(mTabLayout,mViewpager);
    }

    private void setupTab(TabLayout tableLayout,ViewPager viewpager) {
        tableLayout.addTab(tableLayout.newTab()
                                      .setText(R.string.article1));
        tableLayout.addTab(tableLayout.newTab()
                                      .setText(R.string.article2));
        tableLayout.addTab(tableLayout.newTab()
                                      .setText(R.string.article3));
        tableLayout.setupWithViewPager(mViewpager);
    }

    private void setupViewPager(ViewPager viewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFrament(DetailFra.newInstance(getAsset("article2.txt")),
                           UIUtils.getString(R.string.article1));
        adapter.addFrament(DetailFra.newInstance(getAsset("article1.txt")),
                           UIUtils.getString(R.string.article2));
        adapter.addFrament(DetailFra.newInstance(getAsset("article3.txt")),
                           UIUtils.getString(R.string.article3));
        viewPager.setAdapter(adapter);
    }

    private String getAsset(String fileName) {
        AssetManager am = getResources().getAssets();
        InputStream  is = null;
        try {
            is = am.open(fileName, AssetManager.ACCESS_BUFFER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scanner(is).useDelimiter("\\Z")
                              .next();
    }

    static class MyPagerAdapter
            extends FragmentPagerAdapter
    {
        private List<Fragment> mFragments      = new ArrayList<>();
        private List<String>   mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFrament(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);

        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
