package com.qq.e.comm.plugin;

import android.util.Pair;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yp {
    private static volatile sc a;

    private static sc a() {
        if (a == null) {
            synchronized (sc.class) {
                if (a == null) {
                    sc scVar = new sc();
                    Pair<Integer, Integer> pairB = b();
                    scVar.a(((Integer) pairB.first).intValue(), ((Integer) pairB.second).intValue()).a(c());
                    a = scVar;
                }
            }
        }
        return a;
    }

    private static Pair<Integer, Integer> b() {
        try {
            String[] strArrSplit = r1.d().f().b("emtd", "700,100").split(",");
            return new Pair<>(Integer.valueOf(Integer.parseInt(strArrSplit[0])), Integer.valueOf(Integer.parseInt(strArrSplit[1])));
        } catch (Exception unused) {
            return new Pair<>(700, 100);
        }
    }

    private static boolean c() {
        return r1.d().f().a("emts", 0) == 1;
    }

    private static boolean d() {
        return r1.d().f().a("emts", 0) != 0;
    }

    public static boolean e() {
        return r1.d().f().a("fps_enable", 1) == 1;
    }

    public static void f() {
        if (d()) {
            a().c();
        }
    }

    public static void g() {
        if (a != null) {
            synchronized (sc.class) {
                if (a != null) {
                    a.d();
                    a = null;
                }
            }
        }
    }
}
