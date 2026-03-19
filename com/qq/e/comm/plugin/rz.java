package com.qq.e.comm.plugin;

import android.view.View;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class rz implements Runnable {
    private xz a;

    rz() {
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        xz xzVar = this.a;
        if (c() || (view = this.a.w) == null) {
            return;
        }
        mu muVarB = xzVar.b();
        u2 u2VarA = u2.a();
        r5 r5VarD = u2VarA.d(view);
        if (r5VarD != null) {
            r5VarD.d(41);
            r5VarD.c(xzVar.g());
            r5VarD.a(muVarB.s1());
        }
        ad.a(u2VarA.c(view), muVarB, null, this.a.n, null);
        if (muVarB.s1()) {
            f00.c(xzVar.c());
        }
        zv.a(view, muVarB);
    }

    public void b() {
        View view;
        if (c() || (view = this.a.w) == null) {
            return;
        }
        view.post(this);
    }

    public void a() {
        this.a = null;
    }

    public boolean c() {
        return this.a == null;
    }

    public void a(xz xzVar, hk hkVar) {
        this.a = xzVar;
    }
}
