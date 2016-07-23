package com.tylz.mmsapling.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.tylz.mmsapling.R;
import com.tylz.mmsapling.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.ui
 *  @文件名:   TextInputLayoutUI
 *  @创建者:   陈选文
 *  @创建时间:  2016/7/23 20:10
 *  @描述：    TODO
 */
public class TextInputLayoutUI
        extends AppCompatActivity
{
    @Bind(R.id.toolbar)
    Toolbar              mToolbar;
    @Bind(R.id.appbar)
    AppBarLayout         mAppbar;
    @Bind(R.id.layout_user)
    TextInputLayout      mLayoutUser;
    @Bind(R.id.layout_pwd)
    TextInputLayout      mLayoutPwd;
    @Bind(R.id.layout_fab)
    FloatingActionButton mFab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       initView();
    }

    private void initView() {
        setContentView(R.layout.ui_text_input_layout);
        ButterKnife.bind(this);
        mToolbar.setTitle(R.string.login);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              showSnack();
            }
        });
        EditText etPwd = mLayoutPwd.getEditText();
        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 6){
                    mLayoutPwd.setError(UIUtils.getString(R.string.error_pwd_long));
                    mLayoutPwd.setErrorEnabled(true);
                }else{
                    mLayoutPwd.setErrorEnabled(false);
                }
            }
        });
        EditText etUser = mLayoutUser.getEditText();
        etUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s)){
                    mLayoutUser.setErrorEnabled(false);
                }else{
                    mLayoutUser.setError(UIUtils.getString(R.string.error_user_sb));
                    mLayoutUser.setErrorEnabled(true);
                }
            }
        });
    }

    private void showSnack() {
        Snackbar.make(mFab, R.string.exit, Snackbar.LENGTH_LONG).setAction(R.string.confirm,
                                                                           new View.OnClickListener() {
                                                                             @Override
                                                                             public void onClick(View v) {
                                                                                 finish();
                                                                             }
                                                                         }).show();
    }
}
