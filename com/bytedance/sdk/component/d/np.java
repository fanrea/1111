package com.bytedance.sdk.component.d;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class np {
    private static boolean d;

    static String d() {
        return "";
    }

    static String d(Throwable th) {
        return "{\"code\":" + (th instanceof yo ? ((yo) th).d : 0) + i.d;
    }

    static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String strSubstring = d ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (!strSubstring.isEmpty()) {
            return str2 + "," + strSubstring + i.d;
        }
        return str2 + i.d;
    }

    static void d(boolean z) {
        d = z;
    }
}
