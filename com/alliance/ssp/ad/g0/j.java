package com.alliance.ssp.ad.g0;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import com.alliance.ssp.ad.d.a;
import com.alliance.ssp.ad.g0.m;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;

/* compiled from: MsaImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class j implements com.alliance.ssp.ad.f0.c {
    public final Context a;

    /* compiled from: MsaImpl.java */
    public class a implements m.a {
        public a(j jVar) {
        }

        @Override // com.alliance.ssp.ad.g0.m.a
        public String a(IBinder iBinder) {
            com.alliance.ssp.ad.d.a c0074a;
            int i = a.AbstractBinderC0073a.a;
            if (iBinder == null) {
                c0074a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
                c0074a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.alliance.ssp.ad.d.a)) ? new a.AbstractBinderC0073a.C0074a(iBinder) : (com.alliance.ssp.ad.d.a) iInterfaceQueryLocalInterface;
            }
            if (c0074a == null) {
                throw new YTOAIDException("MsaIdInterface is null");
            }
            if (c0074a.f()) {
                return c0074a.a();
            }
            throw new YTOAIDException("MsaIdInterface#isSupported return false");
        }
    }

    public j(Context context) {
        this.a = context;
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.alliance.ssp.ad.f0.c
    public void a(com.alliance.ssp.ad.f0.b bVar) {
        if (this.a == null || bVar == null) {
            return;
        }
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.a.startService(intent);
            } else {
                this.a.startForegroundService(intent);
            }
        } catch (Exception unused) {
        }
        Intent intent2 = new Intent("com.bun.msa.action.bindto.service");
        intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent2.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
        m.a(this.a, intent2, bVar, new a(this));
    }
}
