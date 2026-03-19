package com.bytedance.d.b.d.hc;

import com.bytedance.d.b.d.hc.hc;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static final int b;
    private static final PriorityBlockingQueue<Runnable> c;
    private static final int d;
    private static final int hc;
    private static final PriorityBlockingQueue<Runnable> u;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        d = iAvailableProcessors;
        hc = (iAvailableProcessors / 2) + 1 < 4 ? 4 : (iAvailableProcessors / 2) + 1;
        b = (iAvailableProcessors / 2) + 1 >= 4 ? (iAvailableProcessors / 2) + 1 : 4;
        c = new PriorityBlockingQueue<>();
        u = new PriorityBlockingQueue<>();
    }

    public static ThreadPoolExecutor d() {
        int i = hc;
        return new com.bytedance.sdk.component.tc.c.c(i, i, 1L, TimeUnit.SECONDS, c, new c(hc.d.NORMAL, "tt-api-thread-"));
    }

    public static ThreadPoolExecutor hc() {
        int i = b;
        return new com.bytedance.sdk.component.tc.c.c(i, i, 1L, TimeUnit.SECONDS, u, new c(hc.d.NORMAL, "tt-default-thread-"));
    }

    public static ScheduledExecutorService b() {
        return com.bytedance.sdk.component.tc.b.b(new c(hc.d.LOW, "tt-delay-thread-"));
    }
}
