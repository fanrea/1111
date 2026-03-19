package com.alliance.ssp.ad.g0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.provider.Settings;
import android.text.TextUtils;
import com.alliance.ssp.ad.g0.m;
import com.alliance.ssp.ad.i.a;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;

/* compiled from: HuaweiImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g implements com.alliance.ssp.ad.f0.c {
    public final Context a;
    public String b;

    /* compiled from: HuaweiImpl.java */
    public class a implements m.a {
        public a(g gVar) {
        }

        @Override // com.alliance.ssp.ad.g0.m.a
        public String a(IBinder iBinder) {
            com.alliance.ssp.ad.i.a c0085a;
            int i = a.AbstractBinderC0084a.a;
            if (iBinder == null) {
                c0085a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.c.b.a);
                c0085a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.alliance.ssp.ad.i.a)) ? new a.AbstractBinderC0084a.C0085a(iBinder) : (com.alliance.ssp.ad.i.a) iInterfaceQueryLocalInterface;
            }
            if (c0085a.c()) {
                throw new YTOAIDException("User has disabled advertising identifier");
            }
            return c0085a.e();
        }
    }

    public g(Context context) {
        this.a = context;
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.b = "com.huawei.hwid.tv";
            } else {
                this.b = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.alliance.ssp.ad.f0.c
    public void a(com.alliance.ssp.ad.f0.b bVar) {
        Context context = this.a;
        if (context == null || bVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    bVar.a(string);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(this.b) && !a()) {
            bVar.a(new YTOAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.b);
        m.a(this.a, intent, bVar, new a(this));
    }
}
