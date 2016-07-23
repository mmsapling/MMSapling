package com.tylz.mmsapling.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.tylz.mmsapling.R;
import com.tylz.mmsapling.adapter.StringAdapter;
import com.tylz.mmsapling.utils.UIUtils;
import com.tylz.mmsapling.widgets.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.ui
 *  @文件名:   AppBarLayoutUI
 *  @创建者:   陈选文
 *  @创建时间:  2016/7/23 20:54
 *  @描述：    TODO
 */
public class AppBarLayoutUI
        extends AppCompatActivity
{
    @Bind(R.id.ivImage)
    ImageView               mIvImage;
    @Bind(R.id.toolbar)
    Toolbar                 mToolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @Bind(R.id.ui_recycler_view)
    RecyclerView            mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.ui_appbar_layout);
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
        setupRecyclerView(mRecyclerView);

    }
    private void setupRecyclerView(RecyclerView recyclerview) {

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);
        recyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(new StringAdapter(this, data()));
    }
    public List<String> data(){
        ArrayList<String> datas = new ArrayList<String>();
        PackageManager    pm = getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN,null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> infos = pm.queryIntentActivities(mainIntent,
                                                                  PackageManager.MATCH_DEFAULT_ONLY);
        for(ResolveInfo info :infos){
            datas.add((String) info.loadLabel(pm));
        }
        return datas;
    }
}
