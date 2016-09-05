package com.tylz.mmsapling.manager;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 *  @项目名：  GooglePlay 
 *  @包名：    googleplay.code.manager
 *  @文件名:   ThreadPoolProxy
 *  @创建者:   陈选文
 *  @创建时间:  2016/9/4 16:32
 *  @描述：    TODO
 */
public class ThreadPoolProxy {
    private ThreadPoolExecutor mExecutor;
    private int                corePoolSize;//工作线程的个数
    private int                maximumPoolSize;//最多有多少个工作线程
    private long               keepAliveTime;//

    public ThreadPoolProxy(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
    }

    public Future<?> execute(Runnable task) {
        if (task == null) {
            return null;
        }
        if (mExecutor == null || mExecutor.isShutdown() || mExecutor.isTerminated()) {

            TimeUnit unit = TimeUnit.SECONDS;//时间参数
            // 任务队列
            BlockingQueue<Runnable>  workQueue     = new LinkedBlockingQueue<>();
            ThreadFactory            threadFactory = Executors.defaultThreadFactory();
            RejectedExecutionHandler handler       = new ThreadPoolExecutor.DiscardPolicy();
            mExecutor = new ThreadPoolExecutor(corePoolSize,
                                               maximumPoolSize,
                                               keepAliveTime,
                                               unit,
                                               workQueue,
                                               threadFactory,
                                               handler);
        }
        return mExecutor.submit(task);
    }

    public void remove(Runnable task) {
        mExecutor.getQueue()
                 .remove(task);
    }
}
