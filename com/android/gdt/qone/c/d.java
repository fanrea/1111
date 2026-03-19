package com.android.gdt.qone.c;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d implements Runnable {
    public final /* synthetic */ Runnable a;

    public d(Runnable runnable) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.run();
        } catch (Throwable th) {
            com.android.gdt.qone.af.b.a(th.toString());
        }
    }
}
