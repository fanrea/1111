package com.qq.e.comm.plugin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qg {
    private static final ExecutorService a;
    public static final ExecutorService b;
    public static final ExecutorService c;
    public static final ExecutorService d;
    private static final ScheduledExecutorService e;
    public static final ScheduledExecutorService f;

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool(new a());
        a = executorServiceNewCachedThreadPool;
        b = executorServiceNewCachedThreadPool;
        c = Executors.newSingleThreadExecutor(new b());
        d = Executors.newSingleThreadExecutor(new c());
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new d());
        e = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        f = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    /* compiled from: A */
    class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_IO_THREAD");
        }

        a() {
        }
    }

    /* compiled from: A */
    class b implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_SINGLE_THREAD");
        }

        b() {
        }
    }

    /* compiled from: A */
    class c implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_LOAD_AD_THREAD");
        }

        c() {
        }
    }

    /* compiled from: A */
    class d implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_SCHEDULER_THREAD");
        }

        d() {
        }
    }
}
