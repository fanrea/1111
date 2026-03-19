package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class py<T> extends q4<T> {
    public py(yn ynVar, k10<T> k10Var) {
        super(ynVar, k10Var);
    }

    @Override // com.qq.e.comm.plugin.q4
    public void a() {
        super.a();
        this.o.e();
        this.m.e();
    }

    protected void f() {
        tr trVar = this.r;
        this.B = trVar != null ? trVar.f() : -1;
        tr trVar2 = this.v;
        int iF = trVar2 != null ? trVar2.f() : -1;
        this.C = iF;
        if (this.w && this.x) {
            this.n.a(Math.max(iF, this.B), true);
            this.n.f();
        }
    }

    @Override // com.qq.e.comm.plugin.no
    public void a(l4<T> l4Var, T t, tr trVar) {
        qm$h$$ExternalSyntheticBackport0.m(l4Var);
        qm$h$$ExternalSyntheticBackport0.m(t);
        qm$h$$ExternalSyntheticBackport0.m(trVar);
        if (l4Var == this.m) {
            this.q = t;
            this.r = trVar;
            this.w = true;
            f();
            return;
        }
        if (l4Var == this.o) {
            this.u = t;
            this.v = trVar;
            this.x = true;
            f();
            return;
        }
        if (l4Var == this.n) {
            this.s = t;
            this.t = trVar;
            b();
        }
    }
}
