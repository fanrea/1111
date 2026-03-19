package com.android.gdt.oaid2;

import android.content.Context;
import android.text.TextUtils;
import com.android.gdt.qone.b.a;
import com.android.gdt.qone.b.c;
import com.android.gdt.qone.c.b;
import com.android.gdt.qone.e.i;
import com.android.gdt.qone.g.f;
import com.android.gdt.qone.h.e;
import com.android.gdt.qone.i.h;
import com.android.gdt.qone.l.d;
import com.android.gdt.qone.m.g;
import com.sigmob.sdk.base.mta.PointCategory;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class VendorManager {
    public static final String v = "1.0.8";
    public a a = null;
    public IVendorCallback b = null;
    public Context c = null;
    public volatile boolean d = false;

    public synchronized void callbackOaid(boolean z, String str, String str2, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (!this.d) {
            callbackToUser(z, str, str2);
        }
        if (!z2) {
            if (!TextUtils.isEmpty(str2)) {
                b bVar = com.android.gdt.qone.c.a.a;
                bVar.a("qm_ch_od", str2);
                bVar.a("qm_od_is_sup", String.valueOf(z));
            }
            try {
                a aVar = this.a;
                if (aVar != null) {
                    aVar.d();
                }
            } catch (Throwable th) {
                com.android.gdt.qone.af.b.a(th.toString());
            }
        }
    }

    public void callbackToUser(boolean z, String str, String str2) {
        com.android.gdt.qone.af.b.b("vm onResult " + z);
        try {
            IVendorCallback iVendorCallback = this.b;
            if (iVendorCallback != null) {
                iVendorCallback.onResult(z, str, str2);
                this.d = true;
            }
        } catch (Throwable th) {
            com.android.gdt.qone.af.b.a(th.toString());
        }
    }

    public int getVendorInfo(Context context, IVendorCallback iVendorCallback) {
        VendorChecker vendorChecker;
        this.b = iVendorCallback;
        b bVar = com.android.gdt.qone.c.a.a;
        bVar.b = context;
        String strB = bVar.b();
        if (!TextUtils.isEmpty(strB)) {
            callbackOaid(true, "", strB, true);
        }
        VendorChecker[] vendorCheckerArrValues = VendorChecker.values();
        int length = vendorCheckerArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                vendorChecker = VendorChecker.UNSUPPORTED;
                break;
            }
            vendorChecker = vendorCheckerArrValues[i];
            if (vendorChecker.a()) {
                break;
            }
            i++;
        }
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.c = applicationContext;
            if (applicationContext == null) {
                this.c = context;
            }
        }
        switch (com.android.gdt.qone.b.b.a[vendorChecker.ordinal()]) {
            case 1:
                this.a = new com.android.gdt.qone.o.a();
                break;
            case 2:
                this.a = new com.android.gdt.qone.n.b();
                break;
            case 3:
                this.a = new f();
                break;
            case 4:
                this.a = new d();
                break;
            case 5:
                this.a = new e();
                break;
            case 6:
                this.a = new com.android.gdt.qone.f.e();
                break;
            case 7:
                this.a = new g();
                break;
            case 8:
                this.a = new com.android.gdt.qone.j.e();
                break;
            case 9:
                this.a = new com.android.gdt.qone.k.a();
                break;
            case 10:
                this.a = new h();
                break;
            case 11:
                this.a = new i();
            case 12:
                try {
                    this.c.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
                    this.a = new com.android.gdt.qone.d.g();
                    break;
                } catch (Throwable unused) {
                    break;
                }
        }
        if (this.a == null && (!TextUtils.isEmpty(c.a(com.alipay.sdk.m.c.a.a)) || !TextUtils.isEmpty(c.a(com.alipay.sdk.m.c.a.b)))) {
            this.a = new f();
        }
        if (this.a == null) {
            callbackOaid(false, "", "", false);
            return -12;
        }
        com.android.gdt.qone.af.b.a(PointCategory.INIT);
        try {
            this.a.a(this.c, this);
            if (this.a.c()) {
                com.android.gdt.qone.af.b.a("sync");
                try {
                    this.a.a();
                } catch (Throwable unused2) {
                    callbackOaid(false, "", "", false);
                }
            } else {
                try {
                    this.a.b();
                } catch (Throwable unused3) {
                    callbackOaid(false, "", "", false);
                    return -13;
                }
            }
            return 0;
        } catch (Throwable unused4) {
            callbackOaid(false, "", "", false);
            return -13;
        }
    }
}
