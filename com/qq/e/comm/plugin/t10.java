package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class t10 {
    private static volatile int a;
    private static volatile Boolean b;
    private static volatile Boolean c;
    private static final String d = r1.d().f().b("tdml", "");
    private static final String e = r1.d().f().b("ntdml", "");

    public static int c() {
        return d() ? 2 : 1;
    }

    private static boolean e() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return "tablet".equals((String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.characteristics", "unknown"));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d() {
        return a(false);
    }

    private static boolean a(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private static boolean b(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int i = configuration.smallestScreenWidthDp;
        return configuration.smallestScreenWidthDp >= 600;
    }

    public static int b() {
        return a;
    }

    public static boolean a(boolean z) {
        if (!z && b != null) {
            return b.booleanValue();
        }
        try {
            b = Boolean.valueOf(a());
            return b.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a() {
        j20 j20Var = new j20();
        j20Var.d();
        Context contextA = r1.d().a();
        boolean zA = a(contextA);
        int i = (zA ? 1 : 2) * 1000;
        j20Var.c();
        boolean zB = b(contextA);
        int i2 = i + ((zB ? 1 : 2) * 100);
        j20Var.c();
        if (c == null) {
            c = Boolean.valueOf(e());
        }
        int i3 = i2 + (c.booleanValue() ? 1 : 2);
        boolean z = false;
        boolean z2 = zA || zB || c.booleanValue();
        a = i3;
        j20Var.c();
        String str = r1.d().c().j;
        if (TextUtils.isEmpty(str)) {
            z = z2;
        } else {
            boolean z3 = d.contains(str.toLowerCase()) ? true : z2;
            if (!e.contains(str.toLowerCase())) {
                z = z3;
            }
        }
        j20Var.a();
        wt wtVarB = new wt(2230120).b(j20Var.b()).b(2);
        wtVarB.a(new ja().a("data", j20Var.toString()));
        b10.a(wtVarB);
        return z;
    }
}
