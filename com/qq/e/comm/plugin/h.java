package com.qq.e.comm.plugin;

import android.text.TextUtils;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h {
    private static String a(int i, String str, int i2) {
        return (String) pro.getobjresult(719, 1, Integer.valueOf(i), str, Integer.valueOf(i2));
    }

    private static void b(int i, String str, int i2) {
        pro.getVresult(720, 1, Integer.valueOf(i), str, Integer.valueOf(i2));
    }

    public static void b(String str, int i) {
        b(245, str, i);
    }

    public static void a(String str) {
        b(246, str, 0);
    }

    public static void a(String str, int i) {
        b(246, str, i);
    }

    public static void a(boolean z, boolean z2, String str, int i) {
        b(z ? z2 ? 266 : 267 : z2 ? 282 : 283, str, i);
    }

    public static void a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (q.b(r1.d().a(), str)) {
            b(247, str2, i);
        } else {
            b(248, str2, i);
        }
    }
}
