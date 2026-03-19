package com.kwad.sdk.core.threads.a;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends ScheduledThreadPoolExecutor {
    public static volatile boolean bHX = false;
    private final ConcurrentHashMap<Runnable, Long> bHY;
    private long bHZ;
    private int bIa;

    public a(int i, ThreadFactory threadFactory) {
        super(1, threadFactory);
        this.bHY = new ConcurrentHashMap<>();
        this.bHZ = 0L;
        this.bIa = 0;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (bHX) {
            this.bHY.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (bHX && this.bHY.containsKey(runnable) && this.bHY.get(runnable) != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.bHY.get(runnable).longValue();
            if (jElapsedRealtime >= 0 && jElapsedRealtime < 1800000) {
                long j = this.bHZ;
                int i = this.bIa;
                this.bHZ = ((j * i) + jElapsedRealtime) / (i + 1);
                this.bIa = i + 1;
            }
            this.bHY.remove(runnable);
        }
    }
}
