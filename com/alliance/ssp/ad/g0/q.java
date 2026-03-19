package com.alliance.ssp.ad.g0;

import android.content.Context;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;

/* compiled from: XiaomiImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class q implements com.alliance.ssp.ad.f0.c {
    public final Context a;
    public Class<?> b;
    public Object c;

    public q(Context context) throws ClassNotFoundException {
        this.a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        return this.c != null;
    }

    @Override // com.alliance.ssp.ad.f0.c
    public void a(com.alliance.ssp.ad.f0.b bVar) {
        if (this.a == null || bVar == null) {
            return;
        }
        Class<?> cls = this.b;
        if (cls == null || this.c == null) {
            bVar.a(new YTOAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String str = (String) cls.getMethod("getOAID", Context.class).invoke(this.c, this.a);
            if (str == null || str.length() == 0) {
                throw new YTOAIDException("OAID query failed");
            }
            bVar.a(str);
        } catch (Exception e) {
            bVar.a(e);
        }
    }
}
