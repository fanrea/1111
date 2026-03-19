package com.ss.android.downloadlib.addownload.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class mk {
    private static mk d;
    private List<tt> hc;

    public static mk d() {
        if (d == null) {
            synchronized (mk.class) {
                if (d == null) {
                    d = new mk();
                }
            }
        }
        return d;
    }

    private mk() {
        ArrayList arrayList = new ArrayList();
        this.hc = arrayList;
        arrayList.add(new tc());
        this.hc.add(new mq());
        this.hc.add(new an());
        this.hc.add(new d());
    }

    public void d(com.ss.android.hc.d.hc.hc hcVar, int i, gb gbVar) {
        com.ss.android.socialbase.downloader.h.b bVarHc;
        List<tt> list = this.hc;
        if (list == null || list.size() == 0 || hcVar == null) {
            gbVar.d(hcVar);
            return;
        }
        if (!TextUtils.isEmpty(hcVar.ey())) {
            bVarHc = com.ss.android.downloadlib.tc.d((Context) null).d(hcVar.ey(), null, true);
        } else {
            bVarHc = com.ss.android.downloadlib.tc.d((Context) null).hc(hcVar.d());
        }
        if (bVarHc == null || !"application/vnd.android.package-archive".equals(bVarHc.hg())) {
            gbVar.d(hcVar);
            return;
        }
        boolean z = com.ss.android.socialbase.downloader.uo.d.d(hcVar.rf()).d("pause_optimise_switch", 0) == 1;
        for (tt ttVar : this.hc) {
            if (z || (ttVar instanceof mq)) {
                if (ttVar.d(hcVar, i, gbVar)) {
                    return;
                }
            }
        }
        gbVar.d(hcVar);
    }
}
