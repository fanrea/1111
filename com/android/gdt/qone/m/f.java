package com.android.gdt.qone.m;

import android.content.Intent;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class f implements Runnable {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.a.b;
        if (eVar != null) {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            eVar.d = eVar.c.bindService(intent, eVar.b, 1);
            if (eVar.d || eVar.a == null) {
                com.android.gdt.qone.af.b.b("SI bindService Successful!");
            } else {
                com.android.gdt.qone.af.b.b("SI bindService Failed!");
                eVar.a.f();
            }
        }
    }
}
