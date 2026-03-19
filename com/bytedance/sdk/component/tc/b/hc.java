package com.bytedance.sdk.component.tc.b;

import com.bytedance.sdk.component.tc.mk;
import com.bytedance.sdk.component.utils.mq;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends d {
    private AtomicInteger d;

    @Override // com.bytedance.sdk.component.tc.b.d
    protected int hc() {
        return 1;
    }

    public hc(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new SynchronousQueue(), threadFactory);
        this.d = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        Runnable runnablePoll;
        super.afterExecute(runnable, th);
        BlockingQueue<Runnable> queue = mk.hc.tt().getQueue();
        if (queue.size() == 0) {
            return;
        }
        int maximumPoolSize = getMaximumPoolSize();
        if (this.d.get() >= Math.max(getCorePoolSize(), maximumPoolSize / 4)) {
            return;
        }
        try {
            this.d.getAndIncrement();
            int activeCount = getActiveCount();
            while (activeCount < maximumPoolSize / 2 && !isShutdown() && !isTerminated() && !isTerminating() && (runnablePoll = queue.poll()) != null) {
                if (runnablePoll instanceof com.bytedance.sdk.component.tc.d.b) {
                    com.bytedance.sdk.component.tc.d.b bVar = (com.bytedance.sdk.component.tc.d.b) runnablePoll;
                    bVar.d(hc());
                    bVar.hc();
                }
                runnablePoll.run();
                activeCount = getActiveCount();
            }
        } finally {
            this.d.getAndDecrement();
        }
    }

    @Override // com.bytedance.sdk.component.tc.b.d
    protected void d(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        super.d(runnable, outOfMemoryError);
        if (runnable != null) {
            if (runnable instanceof com.bytedance.sdk.component.tc.d.b) {
                ((com.bytedance.sdk.component.tc.d.b) runnable).d(false);
            } else {
                runnable = new b(runnable);
            }
            mk.hc.tt().execute(runnable);
        }
        try {
            allowCoreThreadTimeOut(false);
        } catch (Exception e) {
            mq.b("BigThreadPool", e);
        }
    }

    @Override // com.bytedance.sdk.component.tc.b.d
    public boolean d() {
        return getActiveCount() >= getMaximumPoolSize();
    }

    @Override // com.bytedance.sdk.component.tc.b.d, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable instanceof b) {
            super.execute(runnable);
            return;
        }
        if (d(runnable)) {
            return;
        }
        if (d()) {
            if (runnable instanceof com.bytedance.sdk.component.tc.d.b) {
                ((com.bytedance.sdk.component.tc.d.b) runnable).d(false);
            } else {
                runnable = new b(runnable);
            }
            mk.hc.tt().execute(runnable);
            return;
        }
        super.execute(runnable);
    }

    private boolean d(Runnable runnable) {
        com.bytedance.sdk.component.tc.d.b bVar;
        if (!c.c()) {
            return false;
        }
        if (runnable instanceof com.bytedance.sdk.component.tc.d.b) {
            bVar = (com.bytedance.sdk.component.tc.d.b) runnable;
            if (!bVar.b()) {
                return false;
            }
        } else {
            bVar = new b(runnable);
        }
        com.bytedance.sdk.component.tc.d.b.d.incrementAndGet();
        bVar.d(false);
        mk.hc.tt().execute(bVar);
        return true;
    }
}
