package com.android.gdt.qone.g;

import android.os.IBinder;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c implements Runnable {
    public final IBinder a;
    public final /* synthetic */ d b;

    public c(d dVar, IBinder iBinder) {
        this.b = dVar;
        this.a = iBinder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.b.offer(this.a);
        } catch (Throwable unused) {
        }
    }
}
