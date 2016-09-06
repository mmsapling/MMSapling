package com.tylz.mmsapling.protocol;

import com.tylz.mmsapling.http.HttpUrl;
import com.tylz.mmsapling.utils.FileUtils;
import com.tylz.mmsapling.utils.IOUtils;
import com.tylz.mmsapling.utils.LogUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;

import okhttp3.Response;

/*
 *  @项目名：  MMSapling 
 *  @包名：    com.tylz.mmsapling.protocol
 *  @文件名:   BaseProtocol
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/5 21:38
 *  @描述：    TODO
 */
public abstract class BaseProtocol<T> {
    private static final String DIR      = "json";
    private static final int    DURATION = 5 * 60 * 1000;
    public String fileName;
    /* 缓存文件命名 为  接口名称 + fileName.index*/


    public T loadData(int index, String fileName)
            throws Exception
    {
        this.fileName = fileName;
        //1.到缓存中找
        T data = getDataFromLocal(index, fileName);
        if (data != null) {
            LogUtils.e("从本地缓存中取数据");
            return data;
        }
        //2.从网络中去取数据
        LogUtils.d("从网络中取数据" + index);
        return getDataFromNet(index, fileName, setParams(index));
    }

    private T getDataFromNet(int index, String fileName, Map<String, String> params)
            throws Exception
    {

        String url = HttpUrl.BASE + getName();
        PostFormBuilder postFormBuilder = OkHttpUtils.post()
                                                     .url(url);
        if (params != null && params.size() != 0) {
            postFormBuilder.params(params);
        }
        Response response = postFormBuilder.build()
                                           .execute();
        if (response.code() == 200) {
            //正确返回
            String json = response.body()
                                  .string();
            /*这里可能需要做其他的处理*/
            write2Local(index, fileName, json);
            return parseJson(json);
        }
        throw new RuntimeException("服务器连接异常");

    }

    private void write2Local(int index, String fileName, String json)
            throws Exception
    {
        String         name   = getName() + fileName + "." + index;
        File           file   = new File(FileUtils.getDir(DIR), name);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(System.currentTimeMillis() + "");
            writer.write("\r\n");
            //writer.newLine();
            writer.write(json);
        } finally {
            IOUtils.close(writer);
        }
    }

    private T getDataFromLocal(int index, String fileName)
    {
        //村粗缓存
        String name = getName() + fileName + "." + index;
        File   file = new File(FileUtils.getDir(DIR), name);
        //如果文件不存在，说明本地没有缓存
        if (!file.exists()) {return null;}
        //文件存在
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String timeStr = reader.readLine();//时间戳
            long   time    = Long.valueOf(timeStr);
            if (time + DURATION < System.currentTimeMillis()) {
                //过期了
                return null;
            }
            String json = reader.readLine();//读取json
            return parseJson(json);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            IOUtils.close(reader);
        }
    }

    /**
     * 接口名称，不知道，让子类命名
     * @return
     */
    protected abstract String getName();

    /**
     * 怎么解析json不知道，让子类实现
     * @param json
     *      jsonzifuc
     * @return
     */
    protected abstract T parseJson(String json);

    /**
     * 得到请求参数,子类如有参数复写
     * @return
     */
    protected Map<String, String> setParams(int index) {
        return null;
    }
}
