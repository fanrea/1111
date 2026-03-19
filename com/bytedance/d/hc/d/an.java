package com.bytedance.d.hc.d;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private static volatile an d;
    private final b hc;

    public static an d(Context context) {
        if (d == null) {
            synchronized (an.class) {
                if (d == null) {
                    d = new an(context);
                }
            }
        }
        return d;
    }

    private an(Context context) {
        this.hc = new b(context);
    }

    public void d() {
        this.hc.d();
    }
}
