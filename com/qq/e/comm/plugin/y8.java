package com.qq.e.comm.plugin;

import com.baidu.mobstat.forbes.Config;
import java.util.Random;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class y8 {
    private static Random a;

    public static int c(h4 h4Var) {
        return a(h4Var, "dlctd", 8);
    }

    private static int a(h4 h4Var, String str, int i) {
        int iA = r1.d().f().a(a(h4Var, str), h4Var.y0(), -1);
        return iA >= 0 ? iA : r1.d().f().a(str, h4Var.y0(), i);
    }

    public static int b(h4 h4Var) {
        return xc.a(a(h4Var, "skscacct"), h4Var.y0(), 0, h4Var.x0());
    }

    public static int a(h4 h4Var, yq yqVar) {
        int iR;
        int iA = xc.a(a(h4Var, "skscprc"), h4Var.y0(), 0, h4Var.x0());
        if (iA <= 0) {
            if (yqVar == null || (iR = yqVar.r()) < 0) {
                return -1;
            }
            return iR;
        }
        if (a == null) {
            a = new Random();
        }
        if (iA < 100 && a.nextInt(100) > iA) {
            a(h4Var, iA, false);
            return 0;
        }
        if (yqVar == null) {
            a(h4Var, iA, true);
            return 1;
        }
        int iR2 = yqVar.r();
        if (iR2 > 0) {
            a(h4Var, iA, true);
            return iR2;
        }
        a(h4Var, iA, true);
        return 1;
    }

    static int a(h4 h4Var) {
        return a(h4Var, "dlcte", 0);
    }

    private static void a(h4 h4Var, int i, boolean z) {
        qc qcVar = new qc(9760000);
        qcVar.a(f5.a(h4Var));
        qcVar.c(i);
        if (z) {
            qcVar.d(1);
        }
        b10.a(qcVar);
    }

    private static String a(h4 h4Var, String str) {
        return str + Config.replace + h4Var.k().d();
    }

    public static void a(h4 h4Var, int i, int i2) {
        qc qcVar = new qc(9760001);
        qcVar.a(f5.a(h4Var));
        qcVar.c(i);
        qcVar.d(i2);
        b10.a(qcVar);
    }
}
