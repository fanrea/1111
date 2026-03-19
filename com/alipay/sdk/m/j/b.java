package com.alipay.sdk.m.j;

import com.alipay.sdk.m.u.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public static boolean a = false;
    public static String b;

    public static void a(String str) {
        b = str;
    }

    public static String b() {
        c cVarB = c.b(c.DOUBLE_REQUEST.b());
        return a(cVarB.b(), cVarB.a(), "");
    }

    public static boolean c() {
        return a;
    }

    public static String d() {
        return b;
    }

    public static String e() {
        c cVarB = c.b(c.PARAMS_ERROR.b());
        return a(cVarB.b(), cVarB.a(), "");
    }

    public static void a(boolean z) {
        a = z;
    }

    public static String a() {
        c cVarB = c.b(c.CANCELED.b());
        return a(cVarB.b(), cVarB.a(), "");
    }

    public static String a(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("resultStatus={").append(i).append("};memo={").append(str).append("};result={").append(str2).append(i.d);
        return sb.toString();
    }
}
