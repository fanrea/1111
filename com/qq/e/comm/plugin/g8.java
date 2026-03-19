package com.qq.e.comm.plugin;

import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class g8 {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(com.qq.e.comm.plugin.h4 r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            com.qq.e.comm.plugin.e2 r1 = r5.k()
            if (r1 == 0) goto L25
            boolean r2 = r1.i()
            if (r2 == 0) goto L13
            java.lang.String r1 = "dlendclstih"
            goto L27
        L13:
            boolean r2 = r1.h()
            if (r2 == 0) goto L1c
            java.lang.String r1 = "dlendclstif"
            goto L27
        L1c:
            boolean r1 = r1.k()
            if (r1 == 0) goto L25
            java.lang.String r1 = "dlendclstrv"
            goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            java.lang.String r2 = r5.y0()
            com.qq.e.comm.plugin.ku r3 = r5.x0()
            r4 = -1
            int r1 = com.qq.e.comm.plugin.xc.a(r1, r2, r4, r3)
            if (r1 < 0) goto L37
            return r1
        L37:
            com.qq.e.comm.plugin.yq r1 = r5.p0()
            if (r1 == 0) goto L48
            com.qq.e.comm.plugin.yq r5 = r5.p0()
            int r5 = r5.e()
            if (r5 < 0) goto L48
            return r5
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.g8.b(com.qq.e.comm.plugin.h4):int");
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ Cif a;

        a(Cif cif) {
            this.a = cif;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            this.a.a(new m8().a().f());
        }
    }

    public static boolean d(h4 h4Var) {
        yq yqVarP0;
        if (h4Var == null || (yqVarP0 = h4Var.p0()) == null) {
            return false;
        }
        return yqVarP0.w();
    }

    static int c(h4 h4Var) {
        yq yqVarP0;
        if (h4Var == null || (yqVarP0 = h4Var.p0()) == null) {
            return -1;
        }
        return yqVarP0.f();
    }

    static boolean a(h4 h4Var) {
        yq yqVarP0;
        return d(h4Var) && (yqVarP0 = h4Var.p0()) != null && yqVarP0.g() == 1;
    }

    static void a(Cif cif) throws JSONException {
        cif.a(new m8().b().f());
    }

    static void a(Cif cif, h4 h4Var) throws JSONException {
        if (d(h4Var)) {
            m8 m8VarC = new m8().c();
            int iB = b(h4Var);
            if (iB <= 0) {
                m8VarC.a();
            }
            cif.a(m8VarC.f());
            cif.c("showEndCard");
            if (iB > 0) {
                xo.a(new a(cif), iB * 1000);
            }
        }
    }
}
