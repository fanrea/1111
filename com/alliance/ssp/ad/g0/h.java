package com.alliance.ssp.ad.g0;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import com.alipay.sdk.m.q0.a;
import com.alliance.ssp.ad.g0.m;
import com.alliance.ssp.ad.j.a;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;

/* compiled from: LenovoImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h implements com.alliance.ssp.ad.f0.c {
    public final Context a;

    /* compiled from: LenovoImpl.java */
    public class a implements m.a {
        public a(h hVar) {
        }

        @Override // com.alliance.ssp.ad.g0.m.a
        public String a(IBinder iBinder) {
            com.alliance.ssp.ad.j.a c0091a;
            int i = a.AbstractBinderC0090a.a;
            if (iBinder == null) {
                c0091a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0056a.a);
                c0091a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.alliance.ssp.ad.j.a)) ? new a.AbstractBinderC0090a.C0091a(iBinder) : (com.alliance.ssp.ad.j.a) iInterfaceQueryLocalInterface;
            }
            if (c0091a == null) {
                throw new YTOAIDException("IDeviceidInterface is null");
            }
            if (c0091a.b()) {
                return c0091a.a();
            }
            throw new YTOAIDException("IDeviceidInterface#isSupport return false");
        }
    }

    public h(Context context) {
        this.a = context;
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
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
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        m.a(this.a, intent, bVar, new a(this));
    }
}
