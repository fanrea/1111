package com.qq.e.comm.plugin;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hn {
    static String a;
    static long b;

    public static void b(f5 f5Var, long j) {
        x6.b(f5Var, j);
    }

    public static void b(f5 f5Var) {
        if (TextUtils.isEmpty(a) || f5Var == null || !TextUtils.equals(a, f5Var.i())) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - b;
        if (jCurrentTimeMillis > 0) {
            wt wtVar = new wt(2130401);
            wtVar.b(jCurrentTimeMillis);
            wtVar.a(f5Var);
            b10.a(wtVar);
        }
    }

    public static void c(f5 f5Var, long j) {
        x6.c(f5Var, j);
    }

    public static void a(f5 f5Var, long j) {
        x6.a(f5Var, j);
    }

    public static void d(f5 f5Var, long j) {
        x6.d(f5Var, j);
    }

    public static void c(f5 f5Var) {
        b10.a(1030013, f5Var);
    }

    public static void a(f5 f5Var, long j, long j2) {
        x6.a(f5Var, j, j2);
    }

    public static void a(f5 f5Var) {
        b10.a(1401000, f5Var);
        if (f5Var != null) {
            a = f5Var.i();
            b = System.currentTimeMillis();
        }
    }

    public static void a(boolean z, f5 f5Var) {
        b10.a(z ? 1030023 : 1030022, f5Var);
    }

    public static void a(f5 f5Var, int i) {
        b10.a(1401001, f5Var, null, Integer.valueOf(i), null);
    }

    public static void a(f5 f5Var, boolean z, boolean z2) {
        b10.a(1401002, f5Var, Integer.valueOf(!z ? 1 : 2), Integer.valueOf(z2 ? 2 : 1), null);
    }
}
