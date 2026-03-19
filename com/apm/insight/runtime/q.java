package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class q {
    private static volatile v a;
    private static volatile Handler b;

    public static HandlerThread a() {
        if (a == null) {
            synchronized (q.class) {
                if (a == null) {
                    a = new v("default_npth_thread");
                    a.b();
                }
            }
        }
        return a.c();
    }

    public static v b() {
        if (a == null) {
            a();
        }
        return a;
    }
}
