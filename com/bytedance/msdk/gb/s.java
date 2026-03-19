package com.bytedance.msdk.gb;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class s {
    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.core.tc.tc tcVar, com.bytedance.msdk.api.d.hc hcVar, boolean z) {
        if (bVar == null || !bVar.ox()) {
            return;
        }
        if (tcVar == null) {
            bVar.d(0.0d);
        }
        String strFu = bVar.fu();
        Map<String, String> mapJ = tcVar.j();
        if (TextUtils.isEmpty(strFu)) {
            if (z) {
                com.bytedance.msdk.u.an.d(tcVar, hcVar, bVar, 40061, com.bytedance.msdk.api.d.d(40061));
            }
            bVar.uo(com.bytedance.msdk.api.d.d(40061));
            bVar.d(0.0d);
            return;
        }
        if (mapJ == null) {
            if (z) {
                com.bytedance.msdk.u.an.d(tcVar, hcVar, bVar, 40062, com.bytedance.msdk.api.d.d(40062));
            }
            bVar.uo(com.bytedance.msdk.api.d.d(40062));
            bVar.d(0.0d);
            return;
        }
        String str = mapJ.get(strFu);
        if (TextUtils.isEmpty(str)) {
            if (z) {
                com.bytedance.msdk.u.an.d(tcVar, hcVar, bVar, 40062, com.bytedance.msdk.api.d.d(40062));
            }
            bVar.d(0.0d);
        } else {
            try {
                bVar.d(Double.valueOf(str).doubleValue());
            } catch (Exception unused) {
                bVar.d(0.0d);
            }
        }
    }
}
