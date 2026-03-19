package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class np {
    private static volatile String d;

    public static String d() {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        String str = Build.MODEL;
        d = str;
        return str;
    }
}
