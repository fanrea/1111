package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.plugin.ky;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ac {
    public static String a(String str, String str2) {
        b(str, str2);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encodeToString(ky.b(str.getBytes(d6.a)), 10).replace("=", "");
        } catch (ky.b | NullPointerException unused) {
            return null;
        }
    }

    private static void b(String str, String str2) {
        if (TextUtils.equals(str2, "click") || TextUtils.equals(str2, "exposure")) {
            return;
        }
        TextUtils.equals(str2, "request");
    }
}
