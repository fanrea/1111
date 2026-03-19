package com.kwad.sdk.live.audience.net;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class KSLiveTaskExecutor {
    private static final int CORE_THREAD_NUM = 5;
    private static final long KEEP_ALIVE_TIME = 10;
    private static final ThreadPoolExecutor THREAD_EXECUTOR = new ThreadPoolExecutor(5, Integer.MAX_VALUE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new SynchronousQueue(true), new KSLiveThreadFactory());

    public static void execute(Runnable runnable) {
        if (runnable != null) {
            THREAD_EXECUTOR.execute(runnable);
        }
    }

    public static void cancel(Runnable runnable) {
        if (runnable != null) {
            THREAD_EXECUTOR.remove(runnable);
        }
    }
}
