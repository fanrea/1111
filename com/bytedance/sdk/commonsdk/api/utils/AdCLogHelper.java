package com.bytedance.sdk.commonsdk.api.utils;

import com.pangrowth.adclog.AdCLog;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class AdCLogHelper {
    private static final AtomicInteger hasAdcLog = new AtomicInteger(0);

    private AdCLogHelper() {
    }

    public static void v(String str, String str2, Throwable th) {
        if (isAdCLogExists()) {
            AdCLog.v(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (isAdCLogExists()) {
            AdCLog.d(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (isAdCLogExists()) {
            AdCLog.i(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (isAdCLogExists()) {
            AdCLog.w(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isAdCLogExists()) {
            AdCLog.e(str, str2);
        }
    }

    public static boolean isAdCLogExists() throws ClassNotFoundException {
        AtomicInteger atomicInteger = hasAdcLog;
        if (atomicInteger.get() == 0) {
            try {
                Class.forName("com.pangrowth.adclog.AdCLog");
                atomicInteger.set(1);
            } catch (ClassNotFoundException unused) {
                hasAdcLog.set(-1);
            }
        }
        return hasAdcLog.get() == 1;
    }
}
