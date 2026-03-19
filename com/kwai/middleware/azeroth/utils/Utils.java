package com.kwai.middleware.azeroth.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.mobstat.forbes.Config;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Utils {
    private static final int ADVANCE_WHEN = 1000;
    public static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());

    public static <T> T defaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    public static <T> T checkNotNull(T t) {
        return (T) checkNotNull(t, "");
    }

    public static <T> T checkNotNullOrEmpty(T t) {
        return (T) checkNotNullOrEmpty(t, "");
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T checkNotNullOrEmpty(T t, String str) {
        if (t == 0 || (((t instanceof CharSequence) && android.text.TextUtils.isEmpty((CharSequence) t)) || (((t instanceof Collection) && ((Collection) t).isEmpty()) || (((t instanceof Map) && ((Map) t).isEmpty()) || ((t instanceof JSONObject) && ((JSONObject) t).length() <= 0))))) {
            throw new NullPointerException(str);
        }
        return t;
    }

    public static void checkAllNotNull(Object... objArr) {
        for (Object obj : objArr) {
            checkNotNull(obj, "");
        }
    }

    public static void checkAllNotNullOrEmpty(Object... objArr) {
        for (Object obj : objArr) {
            checkNotNullOrEmpty(obj, "");
        }
    }

    public static void checkAllArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void checkAllArgument(boolean... zArr) {
        for (boolean z : zArr) {
            checkAllArgument(z, "");
        }
    }

    public static long random() {
        return RANDOM.nextLong();
    }

    public static long random(long j) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ThreadLocalRandom.current().nextLong(j);
        }
        double dNextDouble = RANDOM.nextDouble();
        double d = j - 1;
        Double.isNaN(d);
        return (long) (dNextDouble * d);
    }

    public static boolean randomSelectByRatio(float f) {
        return RANDOM.nextFloat() < f;
    }

    public static void runOnUiThread(Runnable runnable, Object obj) {
        runOnUiThreadDelay(runnable, obj, 0L);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            UI_HANDLER.post(runnable);
        }
    }

    public static void jsRunOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - 1000;
        Handler handler = UI_HANDLER;
        if (jUptimeMillis <= 0) {
            jUptimeMillis = 0;
        }
        handler.postAtTime(runnable, jUptimeMillis);
    }

    public static void runOnUiThreadAtFront(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            UI_HANDLER.postAtFrontOfQueue(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        UI_HANDLER.postDelayed(runnable, j);
    }

    public static void runOnUiThreadDelay(Runnable runnable, Object obj, long j) {
        Message messageObtain = Message.obtain(UI_HANDLER, runnable);
        messageObtain.obj = obj;
        UI_HANDLER.sendMessageDelayed(messageObtain, j);
    }

    public static void removeUiThreadCallbacks(Runnable runnable) {
        UI_HANDLER.removeCallbacks(runnable);
    }

    public static void removeUiThreadCallbacksWithToken(Object obj) {
        UI_HANDLER.removeCallbacksAndMessages(obj);
    }

    public static void ensureNotOnMainThread() {
        if (isOnMainThread()) {
            throw new IllegalStateException("This method cannot be called from the UI thread.");
        }
    }

    public static void ensureOnMainThread() {
        if (!isOnMainThread()) {
            throw new IllegalStateException("This method must be called from the UI thread.");
        }
    }

    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void assertMainThread() {
        if (!isOnMainThread()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static void sleepThread(long j) throws InterruptedException {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    public static boolean isZhLanguage() {
        return "zh".equals(Locale.getDefault().getLanguage());
    }

    public static String getAcceptLanguage() {
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        if (android.text.TextUtils.isEmpty(country)) {
            return language;
        }
        return language + "-" + country.toLowerCase();
    }

    public static String getLocale() {
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        if (android.text.TextUtils.isEmpty(country)) {
            return language;
        }
        return language + Config.replace + country;
    }

    public static long now() {
        return System.currentTimeMillis();
    }

    public static long since(long j) {
        return System.currentTimeMillis() - j;
    }

    public static boolean isChinese() {
        return "zh".equalsIgnoreCase(Locale.getDefault().getLanguage());
    }

    public static String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }
}
