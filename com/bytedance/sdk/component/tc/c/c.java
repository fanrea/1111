package com.bytedance.sdk.component.tc.c;

import com.bytedance.sdk.component.tc.mk;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends d {
    @Override // com.bytedance.sdk.component.tc.c.d, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public void allowCoreThreadTimeOut(boolean z) {
    }

    public c(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new com.bytedance.sdk.component.tc.d.d(blockingQueue), new com.bytedance.sdk.component.tc.d.c(threadFactory, 2));
        d();
    }

    public c(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, new com.bytedance.sdk.component.tc.d.d(blockingQueue), new com.bytedance.sdk.component.tc.d.c(threadFactory, 2), rejectedExecutionHandler);
        d();
    }

    private void d() {
        if (mk.hc.u()) {
            if (!allowsCoreThreadTimeOut()) {
                setKeepAliveTime(d(20L), TimeUnit.SECONDS);
                try {
                    super.allowCoreThreadTimeOut(true);
                } catch (Throwable unused) {
                }
            }
            com.bytedance.sdk.component.tc.c.d.d(this);
        }
    }

    @Override // com.bytedance.sdk.component.tc.c.d, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.tc.hc
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.tc.d.c(threadFactory, 2));
    }

    @Override // com.bytedance.sdk.component.tc.c.d, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public void shutdown() {
        super.shutdown();
        com.bytedance.sdk.component.tc.c.d.hc(this);
    }

    @Override // com.bytedance.sdk.component.tc.c.d, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public List shutdownNow() {
        com.bytedance.sdk.component.tc.c.d.hc(this);
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void finalize() {
        super.finalize();
        shutdown();
        com.bytedance.sdk.component.tc.c.d.hc(this);
    }

    private ExecutorService hc() {
        return com.bytedance.sdk.component.tc.c.d.d("PThreadPoolExecutor", com.bytedance.sdk.component.tc.c.d.d(getQueue()));
    }

    @Override // com.bytedance.sdk.component.tc.c.d, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public <T> Future<T> submit(Callable<T> callable) {
        if (mk.hc.u()) {
            try {
                return super.submit(callable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceHc = hc();
                if (executorServiceHc != null) {
                    return executorServiceHc.submit(callable);
                }
                throw e;
            }
        }
        return super.submit(callable);
    }

    @Override // com.bytedance.sdk.component.tc.c.d, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (mk.hc.u()) {
            try {
                return super.submit(runnable, t);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceHc = hc();
                if (executorServiceHc != null) {
                    return executorServiceHc.submit(runnable, t);
                }
                throw e;
            }
        }
        return super.submit(runnable, t);
    }

    @Override // com.bytedance.sdk.component.tc.c.d, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.tc.hc
    public Future submit(Runnable runnable) {
        if (mk.hc.u()) {
            try {
                return super.submit(runnable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceHc = hc();
                if (executorServiceHc != null) {
                    return executorServiceHc.submit(runnable);
                }
                throw e;
            }
        }
        return super.submit(runnable);
    }

    @Override // com.bytedance.sdk.component.tc.c.d, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.tc.hc
    public void execute(Runnable runnable) {
        if (mk.hc.u()) {
            try {
                super.execute(runnable);
                return;
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceHc = hc();
                if (executorServiceHc != null) {
                    executorServiceHc.execute(runnable);
                    return;
                }
                throw e;
            }
        }
        super.execute(runnable);
    }

    private long d(long j) {
        long jMin = Math.min(j, getKeepAliveTime(TimeUnit.SECONDS));
        if (jMin > 1) {
            return jMin;
        }
        return 1L;
    }
}
