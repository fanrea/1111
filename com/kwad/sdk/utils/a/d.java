package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    static c.d cpg;
    static volatile Executor cph;
    static ExecutorService cpi = Executors.newSingleThreadExecutor();

    private d() {
    }

    public static void a(c.d dVar) {
        cpg = dVar;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            cph = executor;
        }
    }

    static Executor getExecutor() {
        if (cph == null) {
            synchronized (d.class) {
                if (cph == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    cph = threadPoolExecutor;
                }
            }
        }
        return cph;
    }
}
