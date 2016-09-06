package com.tylz.mmsapling.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tylz.mmsapling.R;
import com.tylz.mmsapling.adapter.StringAdapter;
import com.tylz.mmsapling.factory.BaseViewFactory;
import com.tylz.mmsapling.ui.AppBarLayoutUI;
import com.tylz.mmsapling.ui.TabLayoutUI;
import com.tylz.mmsapling.ui.TextInputLayoutUI;
import com.tylz.mmsapling.utils.UIUtils;
import com.tylz.mmsapling.widgets.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.activity.fragment
 *  @文件名:   WidgetFra
 *  @创建者:   陈选文
 *  @创建时间:  2016/7/23 18:50
 *  @描述：    TODO
 */
public class WidgetFra
        extends Fragment
{
    RecyclerView mRecyclerview;
    List<String> mDatas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        mRecyclerview = BaseViewFactory.getBaseRecyclerView(getContext());

        return mRecyclerview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupRecyclerView(mRecyclerview);
    }

    private void setupRecyclerView(RecyclerView recyclerview) {
        String[] arr = UIUtils.getStringArray(R.array.widget_arr);
        mDatas = arr2list(arr);

        recyclerview.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                                                                          mItemClickListener));

        recyclerview.setAdapter(new StringAdapter(getActivity(), mDatas));
    }

    private List<String> arr2list(String[] arr) {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            datas.add(arr[i]);
        }
        return datas;
    }

    private RecyclerItemClickListener.OnItemClickListener mItemClickListener = new RecyclerItemClickListener.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Intent intent = null;
            switch (position) {
                case 0:
                    intent = new Intent(getActivity(), TextInputLayoutUI.class);
                    break;
                case 1:
                    intent = new Intent(getActivity(), AppBarLayoutUI.class);
                    break;
                case 2:
                    intent = new Intent(getActivity(), TabLayoutUI.class);
                    break;
            }
            startActivity(intent);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
