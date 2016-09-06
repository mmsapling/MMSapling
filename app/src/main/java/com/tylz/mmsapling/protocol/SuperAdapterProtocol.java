package com.tylz.mmsapling.protocol;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tylz.mmsapling.bean.ShopBean;
import com.tylz.mmsapling.http.HttpUrl;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.protocol
 *  @文件名:   SuperAdapterProtocol
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/5 21:35
 *  @描述：    TODO
 */
public class SuperAdapterProtocol extends BaseProtocol<List<ShopBean>> {
    @Override
    protected Map<String, String> setParams(int index) {
        Map<String, String> params = new HashMap<>();
        params.put("id", HttpUrl.id);
        params.put("type", "基础动作");
        params.put("page", "" + index);
        return params;
    }

    @Override
    protected String getName() {
        return "getGoodsList";
    }

    @Override
    protected List<ShopBean> parseJson(String json) {
        Type type = new TypeToken<List<ShopBean>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }
}
