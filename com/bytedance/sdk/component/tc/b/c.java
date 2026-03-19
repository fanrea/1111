package com.bytedance.sdk.component.tc.b;

import com.bytedance.sdk.component.tc.h;
import com.bytedance.sdk.component.tc.mk;
import com.bytedance.sdk.component.utils.mq;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends d {
    private ScheduledFuture<?> d;

    @Override // com.bytedance.sdk.component.tc.b.d
    protected int hc() {
        return 2;
    }

    public c(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (h.u()) {
            u();
        }
    }

    private void u() {
        BlockingQueue queue = getQueue();
        int iGb = mk.hc.gb();
        if (getCorePoolSize() == iGb || queue == null || queue.size() != 0) {
            return;
        }
        setCorePoolSize(iGb);
    }

    private boolean an() {
        BlockingQueue queue = getQueue();
        int corePoolSize = getCorePoolSize();
        int i = corePoolSize * 2;
        int iMin = Math.min(corePoolSize + 4, h.d);
        if (corePoolSize >= iMin || queue == null || queue.size() < i) {
            return false;
        }
        try {
            setCorePoolSize(iMin);
            return true;
        } catch (Exception e) {
            mq.d("BizCoreThreadPool", e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    @Override // com.bytedance.sdk.component.tc.b.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void d(java.lang.Runnable r3, java.lang.OutOfMemoryError r4) {
        /*
            r2 = this;
            super.d(r3, r4)
            r0 = 0
            if (r3 == 0) goto Lf
            java.util.concurrent.BlockingQueue r1 = r2.getQueue()     // Catch: java.lang.Throwable -> L18
            boolean r3 = r1.offer(r3)     // Catch: java.lang.Throwable -> L18
            goto L13
        Lf:
            r3 = 1
            com.bytedance.sdk.component.tc.h.d(r0)     // Catch: java.lang.Throwable -> L17
        L13:
            r2.allowCoreThreadTimeOut(r0)     // Catch: java.lang.Throwable -> L17
            goto L19
        L17:
            r0 = r3
        L18:
            r3 = r0
        L19:
            if (r3 == 0) goto L1c
            return
        L1c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tc.b.c.d(java.lang.Runnable, java.lang.OutOfMemoryError):void");
    }

    @Override // com.bytedance.sdk.component.tc.b.d
    public boolean d() {
        BlockingQueue queue = getQueue();
        return queue != null && queue.size() > getCorePoolSize() * 2;
    }

    @Override // com.bytedance.sdk.component.tc.b.d, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (h.u()) {
            an();
        }
        super.execute(runnable);
    }

    public void b() {
        ScheduledFuture<?> scheduledFuture = this.d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public static boolean c() {
        ThreadPoolExecutor threadPoolExecutorTt = mk.hc.tt();
        if (threadPoolExecutorTt.getQueue().size() != 0 || threadPoolExecutorTt.isShutdown() || threadPoolExecutorTt.isTerminated()) {
            return false;
        }
        int activeCount = threadPoolExecutorTt.getActiveCount();
        int corePoolSize = threadPoolExecutorTt.getCorePoolSize();
        return activeCount < corePoolSize + (-1) && com.bytedance.sdk.component.tc.d.b.d.get() < corePoolSize / 2;
    }
}
