package com.ss.android.downloadlib.hc;

import android.os.Build;
import com.ss.android.downloadlib.addownload.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tt {
    public static boolean d(com.ss.android.hc.d.hc.d dVar) {
        return com.ss.android.socialbase.appdownloader.an.u.u() && Build.VERSION.SDK_INT < 29 && mq.mq() != null && mq.mq().d() && com.ss.android.downloadlib.h.u.d(dVar).hc("invoke_app_form_background_switch") == 1 && dVar.w();
    }
}
