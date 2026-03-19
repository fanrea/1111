package com.bytedance.sdk.component.h.b.d;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    public static String d = "com.bytedance.openadsdk";
    public static String hc = "content://" + d + ".TTMultiProvider";

    static {
        d();
    }

    public static void d() {
        Context context = hc.getContext();
        if (context != null) {
            d = context.getPackageName();
            hc = "content://" + d + ".TTMultiProvider";
        }
    }
}
