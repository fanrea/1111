package com.ss.android.downloadlib.addownload.c;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class mq implements tt {
    @Override // com.ss.android.downloadlib.addownload.c.tt
    public boolean d(com.ss.android.hc.d.hc.hc hcVar, int i, gb gbVar) {
        com.ss.android.socialbase.downloader.h.b bVarHc;
        if (hcVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(hcVar.ey())) {
            bVarHc = com.ss.android.downloadlib.tc.d((Context) null).d(hcVar.ey(), null, true);
        } else {
            bVarHc = com.ss.android.downloadlib.tc.d((Context) null).hc(hcVar.d());
        }
        return e.d(hcVar, bVarHc, i, gbVar, false, null);
    }
}
