package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.HashSet;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vn {
    public static String a(String str, h4 h4Var, boolean z) {
        String str2;
        if (TextUtils.isEmpty(str) || h4Var == null) {
            return str;
        }
        if (h4Var.I() != 1 && h4Var.I() != 4) {
            return str;
        }
        if (z && h4Var.C1()) {
            str2 = h4Var.X0() > h4Var.b1() ? "1" : "2";
        } else {
            str2 = "0";
        }
        return a30.c(a30.c(str, "v_subtype", str2), "ad_type", String.valueOf(h4Var.k().c));
    }

    public static String a(String str, String str2) {
        return a30.a(str, "land_page_source", str2);
    }

    public static boolean a(String str, int i) {
        String[] strArrSplit = r1.d().f().a("sklpjp", str, "1,4,7,10").split(",");
        HashSet hashSet = new HashSet();
        try {
            for (String str2 : strArrSplit) {
                hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return hashSet.contains(Integer.valueOf(i));
    }
}
