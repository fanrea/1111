package com.bykv;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d d;
    private int hc;

    private d() {
    }

    public static d d() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    public int hc() {
        return this.hc;
    }

    public void d(int i) {
        if (i <= 0) {
            return;
        }
        this.hc = i;
    }
}
