package com.qq.e.comm.plugin;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class fn {
    public static String b(h4 h4Var) {
        if (h4Var == null) {
            return "惊喜奖励";
        }
        String strF0 = h4Var.F0();
        return !TextUtils.isEmpty(strF0) ? strF0 : xc.a("rwtips", h4Var.y0(), "惊喜奖励", h4Var.x0());
    }

    public static int a(h4 h4Var) {
        return xc.a("ifsbcst", h4Var.y0(), 5, h4Var.x0());
    }

    public static boolean a() {
        return r1.d().f().a("bxgfvbc", 0) == 1;
    }
}
