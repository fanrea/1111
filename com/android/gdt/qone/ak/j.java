package com.android.gdt.qone.ak;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class j implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ o b;

    public j(o oVar, a aVar) {
        this.b = oVar;
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o oVar = this.b;
        b bVarA = !oVar.l() ? null : com.android.gdt.qone.ap.f.a(oVar.d);
        if (bVarA == null || bVarA.c()) {
            this.b.a(this.a);
        } else {
            this.a.a(bVarA);
        }
    }
}
