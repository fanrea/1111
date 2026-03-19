package com.ss.android.socialbase.appdownloader.an;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.c.s;
import com.ss.android.socialbase.downloader.downloader.h;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {
    public static void d(com.ss.android.socialbase.downloader.h.b bVar) {
        hc(bVar);
    }

    private static void hc(final com.ss.android.socialbase.downloader.h.b bVar) {
        final Context contextTr = com.ss.android.socialbase.downloader.downloader.b.tr();
        boolean z = true;
        if (((bVar.sy() && !bVar.de()) || com.ss.android.socialbase.appdownloader.b.hc(bVar.s()) || TextUtils.isEmpty(bVar.hg()) || !bVar.hg().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int iD = z ? com.ss.android.socialbase.appdownloader.b.d(contextTr, bVar.h(), false) : 2;
        com.ss.android.socialbase.downloader.downloader.b.mk().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.an.hc.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.b.u uVarB = com.ss.android.socialbase.appdownloader.c.mk().b();
                s sVarTt = h.hc(contextTr).tt(bVar.h());
                if (uVarB == null && sVarTt == null) {
                    return;
                }
                File file = new File(bVar.mk(), bVar.gb());
                if (file.exists()) {
                    try {
                        PackageInfo packageInfoD = com.ss.android.socialbase.appdownloader.b.d(bVar, file);
                        if (packageInfoD != null) {
                            String strUs = (iD == 1 || TextUtils.isEmpty(bVar.us())) ? packageInfoD.packageName : bVar.us();
                            if (uVarB != null) {
                                uVarB.d(bVar.h(), 1, strUs, -3, bVar.pa());
                            }
                            if (sVarTt != null) {
                                sVarTt.d(1, bVar, strUs, "");
                            }
                        }
                    } catch (Exception e) {
                        mq.d(e);
                    }
                }
            }
        });
    }
}
