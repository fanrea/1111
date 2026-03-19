package com.bytedance.sdk.component.tc.b;

import com.bytedance.sdk.component.tc.h;
import com.bytedance.sdk.component.tc.mk;
import com.bytedance.sdk.component.utils.mq;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d extends ThreadPoolExecutor {
    public boolean d() {
        return false;
    }

    protected int hc() {
        return 0;
    }

    public d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, com.bytedance.sdk.component.tc.c.d.d);
    }

    public d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    private void d(Runnable runnable) {
        com.bytedance.sdk.component.tc.d.b bVar;
        try {
            if (runnable instanceof com.bytedance.sdk.component.tc.d.b) {
                bVar = (com.bytedance.sdk.component.tc.d.b) runnable;
            } else {
                bVar = new com.bytedance.sdk.component.tc.d.b(runnable);
            }
            bVar.hc();
            if (mk.hc.k()) {
                if (!(getCorePoolSize() > getActiveCount() && getQueue().size() <= 0)) {
                    mq.hc("BaseThreadPool", "crashing drop task :".concat(String.valueOf(runnable)));
                    bVar.d(3);
                    mk.hc.mq().submit(bVar);
                    return;
                }
            }
            bVar.d(hc());
            super.execute(bVar);
        } catch (OutOfMemoryError e) {
            if (mk.hc.hc()) {
                h.d(false);
            }
            d(runnable, e);
            mk mkVar = mk.hc;
        }
    }

    protected void d(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        com.bytedance.sdk.component.tc.d.b.hc = true;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        d(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i) {
        try {
            super.setCorePoolSize(i);
        } catch (Exception e) {
            mq.d("BaseThreadPool", e.getMessage());
        } catch (OutOfMemoryError e2) {
            d(null, e2);
        }
    }
}
