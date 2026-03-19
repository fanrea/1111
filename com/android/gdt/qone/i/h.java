package com.android.gdt.qone.i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class h implements com.android.gdt.qone.b.a {
    public e a;
    public Context b;
    public VendorManager c;
    public final g d = new g(this);

    @Override // com.android.gdt.qone.b.a
    public final void a() {
    }

    @Override // com.android.gdt.qone.b.a
    public final void b() {
        com.android.gdt.qone.c.e.c.a(this.d);
    }

    @Override // com.android.gdt.qone.b.a
    public final boolean c() {
        return false;
    }

    @Override // com.android.gdt.qone.b.a
    public final void d() {
        c cVar;
        e eVar = this.a;
        if (eVar == null || (cVar = eVar.d) == null) {
            return;
        }
        try {
            ((a) cVar).e();
            d dVar = eVar.b;
            if (dVar != null) {
                eVar.c.unbindService(dVar);
            }
        } catch (Exception unused) {
        }
        eVar.b = null;
        eVar.d = null;
    }

    public final boolean e() {
        e eVar = this.a;
        if (eVar == null) {
            return false;
        }
        try {
            c cVar = eVar.d;
            if (cVar == null) {
                return false;
            }
            return ((a) cVar).d();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.android.gdt.qone.b.a
    public final void a(Context context, VendorManager vendorManager) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo("com.mdid.msa", 0);
            String strA = com.android.gdt.qone.b.c.a(context);
            if (!TextUtils.isEmpty(strA)) {
                Intent intent = new Intent();
                intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
                intent.setAction("com.bun.msa.action.start.service");
                intent.putExtra("com.bun.msa.param.pkgname", strA);
                try {
                    intent.putExtra("com.bun.msa.param.runinset", true);
                    context.startService(intent);
                } catch (Exception unused) {
                }
            }
            this.a = new e(context, this);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        this.c = vendorManager;
        this.b = context;
    }
}
