package com.kwai.middleware.azeroth.async;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class WorkerHandler extends HandlerThread {
    private static Handler sHandler;
    private static WorkerHandler sInstance;

    private WorkerHandler() {
        super("worker-handler", 10);
    }

    private static void ensureThreadLocked() {
        if (sInstance == null) {
            WorkerHandler workerHandler = new WorkerHandler();
            sInstance = workerHandler;
            workerHandler.start();
            sHandler = new Handler(sInstance.getLooper());
        }
    }

    public static WorkerHandler get() {
        WorkerHandler workerHandler;
        synchronized (WorkerHandler.class) {
            ensureThreadLocked();
            workerHandler = sInstance;
        }
        return workerHandler;
    }

    public static Handler getHandler() {
        Handler handler;
        synchronized (WorkerHandler.class) {
            ensureThreadLocked();
            handler = sHandler;
        }
        return handler;
    }

    public static void post(Runnable runnable) {
        getHandler().post(runnable);
    }

    public static void postDelayed(Runnable runnable, long j) {
        getHandler().postDelayed(runnable, j);
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        throw new UnsupportedOperationException();
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        throw new UnsupportedOperationException();
    }
}
