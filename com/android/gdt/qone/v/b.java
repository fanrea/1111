package com.android.gdt.qone.v;

import com.android.gdt.qone.ae.h;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b implements Runnable {
    public final /* synthetic */ Runnable a;

    public b(Runnable runnable) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.run();
        } catch (Throwable th) {
            String message = th.getMessage();
            if (!h.a.get()) {
                com.android.gdt.qone.af.c.a(th);
            } else {
                throw new IllegalStateException("[strict] " + message);
            }
        }
    }
}
