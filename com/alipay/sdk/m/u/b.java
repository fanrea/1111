package com.alipay.sdk.m.u;

import android.os.SystemClock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public static final long a = 3000;
    public static long b = -1;

    public static synchronized boolean a() {
        boolean z;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - b >= a) {
            b = jElapsedRealtime;
            z = false;
        } else {
            z = true;
        }
        return z;
    }
}
