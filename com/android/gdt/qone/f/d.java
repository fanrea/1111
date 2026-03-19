package com.android.gdt.qone.f;

import android.content.ComponentName;
import android.content.Intent;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d implements Runnable {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VendorManager vendorManager;
        e eVar = this.a;
        g gVar = eVar.d;
        if (gVar != null) {
            try {
                gVar.d = eVar;
                Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
                ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                com.android.gdt.qone.af.b.c("HSDID start to bind did service");
                boolean zBindService = gVar.b.bindService(intent2, gVar.e, 1);
                gVar.a = zBindService;
                if (zBindService || (vendorManager = gVar.d.a) == null) {
                    return;
                }
                vendorManager.callbackOaid(false, null, null, false);
            } catch (Exception unused) {
                gVar.a(false);
            }
        }
    }
}
