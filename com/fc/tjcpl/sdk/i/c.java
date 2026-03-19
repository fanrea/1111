package com.fc.tjcpl.sdk.i;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c {
    public static final a a = new a();

    public static void a(Object obj) {
        a.getClass();
        b("TJLog", obj);
    }

    public static void a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            a.getClass();
            str = "TJLog";
        }
        b.a(3, str, obj);
    }

    public static void b(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            a.getClass();
            str = "TJLog";
        }
        b.a(6, str, obj);
    }

    public static void c(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            a.getClass();
            str = "TJLog";
        }
        b.a(4, str, obj);
    }
}
