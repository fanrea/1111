package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class g {
    public static synchronized String a(Context context, String str) {
        String strA = com.alipay.sdk.m.b0.e.a(context, "openapi_file_pri", "openApi" + str, "");
        if (com.alipay.sdk.m.z.a.a(strA)) {
            return "";
        }
        String strB = com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), strA);
        return com.alipay.sdk.m.z.a.a(strB) ? "" : strB;
    }

    public static synchronized void a() {
    }

    public static synchronized void a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
        if (editorEdit != null) {
            editorEdit.clear();
            editorEdit.commit();
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (editorEdit != null) {
                editorEdit.putString("openApi" + str, com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str2));
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }
}
