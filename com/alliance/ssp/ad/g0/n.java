package com.alliance.ssp.ad.g0;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.alliance.ssp.ad.g.a;
import com.alliance.ssp.ad.g0.m;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;
import java.security.MessageDigest;

/* compiled from: OppoImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class n implements com.alliance.ssp.ad.f0.c {
    public final Context a;
    public String b;

    /* compiled from: OppoImpl.java */
    public class a implements m.a {
        public a() {
        }

        @Override // com.alliance.ssp.ad.g0.m.a
        public String a(IBinder iBinder) throws RemoteException {
            try {
                return n.this.a(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (YTOAIDException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new YTOAIDException(e3);
            }
        }
    }

    public n(Context context) {
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
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.alliance.ssp.ad.f0.c
    public void a(com.alliance.ssp.ad.f0.b bVar) {
        if (this.a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        m.a(this.a, intent, bVar, new a());
    }

    public final String a(IBinder iBinder) {
        String packageName = this.a.getPackageName();
        String str = this.b;
        if (str == null) {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            String string = sb.toString();
            this.b = string;
            return a(iBinder, packageName, string);
        }
        return a(iBinder, packageName, str);
    }

    public final String a(IBinder iBinder, String str, String str2) {
        com.alliance.ssp.ad.g.a c0080a;
        int i = a.AbstractBinderC0079a.a;
        if (iBinder == null) {
            c0080a = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.alliance.ssp.ad.g.a)) {
                c0080a = (com.alliance.ssp.ad.g.a) iInterfaceQueryLocalInterface;
            } else {
                c0080a = new a.AbstractBinderC0079a.C0080a(iBinder);
            }
        }
        if (c0080a != null) {
            return c0080a.a(str, str2, "OUID");
        }
        throw new YTOAIDException("IOpenID is null");
    }
}
