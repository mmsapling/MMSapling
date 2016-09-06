package com.tylz.mmsapling.holder;

import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tylz.mmsapling.R;
import com.tylz.mmsapling.bean.ShopBean;
import com.tylz.mmsapling.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.holder
 *  @文件名:   ShopHolder
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/5 20:06
 *  @描述：    TODO
 */
public class ShopHolder
        extends BaseHolder<ShopBean>
{
    @Bind(R.id.item_iv_robot)
    CircleImageView mItemIvRobot;
    @Bind(R.id.item_tv_title)
    TextView        mItemTvTitle;

    @Override
    protected View initView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.item_list_super, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void refreshUI(ShopBean data) {
        Picasso.with(UIUtils.getContext())
               .load(data.picurl)
               .into(mItemIvRobot);
        mItemTvTitle.setText(data.title);
    }
}
