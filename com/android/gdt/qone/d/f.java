package com.android.gdt.qone.d;

import android.content.ComponentName;
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
        g gVar;
        b bVar = this.a.b;
        if (bVar != null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            bVar.e = bVar.a.bindService(intent, bVar.c, 1);
            if (bVar.e || (gVar = bVar.b) == null) {
                return;
            }
            gVar.e();
        }
    }
}
