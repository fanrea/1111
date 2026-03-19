package com.ss.android.downloadlib.hc;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.downloader.d.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    private static Handler d = new Handler(Looper.getMainLooper());

    public static void d(final com.ss.android.hc.d.hc.hc hcVar, final gb gbVar) {
        boolean zHc = com.ss.android.socialbase.downloader.d.d.d().hc();
        if (!zHc && Build.VERSION.SDK_INT >= 29) {
            uo.b();
        }
        boolean zHc2 = com.ss.android.socialbase.downloader.d.d.d().hc();
        boolean z = !zHc && zHc2;
        if (hcVar != null) {
            hcVar.mq(z);
        }
        gbVar.d(z);
        if (hcVar == null) {
            return;
        }
        hc(hcVar, tc(hcVar));
        if (zHc2) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.d.d.d().d(new d.InterfaceC0785d() { // from class: com.ss.android.downloadlib.hc.an.1
            @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
            public void b() {
            }

            @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
            public void hc() {
                com.ss.android.socialbase.downloader.d.d.d().hc(this);
                com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.hc.an.1.1
                    @Override // java.lang.Runnable
                    public void run() throws PackageManager.NameNotFoundException {
                        boolean zB = uo.b(hcVar.u());
                        long jU = an.u(hcVar);
                        if (!zB || jU >= System.currentTimeMillis() - jCurrentTimeMillis) {
                            if (System.currentTimeMillis() - jCurrentTimeMillis > an.gb(hcVar)) {
                                com.ss.android.downloadlib.c.d.d().d("deeplink_delay_timeout", hcVar);
                                return;
                            }
                            hcVar.mq(true);
                            com.ss.android.downloadlib.c.d.d().d("deeplink_delay_invoke", hcVar);
                            gbVar.d(true);
                            an.hc(hcVar, an.tc(hcVar));
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(final com.ss.android.hc.d.hc.hc hcVar, final int i) {
        if (i <= 0) {
            return;
        }
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.hc.an.2
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                int i2 = 1;
                if (uo.b(hcVar.u())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!hcVar.ia()) {
                            i2 = 2;
                        }
                        jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                    } catch (JSONException e) {
                        mq.d(e);
                    }
                    com.ss.android.downloadlib.c.d.d().d("deeplink_success_2", jSONObject, hcVar);
                    return;
                }
                an.hc(hcVar, i - 1);
            }
        }, tt(hcVar) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long gb(com.ss.android.hc.d.hc.hc hcVar) {
        return com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVar).d("app_link_check_timeout", 300000L);
    }

    private static int tt(com.ss.android.hc.d.hc.hc hcVar) {
        return com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVar).d("app_link_check_delay", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int tc(com.ss.android.hc.d.hc.hc hcVar) {
        return com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVar).d("app_link_check_count", 10);
    }

    public static boolean d(com.ss.android.hc.d.hc.hc hcVar) {
        return com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVar).hc("app_link_opt_switch") == 1;
    }

    public static boolean hc(com.ss.android.hc.d.hc.hc hcVar) {
        return com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVar).hc("app_link_opt_install_switch") == 1;
    }

    public static boolean b(com.ss.android.hc.d.hc.hc hcVar) {
        return com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVar).hc("app_link_opt_invoke_switch") == 1;
    }

    public static boolean c(com.ss.android.hc.d.hc.hc hcVar) {
        return com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVar).hc("app_link_opt_dialog_switch") == 1;
    }

    public static long u(com.ss.android.hc.d.hc.hc hcVar) {
        return hcVar == null ? com.alipay.sdk.m.u.b.a : com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVar).d("app_link_opt_back_time_limit", 3) * 1000;
    }
}
