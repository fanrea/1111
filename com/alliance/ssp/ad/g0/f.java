package com.alliance.ssp.ad.g0;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import com.alliance.ssp.ad.f.a;
import com.alliance.ssp.ad.g0.m;

/* compiled from: GmsImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f implements com.alliance.ssp.ad.f0.c {
    public final Context a;

    /* compiled from: GmsImpl.java */
    public class a implements m.a {
        public a(f fVar) {
        }

        @Override // com.alliance.ssp.ad.g0.m.a
        public String a(IBinder iBinder) {
            com.alliance.ssp.ad.f.a c0078a;
            int i = a.AbstractBinderC0077a.a;
            if (iBinder == null) {
                c0078a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                c0078a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.alliance.ssp.ad.f.a)) ? new a.AbstractBinderC0077a.C0078a(iBinder) : (com.alliance.ssp.ad.f.a) iInterfaceQueryLocalInterface;
            }
            c0078a.a(true);
            return c0078a.d();
        }
    }

    public f(Context context) {
        this.a = context;
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.alliance.ssp.ad.f0.c
    public void a(com.alliance.ssp.ad.f0.b bVar) {
        if (this.a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        m.a(this.a, intent, bVar, new a(this));
    }
}
