package com.alliance.ssp.ad.g0;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import com.alipay.sdk.m.k0.a;
import com.alliance.ssp.ad.g0.m;
import com.alliance.ssp.ad.h.a;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;

/* compiled from: SamsungImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class o implements com.alliance.ssp.ad.f0.c {
    public final Context a;

    /* compiled from: SamsungImpl.java */
    public class a implements m.a {
        public a(o oVar) {
        }

        @Override // com.alliance.ssp.ad.g0.m.a
        public String a(IBinder iBinder) {
            com.alliance.ssp.ad.h.a c0083a;
            int i = a.AbstractBinderC0082a.a;
            if (iBinder == null) {
                c0083a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0051a.a);
                c0083a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.alliance.ssp.ad.h.a)) ? new a.AbstractBinderC0082a.C0083a(iBinder) : (com.alliance.ssp.ad.h.a) iInterfaceQueryLocalInterface;
            }
            if (c0083a != null) {
                return c0083a.a();
            }
            throw new YTOAIDException("IDeviceIdService is null");
        }
    }

    public o(Context context) {
        this.a = context;
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.alliance.ssp.ad.f0.c
    public void a(com.alliance.ssp.ad.f0.b bVar) {
        if (this.a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        m.a(this.a, intent, bVar, new a(this));
    }
}
