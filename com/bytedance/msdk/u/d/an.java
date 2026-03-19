package com.bytedance.msdk.u.d;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends h {
    private static volatile an d;

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
        super(context);
    }
}
