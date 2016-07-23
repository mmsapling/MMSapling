package com.tylz.mmsapling.base;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;



import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;



/**
 * @author cxw
 * @time 2016/3/18 0018 15:02
 * @des 程序的入口类，保存一些公共方法和属性
 * @updateAuthor tylz
 * @updateDate 2016/3/18 0018
 * @updateDes
 */

public class BaseApplication
        extends Application
{
    private static Context mContext;                                                // member
    private static long    mMainThreadId;
    private static Handler mMainThreadHandler;
    private List<Activity> activitys = new LinkedList<Activity>();
    private List<Service>  services  = new LinkedList<Service>();


    public static Context getContext() {
        return mContext;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    @Override
    public void onCreate() {

        super.onCreate();
        init();



    }



    private void init() {
        // 1.上下文
        mContext = getApplicationContext();

        // 2.主线程的Id
        /**
         * Tid Thread Pid Process Uid User
         */
        mMainThreadId = android.os.Process.myTid();

        // 3.创建一个主线程的handler
        mMainThreadHandler = new Handler();
    }



    public void addActivity(Activity activity) {
        activitys.add(activity);
    }

    public void removeActivity(Activity activity) {
        activitys.remove(activity);
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void removeService(Service service) {
        services.remove(service);
    }

    public void closeApplication() {
        closeActivitys();
        closeServices();
    }

    private void closeActivitys() {
        ListIterator<Activity> iterator = activitys.listIterator();
        while (iterator.hasNext()) {
            Activity activity = iterator.next();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private void closeServices() {
        ListIterator<Service> iterator = services.listIterator();
        while (iterator.hasNext()) {
            Service service = iterator.next();
            if (service != null) {
                stopService(new Intent(this, service.getClass()));
            }
        }
    }


}
