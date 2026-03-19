package com.android.gdt.qone.k;

import android.content.Context;
import android.os.RemoteException;
import com.android.gdt.oaid2.VendorManager;
import com.android.gdt.qone.b.c;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a implements com.android.gdt.qone.b.a {
    public Context a;
    public VendorManager b;

    @Override // com.android.gdt.qone.b.a
    public final void a(Context context, VendorManager vendorManager) {
        this.a = context;
        this.b = vendorManager;
    }

    @Override // com.android.gdt.qone.b.a
    public final void b() {
    }

    @Override // com.android.gdt.qone.b.a
    public final boolean c() {
        return true;
    }

    @Override // com.android.gdt.qone.b.a
    public final void d() {
    }

    @Override // com.android.gdt.qone.b.a
    public final void a() throws RemoteException {
        VendorManager vendorManager = this.b;
        if (vendorManager != null) {
            boolean zA = b.a(this.a);
            Context context = this.a;
            vendorManager.callbackOaid(zA, b.a(context, c.a(context)), b.b(this.a), false);
        }
    }
}
