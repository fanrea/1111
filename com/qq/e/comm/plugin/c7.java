package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c7 {
    public static Set<String> c(h4 h4Var) {
        if (h4Var == null) {
            return Collections.emptySet();
        }
        return a(h4Var, a(h4Var.k()));
    }

    public static Set<String> d(h4 h4Var) {
        return b(h4Var, "skgdcwl");
    }

    public static Set<String> b(h4 h4Var) {
        return b(h4Var, "skgdcblm");
    }

    public static Set<String> a(h4 h4Var) {
        return b(h4Var, "skgdcbl");
    }

    private static Set<String> a(h4 h4Var, String str) {
        Set<String> setEmptySet = Collections.emptySet();
        String strC = r1.d().f().c(str, h4Var.y0());
        return !TextUtils.isEmpty(strC) ? new HashSet(Arrays.asList(strC.split(","))) : setEmptySet;
    }

    private static Set<String> b(h4 h4Var, String str) {
        Set<String> setEmptySet = Collections.emptySet();
        String strY0 = h4Var.y0();
        String strC = r1.d().f().c(vx.a(str, h4Var.k()), strY0);
        if (!TextUtils.isEmpty(strC)) {
            return new HashSet(Arrays.asList(strC.split(",")));
        }
        String strC2 = r1.d().f().c(str, strY0);
        return !TextUtils.isEmpty(strC2) ? new HashSet(Arrays.asList(strC2.split(","))) : setEmptySet;
    }

    private static String a(e2 e2Var) {
        return e2Var.l() ? "te_bxg_sp_ccids" : e2Var.g() ? "te_bxg_ex_ccids" : e2Var.i() ? "te_bxg_ih_ccids" : e2Var.h() ? "te_bxg_if_ccids" : e2Var.f() ? "te_bxg_ba_ccids" : e2Var.k() ? "te_bxg_rv_ccids" : e2Var.j() ? "te_bxg_nu_ccids" : "";
    }
}
