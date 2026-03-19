package com.kwai.middleware.azeroth.async;

import com.alipay.sdk.m.u.i;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Async {
    private final ThreadPoolExecutor mGlobalCachedExecutor;
    private final ThreadPoolExecutor mGlobalExecutor;

    static class Holder {
        static final Async INSTANCE = new Async();

        private Holder() {
        }
    }

    public static Async get() {
        return Holder.INSTANCE;
    }

    private Async() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        this.mGlobalExecutor = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 3L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new DefaultThreadFactory("azeroth-global-default-pool"));
        this.mGlobalExecutor.allowCoreThreadTimeOut(true);
        this.mGlobalCachedExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("azeroth-global-cached-pool"));
    }

    public static void execute(Runnable runnable) {
        get().mGlobalExecutor.execute(runnable);
    }

    public static Future<?> submit(Runnable runnable) {
        return get().mGlobalExecutor.submit(runnable);
    }

    public static ThreadPoolExecutor newSingleThreadExecutor(String str) {
        return newFixedThreadPoolExecutor(str, 1);
    }

    public static ThreadPoolExecutor newFixedThreadPoolExecutor(String str, int i) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new DefaultThreadFactory(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ThreadPoolExecutor newFixedThreadPoolExecutor(String str, int i, BlockingQueue blockingQueue) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 1L, TimeUnit.MINUTES, (BlockingQueue<Runnable>) blockingQueue, new DefaultThreadFactory(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ThreadPoolExecutor getCacheThreadPoolExecutor() {
        return get().mGlobalCachedExecutor;
    }

    public static ThreadPoolExecutor getGlobalExecutor() {
        return get().mGlobalExecutor;
    }

    private static String toJsonString(String str, String str2, int i, int i2) {
        return "{name:" + str + ", threadName:" + str2 + ", findSourceCost:" + i + ", duration: " + i2 + i.d;
    }
}
