package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h {
    private static volatile ExecutorService clk;
    private static volatile ScheduledExecutorService cll;

    public static void execute(Runnable runnable) {
        if (clk == null) {
            synchronized (h.class) {
                if (clk == null) {
                    clk = GlobalThreadPools.acm();
                }
            }
        }
        if (clk == null || clk.isShutdown() || clk.isTerminated()) {
            return;
        }
        clk.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (cll == null) {
            synchronized (h.class) {
                if (cll == null) {
                    cll = GlobalThreadPools.acn();
                }
            }
        }
        cll.schedule(runnable, j, timeUnit);
    }
}
