package com.bytedance.common.utility.concurrent;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ThreadPlus implements Runnable {
    private final boolean mBackground;
    private Runnable runnable;
    private static ExecutorService mCachedExecutor = TTExecutors.getNormalExecutor();
    private static ExecutorService mFixedExecutor = TTExecutors.getNormalExecutor();
    protected static final AtomicInteger S_COUNT = new AtomicInteger();

    public static void shutdown() {
    }

    public ThreadPlus(Runnable runnable, String str, boolean z) {
        this.runnable = runnable;
        this.mBackground = z;
    }

    public ThreadPlus(String str) {
        this(false);
    }

    public ThreadPlus() {
        this(false);
    }

    public ThreadPlus(boolean z) {
        this.mBackground = z;
    }

    public static void setExecutorService(ExecutorService executorService) {
        mCachedExecutor = executorService;
        mFixedExecutor = executorService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.runnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void start() {
        Runnable runnable = Logger.debug() ? new Runnable() { // from class: com.bytedance.common.utility.concurrent.ThreadPlus.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.d("ThreadPlus", "thread count: " + ThreadPlus.S_COUNT.incrementAndGet());
                try {
                    ThreadPlus.this.run();
                } catch (Exception e) {
                    Logger.w("ThreadPlus", "Thread crashed!", e);
                }
                Logger.d("ThreadPlus", "thread count: " + ThreadPlus.S_COUNT.decrementAndGet());
            }
        } : this;
        if (this.mBackground) {
            mFixedExecutor.submit(runnable);
        } else {
            mCachedExecutor.submit(runnable);
        }
    }

    public static void submitRunnable(Runnable runnable) {
        if (runnable != null) {
            mCachedExecutor.submit(runnable);
        }
    }
}
