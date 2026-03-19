package com.bytedance.sdk.component.tc.c;

import com.bytedance.sdk.component.tc.d.an;
import com.bytedance.sdk.component.tc.mk;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends ThreadPoolExecutor implements com.bytedance.sdk.component.tc.hc {
    public static final RejectedExecutionHandler d = new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.tc.c.d.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor != null && (threadPoolExecutor instanceof ScheduledThreadPoolExecutor) && threadPoolExecutor.getCorePoolSize() == 1) {
                ScheduledExecutorService scheduledExecutorServiceMq = mk.hc.mq();
                if (scheduledExecutorServiceMq.isShutdown() || scheduledExecutorServiceMq.isTerminated()) {
                    mk.hc.tt().execute(runnable);
                } else {
                    scheduledExecutorServiceMq.execute(runnable);
                }
            } else {
                mk.hc.tt().execute(runnable);
            }
            mk.hc.h();
        }
    };
    private com.bytedance.sdk.component.tc.hc hc;

    public d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, d);
    }

    public d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.hc = new an(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler, this);
        mk.hc.h();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.tc.hc
    public void execute(Runnable runnable) {
        this.hc.execute(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public Future<?> submit(Runnable runnable) {
        return this.hc.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public <T> Future<T> submit(Callable<T> callable) {
        return this.hc.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.hc.submit(runnable, t);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public void shutdown() {
        this.hc.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public List<Runnable> shutdownNow() {
        return this.hc.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public boolean isShutdown() {
        return this.hc.isShutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public boolean isTerminating() {
        return this.hc.isTerminating();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public boolean isTerminated() {
        return this.hc.isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.hc.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.hc.setThreadFactory(threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public ThreadFactory getThreadFactory() {
        return this.hc.getThreadFactory();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        this.hc.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.hc.getRejectedExecutionHandler();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public void setCorePoolSize(int i) {
        this.hc.setCorePoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public int getCorePoolSize() {
        return this.hc.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public boolean prestartCoreThread() {
        return this.hc.prestartCoreThread();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public int prestartAllCoreThreads() {
        return this.hc.prestartAllCoreThreads();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public boolean allowsCoreThreadTimeOut() {
        return this.hc.allowsCoreThreadTimeOut();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public void allowCoreThreadTimeOut(boolean z) {
        this.hc.allowCoreThreadTimeOut(z);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public void setMaximumPoolSize(int i) {
        this.hc.setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public int getMaximumPoolSize() {
        return this.hc.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        this.hc.setKeepAliveTime(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return this.hc.getKeepAliveTime(timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public BlockingQueue<Runnable> getQueue() {
        return this.hc.getQueue();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public boolean remove(Runnable runnable) {
        return this.hc.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public void purge() {
        this.hc.purge();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public int getPoolSize() {
        return this.hc.getPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public int getActiveCount() {
        return this.hc.getActiveCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public int getLargestPoolSize() {
        return this.hc.getLargestPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public long getTaskCount() {
        return this.hc.getTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public long getCompletedTaskCount() {
        return this.hc.getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public String toString() {
        com.bytedance.sdk.component.tc.hc hcVar = this.hc;
        if (hcVar != null) {
            return hcVar.toString();
        }
        return super.toString();
    }
}
