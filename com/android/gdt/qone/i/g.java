package com.android.gdt.qone.i;

import android.content.Intent;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class g implements Runnable {
    public final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar;
        VendorManager vendorManager;
        h hVar2 = this.a;
        e eVar = hVar2.a;
        if (eVar == null) {
            VendorManager vendorManager2 = hVar2.c;
            if (vendorManager2 != null) {
                vendorManager2.callbackOaid(false, "", "", false);
                return;
            }
            return;
        }
        String strA = com.android.gdt.qone.b.c.a(hVar2.b);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", strA);
        if (eVar.c.bindService(intent, eVar.b, 1) || (hVar = eVar.a) == null || (vendorManager = hVar.c) == null) {
            return;
        }
        vendorManager.callbackOaid(false, "", "", false);
    }
}
