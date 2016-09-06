package com.tylz.mmsapling.ui.example;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tylz.mmsapling.R;
import com.tylz.mmsapling.base.LoadingPager;
import com.tylz.mmsapling.factory.BaseViewFactory;
import com.tylz.mmsapling.protocol.HolderProtocol;
import com.tylz.mmsapling.ui.example.holder.Example1Holder;
import com.tylz.mmsapling.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.ui.example
 *  @文件名:   HolderUI
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/6 16:20
 *  @描述：    TODO
 */
public class HolderUI
        extends BaseParentUI
{
    @Bind(R.id.fl_example1)
    FrameLayout mFlExample1;
    @Bind(R.id.fl_example2)
    FrameLayout mFlExample2;
    HolderProtocol mProtocol;

    @Override
    protected void initData() {
        mToolbar.setTitle("页面分模块使用");
        super.initData();
    }

    @Override
    protected LoadingPager.LoadedResult onLoadData() {
        return LoadingPager.LoadedResult.SUCCESS;
    }

    @Override
    protected View onSuccessView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.ui_holder, null);
        ButterKnife.bind(this,view);
        mProtocol = new HolderProtocol();
        //模块一
        example1();
        //模块二
        mFlExample2.addView(new Example1(UIUtils.getContext()));
        return view;
    }
    private void example1() {
        final Example1Holder example1Holder = new Example1Holder();
        mFlExample1.addView(example1Holder.getRootView());
        example1Holder.setData("原谅我这一生放荡不羁爱自由！");
    }
    /*另外一种实现方法*/
    class Example1 extends LoadingPager{
        private String mData;
        public Example1(Context context) {
            super(context);
            loadData();
        }

        @Override
        protected View onCreateSuccessView() {
            TextView view = BaseViewFactory.getBaseTextView();
            view.setText(mData);
            return view;
        }

        @Override
        protected LoadedResult onStartLoadData() {
            try {
                mData = mProtocol.loadData(0, "");
                if(TextUtils.isEmpty(mData)){
                    return LoadedResult.EMPTY;
                }
                return LoadedResult.SUCCESS;
            } catch (Exception e) {
                e.printStackTrace();
                return LoadedResult.ERROR;
            }
        }
    }
}
