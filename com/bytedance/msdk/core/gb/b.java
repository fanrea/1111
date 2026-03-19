package com.bytedance.msdk.core.gb;

import android.text.TextUtils;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private Map<String, hc> d;
    private Map<String, ConcurrentHashMap<String, com.bytedance.msdk.core.gb.d>> hc;

    private b() {
        this.hc = new ConcurrentHashMap();
    }

    public static b d() {
        return d.d;
    }

    private static class d {
        private static b d = new b();
    }

    public void d(ConcurrentHashMap<String, hc> concurrentHashMap) {
        this.d = concurrentHashMap;
        if (concurrentHashMap != null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_AdnShowControl", "mAdnControlMap = ".concat(String.valueOf(concurrentHashMap)));
        } else {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_AdnShowControl", "mAdnControlMap is null ");
        }
    }

    public void d(String str, String str2, String str3) {
        boolean z;
        com.bytedance.msdk.d.u.b.d("TTMediationSDK_AdnShowControl", "setAdnError adnName = " + str + " slotId = " + str2 + " error = " + str3);
        Map<String, hc> map = this.d;
        hc hcVar = map != null ? map.get(str) : null;
        if (hcVar != null) {
            for (String str4 : hcVar.hc()) {
                if (TextUtils.equals(str4, str3)) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK_AdnShowControl", "setAdnError 命中errorCode = ".concat(String.valueOf(str4)));
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (z) {
            long time = new Date().getTime() + hcVar.d();
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_AdnShowControl", "setAdnError 更新时间 = " + an.hc(time));
            com.bytedance.msdk.core.gb.d dVar = new com.bytedance.msdk.core.gb.d(str, str2, time);
            if (this.hc != null) {
                ConcurrentHashMap<String, com.bytedance.msdk.core.gb.d> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.put(str2, dVar);
                this.hc.put(str, concurrentHashMap);
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_AdnShowControl", "setAdnError mAdnControlMap = " + this.hc);
            }
        }
    }

    public com.bytedance.msdk.api.d d(String str, String str2) {
        com.bytedance.msdk.core.gb.d dVar;
        ConcurrentHashMap<String, com.bytedance.msdk.core.gb.d> concurrentHashMap;
        com.bytedance.msdk.d.u.b.d("TTMediationSDK_AdnShowControl", "checkLoad adnName = " + str + " slotId = " + str2);
        Map<String, ConcurrentHashMap<String, com.bytedance.msdk.core.gb.d>> map = this.hc;
        if (map == null || (concurrentHashMap = map.get(str)) == null) {
            dVar = null;
        } else {
            dVar = concurrentHashMap.get(str2);
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_AdnShowControl", "checkLoad 取出的showBean = ".concat(String.valueOf(dVar)));
        }
        if (dVar != null && dVar.d() != 0) {
            long time = new Date().getTime();
            if (time <= dVar.d()) {
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_AdnShowControl", "checkLoad 当前时间 = " + an.hc(time));
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_AdnShowControl", "checkLoad 规则有效时间 = " + an.hc(dVar.d()));
                return new com.bytedance.msdk.api.hc.d(40044, com.bytedance.msdk.api.d.d(40044));
            }
        }
        return null;
    }
}
