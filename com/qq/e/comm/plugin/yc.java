package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.xc;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yc {
    private static xc.c a(xc.c cVar, h4 h4Var, String str, String str2, String str3, boolean z) {
        cVar.a(h4Var, str, str2, str3);
        if (z) {
            cVar.a(h4Var, str, n4.a(str2), str3);
        }
        return cVar;
    }

    public static void a(h4 h4Var) {
        s20.a().b(h4Var);
        String strC = h4Var.k().c();
        a(xc.d().a(h4Var, "APP", "alaai", 1, (xc.b<Integer>) null).a(h4Var, "APP", "prhs", 0, (xc.b<Integer>) null).a(h4Var, "APP", "iehna", 0, (xc.b<Integer>) null).a(h4Var, "APP", "htph", 0, (xc.b<Integer>) null).a(h4Var, strC, "itratcl", 0, (xc.b<Integer>) null).a(h4Var, "APP", "snspcc", sy.f.intValue()).a(h4Var, "APP", "snsts", sy.a.intValue()).a(h4Var, "iaflc", 8).a(h4Var, "iaflft", 2).a(h4Var, "APP", aj.f("mi"), 0).a(h4Var, "APP", aj.f("v"), 0).a(h4Var, "APP", aj.f("c"), 0).a(h4Var, "APP", "adroptc", 0), h4Var, strC).a();
        jh.c().e(h4Var);
        s1.d().b();
    }

    private static xc.c a(xc.c cVar, h4 h4Var, String str) {
        String str2;
        a(cVar, h4Var, str, "eapasc", "", true);
        a(cVar, h4Var, str, "eapatc", "", true);
        for (Map.Entry entry : n4.b().entrySet()) {
            int iIntValue = ((Integer) entry.getValue()).intValue();
            if (iIntValue == 1) {
                str2 = "APP";
            } else if (iIntValue == 2) {
                str2 = str;
            }
            cVar.a(h4Var, str2, n4.a((String) entry.getKey()), "");
        }
        return cVar;
    }
}
