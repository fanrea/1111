package com.android.gdt.qone.l;

import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c implements Runnable {
    public final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!a.a) {
                throw new RuntimeException("SDK Need Init First!");
            }
            if (!a.b) {
                VendorManager vendorManager = this.a.b;
                if (vendorManager != null) {
                    vendorManager.callbackOaid(false, "", "", false);
                    return;
                }
                return;
            }
            d dVar = this.a;
            VendorManager vendorManager2 = dVar.b;
            if (vendorManager2 != null) {
                vendorManager2.callbackOaid(true, "", b.a(dVar.a), false);
            }
        } catch (Throwable th) {
            VendorManager vendorManager3 = this.a.b;
            if (vendorManager3 != null) {
                vendorManager3.callbackOaid(false, "", "", false);
            }
            th.printStackTrace();
        }
    }
}
