package com.qq.e.comm.plugin;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class th {
    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int iA = r1.d().f().a("urlLimit", 8000);
            int length = str.length() + str2.length();
            if (length <= iA) {
                return a30.c(str, "mu_p", str2);
            }
            b10.a(100022, null, Integer.valueOf(length / 1000));
        }
        return str;
    }

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int iA = r1.d().f().a("urlLimit", 8000);
            int length = str.length() + str2.length();
            if (length <= iA) {
                return a30.c(str, "mu_p", str2);
            }
            b10.a(100162, null, Integer.valueOf(length / 1000));
        }
        return str;
    }

    public static boolean a(String str) {
        return a30.b(str, "ase", "1");
    }
}
