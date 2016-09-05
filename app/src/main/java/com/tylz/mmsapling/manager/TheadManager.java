package com.tylz.mmsapling.manager;

/*
 *  @项目名：  GooglePlay 
 *  @包名：    googleplay.code.manager
 *  @文件名:   TheadManager
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/4 17:14
 *  @描述：    TODO
 */
public class TheadManager {
    private static ThreadPoolProxy mLongPool;
    private static Object mLongLock = new Object();
    public static ThreadPoolProxy getLongRunPool(){

        if(mLongPool == null){
            synchronized (mLongLock){
                if(mLongPool == null){
                    mLongPool = new ThreadPoolProxy(3,3,5L);
                }
            }
        }
        return mLongPool;
    }
}
