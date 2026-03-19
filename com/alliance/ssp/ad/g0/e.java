package com.alliance.ssp.ad.g0;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import com.alliance.ssp.ad.b.a;
import com.alliance.ssp.ad.g0.m;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;

/* compiled from: FreemeImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e implements com.alliance.ssp.ad.f0.c {
    public final Context a;

    /* compiled from: FreemeImpl.java */
    public class a implements m.a {
        public a(e eVar) {
        }

        @Override // com.alliance.ssp.ad.g0.m.a
        public String a(IBinder iBinder) {
            com.alliance.ssp.ad.b.a c0069a;
            int i = a.AbstractBinderC0068a.a;
            if (iBinder == null) {
                c0069a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
                c0069a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.alliance.ssp.ad.b.a)) ? new a.AbstractBinderC0068a.C0069a(iBinder) : (com.alliance.ssp.ad.b.a) iInterfaceQueryLocalInterface;
            }
            if (c0069a != null) {
                return c0069a.a();
            }
            throw new YTOAIDException("IdsSupplier is null");
        }
    }

    public e(Context context) {
        this.a = context;
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.alliance.ssp.ad.f0.c
    public void a(com.alliance.ssp.ad.f0.b bVar) {
        if (this.a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        m.a(this.a, intent, bVar, new a(this));
    }
}
