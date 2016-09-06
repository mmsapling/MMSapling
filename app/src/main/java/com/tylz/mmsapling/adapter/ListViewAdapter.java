package com.tylz.mmsapling.adapter;

import android.widget.AbsListView;

import com.tylz.mmsapling.bean.ShopBean;
import com.tylz.mmsapling.holder.BaseHolder;
import com.tylz.mmsapling.holder.ShopHolder;
import com.tylz.mmsapling.protocol.SuperAdapterProtocol;

import java.util.List;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.adapter
 *  @文件名:   ListViewAdapter
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/5 19:53
 *  @描述：    TODO
 */
public class ListViewAdapter extends SuperBaseAdapter<ShopBean>  {
    private SuperAdapterProtocol mProtocol;
    public ListViewAdapter(AbsListView listView, List<ShopBean> datas,SuperAdapterProtocol protocol) {
        super(listView, datas);
        this.mProtocol = protocol;
    }

    @Override
    protected BaseHolder<ShopBean> getHolder() {
        return new ShopHolder();
    }
    @Override
    protected List<ShopBean> onLoadMoreData()
            throws Exception
    {
        return mProtocol.loadData(1,mProtocol.fileName);
    }
}
