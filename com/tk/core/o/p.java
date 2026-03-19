package com.tk.core.o;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class p {
    private static final int ajm;
    private static final int ajn;
    private static final int ajo;
    private static final ThreadPoolExecutor ajp;
    public static final ThreadPoolExecutor ajq;
    public static ThreadPoolExecutor ajr;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        ajm = iAvailableProcessors;
        ajn = iAvailableProcessors == 1 ? ajm : Math.max(2, Math.min(ajm - 1, 4));
        ajo = (ajm * 2) + 1;
        ajr = null;
        ajp = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b("tk-backup-pool"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(ajn, ajo, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new b("tk-async-pool"));
        ajq = threadPoolExecutor;
        threadPoolExecutor.setRejectedExecutionHandler(new a((byte) 0));
        ajr = sO();
    }

    public static void execute(Runnable runnable) {
        try {
            ajq.execute(runnable);
        } catch (Exception e) {
            com.tk.core.i.a.y("TKAsync", e.getMessage());
        }
    }

    public static ThreadPoolExecutor p(String str, int i) {
        return new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(str));
    }

    private static ThreadPoolExecutor sO() {
        if (ajr == null) {
            ajr = p("tk-single-thread-pool", 1);
        }
        return ajr;
    }

    static class b implements ThreadFactory {
        private final String ajs;
        private final AtomicInteger y = new AtomicInteger(1);

        public b(String str) {
            this.ajs = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            String str = "TKExecutor-->" + this.ajs + "#" + this.y.getAndIncrement();
            com.tk.core.i.a.x("TKExecutor", "threadName=" + str);
            return new Thread(runnable, str);
        }
    }

    static class a implements RejectedExecutionHandler {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            p.ajp.execute(runnable);
            com.tk.core.i.a.y("TKAsync", "reject work, put into tk-backup-pool, queueSize=" + p.ajp.getQueue().size());
        }
    }
}
