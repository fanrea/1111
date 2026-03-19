package com.bytedance.sdk.component.tc.c;

import com.bytedance.sdk.component.tc.mk;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends ScheduledThreadPoolExecutor {
    private final ConcurrentHashMap d;

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z) {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
    }

    public u(int i, ThreadFactory threadFactory) {
        super(i, new com.bytedance.sdk.component.tc.d.c(threadFactory, 8));
        this.d = new ConcurrentHashMap();
        d();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.tc.d.c(threadFactory, 8));
    }

    private void d() {
        if (!mk.hc.u() || allowsCoreThreadTimeOut()) {
            return;
        }
        super.setKeepAliveTime(Math.max(10L, getKeepAliveTime(TimeUnit.SECONDS)), TimeUnit.SECONDS);
        super.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j, final TimeUnit timeUnit) throws NoSuchFieldException {
        if (mk.hc.u()) {
            try {
                ScheduledFuture<?> scheduledFutureSchedule = super.schedule(runnable, j, timeUnit);
                this.d.remove(runnable);
                return scheduledFutureSchedule;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.tc.c.d.d("PThreadScheduledThreadPoolExecutor");
                mk.hc.mq().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tc.c.u.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.super.schedule(runnable, j, timeUnit);
                        u.this.d.remove(runnable);
                    }
                }, mk.hc.c(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.d.get(runnable);
            }
        }
        return super.schedule(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) throws NoSuchFieldException {
        if (mk.hc.u()) {
            try {
                ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
                this.d.remove(runnable);
                return scheduledFutureScheduleAtFixedRate;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.tc.c.d.d("PThreadScheduledThreadPoolExecutor");
                mk.hc.mq().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tc.c.u.2
                    @Override // java.lang.Runnable
                    public void run() {
                        u.super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
                        u.this.d.remove(runnable);
                    }
                }, mk.hc.c(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.d.get(runnable);
            }
        }
        return super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) throws NoSuchFieldException {
        if (mk.hc.u()) {
            try {
                ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
                this.d.remove(runnable);
                return scheduledFutureScheduleWithFixedDelay;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.tc.c.d.d("PThreadScheduledThreadPoolExecutor");
                mk.hc.mq().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tc.c.u.3
                    @Override // java.lang.Runnable
                    public void run() {
                        u.super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
                        u.this.d.remove(runnable);
                    }
                }, mk.hc.c(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.d.get(runnable);
            }
        }
        return super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j, final TimeUnit timeUnit) throws NoSuchFieldException {
        if (mk.hc.u()) {
            try {
                ScheduledFuture scheduledFutureSchedule = super.schedule(callable, j, timeUnit);
                this.d.remove(callable);
                return scheduledFutureSchedule;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.tc.c.d.d("PThreadScheduledThreadPoolExecutor");
                mk.hc.mq().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tc.c.u.4
                    @Override // java.lang.Runnable
                    public void run() {
                        u.super.schedule(callable, j, timeUnit);
                        u.this.d.remove(callable);
                    }
                }, mk.hc.c(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.d.get(callable);
            }
        }
        return super.schedule(callable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected RunnableScheduledFuture decorateTask(Runnable runnable, RunnableScheduledFuture runnableScheduledFuture) {
        if (mk.hc.u()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.d.get(runnable);
            if (runnableScheduledFuture2 != null) {
                return runnableScheduledFuture2;
            }
            RunnableScheduledFuture runnableScheduledFutureDecorateTask = super.decorateTask(runnable, runnableScheduledFuture);
            this.d.put(runnable, runnableScheduledFutureDecorateTask);
            return runnableScheduledFutureDecorateTask;
        }
        return super.decorateTask(runnable, runnableScheduledFuture);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected RunnableScheduledFuture decorateTask(Callable callable, RunnableScheduledFuture runnableScheduledFuture) {
        if (mk.hc.u()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.d.get(callable);
            if (runnableScheduledFuture2 != null) {
                return runnableScheduledFuture2;
            }
            RunnableScheduledFuture runnableScheduledFutureDecorateTask = super.decorateTask(callable, runnableScheduledFuture);
            this.d.put(callable, runnableScheduledFutureDecorateTask);
            return runnableScheduledFutureDecorateTask;
        }
        return super.decorateTask(callable, runnableScheduledFuture);
    }
}
