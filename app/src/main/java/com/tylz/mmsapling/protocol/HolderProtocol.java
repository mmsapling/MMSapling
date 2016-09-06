package com.tylz.mmsapling.protocol;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.protocol
 *  @文件名:   HolderProtocol
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/6 16:33
 *  @描述：    TODO
 */
public class HolderProtocol extends BaseProtocol<String> {
    @Override
    protected String getName() {
        return "getHelpInfo";
    }

    @Override
    protected String parseJson(String json) {
        return json;
    }
}
