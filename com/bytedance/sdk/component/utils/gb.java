package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private static volatile Handler d;

    public static Handler d() {
        return com.bytedance.sdk.component.tc.hc.d.d().hc();
    }

    public static Handler hc() {
        if (d == null) {
            synchronized (gb.class) {
                if (d == null) {
                    d = new Handler(Looper.getMainLooper());
                }
            }
        }
        return d;
    }

    public static Handler b() {
        return com.bytedance.sdk.component.tc.hc.d.d().b();
    }
}
