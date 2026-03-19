package com.kwad.sdk.glide.load.engine.b;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.sigmob.sdk.base.n;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements ExecutorService {
    private static final long bVI = TimeUnit.SECONDS.toMillis(10);
    private static volatile int bVJ;
    private final ExecutorService bVK;

    public static a aho() {
        return a(1, "disk-cache", b.bVS);
    }

    private static a a(int i, String str, b bVar) {
        return new a(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0611a(str, bVar, true)));
    }

    public static a ahp() {
        return b(ahs(), n.l, b.bVS);
    }

    private static a b(int i, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0611a(str, bVar, false)));
    }

    public static a ahq() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, bVI, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0611a("source-unlimited", b.bVS, false)));
    }

    public static a ahr() {
        return a(ahs() >= 4 ? 2 : 1, b.bVS);
    }

    private static a a(int i, b bVar) {
        return new a(new ThreadPoolExecutor(0, i, bVI, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0611a("animation", bVar, true)));
    }

    private a(ExecutorService executorService) {
        this.bVK = executorService;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.bVK.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        return this.bVK.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.bVK.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.bVK.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.bVK.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return (T) this.bVK.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable runnable, T t) {
        return this.bVK.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> callable) {
        return this.bVK.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.bVK.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.bVK.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.bVK.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.bVK.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.bVK.awaitTermination(j, timeUnit);
    }

    public final String toString() {
        return this.bVK.toString();
    }

    private static int ahs() {
        if (bVJ == 0) {
            bVJ = Math.min(4, com.kwad.sdk.glide.load.engine.b.b.availableProcessors());
        }
        return bVJ;
    }

    public interface b {
        public static final b bVP = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.1
            @Override // com.kwad.sdk.glide.load.engine.b.a.b
            public final void z(Throwable th) {
            }
        };
        public static final b bVQ;
        public static final b bVR;
        public static final b bVS;

        void z(Throwable th);

        static {
            b bVar = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.2
                @Override // com.kwad.sdk.glide.load.engine.b.a.b
                public final void z(Throwable th) {
                    if (Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                    }
                }
            };
            bVQ = bVar;
            bVR = new b() { // from class: com.kwad.sdk.glide.load.engine.b.a.b.3
                @Override // com.kwad.sdk.glide.load.engine.b.a.b
                public final void z(Throwable th) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            };
            bVS = bVar;
        }
    }

    /* renamed from: com.kwad.sdk.glide.load.engine.b.a$a, reason: collision with other inner class name */
    static final class ThreadFactoryC0611a implements ThreadFactory {
        final b bVL;
        final boolean bVM;
        private int bVN;
        private final String name;

        ThreadFactoryC0611a(String str, b bVar, boolean z) {
            this.name = str;
            this.bVL = bVar;
            this.bVM = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "ksad-glide-" + this.name + "-thread-" + this.bVN) { // from class: com.kwad.sdk.glide.load.engine.b.a.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() throws SecurityException, IllegalArgumentException {
                    Process.setThreadPriority(9);
                    if (ThreadFactoryC0611a.this.bVM) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        ThreadFactoryC0611a.this.bVL.z(th);
                    }
                }
            };
            this.bVN++;
            return thread;
        }
    }
}
