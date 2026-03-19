package com.qq.e.comm.plugin;

import android.util.Pair;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ar {
    private static volatile Boolean a;
    private static volatile HashSet<Integer> b;
    private static volatile Boolean c;
    private static volatile Boolean d;

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e2.values().length];
            a = iArr;
            try {
                iArr[e2.NATIVEEXPRESSAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e2.UNIFIED_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e2.NATIVEUNIFIEDAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static boolean b() {
        if (c == null) {
            synchronized (ar.class) {
                if (c == null) {
                    boolean z = true;
                    if (xc.a("skucdt", 1, tc.c()) != 1) {
                        z = false;
                    }
                    c = Boolean.valueOf(z);
                }
            }
        }
        return c.booleanValue();
    }

    private static int a(h4 h4Var) {
        e2 e2VarK = h4Var.k();
        e2 e2Var = e2.NATIVEEXPRESSAD;
        if (e2VarK == e2Var && h4Var.p0() != null && h4Var.p0().A()) {
            return 52;
        }
        if (h4Var.k() == e2Var && h4Var.H0() == 4) {
            return 51;
        }
        return h4Var.k().c;
    }

    static Pair<Boolean, String> a(h4 h4Var, boolean z) {
        String str;
        boolean zA = r1.d().c().A();
        int i = (!h4Var.C1() || z) ? 1 : 2;
        int i2 = h4Var.w0() > h4Var.v0() ? 2 : 1;
        int i3 = zA ? 2 : 1;
        e2 e2VarK = h4Var.k();
        boolean zA2 = t10.a(true);
        boolean z2 = zA2 && a(e2VarK);
        boolean zA3 = a();
        if (zA2 && (zA3 || z2)) {
            z2 = !zA3;
            str = "1%d%d%d%02d";
        } else {
            str = "%d%d%d%02d";
        }
        int i4 = a.a[e2VarK.ordinal()];
        if (i4 == 1 || i4 == 2) {
            if (h4Var.p0() == null || !h4Var.p0().A()) {
                i3 = 0;
                i2 = 0;
            } else {
                i3 = 0;
            }
        } else if (i4 == 3) {
            if (i == 2 && !jr.a) {
                return new Pair<>(Boolean.valueOf(z2), "");
            }
            i3 = 0;
        }
        return new Pair<>(Boolean.valueOf(z2), String.format(Locale.CHINA, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(a(h4Var))));
    }

    private static boolean a(e2 e2Var) {
        if (a == null) {
            synchronized (ar.class) {
                if (a == null) {
                    boolean z = true;
                    if (r1.d().f().a("puit", 1) != 1) {
                        z = false;
                    }
                    a = Boolean.valueOf(z);
                }
            }
        }
        if (!a.booleanValue()) {
            return false;
        }
        if (b == null) {
            synchronized (ar.class) {
                if (b == null) {
                    b = new HashSet<>();
                    for (String str : r1.d().f().b("puitat", "3,5,8,9,4").split(",")) {
                        b.add(Integer.valueOf(Integer.parseInt(str)));
                    }
                }
            }
        }
        return b.contains(Integer.valueOf(e2Var.c));
    }

    public static boolean a() {
        if (d == null) {
            synchronized (ar.class) {
                if (d == null) {
                    d = Boolean.valueOf(xc.a("skspde", 0, tc.c()) == 1);
                }
            }
        }
        return d.booleanValue();
    }
}
