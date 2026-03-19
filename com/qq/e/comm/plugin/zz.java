package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.xc;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class zz {
    static int a;
    private static final String b = String.valueOf(e2.SPLASH.e());
    private static int c = -1;
    private static int d = -1;
    private static int e;

    static void d(h4 h4Var) {
        int iA = r1.d().f().a("spl_lptime", h4Var.y0(), 20);
        if (iA > 10000) {
            g00.a(b.c().a(h4Var.x0(), String.valueOf(iA), 20));
        }
    }

    static boolean e(String str) {
        return xc.a("slawlm", b, str, 0) == 1;
    }

    public static boolean f(String str) {
        return r1.d().f().a("sskphe", str, 1) == 1;
    }

    static boolean g(String str) {
        return r1.d().f().a("deepLink_confirm", str, 0) == 1;
    }

    static int d(String str) {
        int iA = r1.d().f().a("spl_lptime", str, 20);
        if (iA > 10000) {
            iA = g00.c();
        }
        if (iA <= -1) {
            return -1;
        }
        return iA * 100;
    }

    static boolean d() {
        return r1.d().f().a("szo", 0) == 1;
    }

    static void c(h4 h4Var) {
        if (h4Var == null) {
            return;
        }
        d(h4Var);
        xc.c cVarD = xc.d();
        String str = b;
        cVarD.a(h4Var, str, "softc", "").a(h4Var, str, "slawlm", 0).a(h4Var, str, "spcasi", 0).a();
    }

    static boolean c() {
        return r1.d().f().a("splashLoadedEnqueueHead", 0) == 1;
    }

    private static int c(String str) {
        return r1.d().f().a("splashSkipShowDelay", str, 0);
    }

    static int a(h4 h4Var) {
        String strY0 = h4Var.y0();
        int iA = xc.a("spl_exptime_exp", strY0, 5, h4Var.x0());
        return iA != 5 ? iA * 1000 : r1.d().f().a("spl_exptime", strY0, 5000);
    }

    public static boolean b(h4 h4Var) {
        return (h4Var == null || h4Var.o() == null || h4Var.o().b() == null || r1.d().f().a("ssmi", h4Var.y0(), 0) != 1) ? false : true;
    }

    static double a(boolean z, boolean z2) {
        int iA = r1.d().f().a(z2 ? z ? "chrffsl" : "chrl" : z ? "chrffs" : "chr", 0);
        if (iA > 0) {
            double d2 = iA;
            Double.isNaN(d2);
            return d2 / 100.0d;
        }
        if (z) {
            return 0.95d;
        }
        return z2 ? 0.85d : 0.75d;
    }

    public static boolean b(mu muVar) {
        return (muVar == null || c(muVar.y0()) == 0) ? false : true;
    }

    static int b(String str) {
        return r1.d().f().a("pis", str, 7200);
    }

    public static int b() {
        if (c < 0) {
            c = r1.d().f().a("swvct", 2000);
        }
        return c;
    }

    public static int a(mu muVar) {
        if (muVar == null) {
            return 0;
        }
        int iA = r1.d().f().a("splashSkipPos", muVar.y0(), 3);
        if (iA < 0 || iA > 4) {
            return 3;
        }
        return iA;
    }

    static void a(int i) {
        a = i;
        if (i <= 0) {
            return;
        }
        vx vxVarF = r1.d().f();
        if (e <= 0) {
            int i2 = 1500;
            int iA = vxVarF.a("spl_ltime_min", 1500);
            if (iA <= 5000 && iA > 0) {
                i2 = iA;
            }
            e = i2;
        }
        int i3 = e;
        if (i < i3) {
            GDTLogger.w("开屏超时时长取值范围为[" + e + ", 5000]，已将超时时长设为" + e + "ms。", null);
            i = i3;
        } else if (i > 5000) {
            GDTLogger.w("开屏超时时长取值范围为[" + e + ", 5000]，已将超时时长设为5000ms。", null);
            i = 5000;
        }
        vxVarF.a("spl_ltime", Integer.valueOf(i));
    }

    public static boolean a(w1 w1Var) {
        return w1Var != null && w1Var.x() == e2.SPLASH.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int a(boolean r5, java.lang.String r6) throws java.lang.NumberFormatException {
        /*
            java.lang.String r0 = com.qq.e.comm.plugin.zz.b
            java.lang.String r1 = "softc"
            java.lang.String r2 = ""
            java.lang.String r0 = com.qq.e.comm.plugin.xc.a(r1, r0, r6, r2)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            r3 = -1
            if (r1 != 0) goto L2e
            java.lang.String r1 = ","
            java.lang.String[] r0 = r0.split(r1)     // Catch: java.lang.Exception -> L28
            r1 = r0[r2]     // Catch: java.lang.Exception -> L28
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L28
            r4 = 1
            r0 = r0[r4]     // Catch: java.lang.Exception -> L26
            int r3 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L26
            goto L2f
        L26:
            r0 = move-exception
            goto L2a
        L28:
            r0 = move-exception
            r1 = -1
        L2a:
            r0.getMessage()
            goto L2f
        L2e:
            r1 = -1
        L2f:
            if (r3 <= 0) goto L3d
            if (r1 < 0) goto L3d
            int r0 = com.qq.e.comm.plugin.zz.a
            if (r0 == 0) goto L38
            r2 = 2
        L38:
            int r5 = r5 + r2
            r5 = r5 & r1
            if (r5 != 0) goto L3d
            return r3
        L3d:
            com.qq.e.comm.plugin.r1 r5 = com.qq.e.comm.plugin.r1.d()
            com.qq.e.comm.plugin.vx r5 = r5.f()
            java.lang.String r0 = "spl_ltime"
            r1 = 3000(0xbb8, float:4.204E-42)
            int r5 = r5.a(r0, r6, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.zz.a(boolean, java.lang.String):int");
    }

    static int a(String str) {
        return xc.a("spcasi", b, str, 0);
    }

    public static int a() {
        if (d < 0) {
            d = r1.d().f().a("sabct", com.alipay.sdk.m.e0.a.a);
        }
        return d;
    }
}
