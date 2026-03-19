package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class un {
    private static h4 a;
    private static long b;

    public static void c(f5 f5Var, h4 h4Var) {
        b10.a(1403006, f5Var, Integer.valueOf(a(h4Var)));
    }

    public static void d(f5 f5Var, h4 h4Var) {
        b10.a(1403010, f5Var, Integer.valueOf(a(h4Var)));
    }

    public static void b(f5 f5Var, h4 h4Var) {
        b10.a(1403012, f5Var, Integer.valueOf(a(h4Var)));
    }

    private static int a(h4 h4Var) {
        if (h4Var == null) {
            return 0;
        }
        return h4Var.r1() ? 1 : -1;
    }

    public static void a(l6 l6Var) {
        if (l6Var == null) {
            return;
        }
        a = l6Var.B;
        b = l6Var.a;
    }

    public static void a(f5 f5Var, h4 h4Var) {
        b10.a(1403013, f5Var, Integer.valueOf(a(h4Var)));
    }

    public static void a(f5 f5Var, h4 h4Var, int i) {
        b10.a(1403009, f5Var, Integer.valueOf(a(h4Var)), Integer.valueOf(i), null);
    }

    public static void a(f5 f5Var, int i, ja jaVar, h4 h4Var) {
        b10.a(1403008, f5Var, Integer.valueOf(a(h4Var)), Integer.valueOf(i), jaVar);
    }

    public static void a(f5 f5Var, h4 h4Var, long j, boolean z, String str) throws JSONException {
        h4 h4Var2;
        int iA = a(h4Var);
        ja jaVarA = new ja().a("du", Long.valueOf(j));
        if (h4Var != null) {
            jaVarA.a("data", Integer.valueOf(h4Var.I()));
        }
        if (j > 200) {
            jaVarA.a("url", a30.c(str));
        }
        b10.a(1403007, f5Var, Integer.valueOf(iA), Integer.valueOf(z ? 1 : 2), jaVarA);
        if (b == 0 || (h4Var2 = a) == null || h4Var == null || !TextUtils.equals(h4Var2.S0(), h4Var.S0())) {
            return;
        }
        wt wtVar = new wt(2040006);
        wtVar.a(f5Var);
        wtVar.b(System.currentTimeMillis() - b);
        wtVar.b(iA);
        b10.a(wtVar);
    }

    public static void a(int i, long j, f5 f5Var, String str, String str2) {
        wt wtVarB = new wt(i).b(System.currentTimeMillis() - j);
        wtVarB.a(f5Var);
        wtVarB.a(new ja().a("url", str).a("msg", str2));
        b10.a(wtVarB);
    }
}
