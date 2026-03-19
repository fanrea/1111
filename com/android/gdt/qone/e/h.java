package com.android.gdt.qone.e;

import android.content.pm.PackageManager;
import android.os.Build;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class h implements Runnable {
    public final /* synthetic */ i a;

    public h(i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT >= 17) {
            i.a(this.a);
            return;
        }
        i iVar = this.a;
        VendorManager vendorManager = iVar.b;
        if (vendorManager != null) {
            vendorManager.callbackOaid(iVar.d, "", iVar.c, false);
        }
    }
}
