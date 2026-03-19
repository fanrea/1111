package com.lingku.xuanshang.xutils.common.task;

import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PriorityExecutor implements Executor {
    public static final AtomicLong a = new AtomicLong(0);
    public static final ThreadFactory b = new a();
    public static final Comparator<Runnable> c = new b();
    public static final Comparator<Runnable> d = new c();
    public final ThreadPoolExecutor e;

    public class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "xTID#" + this.a.getAndIncrement());
        }
    }

    public class b implements Comparator<Runnable> {
        @Override // java.util.Comparator
        public int compare(Runnable runnable, Runnable runnable2) {
            Runnable runnable3 = runnable;
            Runnable runnable4 = runnable2;
            if (!(runnable3 instanceof lkxssdk.o0.a) || !(runnable4 instanceof lkxssdk.o0.a)) {
                return 0;
            }
            lkxssdk.o0.a aVar = (lkxssdk.o0.a) runnable3;
            lkxssdk.o0.a aVar2 = (lkxssdk.o0.a) runnable4;
            int iOrdinal = aVar.b.ordinal() - aVar2.b.ordinal();
            return iOrdinal == 0 ? (int) (aVar.a - aVar2.a) : iOrdinal;
        }
    }

    public class c implements Comparator<Runnable> {
        @Override // java.util.Comparator
        public int compare(Runnable runnable, Runnable runnable2) {
            Runnable runnable3 = runnable;
            Runnable runnable4 = runnable2;
            if (!(runnable3 instanceof lkxssdk.o0.a) || !(runnable4 instanceof lkxssdk.o0.a)) {
                return 0;
            }
            lkxssdk.o0.a aVar = (lkxssdk.o0.a) runnable3;
            lkxssdk.o0.a aVar2 = (lkxssdk.o0.a) runnable4;
            int iOrdinal = aVar.b.ordinal() - aVar2.b.ordinal();
            return iOrdinal == 0 ? (int) (aVar2.a - aVar.a) : iOrdinal;
        }
    }

    public PriorityExecutor(int i, boolean z) {
        this.e = new ThreadPoolExecutor(i, 256, 1L, TimeUnit.SECONDS, new PriorityBlockingQueue(256, z ? c : d), b);
    }

    public PriorityExecutor(boolean z) {
        this(5, z);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable instanceof lkxssdk.o0.a) {
            ((lkxssdk.o0.a) runnable).a = a.getAndIncrement();
        }
        this.e.execute(runnable);
    }

    public int getPoolSize() {
        return this.e.getCorePoolSize();
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return this.e;
    }

    public boolean isBusy() {
        return this.e.getActiveCount() >= this.e.getCorePoolSize();
    }

    public void setPoolSize(int i) {
        if (i > 0) {
            this.e.setCorePoolSize(i);
        }
    }
}
