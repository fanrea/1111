package com.qq.e.comm.plugin;

import java.util.Iterator;
import java.util.Queue;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class tb {
    public static void a(int i) {
        a(i, null);
    }

    public static void a(int i, h4 h4Var) {
        ub ubVarC = ub.c();
        a(ubVarC, i, h4Var);
        if (i == 1) {
            ubVarC.e(wb.e());
            ubVarC.e(wb.c());
            ubVarC.e(wb.d());
            ubVarC.e(wb.b());
            return;
        }
        if (i != 4) {
            return;
        }
        ubVarC.e(wb.a(h4Var.k()));
        ubVarC.e(wb.b(h4Var.k()));
        ubVarC.e(wb.a(h4Var));
    }

    public static void a(int i, String str, e2 e2Var) {
        a(i, new h4(null, str, null, e2Var, null, null));
    }

    private static void a(ub ubVar, int i, h4 h4Var) {
        Queue<JSONObject> queueA = n4.a();
        if (queueA.isEmpty()) {
            return;
        }
        Iterator<JSONObject> it = queueA.iterator();
        while (it.hasNext()) {
            ubVar.e(wb.a(h4Var, it.next(), i));
        }
    }
}
