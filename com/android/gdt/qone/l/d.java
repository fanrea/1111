package com.android.gdt.qone.l;

import android.content.Context;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d implements com.android.gdt.qone.b.a {
    public Context a = null;
    public VendorManager b = null;
    public final c c = new c(this);

    @Override // com.android.gdt.qone.b.a
    public final void a() {
    }

    @Override // com.android.gdt.qone.b.a
    public final void b() {
        com.android.gdt.qone.c.e.c.a(this.c);
    }

    @Override // com.android.gdt.qone.b.a
    public final boolean c() {
        return false;
    }

    @Override // com.android.gdt.qone.b.a
    public final void d() {
    }

    @Override // com.android.gdt.qone.b.a
    public final void a(Context context, VendorManager vendorManager) {
        this.a = context;
        this.b = vendorManager;
        i iVar = i.f;
        if (context != null && context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        iVar.getClass();
        a.b = i.a(context);
        a.a = true;
    }
}
