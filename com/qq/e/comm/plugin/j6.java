package com.qq.e.comm.plugin;

import java.util.concurrent.atomic.AtomicInteger;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class j6 {
    private static final AtomicInteger a = new AtomicInteger();

    static /* synthetic */ AtomicInteger a() {
        return (AtomicInteger) pro.getobjresult(157, 1, new Object[0]);
    }

    public static void a(l6 l6Var, qs qsVar) {
        pro.getVresult(158, 1, l6Var, qsVar);
    }

    private static boolean a(l6 l6Var) {
        return pro.getZresult(159, 1, l6Var);
    }

    public static void b(l6 l6Var, qs qsVar) {
        pro.getVresult(160, 1, l6Var, qsVar);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ l6 a;
        final /* synthetic */ pj b;
        final /* synthetic */ qs c;

        a(l6 l6Var, pj pjVar, qs qsVar) {
            this.a = l6Var;
            this.b = pjVar;
            this.c = qsVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j6.a().incrementAndGet();
            l6 l6Var = this.a;
            if (l6Var.h) {
                j3.a(h10.f(l6Var.i) ? 4001019 : 4001020, this.a.x);
            }
            this.a.B.i1();
            this.b.a(this.a, this.c);
            l6 l6Var2 = this.a;
            o6.a(2300007, l6Var2.a, l6Var2);
            j6.a().decrementAndGet();
            tb.a(8, this.a.B);
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ l6 a;
        final /* synthetic */ pj b;
        final /* synthetic */ qs c;

        b(l6 l6Var, pj pjVar, qs qsVar) {
            this.a = l6Var;
            this.b = pjVar;
            this.c = qsVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j6.a().incrementAndGet();
            this.a.B.i1();
            this.b.a(this.a, this.c);
            j6.a().decrementAndGet();
            tb.a(8, this.a.B);
        }
    }
}
