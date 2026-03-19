package com.qq.e.comm.plugin;

import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class u5 {
    public static void b(h4 h4Var) {
        List<xv> listE0;
        if (h4Var == null || (listE0 = h4Var.E0()) == null || listE0.size() <= 0) {
            return;
        }
        for (xv xvVar : listE0) {
            if (xvVar != null) {
                zt.a(xvVar.a());
            }
        }
    }

    public static void a(h4 h4Var) {
        List<String> listV = h4Var.v();
        if (listV == null || listV.size() <= 0) {
            return;
        }
        Iterator<String> it = listV.iterator();
        while (it.hasNext()) {
            zt.a(it.next());
        }
    }
}
