package com.qq.e.comm.plugin;

import android.graphics.Color;
import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f8 {
    private static boolean b(h4 h4Var) {
        return r1.d().f().a("adms", h4Var.y0(), sy.d.intValue()) == 1;
    }

    public static String a(h4 h4Var) {
        return (h4Var == null || !b(h4Var)) ? "" : a(yh.a(h4Var.k()));
    }

    private static String a(String str) {
        if (TextUtils.equals("false", str)) {
            return "";
        }
        try {
            Color.parseColor(str);
            return str;
        } catch (Exception unused) {
            return "#66121212";
        }
    }
}
