package com.bytedance.msdk.gb;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k {
    public static com.bytedance.msdk.api.b d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.hc.b bVar, boolean z) {
        if (bVar == null || hcVar == null) {
            return null;
        }
        com.bytedance.msdk.api.b bVar2 = new com.bytedance.msdk.api.b();
        bVar2.d(bVar.t());
        bVar2.gb(bVar.nw());
        bVar2.tt(bVar.dz());
        bVar2.tc(bVar.ph());
        bVar2.mq(bVar.fu());
        if (z) {
            if (!d() && (bVar.oc() || bVar.tj() || bVar.ox())) {
                bVar2.mk("-3");
            } else {
                bVar2.mk(bVar.o());
            }
        } else if (!hc() && bVar.oc()) {
            bVar2.mk("-3");
        } else {
            bVar2.mk(bVar.f());
        }
        bVar2.k(bVar.ai());
        bVar2.hc(bVar.hg());
        bVar2.uo(bVar.l());
        bVar2.d(d(hcVar));
        bVar2.hc(d(bVar));
        bVar2.h(hcVar != null ? hcVar.np() : null);
        bVar2.an(d(hcVar != null ? hcVar.l() : null));
        bVar2.b(new StringBuilder().append(hcVar.fu()).toString());
        com.bytedance.msdk.api.c.an anVarZw = com.bytedance.msdk.core.d.mk().zw();
        bVar2.c(anVarZw != null ? anVarZw.b() : null);
        bVar2.u(anVarZw != null ? anVarZw.c() : null);
        Map<String, Object> mapHv = hcVar != null ? hcVar.hv() : null;
        if (mapHv != null && !mapHv.isEmpty()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, Object> entry : mapHv.entrySet()) {
                Object value = entry.getValue();
                map.put(entry.getKey(), value == null ? null : value.toString());
            }
            bVar2.d(map);
        }
        return bVar2;
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str).optString("experiment_detail_id");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    private static String d(com.bytedance.msdk.api.d.hc hcVar) {
        if (hcVar == null) {
            return null;
        }
        switch (hcVar.de()) {
        }
        return null;
    }

    private static String d(com.bytedance.msdk.hc.b bVar) {
        if (bVar == null) {
            return null;
        }
        switch (bVar.nv()) {
            case 1:
                return "interstitial";
            case 2:
            case 7:
                return "fullVideo";
            case 3:
                return "banner";
            case 4:
                return "feed";
            case 5:
                return "draw";
            case 6:
                return "rewardVideo";
            default:
                int iEl = bVar.el();
                if (iEl == 1) {
                    return "banner";
                }
                if (iEl == 5) {
                    return "feed";
                }
                if (iEl != 7) {
                    return null;
                }
                return "rewardVideo";
        }
    }

    private static boolean d() {
        return com.bytedance.msdk.core.hc.hc().v();
    }

    private static boolean hc() {
        return com.bytedance.msdk.core.hc.hc().yi();
    }

    public static boolean d(List<com.bytedance.msdk.hc.b> list, List<com.bytedance.msdk.hc.b> list2, List<com.bytedance.msdk.hc.b> list3, com.bytedance.msdk.api.d.hc hcVar, boolean z, String str, int i, List<com.bytedance.msdk.core.tc.tc> list4) throws JSONException {
        int iHc = com.bytedance.msdk.b.c.hc.hc(str);
        com.bytedance.msdk.u.an.d(list, list2, list3, hcVar, iHc);
        if (z || iHc != 0) {
            return false;
        }
        if (list.size() > 0) {
            for (com.bytedance.msdk.hc.b bVar : list) {
                if (bVar != null) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.hc(str, bVar.ph()) + "isReady-》广告类型：" + com.bytedance.msdk.hc.d.d(bVar.t()) + ",是否已准备好？isReady()：" + bVar.ba(str));
                    if (bVar.ba(str) && !bVar.xp()) {
                        return true;
                    }
                }
            }
        }
        if (list3 != null && list3.size() > 0) {
            for (com.bytedance.msdk.hc.b bVar2 : list3) {
                if (bVar2 != null) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.hc(str, bVar2.ph()) + "isReady-》广告类型：" + com.bytedance.msdk.hc.d.d(bVar2.t()) + ",是否已准备好？isReady()：" + bVar2.ba(str));
                    if (bVar2.ba(str) && !bVar2.xp()) {
                        return true;
                    }
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (com.bytedance.msdk.hc.b bVar3 : list2) {
                if (bVar3 != null) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.hc(str, bVar3.ph()) + "isReady--->biding-->广告类型：" + com.bytedance.msdk.hc.d.d(bVar3.t()) + ",是否已准备好？isReady()：" + bVar3.ba(str));
                    if (bVar3.ba(str) && !bVar3.xp()) {
                        return true;
                    }
                }
            }
        }
        if (list4 != null && list4.size() > 0) {
            for (com.bytedance.msdk.core.tc.tc tcVar : list4) {
                String strYo = tcVar.yo();
                if (tcVar.jh() && com.bytedance.msdk.core.u.d.d.d().c(str, strYo, i) && com.bytedance.msdk.core.u.d.d.d().d(strYo, hcVar, false) == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("show_adn_load_error_detail");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static com.bytedance.msdk.api.d d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.d dVar, List<com.bytedance.msdk.api.hc> list) {
        if (dVar == null || hcVar == null || list == null || list.size() == 0 || !d(hcVar.hv())) {
            return dVar;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.bytedance.msdk.api.hc hcVar2 : list) {
            if (hcVar2 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("adn_name", TextUtils.isEmpty(hcVar2.b()) ? hcVar2.c() : hcVar2.b());
                    jSONObject.put("mediation_rit", hcVar2.hc());
                    jSONObject.put("ad_type", hcVar2.d());
                    jSONObject.put("error_code", hcVar2.u());
                    jSONObject.put("error_msg", hcVar2.an());
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        dVar.hc = jSONArray.toString();
        return dVar;
    }
}
