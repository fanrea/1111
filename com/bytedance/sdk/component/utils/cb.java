package com.bytedance.sdk.component.utils;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class cb {
    public static void d(Object obj, String str) {
        if (obj == null) {
            hc(str);
        }
    }

    public static void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            hc(str2);
        }
    }

    public static void d(boolean z, String str) {
        if (z) {
            return;
        }
        hc(str);
    }

    public static void d(String str) {
        hc(str);
    }

    private static void hc(String str) {
        throw new IllegalArgumentException(str);
    }
}
