package com.kwad.sdk.lib.widget.a.a;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b<T> {
    private final Executor cds;
    private final Executor cdt;
    private final e<T> cdu;
    private final Runnable cdv;

    /* synthetic */ b(Executor executor, Executor executor2, e eVar, Runnable runnable, byte b) {
        this(executor, executor2, eVar, runnable);
    }

    private b(Executor executor, Executor executor2, e<T> eVar, Runnable runnable) {
        this.cds = executor;
        this.cdt = executor2;
        this.cdu = eVar;
        this.cdv = runnable;
    }

    public final Executor getMainThreadExecutor() {
        return this.cds;
    }

    public final Executor getBackgroundThreadExecutor() {
        return this.cdt;
    }

    public final e<T> alb() {
        return this.cdu;
    }

    public final Runnable alc() {
        return this.cdv;
    }

    public static final class a<T> {
        private static Executor cdx;
        private Executor cds;
        private Executor cdt;
        private final e<T> cdu;
        private Runnable cdv;
        private static final Object cdw = new Object();
        private static final Executor cdy = new ExecutorC0621a(0);

        public a(e<T> eVar) {
            this.cdu = eVar;
        }

        public final a<T> a(Executor executor) {
            this.cdt = executor;
            return this;
        }

        /* renamed from: com.kwad.sdk.lib.widget.a.a.b$a$a, reason: collision with other inner class name */
        static class ExecutorC0621a implements Executor {
            final Handler mHandler;

            private ExecutorC0621a() {
                this.mHandler = new Handler(Looper.getMainLooper());
            }

            /* synthetic */ ExecutorC0621a(byte b) {
                this();
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.mHandler.post(runnable);
            }
        }

        public final b<T> ald() {
            if (this.cds == null) {
                this.cds = cdy;
            }
            if (this.cdt == null) {
                synchronized (cdw) {
                    if (cdx == null) {
                        cdx = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new GlobalThreadPools.e(5, "asyncDiffer"));
                    }
                }
                this.cdt = cdx;
            }
            return new b<>(this.cds, this.cdt, this.cdu, this.cdv, (byte) 0);
        }
    }
}
