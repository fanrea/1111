package com.bytedance.sdk.component.tc;

import com.baidu.mobstat.forbes.Config;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc implements ThreadFactory {
    private int b;
    private final AtomicInteger c;
    public final String d;
    private final ThreadGroup hc;

    public tc(String str) {
        this(5, str);
    }

    public tc(int i, String str) {
        this.c = new AtomicInteger(1);
        this.b = i;
        this.hc = new ThreadGroup("csj_g_" + str);
        this.d = "csj_" + (mk.hc.an() ? "p" : "") + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadD = d(this.hc, runnable, this.d + Config.replace + this.c.getAndIncrement());
        if (threadD.isDaemon()) {
            threadD.setDaemon(false);
        }
        int i = this.b;
        if (i > 10) {
            this.b = 10;
        } else if (i <= 0) {
            this.b = 1;
        }
        threadD.setPriority(this.b);
        return threadD;
    }

    protected Thread d(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new com.bytedance.sdk.component.tc.c.b(threadGroup, runnable, str);
    }
}
