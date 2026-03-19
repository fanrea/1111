package com.ss.android.downloadlib.hc;

import android.os.Build;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.downloader.d.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    public static void d(final com.ss.android.hc.d.hc.hc hcVar, final com.ss.android.downloadlib.guide.install.d dVar) {
        boolean zHc = com.ss.android.socialbase.downloader.d.d.d().hc();
        if (!zHc && Build.VERSION.SDK_INT >= 29) {
            uo.b();
        }
        boolean zHc2 = com.ss.android.socialbase.downloader.d.d.d().hc();
        if (!zHc && zHc2 && hcVar != null) {
            hcVar.mq(true);
        }
        dVar.d();
        com.ss.android.socialbase.downloader.an.d.hc("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::".concat(String.valueOf(zHc2)));
        if (zHc2) {
            return;
        }
        com.ss.android.socialbase.downloader.d.d.d().d(new d.InterfaceC0785d() { // from class: com.ss.android.downloadlib.hc.b.1
            @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
            public void b() {
            }

            @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
            public void hc() {
                com.ss.android.socialbase.downloader.an.d.hc("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.ss.android.socialbase.downloader.d.d.d().hc(this);
                if (uo.hc(hcVar)) {
                    return;
                }
                hcVar.uo(true);
                com.ss.android.downloadlib.c.d.d().d("install_delay_invoke", hcVar);
                dVar.d();
            }
        });
    }
}
