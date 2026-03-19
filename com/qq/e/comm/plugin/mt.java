package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mt<T> extends q4<T> {
    private boolean E;

    public mt(yn ynVar, k10<T> k10Var) {
        super(ynVar, k10Var);
    }

    @Override // com.qq.e.comm.plugin.q4
    public void a() {
        super.a();
        this.o.e();
        this.m.e();
        this.n.f();
    }

    protected void f() {
        if (this.w) {
            tr trVar = this.r;
            int iF = trVar != null ? trVar.f() : -1;
            this.B = iF;
            if (iF > this.C) {
                this.n.a(iF, false);
            }
        }
        if (this.x) {
            tr trVar2 = this.v;
            int iF2 = trVar2 != null ? trVar2.f() : -1;
            this.C = iF2;
            if (iF2 > this.B) {
                this.n.a(iF2, false);
            }
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
        } else if (l4Var == this.n) {
            this.s = t;
            this.t = trVar;
            this.E = true;
        } else if (l4Var == this.o) {
            this.u = t;
            this.v = trVar;
            this.x = true;
            f();
        }
        g();
    }

    private void g() {
        if (this.E && this.w && this.x) {
            b();
        }
    }
}
