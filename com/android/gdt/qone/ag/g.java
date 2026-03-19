package com.android.gdt.qone.ag;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class g implements Runnable {
    public final /* synthetic */ com.android.gdt.qone.ak.l a;
    public final /* synthetic */ o b;

    public g(o oVar, com.android.gdt.qone.ak.l lVar) {
        this.b = oVar;
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.b) {
            if (!this.b.c) {
                com.android.gdt.qone.w.c.h().c = 10L;
                this.a.a(4);
                this.b.c = true;
            }
        }
    }
}
