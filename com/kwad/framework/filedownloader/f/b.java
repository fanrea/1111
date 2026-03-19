package com.kwad.framework.filedownloader.f;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b {
    private static volatile ThreadPoolExecutor bhd;

    @Deprecated
    public static ThreadPoolExecutor cC(String str) {
        if (OT()) {
            return OU();
        }
        com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        return bVar;
    }

    private static boolean OT() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.OT();
        }
        return false;
    }

    private static ThreadPoolExecutor OU() {
        if (bhd == null) {
            synchronized (b.class) {
                if (bhd == null) {
                    com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(""));
                    bhd = bVar;
                    com.kwad.sdk.core.threads.c.a(bVar, "ksad-filedownload-default");
                }
            }
        }
        return bhd;
    }

    @Deprecated
    public static ThreadPoolExecutor G(int i, String str) {
        if (OT()) {
            return OU();
        }
        return a(i, new LinkedBlockingQueue(), str);
    }

    @Deprecated
    public static ThreadPoolExecutor a(int i, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        if (OT()) {
            return OU();
        }
        com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(i, i, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        bVar.allowCoreThreadTimeOut(true);
        return bVar;
    }

    static class a implements ThreadFactory {
        private static final AtomicInteger bhe = new AtomicInteger(1);
        private final String bhf;
        private final AtomicInteger bhh = new AtomicInteger(1);
        private final ThreadGroup bhg = Thread.currentThread().getThreadGroup();

        a(String str) {
            this.bhf = f.cI(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.bhg, runnable, "ksad-" + this.bhf + this.bhh.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }
}
