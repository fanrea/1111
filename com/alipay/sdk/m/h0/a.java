package com.alipay.sdk.m.h0;

import android.content.Context;
import com.alipay.sdk.m.a.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static String a(Context context) {
        if (a.b.a) {
            return a.c.b.a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (a.b.a) {
            return a.c.b.a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (a.b.a) {
            return a.c.b.a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (a.b.a) {
            return a.c.b.a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void e(Context context) {
        a.b.b = a.c.b.a.a(context.getApplicationContext());
        a.b.a = true;
    }

    public static boolean a() {
        if (a.b.a) {
            return a.b.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
