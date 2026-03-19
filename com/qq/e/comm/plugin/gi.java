package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class gi {
    static final int a = yu.a(r1.d().a(), 35);

    public static yl a(Context context, h4 h4Var) {
        if (context == null || h4Var == null) {
            return null;
        }
        return new tz(context, "点击" + b(h4Var));
    }

    public static String b(h4 h4Var) {
        if (h4Var.k1()) {
            return r1.d().f().a("srat", h4Var.y0(), "下载或跳转第三方应用");
        }
        return r1.d().f().a("srlt", h4Var.y0(), "跳转详情或第三方应用");
    }

    public static String a(h4 h4Var) {
        if (TextUtils.isEmpty(h4Var.u0())) {
            return h4Var.E1() ? "去微信看看" : h4Var.k1() ? "点击下载或跳转第三方应用" : "点击跳转详情或第三方应用";
        }
        return h4Var.u0();
    }
}
