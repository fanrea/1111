package com.qq.e.comm.plugin;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class l1 {
    private static final int a = r1.d().f().a("aipvc", 1);

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e2.values().length];
            a = iArr;
            try {
                iArr[e2.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e2.NATIVEUNIFIEDAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e2.REWARDVIDEOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e2.UNIFIED_INTERSTITIAL_FULLSCREEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[e2.UNIFIED_INTERSTITIAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[e2.UNIFIED_BANNER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[e2.NATIVEEXPRESSAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(com.qq.e.comm.plugin.h4 r3) {
        /*
            boolean r0 = a()
            if (r0 != 0) goto L9a
            if (r3 != 0) goto La
            goto L9a
        La:
            java.lang.String r0 = r3.x()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = r3.S()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L1e
            int r0 = r0 + 2
        L1e:
            java.lang.String r1 = r3.c0()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L2a
            int r0 = r0 + 4
        L2a:
            int r1 = r3.v0()
            if (r1 <= 0) goto L36
            int r1 = r3.w0()
            if (r1 > 0) goto L38
        L36:
            int r0 = r0 + 8
        L38:
            java.lang.String r1 = r3.V0()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L58
            int r1 = r3.b1()
            if (r1 <= 0) goto L4e
            int r1 = r3.X0()
            if (r1 > 0) goto L50
        L4e:
            int r0 = r0 + 16
        L50:
            int r1 = r3.W0()
            if (r1 > 0) goto L58
            int r0 = r0 + 32
        L58:
            java.lang.String r1 = r3.d0()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L64
            int r0 = r0 + 64
        L64:
            int r1 = r3.f()
            if (r1 > 0) goto L6c
            int r0 = r0 + 128
        L6c:
            java.lang.String r1 = r3.c0()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L82
            java.lang.String r1 = r3.V0()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L82
            int r0 = r0 + 256
        L82:
            int r1 = r3.B0()
            if (r1 > 0) goto L8a
            int r0 = r0 + 512
        L8a:
            com.qq.e.comm.plugin.yq r1 = r3.p0()
            a(r1, r3)
            if (r0 == 0) goto L9a
            r1 = 1400016(0x155cd0, float:1.96184E-39)
            r2 = 0
            a(r1, r3, r0, r2)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.l1.b(com.qq.e.comm.plugin.h4):void");
    }

    private static void a(int i, h4 h4Var, int i2, ja jaVar) {
        qc qcVar = new qc(i);
        qcVar.d(i2);
        qcVar.a(f5.a(h4Var));
        if (jaVar != null) {
            qcVar.a(jaVar);
        }
        b10.a(qcVar);
    }

    private static void a(yq yqVar, h4 h4Var) {
        int i;
        if (yqVar == null) {
            i = 1;
        } else {
            int i2 = TextUtils.isEmpty(yqVar.c()) ? 2 : 0;
            i = TextUtils.isEmpty(yqVar.m()) ? i2 + 4 : i2;
        }
        if (i != 0) {
            a(1400022, h4Var, i, null);
        }
    }

    public static void a(pw pwVar) {
        String str;
        int i;
        if (pwVar == null) {
            i = 3;
            str = "Android getValidData return null";
        } else {
            str = "";
            i = (TextUtils.isEmpty(pwVar.V0()) && TextUtils.isEmpty(pwVar.c0())) ? 4 : 0;
        }
        if (i != 0) {
            a(1400017, pwVar, i, new ja().a("msg", str));
        }
    }

    private static boolean a() {
        return a != 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.qq.e.comm.plugin.h4 r3) {
        /*
            boolean r0 = a()
            if (r0 == 0) goto L7
            return
        L7:
            java.lang.String r0 = r3.O0()
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L67
            r1 = 10000(0x2710, float:1.4013E-41)
            if (r0 >= r1) goto L14
            goto L67
        L14:
            boolean r0 = r3.a0()
            com.qq.e.comm.plugin.e2 r1 = r3.k()
            r1.e()
            r3.C1()
            int[] r2 = com.qq.e.comm.plugin.l1.a.a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            switch(r1) {
                case 1: goto L4f;
                case 2: goto L4c;
                case 3: goto L3b;
                case 4: goto L3b;
                case 5: goto L2e;
                case 6: goto L2e;
                default: goto L2d;
            }
        L2d:
            goto L5d
        L2e:
            java.lang.String r1 = r3.V0()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L5d
            if (r0 == 0) goto L5d
            goto L5b
        L3b:
            java.lang.String r1 = r3.V0()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L48
            if (r0 == 0) goto L5d
            goto L5b
        L48:
            if (r0 != 0) goto L5d
            r0 = 2
            goto L5e
        L4c:
            if (r0 != 0) goto L5d
            goto L5b
        L4f:
            java.lang.String r1 = r3.V0()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L5d
            if (r0 != 0) goto L5d
        L5b:
            r0 = 1
            goto L5e
        L5d:
            r0 = 0
        L5e:
            if (r0 == 0) goto L67
            r1 = 1400020(0x155cd4, float:1.961846E-39)
            r2 = 0
            a(r1, r3, r0, r2)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.l1.a(com.qq.e.comm.plugin.h4):void");
    }
}
