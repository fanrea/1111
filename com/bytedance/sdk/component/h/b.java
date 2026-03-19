package com.bytedance.sdk.component.h;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static volatile Context d;

    public static void d(Context context) {
        if (d == null && context != null) {
            d = context.getApplicationContext();
        }
    }

    public static Context getContext() {
        return d;
    }
}
