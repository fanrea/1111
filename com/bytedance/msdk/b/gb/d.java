package com.bytedance.msdk.b.gb;

import android.os.SystemClock;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static void d(com.bytedance.msdk.b.an.d.hc hcVar, List<com.bytedance.msdk.hc.b> list, boolean z) {
        if (hcVar == null) {
            return;
        }
        com.bytedance.msdk.hc.b bVarD = d(list);
        if (hcVar.fs()) {
            return;
        }
        hcVar.b(SystemClock.elapsedRealtime());
        com.bytedance.msdk.u.an.d(bVarD, hcVar.rf(), hcVar.mq(), hcVar.z() - hcVar.us(), hcVar.ba().d, !hcVar.v(), list != null ? list.size() : 0, hcVar.ba().u, z);
        hcVar.c(true);
    }

    private static com.bytedance.msdk.hc.b d(List<com.bytedance.msdk.hc.b> list) {
        com.bytedance.msdk.hc.b bVar = null;
        if (list != null && list.size() != 0) {
            for (com.bytedance.msdk.hc.b bVar2 : list) {
                if (bVar == null || bVar2.ra() < bVar.ra()) {
                    bVar = bVar2;
                }
            }
        }
        return bVar;
    }
}
