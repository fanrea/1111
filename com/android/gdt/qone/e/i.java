package com.android.gdt.qone.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.android.gdt.oaid2.VendorManager;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class i implements com.android.gdt.qone.b.a {
    public Context a;
    public VendorManager b;
    public String c = "";
    public boolean d = false;
    public final g e = new g();
    public volatile boolean f = false;
    public final h g = new h(this);

    @Override // com.android.gdt.qone.b.a
    public final void a() {
    }

    @Override // com.android.gdt.qone.b.a
    public final void b() {
        com.android.gdt.qone.c.e.c.a(this.g);
    }

    @Override // com.android.gdt.qone.b.a
    public final boolean c() {
        return false;
    }

    @Override // com.android.gdt.qone.b.a
    public final void d() {
    }

    @Override // com.android.gdt.qone.b.a
    public final void a(Context context, VendorManager vendorManager) {
        this.a = context;
        this.b = vendorManager;
    }

    public static void a(i iVar) throws PackageManager.NameNotFoundException {
        boolean zIsEmpty;
        boolean z;
        String string;
        String string2;
        g gVar = iVar.e;
        Context context = iVar.a;
        gVar.getClass();
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo("com.hihonor.id", 0);
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            zIsEmpty = packageManager.queryIntentServices(intent, 0).isEmpty();
            z = true;
        } catch (Exception unused) {
        }
        if (!zIsEmpty) {
            try {
                string = Settings.Global.getString(iVar.a.getContentResolver(), "oaid_limit_state");
                string2 = Settings.Global.getString(iVar.a.getContentResolver(), "oaid");
            } catch (Throwable th) {
                com.android.gdt.qone.af.b.a("honor get cache oaid error " + th.toString());
            }
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                iVar.d = !Boolean.parseBoolean(string);
                iVar.c = string2;
            } else {
                try {
                    iVar.f = iVar.e.a(iVar.a);
                    iVar.e.a.await(2L, TimeUnit.SECONDS);
                    d dVar = iVar.e.b;
                    if (TextUtils.isEmpty(dVar.a) || dVar.b) {
                        z = false;
                    } else {
                        iVar.c = iVar.e.b.a;
                        iVar.d = !r0.b;
                    }
                    if (iVar.f) {
                        g gVar2 = iVar.e;
                        Context context2 = iVar.a;
                        gVar2.getClass();
                        try {
                            context2.unbindService(gVar2);
                        } catch (Exception e) {
                            com.android.gdt.qone.af.b.a("honor unbind service exceprion:" + e.toString());
                        }
                    }
                } catch (Exception unused2) {
                    if (iVar.f) {
                        g gVar3 = iVar.e;
                        Context context3 = iVar.a;
                        gVar3.getClass();
                        try {
                            context3.unbindService(gVar3);
                        } catch (Exception e2) {
                            com.android.gdt.qone.af.b.a("honor unbind service exceprion:" + e2.toString());
                        }
                    }
                } catch (Throwable th2) {
                    if (iVar.f) {
                        g gVar4 = iVar.e;
                        Context context4 = iVar.a;
                        gVar4.getClass();
                        try {
                            context4.unbindService(gVar4);
                        } catch (Exception e3) {
                            com.android.gdt.qone.af.b.a("honor unbind service exceprion:" + e3.toString());
                        }
                    }
                    throw th2;
                }
                if (!z) {
                    com.android.gdt.qone.af.b.b("honor get oaid failed");
                }
            }
            com.android.gdt.qone.af.b.b("honor get oaid success");
        } else {
            com.android.gdt.qone.af.b.a("honor {com.hihonor.id.HnOaIdService} not exist");
        }
        VendorManager vendorManager = iVar.b;
        if (vendorManager != null) {
            vendorManager.callbackOaid(iVar.d, "", iVar.c, false);
        }
    }
}
