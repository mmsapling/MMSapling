package com.tylz.mmsapling.ui.example.holder;

import android.view.View;
import android.widget.TextView;

import com.tylz.mmsapling.factory.BaseViewFactory;
import com.tylz.mmsapling.holder.BaseHolder;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.ui.example.holder
 *  @文件名:   ExampleHolder
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/6 16:29
 *  @描述：    TODO
 */
public class Example1Holder
        extends BaseHolder<String>
{

    private TextView mTextView;

    @Override
    protected View initView() {
        mTextView = BaseViewFactory.getBaseTextView();
        return mTextView;
    }

    @Override
    protected void refreshUI(String data) {
        mTextView.setText(data);
    }
}
