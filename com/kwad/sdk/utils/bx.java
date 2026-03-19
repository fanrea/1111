package com.kwad.sdk.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import java.io.Closeable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bx {
    private static final Handler cof = new Handler(Looper.getMainLooper());
    private static long ps = 400;

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            cof.post(runnable);
        }
    }

    public static void postOnUiThread(Runnable runnable) {
        cof.post(runnable);
    }

    public static void c(Runnable runnable) {
        cof.postAtFrontOfQueue(runnable);
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        cof.postDelayed(runnable, j);
    }

    public static void d(Runnable runnable) {
        cof.removeCallbacks(runnable);
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Handler handler = cof;
        Message messageObtain = Message.obtain(handler, runnable);
        messageObtain.obj = obj;
        handler.sendMessageDelayed(messageObtain, j);
    }

    public static void a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, ps);
    }

    public static void vibrate(Context context, Vibrator vibrator, long j) {
        if (vibrator != null) {
            try {
                if (au.aI(context, "android.permission.VIBRATE") == 0) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(VibrationEffect.createOneShot(j, -1));
                    } else {
                        vibrator.vibrate(j);
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || au.aI(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean iV(String str) {
        return TextUtils.isEmpty(str) || str.contains(" ") || !URLUtil.isNetworkUrl(str);
    }

    public static String A(Throwable th) {
        try {
            String stackTraceString = Log.getStackTraceString(th);
            return TextUtils.isEmpty(stackTraceString) ? th.toString() : stackTraceString;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void e(DialogInterface dialogInterface) {
        try {
            dialogInterface.dismiss();
        } catch (Exception unused) {
        }
    }
}
