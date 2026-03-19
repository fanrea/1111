package com.fendasz.moku.planet.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ThreadUtils {
    private ExecutorService executorService;
    private Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;

    public static void runOnChildThread(Runnable runnable) {
        if (runnable != null) {
            HandlerThread handlerThread = new HandlerThread(System.currentTimeMillis() + "");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).post(runnable);
        }
    }

    public static void runOnChildThread(Runnable runnable, long j) {
        if (runnable != null) {
            HandlerThread handlerThread = new HandlerThread(System.currentTimeMillis() + "");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).postDelayed(runnable, j);
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable != null) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        if (runnable != null) {
            new Handler(Looper.getMainLooper()).postDelayed(runnable, j);
        }
    }
}
