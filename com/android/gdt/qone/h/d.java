package com.android.gdt.qone.h;

import android.content.Intent;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d implements Runnable {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar = this.a.a;
        if (gVar != null) {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (gVar.a.bindService(intent, gVar.c, 1)) {
                g.a("bindService Successful!");
                return;
            }
            e eVar = gVar.d;
            if (eVar != null) {
                eVar.h();
            }
            g.a("bindService Failed!!!");
        }
    }
}
