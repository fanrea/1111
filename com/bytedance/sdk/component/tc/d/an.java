package com.bytedance.sdk.component.tc.d;

import com.bytedance.sdk.component.tc.mk;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements com.bytedance.sdk.component.tc.hc {
    private volatile ThreadFactory an;
    private final ReentrantLock b;
    private final Condition c;
    private final AtomicInteger d = new AtomicInteger(d(-536870912, 0));
    private volatile long gb;
    private volatile RejectedExecutionHandler h;
    private final BlockingQueue<Runnable> hc;
    private boolean mk;
    private volatile int mq;
    private final ThreadPoolExecutor tc;
    private volatile int tt;
    private int u;
    private ThreadPoolExecutor uo;

    private static boolean b(int i) {
        return i < 0;
    }

    private static boolean b(int i, int i2) {
        return i >= i2;
    }

    private static int d(int i) {
        return i & (-536870912);
    }

    private static int d(int i, int i2) {
        return i | i2;
    }

    private static int hc(int i) {
        return i & 536870911;
    }

    private static boolean hc(int i, int i2) {
        return i < i2;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public long getCompletedTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public int getLargestPoolSize() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public long getTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public int prestartAllCoreThreads() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public boolean prestartCoreThread() {
        return false;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public void setCorePoolSize(int i) {
    }

    private boolean c(int i) {
        return this.d.compareAndSet(i, i + 1);
    }

    private boolean u(int i) {
        return this.d.compareAndSet(i, i - 1);
    }

    private void b() {
        while (!u(this.d.get())) {
        }
    }

    private void an(int i) {
        int i2;
        do {
            i2 = this.d.get();
            if (b(i2, i)) {
                return;
            }
        } while (!this.d.compareAndSet(i2, d(i, hc(i2))));
    }

    public ThreadPoolExecutor d() {
        if (this.uo == null) {
            this.uo = mk.hc.tc();
        }
        return this.uo;
    }

    final void hc() {
        while (true) {
            int i = this.d.get();
            if (b(i) || b(i, 1073741824)) {
                return;
            }
            if ((d(i) == 0 && !this.hc.isEmpty()) || hc(i) != 0) {
                return;
            }
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                if (this.d.compareAndSet(i, d(1073741824, 0))) {
                    this.d.set(d(1610612736, 0));
                    this.c.signalAll();
                    return;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    final void d(Runnable runnable) {
        this.h.rejectedExecution(runnable, this.tc);
    }

    private List<Runnable> c() {
        BlockingQueue<Runnable> blockingQueue = this.hc;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    if (runnable instanceof b) {
                        arrayList.add(((b) runnable).b);
                    } else {
                        arrayList.add(runnable);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean hc(java.lang.Runnable r6, boolean r7) {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicInteger r0 = r5.d
            int r0 = r0.get()
            int r1 = d(r0)
            r2 = 0
            if (r1 < 0) goto L1a
            if (r1 != 0) goto L19
            if (r6 != 0) goto L19
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r3 = r5.hc
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L1a
        L19:
            return r2
        L1a:
            int r3 = hc(r0)
            r4 = 536870911(0x1fffffff, float:1.0842021E-19)
            if (r3 >= r4) goto L80
            if (r7 == 0) goto L28
            int r4 = r5.tt
            goto L2a
        L28:
            int r4 = r5.mq
        L2a:
            if (r3 < r4) goto L2d
            goto L80
        L2d:
            boolean r0 = r5.c(r0)
            if (r0 != 0) goto L40
            java.util.concurrent.atomic.AtomicInteger r0 = r5.d
            int r0 = r0.get()
            int r3 = d(r0)
            if (r3 != r1) goto L0
            goto L1a
        L40:
            java.util.concurrent.locks.ReentrantLock r7 = r5.b     // Catch: java.lang.Throwable -> L7b
            r7.lock()     // Catch: java.lang.Throwable -> L7b
            java.util.concurrent.atomic.AtomicInteger r0 = r5.d     // Catch: java.lang.Throwable -> L76
            int r0 = r0.get()     // Catch: java.lang.Throwable -> L76
            int r0 = d(r0)     // Catch: java.lang.Throwable -> L76
            if (r0 < 0) goto L55
            if (r0 != 0) goto L6d
            if (r6 != 0) goto L6d
        L55:
            java.util.concurrent.ThreadPoolExecutor r0 = r5.d()     // Catch: java.lang.Throwable -> L76
            r0.execute(r6)     // Catch: java.lang.Throwable -> L76
            java.util.concurrent.atomic.AtomicInteger r6 = r5.d     // Catch: java.lang.Throwable -> L76
            int r6 = r6.get()     // Catch: java.lang.Throwable -> L76
            int r6 = hc(r6)     // Catch: java.lang.Throwable -> L76
            int r0 = r5.u     // Catch: java.lang.Throwable -> L76
            if (r6 <= r0) goto L6c
            r5.u = r6     // Catch: java.lang.Throwable -> L76
        L6c:
            r2 = 1
        L6d:
            r7.unlock()     // Catch: java.lang.Throwable -> L7b
            if (r2 != 0) goto L75
            r5.u()
        L75:
            return r2
        L76:
            r6 = move-exception
            r7.unlock()     // Catch: java.lang.Throwable -> L7b
            throw r6     // Catch: java.lang.Throwable -> L7b
        L7b:
            r6 = move-exception
            r5.u()
            throw r6
        L80:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tc.d.an.hc(java.lang.Runnable, boolean):boolean");
    }

    private void u() {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            b();
            hc();
        } finally {
            reentrantLock.unlock();
        }
    }

    public an(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ThreadPoolExecutor threadPoolExecutor) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.b = reentrantLock;
        this.c = reentrantLock.newCondition();
        if (i < 0 || i2 <= 0 || i2 < i || j < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue == null || threadFactory == null || rejectedExecutionHandler == null) {
            throw null;
        }
        this.tt = i;
        this.mq = i2;
        this.hc = blockingQueue;
        this.gb = timeUnit.toNanos(j);
        this.an = threadFactory;
        this.h = rejectedExecutionHandler;
        this.tc = threadPoolExecutor;
    }

    @Override // com.bytedance.sdk.component.tc.hc, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        b bVar;
        if (runnable == null) {
            return;
        }
        if (runnable instanceof b) {
            bVar = (b) runnable;
            bVar.d(this);
        } else {
            bVar = new b(runnable, this);
        }
        d(bVar);
    }

    @Override // com.bytedance.sdk.component.tc.hc, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.bytedance.sdk.component.tc.hc, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        if (callable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.bytedance.sdk.component.tc.hc, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, t);
        execute(futureTask);
        return futureTask;
    }

    private void d(b bVar) {
        int i = this.d.get();
        if (hc(i) < this.tt) {
            if (hc((Runnable) bVar, true)) {
                mk.hc.h();
                return;
            }
            i = this.d.get();
        }
        if (hc(i) == 0) {
            if (hc((Runnable) bVar, false)) {
                mk.hc.h();
                return;
            }
            i = this.d.get();
        }
        if (b(i) && this.hc.offer(bVar)) {
            if (!b(this.d.get()) && remove(bVar)) {
                d(bVar.d());
                mk.hc.h();
                return;
            } else {
                mk.hc.h();
                return;
            }
        }
        if (hc(i) < this.mq && hc((Runnable) bVar, false)) {
            mk.hc.h();
        } else {
            d(bVar.d());
            mk.hc.h();
        }
    }

    @Override // com.bytedance.sdk.component.tc.hc, java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            an(0);
            reentrantLock.unlock();
            hc();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.tc.hc, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            an(536870912);
            List<Runnable> listC = c();
            reentrantLock.unlock();
            hc();
            return listC;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.tc.hc, java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return !b(this.d.get());
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public boolean isTerminating() {
        int i = this.d.get();
        return !b(i) && hc(i, 1610612736);
    }

    @Override // com.bytedance.sdk.component.tc.hc, java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return b(this.d.get(), 1610612736);
    }

    @Override // com.bytedance.sdk.component.tc.hc, java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        while (!b(this.d.get(), 1610612736)) {
            try {
                if (nanos > 0) {
                    nanos = this.c.awaitNanos(nanos);
                } else {
                    reentrantLock.unlock();
                    return false;
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    protected void finalize() {
        shutdown();
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.an = threadFactory;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public ThreadFactory getThreadFactory() {
        return this.an;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        rejectedExecutionHandler.getClass();
        this.h = rejectedExecutionHandler;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.h;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public int getCorePoolSize() {
        return this.tt;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public boolean allowsCoreThreadTimeOut() {
        return this.mk;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public void allowCoreThreadTimeOut(boolean z) {
        this.mk = true;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public void setMaximumPoolSize(int i) {
        if (i <= 0 || i < this.tt) {
            throw new IllegalArgumentException();
        }
        this.mq = i;
        this.d.get();
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public int getMaximumPoolSize() {
        return this.mq;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        this.gb = timeUnit.toNanos(j);
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.gb, TimeUnit.NANOSECONDS);
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public BlockingQueue<Runnable> getQueue() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public boolean remove(Runnable runnable) {
        boolean zRemove = this.hc.remove(runnable);
        hc();
        return zRemove;
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public void purge() {
        BlockingQueue<Runnable> blockingQueue = this.hc;
        try {
            Iterator it = blockingQueue.iterator();
            while (it.hasNext()) {
                Runnable runnable = (Runnable) it.next();
                if ((runnable instanceof Future) && ((Future) runnable).isCancelled()) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException unused) {
            for (Object obj : blockingQueue.toArray()) {
                if ((obj instanceof Future) && ((Future) obj).isCancelled()) {
                    blockingQueue.remove(obj);
                }
            }
        }
        hc();
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public int getPoolSize() {
        if (b(this.d.get(), 1073741824)) {
            return 0;
        }
        return hc(this.d.get());
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public int getActiveCount() {
        return hc(this.d.get());
    }

    @Override // com.bytedance.sdk.component.tc.hc
    public String toString() {
        String str;
        int i = this.d.get();
        if (hc(i, 0)) {
            str = "Running";
        } else {
            str = b(i, 1610612736) ? "Terminated" : "Shutting down";
        }
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "[" + str + ", runnable name = , core size = " + this.tt + ", max size = " + this.mq + ", worker count = " + hc(i) + ", queued tasks = " + this.hc.size() + "]";
    }

    public void d(Runnable runnable, boolean z) {
        int i = this.d.get();
        int iHc = hc(runnable);
        if (hc(i, 536870912)) {
            do {
                Runnable runnablePoll = this.hc.poll();
                if (runnablePoll != null) {
                    if (h(iHc) && (runnablePoll instanceof b)) {
                        b bVar = (b) runnablePoll;
                        bVar.hc();
                        bVar.d(iHc);
                        bVar.d((an) null);
                        runnablePoll.run();
                    } else {
                        d().execute(runnablePoll);
                        return;
                    }
                } else {
                    b();
                    return;
                }
            } while (hc(i, 536870912));
            hc();
            return;
        }
        hc();
    }

    private boolean h(int i) {
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return com.bytedance.sdk.component.tc.b.c.c();
        }
        return false;
    }

    private int hc(Runnable runnable) {
        if (runnable instanceof b) {
            return ((b) runnable).c();
        }
        return 0;
    }
}
