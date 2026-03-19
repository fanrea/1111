package com.bytedance.sdk.component.tt.c;

import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static boolean d = false;
    private static int hc = 4;

    public static boolean d() {
        return d;
    }

    public static void d(String str, String str2) {
        if (d && str2 != null && hc <= 4) {
            mq.d(mq.c(str), str2);
        }
    }
}
