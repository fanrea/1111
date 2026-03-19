package com.bytedance.sdk.component.widget.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d hc;
    private volatile hc d;

    private d() {
    }

    public static d d() {
        if (hc == null) {
            synchronized (d.class) {
                if (hc == null) {
                    hc = new d();
                }
            }
        }
        return hc;
    }

    public hc hc() {
        return this.d;
    }
}
