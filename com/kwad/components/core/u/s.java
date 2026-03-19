package com.kwad.components.core.u;

import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class s implements Runnable {
    private WeakReference<Runnable> abc;

    public s(Runnable runnable) {
        this.abc = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.abc.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
