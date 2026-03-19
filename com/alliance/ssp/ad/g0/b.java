package com.alliance.ssp.ad.g0;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import com.alliance.ssp.ad.e.a;
import com.alliance.ssp.ad.g0.m;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;

/* compiled from: CoolpadImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b implements com.alliance.ssp.ad.f0.c {
    public final Context a;

    /* compiled from: CoolpadImpl.java */
    public class a implements m.a {
        public a() {
        }

        @Override // com.alliance.ssp.ad.g0.m.a
        public String a(IBinder iBinder) {
            com.alliance.ssp.ad.e.a c0076a;
            int i = a.AbstractBinderC0075a.a;
            if (iBinder == null) {
                c0076a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                c0076a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.alliance.ssp.ad.e.a)) ? new a.AbstractBinderC0075a.C0076a(iBinder) : (com.alliance.ssp.ad.e.a) iInterfaceQueryLocalInterface;
            }
            if (c0076a != null) {
                return c0076a.a(b.this.a.getPackageName());
            }
            throw new YTOAIDException("IDeviceIdManager is null");
        }
    }

    public b(Context context) {
        if (context instanceof Application) {
            this.a = context;
        } else {
            this.a = context.getApplicationContext();
        }
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
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
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        m.a(this.a, intent, bVar, new a());
    }
}
