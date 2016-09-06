package com.tylz.mmsapling.ui.example;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.tylz.mmsapling.adapter.SuperBaseAdapter;
import com.tylz.mmsapling.base.LoadingPager;
import com.tylz.mmsapling.bean.ShopBean;
import com.tylz.mmsapling.conf.Constants;
import com.tylz.mmsapling.factory.BaseViewFactory;
import com.tylz.mmsapling.holder.BaseHolder;
import com.tylz.mmsapling.holder.ShopHolder;
import com.tylz.mmsapling.protocol.SuperAdapterProtocol;

import java.util.List;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.ui.example
 *  @文件名:   SuperAdapterUI
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/5 19:38
 *  @描述：    TODO
 */
public class SuperAdapterUI
        extends BaseParentUI
{

    private List<ShopBean> mDatas;
    private SuperAdapterProtocol mProtocol;
    public static final String CACHE_NAME = "shop";
    private int page ;
    @Override
    protected void initData() {
        mToolbar.setTitle("ListView强大的适配器");
        super.initData();
        mProtocol = new SuperAdapterProtocol();
        page = 0;
    }

    @Override
    protected LoadingPager.LoadedResult onLoadData() {
        try {

            mDatas = mProtocol.loadData(page,CACHE_NAME);
            if(mDatas == null || mDatas.size() == 0 || mDatas.size() < Constants.PAGE_SIZE){
                page = 0;
            }else{
                page++;
            }
            return checkState(mDatas);
        } catch (Exception e) {
            e.printStackTrace();
            return LoadingPager.LoadedResult.ERROR;
        }
    }

    @Override
    protected View onSuccessView() {
        ListView listView = BaseViewFactory.getBaseListView();
        listView.setAdapter(new SuperAdapter(listView,mDatas));
        return listView;
    }
    class SuperAdapter extends SuperBaseAdapter<ShopBean>{

        public SuperAdapter(AbsListView listView, List<ShopBean> datas) {
            super(listView, datas);
        }

        @Override
        protected BaseHolder<ShopBean> getHolder() {
            return new ShopHolder();
        }
        @Override
        protected List<ShopBean> onLoadMoreData()
                throws Exception
        {
            //因为这里接口问题，太无语,实际上起始位置 和每页的数量由我们自己定
            List<ShopBean> beanList = mProtocol.loadData(page++, mProtocol.fileName);
            if(beanList == null || beanList.size() == 0 ){
                page--;
            }
            return beanList;
        }
    }
}
