package com.tk.core.o;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class ac {
    private static Handler ajG;

    public static boolean sX() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void runOnUiThread(Runnable runnable) {
        synchronized (ac.class) {
            if (ajG == null) {
                ajG = new Handler(Looper.getMainLooper());
            }
        }
        ajG.post(runnable);
    }

    public static void c(Runnable runnable) {
        if (sX()) {
            runnable.run();
        } else {
            runOnUiThread(runnable);
        }
    }

    public static void a(Runnable runnable, long j) {
        synchronized (ac.class) {
            if (ajG == null) {
                ajG = new Handler(Looper.getMainLooper());
            }
        }
        ajG.postDelayed(runnable, j);
    }

    public static void d(Runnable runnable) {
        synchronized (ac.class) {
            if (ajG == null) {
                ajG = new Handler(Looper.getMainLooper());
            }
        }
        ajG.removeCallbacks(runnable);
    }
}
