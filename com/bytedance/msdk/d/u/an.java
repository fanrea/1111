package com.bytedance.msdk.d.u;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.sdk.component.utils.mq;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private static Handler an = null;
    private static boolean b = false;
    private static Handler c = null;
    static final /* synthetic */ boolean d = true;
    private static final int gb;
    private static final int h;
    private static final Object hc = new Object();
    private static final Executor tc;
    private static final ThreadPoolExecutor tt;
    private static HandlerThread u;

    static {
        d();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        h = iAvailableProcessors;
        gb = Math.min(iAvailableProcessors, 4);
        tt = tt();
        tc = tc();
    }

    public static void d() {
        try {
            HandlerThread handlerThread = new HandlerThread("gm_t_main", -19);
            u = handlerThread;
            handlerThread.start();
            an = new Handler(u.getLooper());
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private static boolean gb() {
        HandlerThread handlerThread = u;
        return (handlerThread == null || !handlerThread.isAlive() || an == null) ? false : true;
    }

    public static void d(Runnable runnable) {
        if (gb()) {
            if (b()) {
                runnable.run();
                return;
            } else {
                an.post(runnable);
                return;
            }
        }
        d();
    }

    public static void d(Runnable runnable, long j) {
        if (gb()) {
            an.postDelayed(runnable, j);
        } else {
            d();
        }
    }

    public static Looper hc() {
        if (gb()) {
            return u.getLooper();
        }
        return null;
    }

    public static boolean b() {
        return gb() && u.getLooper() == Looper.myLooper();
    }

    public static ThreadFactory d(final String str) {
        return new ThreadFactory() { // from class: com.bytedance.msdk.d.u.an.1
            private final AtomicInteger hc = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new com.bytedance.sdk.component.tc.c.b(runnable, str + " # " + this.hc.getAndIncrement());
            }
        };
    }

    public static Handler c() {
        Handler handler;
        synchronized (hc) {
            if (c == null) {
                if (b) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                c = new Handler(Looper.getMainLooper());
            }
            handler = c;
        }
        return handler;
    }

    public static void hc(Runnable runnable) throws ExecutionException, InterruptedException {
        if (u()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        d(futureTask);
        try {
            futureTask.get();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured while waiting for runnable", e);
        }
    }

    public static void b(Runnable runnable) {
        if (u()) {
            runnable.run();
        } else {
            c().post(runnable);
        }
    }

    public static <T> FutureTask<T> d(FutureTask<T> futureTask) {
        c().post(futureTask);
        return futureTask;
    }

    public static void hc(Runnable runnable, long j) {
        c().postDelayed(runnable, j);
    }

    public static boolean u() {
        return c().getLooper() == Looper.myLooper();
    }

    public static ExecutorService d(String str, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        return new com.bytedance.sdk.component.tc.c.c(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(i), d("gm_t_single_".concat(String.valueOf(str))), rejectedExecutionHandler);
    }

    private static ThreadPoolExecutor tt() {
        int i = gb;
        com.bytedance.sdk.component.tc.c.c cVar = new com.bytedance.sdk.component.tc.c.c(i, i, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(1024), d("gm_t_executor:"), new ThreadPoolExecutor.DiscardOldestPolicy() { // from class: com.bytedance.msdk.d.u.an.2
            @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                super.rejectedExecution(runnable, threadPoolExecutor);
                com.bytedance.msdk.h.hc.d.d().b();
            }
        });
        try {
            cVar.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            mq.b("ThreadHelper", "stackerror:", e);
        } catch (NoSuchMethodError e2) {
            mq.d(e2);
        }
        return cVar;
    }

    public static Executor an() {
        return tt;
    }

    private static Executor tc() {
        return new com.bytedance.sdk.component.tc.c.c(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), d("gm_t_log_upload:"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static Executor h() {
        return tc;
    }

    public static void c(Runnable runnable) {
        d(tt, runnable);
    }

    public static <T> Future<T> d(Callable<T> callable) {
        try {
            return tt.submit(callable);
        } catch (Exception e) {
            mq.b("ThreadHelper", "stackerror:", e);
            return null;
        }
    }

    private static boolean d(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
            return true;
        } catch (Exception e) {
            mq.b("ThreadHelper", "stackerror:", e);
            return false;
        }
    }
}
