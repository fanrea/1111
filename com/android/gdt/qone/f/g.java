package com.android.gdt.qone.f;

import android.content.Context;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class g {
    public final Context b;
    public c c;
    public e d;
    public boolean a = false;
    public final f e = new f(this);

    public g(Context context) {
        this.b = context;
    }

    public final void a(boolean z) {
        if (!z) {
            VendorManager vendorManager = this.d.a;
            if (vendorManager != null) {
                vendorManager.callbackOaid(false, null, null, false);
                return;
            }
            return;
        }
        try {
            this.d.a(this.c);
        } catch (Exception e) {
            com.android.gdt.qone.af.b.a("HSDID notify did bind status error :" + e.getMessage());
        }
    }
}
