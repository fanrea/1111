package com.android.gdt.qone.ap;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static long a() {
        long startElapsedRealtime;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (Build.VERSION.SDK_INT >= 24) {
            startElapsedRealtime = Process.getStartElapsedRealtime();
        } else {
            startElapsedRealtime = 0;
            jElapsedRealtime = -1;
        }
        return jElapsedRealtime - startElapsedRealtime;
    }
}
