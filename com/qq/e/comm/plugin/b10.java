package com.qq.e.comm.plugin;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b10 {
    private static final Queue<qc> a = new ConcurrentLinkedQueue();
    private static final Queue<wt> b = new ConcurrentLinkedQueue();

    private static void a(r4 r4Var) {
    }

    public static void b(int i, f5 f5Var, Integer num) {
        b(i, f5Var, num, null);
    }

    public static void a() {
        while (true) {
            qc qcVarPoll = a.poll();
            if (qcVarPoll == null) {
                break;
            } else {
                a(qcVarPoll, false);
            }
        }
        while (true) {
            wt wtVarPoll = b.poll();
            if (wtVarPoll == null) {
                return;
            } else {
                a(wtVarPoll);
            }
        }
    }

    public static void b(int i, f5 f5Var, Integer num, ja jaVar) {
        a(i, f5Var, null, num, jaVar);
    }

    public static void a(int i, f5 f5Var) {
        a(i, f5Var, null, null, null);
    }

    public static void a(int i, f5 f5Var, Integer num, Integer num2, ja jaVar) {
        a(i, f5Var, num, num2, jaVar, false);
    }

    public static void a(int i, f5 f5Var, Integer num, Integer num2, ja jaVar, boolean z) {
        qc qcVar = new qc(i);
        if (num != null) {
            qcVar.c(num.intValue());
        }
        qcVar.a(f5Var);
        qcVar.a(jaVar);
        if (num2 != null) {
            qcVar.d(num2.intValue());
        }
        a(qcVar, z);
    }

    public static void a(qc qcVar) {
        a(qcVar, false);
    }

    public static void a(int i, f5 f5Var, Integer num) {
        a(i, f5Var, num, null);
    }

    public static void a(int i, f5 f5Var, Integer num, ja jaVar) {
        a(i, f5Var, num, null, jaVar);
    }

    public static void a(qc qcVar, boolean z) {
        if (!iu.d()) {
            a.add(qcVar);
            return;
        }
        if (qcVar != null) {
            if (z || o00.a(qcVar.c())) {
                zr zrVarF = as.f();
                qcVar.a(zrVarF);
                vc.a(qcVar);
                qcVar.a(pr.a().a(zrVarF, qcVar.b()));
                a((r4) qcVar);
                boolean zA = o00.a(z, qcVar.c());
                z00.c().a(s00.a(qcVar), zA);
                ub.c().a(qcVar, false);
            }
        }
    }

    public static void a(wt wtVar) {
        if (!iu.d()) {
            b.add(wtVar);
            return;
        }
        if (wtVar == null || !o00.b(wtVar.c())) {
            return;
        }
        a((r4) wtVar);
        zr zrVarF = as.f();
        wtVar.a(pr.a().a(zrVarF, wtVar.b()));
        wtVar.a(zrVarF);
        vc.a(wtVar);
        z00.c().a(w00.a(wtVar));
    }
}
