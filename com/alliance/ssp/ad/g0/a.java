package com.alliance.ssp.ad.g0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import com.alliance.ssp.ad.c.a;
import com.alliance.ssp.ad.g0.m;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;

/* compiled from: AsusImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a implements com.alliance.ssp.ad.f0.c {
    public final Context a;

    /* compiled from: AsusImpl.java */
    /* renamed from: com.alliance.ssp.ad.g0.a$a, reason: collision with other inner class name */
    public class C0081a implements m.a {
        public C0081a(a aVar) {
        }

        @Override // com.alliance.ssp.ad.g0.m.a
        public String a(IBinder iBinder) {
            com.alliance.ssp.ad.c.a c0071a;
            int i = a.AbstractBinderC0070a.a;
            if (iBinder == null) {
                c0071a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                c0071a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.alliance.ssp.ad.c.a)) ? new a.AbstractBinderC0070a.C0071a(iBinder) : (com.alliance.ssp.ad.c.a) iInterfaceQueryLocalInterface;
            }
            if (c0071a == null) {
                throw new YTOAIDException("IDidAidlInterface is null");
            }
            if (c0071a.b()) {
                return c0071a.a();
            }
            throw new YTOAIDException("IDidAidlInterface#isSupport return false");
        }
    }

    public a(Context context) {
        this.a = context;
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.alliance.ssp.ad.f0.c
    public void a(com.alliance.ssp.ad.f0.b bVar) {
        if (this.a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        m.a(this.a, intent, bVar, new C0081a(this));
    }
}
