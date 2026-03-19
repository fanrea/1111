package com.bytedance.sdk.component.gb.hc.an;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile hc d;

    public static hc d(com.bytedance.sdk.component.gb.d.u uVar) {
        if (d == null) {
            synchronized (hc.class) {
                if (d == null) {
                    d = new b(new an(uVar), uVar);
                }
            }
        }
        return d;
    }
}
