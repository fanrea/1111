package com.ss.android.downloadlib.addownload.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private static c d;
    private List<h> hc;

    public static c d() {
        if (d == null) {
            synchronized (mk.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    private c() {
        ArrayList arrayList = new ArrayList();
        this.hc = arrayList;
        arrayList.add(new u());
        this.hc.add(new hc());
        this.hc.add(new b());
    }

    public void d(com.ss.android.hc.d.hc.hc hcVar, int i, gb gbVar, com.ss.android.downloadlib.addownload.d.b bVar) {
        com.ss.android.socialbase.downloader.h.b bVarHc;
        List<h> list = this.hc;
        if (list == null || list.size() == 0 || hcVar == null) {
            gbVar.d(hcVar);
        }
        if (!TextUtils.isEmpty(hcVar.ey())) {
            bVarHc = com.ss.android.downloadlib.tc.d(com.ss.android.downloadlib.addownload.mq.getContext()).d(hcVar.ey(), null, true);
        } else {
            bVarHc = com.ss.android.downloadlib.tc.d(com.ss.android.downloadlib.addownload.mq.getContext()).hc(hcVar.d());
        }
        if (bVarHc == null) {
            bVarHc = com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.downloadlib.addownload.mq.getContext()).gb(hcVar.rf());
        }
        if (bVarHc == null || !"application/vnd.android.package-archive".equals(bVarHc.hg())) {
            gbVar.d(hcVar);
            return;
        }
        if (new tc().d(hcVar, i, gbVar)) {
            return;
        }
        Iterator<h> it = this.hc.iterator();
        while (it.hasNext()) {
            if (it.next().d(hcVar, i, gbVar, bVar)) {
                return;
            }
        }
        gbVar.d(hcVar);
    }
}
