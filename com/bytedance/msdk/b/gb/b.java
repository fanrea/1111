package com.bytedance.msdk.b.gb;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.msdk.core.tc.tt;
import com.bytedance.msdk.gb.s;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    public static com.bytedance.msdk.b.d.d d(com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, com.bytedance.msdk.b.d.hc hcVar3) {
        com.bytedance.msdk.core.tc.d dVarD;
        com.bytedance.msdk.api.c.d.hc.b.d dVarD2;
        if (hcVar == null || hcVar2 == null) {
            return null;
        }
        hcVar.d(d(hcVar2, hcVar));
        hcVar.hc(hcVar2.v());
        if (!hcVar.tc()) {
            if (hcVar.mk()) {
                return com.bytedance.msdk.b.b.hc.d.c.d(hcVar, hcVar3);
            }
            if (com.bytedance.msdk.core.h.b.d(hcVar.gb())) {
                return new com.bytedance.msdk.b.b.hc.d.b(hcVar3);
            }
            return null;
        }
        com.bytedance.msdk.an.hc.d(com.bytedance.msdk.core.hc.getContext(), hcVar != null ? hcVar.uo() : "");
        if (com.bytedance.msdk.an.hc.d.d(hcVar.uo()) == null || (dVarD = com.bytedance.msdk.h.d.hc.d().d(hcVar.uo())) == null || dVarD.b() == null || (dVarD2 = dVarD.b().d(hcVar.he(), hcVar.e())) == null || !d(dVarD2)) {
            return null;
        }
        return com.bytedance.msdk.b.b.hc.d.c.d(dVarD2.d(), hcVar, hcVar3);
    }

    public static String d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.b.an.hc.hc hcVar2) {
        if (hcVar == null || hcVar2 == null) {
            return null;
        }
        String strD = TextUtils.isEmpty(hcVar.d()) ? null : hcVar.d();
        if (TextUtils.isEmpty(hcVar2.mq())) {
            return strD;
        }
        return (strD + Config.replace) + hcVar2.mq();
    }

    public static boolean d(com.bytedance.msdk.api.c.d.hc.b.d dVar) {
        if (dVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> functionH = com.bytedance.msdk.core.mk.d.d().h();
        if (functionH != null) {
            if (!TextUtils.isEmpty(dVar.d())) {
                com.bykv.d.d.d.d.d dVarD = com.bykv.d.d.d.d.d.d();
                dVarD.d(8010, dVar.d());
                com.bytedance.msdk.d.u.b.hc("TMe", "custom className is " + dVar.d());
                dVarD.d(-99999987, 8229);
                dVarD.d(-99999985, Boolean.class);
                return ((Boolean) functionH.apply(dVarD.hc().sparseArray())).booleanValue();
            }
            com.bytedance.msdk.d.u.b.hc("TMe", "custom className is empty");
        } else {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "load ad check custom name class loader is null ");
        }
        return false;
    }

    public static Map<String, Object> d(com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, Map<String, Object> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (hcVar != null && hcVar2 != null) {
            com.bytedance.msdk.core.tc.d dVarD = com.bytedance.msdk.core.hc.hc().d(hcVar.uo());
            if (dVarD != null) {
                concurrentHashMap.put("tt_ad_network_config_appid", dVarD.d());
                concurrentHashMap.put("tt_ad_network_config_appKey", dVarD.hc());
            }
            concurrentHashMap.put("tt_ad_origin_type", Integer.valueOf(hcVar.k()));
            concurrentHashMap.put("tt_ad_sub_type", Integer.valueOf(hcVar.e()));
            if (hcVar2 != null) {
                Map<String, Object> mapHv = hcVar2.hv();
                if (mapHv != null && mapHv.size() > 0) {
                    for (Map.Entry<String, Object> entry : mapHv.entrySet()) {
                        if (entry.getKey() != null && entry.getValue() != null) {
                            concurrentHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                int iYi = hcVar2.yi();
                int iHe = hcVar2.he();
                if (iYi < 0) {
                    iYi = 0;
                }
                if (iHe < 0) {
                    iHe = 0;
                }
                concurrentHashMap.put("ad_height", Integer.valueOf(iHe));
                concurrentHashMap.put("ad_width", Integer.valueOf(iYi));
                concurrentHashMap.put("ad_type", Integer.valueOf(hcVar2.de()));
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    if (entry2.getKey() != null && entry2.getValue() != null) {
                        concurrentHashMap.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
        }
        return concurrentHashMap;
    }

    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.b.an.hc.hc hcVar2, tt ttVar, String str) {
        if (bVar == null || hcVar2 == null || hcVar == null) {
            return;
        }
        if ((hcVar2.rf() == 0 || hcVar2.rf() == 100) && hcVar2.zw() != 0.0d) {
            bVar.d(hcVar2.zw());
        }
        if (hcVar2.v()) {
            bVar.hc(hcVar2.j());
            bVar.b(hcVar2.s());
            if (hcVar2.us() != null) {
                bVar.u(hcVar2.us().b());
                bVar.an(hcVar2.us().c());
                bVar.b(hcVar2.us().gb());
                bVar.c(hcVar2.us().tt());
                bVar.c(hcVar2.us().d());
            }
        }
        bVar.e(hcVar2.rf());
        bVar.w(hcVar2.jh());
        bVar.cb(hcVar2.sy());
        if (str == null) {
            str = "";
        }
        bVar.yo(str);
        bVar.cb(hcVar2.uo());
        bVar.w(hcVar2.gb() != null ? hcVar2.gb().cb() : "");
        bVar.e(hcVar2.z());
        bVar.d(SystemClock.elapsedRealtime());
        bVar.jh(hcVar2.mq());
        bVar.rf(hcVar2.hc());
        bVar.uo(com.bytedance.msdk.hc.d.hc(hcVar2.uo()));
        bVar.h(hcVar2.h());
        bVar.gb(hcVar2.an());
        bVar.h(hcVar.d());
        bVar.tt(hcVar2.h());
        bVar.tc(hcVar2.an());
        bVar.an(hcVar2.k());
        bVar.u(hcVar2.e());
        bVar.k(hcVar.de());
        bVar.b(hcVar2.fs());
        bVar.d(hcVar2.vv());
        s.d(bVar, hcVar2.gb(), hcVar, false);
        if (ttVar != null) {
            bVar.hc("if_test", Integer.valueOf(ttVar.hc == 1 ? ttVar.hc : 0));
            bVar.hc("server_bidding_extra", ttVar.d);
            int iGb = bVar.gb(hcVar != null ? hcVar.d() : null);
            if (iGb == 1 || iGb == 2) {
                bVar.b(ttVar.u);
            }
        }
        if (hcVar2.us() == null || hcVar2.us() == null) {
            return;
        }
        bVar.d("extra_data_and_no_parse", hcVar2.us().hc());
    }
}
