package com.android.gdt.qone.ak;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class p implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ q b;

    public p(q qVar, String str) {
        this.b = qVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q qVar = this.b;
        String str = this.a;
        synchronized (qVar.d) {
            com.android.gdt.qone.ad.h.a(qVar.a).a("tn", str);
            com.android.gdt.qone.ad.h.a(qVar.a).a("t_s_t", System.currentTimeMillis());
        }
    }
}
