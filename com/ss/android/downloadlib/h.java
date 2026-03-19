package com.ss.android.downloadlib;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h {
    private static volatile h d;
    private com.ss.android.d.d.hc.an hc = null;

    private h() {
    }

    public static h d() {
        if (d == null) {
            synchronized (h.class) {
                if (d == null) {
                    d = new h();
                }
            }
        }
        return d;
    }

    public com.ss.android.d.d.hc.an hc() {
        return this.hc;
    }
}
