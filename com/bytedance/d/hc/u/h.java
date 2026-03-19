package com.bytedance.d.hc.u;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private static volatile Handler b;
    private static volatile HandlerThread d;
    private static volatile Handler hc;

    public static HandlerThread d() {
        if (d == null) {
            synchronized (h.class) {
                if (d == null) {
                    HandlerThread handlerThread = new HandlerThread("default_npth_thread");
                    d = handlerThread;
                    handlerThread.start();
                    hc = new Handler(d.getLooper());
                }
            }
        }
        return d;
    }

    public static Handler hc() {
        if (hc == null) {
            d();
        }
        return hc;
    }
}
