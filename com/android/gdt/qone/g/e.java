package com.android.gdt.qone.g;

import android.text.TextUtils;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class e implements Runnable {
    public final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a aVarA = b.a(this.a.a);
            if (aVarA == null) {
                VendorManager vendorManager = this.a.b;
                if (vendorManager != null) {
                    vendorManager.callbackOaid(false, "", "", false);
                    return;
                }
                return;
            }
            f fVar = this.a;
            String str = aVarA.a;
            fVar.c = str;
            if (!TextUtils.isEmpty(str)) {
                this.a.d = true;
            }
            f fVar2 = this.a;
            VendorManager vendorManager2 = fVar2.b;
            if (vendorManager2 != null) {
                vendorManager2.callbackOaid(fVar2.d, "", fVar2.c, false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (TextUtils.isEmpty(this.a.c)) {
                this.a.d = false;
            }
            f fVar3 = this.a;
            VendorManager vendorManager3 = fVar3.b;
            if (vendorManager3 != null) {
                vendorManager3.callbackOaid(fVar3.d, "", fVar3.c, false);
            }
        }
    }
}
