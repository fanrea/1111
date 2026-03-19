package com.bytedance.msdk.core.tt;

import android.text.TextUtils;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public static final Map<String, com.bytedance.msdk.core.tc.hc> d = new ConcurrentHashMap();

    public static void d(int i, String str, int i2, double d2) {
        com.bytedance.msdk.core.tc.hc hcVarD;
        com.bytedance.msdk.core.tc.c cVarU;
        if (com.bytedance.msdk.core.hc.hc().ru() && (hcVarD = com.bytedance.msdk.core.hc.hc().d(str, i2, 101)) != null) {
            if (hcVarD.an() == 1 && i == 1) {
                u.c().d(i2, d2);
                return;
            }
            if (hcVarD.an() != 2 || (cVarU = com.bytedance.msdk.core.hc.hc().u(str)) == null) {
                return;
            }
            if (i == 2 && cVarU.b() == 2) {
                hc.c().d(str, 2, d2);
            } else {
                if (i != 1 || cVarU.b() == 2) {
                    return;
                }
                hc.c().d(str, cVarU.b(), d2);
            }
        }
    }

    public static void d(com.bytedance.msdk.core.tc.hc hcVar, double d2, String str, int i) {
        if (!com.bytedance.msdk.core.hc.hc().ru() || hcVar == null) {
            return;
        }
        if (hcVar.an() == 2) {
            d(2, str, i, d2);
        } else if (hcVar.an() == 3 || hcVar.an() == 4) {
            hc.c().d(hcVar.fs(), "_last_load_cpm_", hcVar.us(), d2);
        }
    }

    public static void d(String str, String str2, int i, JSONObject jSONObject) {
        com.bytedance.msdk.core.tc.hc hcVarD;
        if (com.bytedance.msdk.core.hc.hc().ru() && (hcVarD = com.bytedance.msdk.h.d.b.d().d(str, i, 101)) != null) {
            if ("mediation_request".equals(str2)) {
                if (hcVarD.an() == 1) {
                    u.c().d(String.valueOf(i), jSONObject, hcVarD.u());
                    return;
                } else {
                    if (hcVarD.an() == 2) {
                        hc.c().d(String.valueOf(i), jSONObject, hcVarD.u());
                        return;
                    }
                    return;
                }
            }
            if (hcVarD.an() != 2 || "sdk_init".equals(str2) || ILogConst.EVENT_SDK_INIT_END.equals(str2) || "get_config_start".equals(str2) || "get_config_final".equals(str2)) {
                return;
            }
            hc.c().b(String.valueOf(i), jSONObject, hcVarD.u());
        }
    }

    public static com.bytedance.msdk.core.tc.hc d(com.bytedance.msdk.core.tc.hc hcVar, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (hcVar != null && com.bytedance.msdk.core.hc.hc().ru()) {
            if (i == 101) {
                return d.get(hcVar.fs());
            }
            if (i == 100 && (hcVar.an() == 2 || hcVar.an() == 3 || hcVar.an() == 4)) {
                List<tc> listD = b.d(hcVar, hcVar.fs());
                Object obj = hcVar.u().get("rule_in_use");
                int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
                hcVar.u().put("cost_time", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                if (listD == null || iIntValue == 0) {
                    return hcVar;
                }
                com.bytedance.msdk.core.tc.hc hcVarClone = hcVar.clone();
                if (hcVarClone.mk()) {
                    hcVarClone.hc(listD);
                } else {
                    hcVarClone.d(listD);
                }
                Object obj2 = hcVarClone.u().get("max_ecpm");
                Object obj3 = hcVarClone.u().get("min_ecpm");
                if (obj2 != null) {
                    hcVarClone.c(((Double) obj2).doubleValue());
                }
                if (obj3 != null) {
                    hcVarClone.u(((Double) obj3).doubleValue());
                }
                d.put(hcVar.fs(), hcVarClone);
                hcVarClone.u().put("cost_time", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                return hcVarClone;
            }
        }
        return null;
    }

    public static int d(String str, int i, Map<String, Object> map) {
        com.bytedance.msdk.core.tc.c cVarU;
        int iD;
        if (!TextUtils.isEmpty(str) && i == 1 && (cVarU = com.bytedance.msdk.core.hc.hc().u(str)) != null) {
            int iB = cVarU.b();
            String strC = cVarU.c();
            if (iB > 0 && !TextUtils.isEmpty(strC)) {
                double d2 = hc.c().d(3, str, iB);
                List<com.bytedance.msdk.core.tc.b> listAn = com.bytedance.msdk.core.hc.hc().an(String.valueOf(i));
                if (listAn == null || listAn.size() <= 0) {
                    iD = 0;
                    if (iD < 10000 && iD <= 180000) {
                        return iD;
                    }
                } else {
                    for (com.bytedance.msdk.core.tc.b bVar : listAn) {
                        if (d2 > bVar.an() && d2 <= bVar.u()) {
                            iD = cVarU.d(String.valueOf(bVar.b()));
                            map.put("refresh_time", Integer.valueOf(iD));
                            break;
                        }
                    }
                    iD = 0;
                    if (iD < 10000) {
                    }
                }
            }
        }
        return 0;
    }

    public static void d(int i, String str, JSONObject jSONObject) throws JSONException {
        com.bytedance.msdk.core.tc.c cVarU;
        if (com.bytedance.msdk.core.hc.hc().ru() && i == 2 && (cVarU = com.bytedance.msdk.core.hc.hc().u(str)) != null) {
            try {
                jSONObject.putOpt("dynamic_rule_id", cVarU.c());
            } catch (JSONException e) {
                mq.d(e);
            }
        }
    }

    public static void d(List<com.bytedance.msdk.hc.b> list, com.bytedance.msdk.core.tc.hc hcVar) {
        Object obj;
        if (!com.bytedance.msdk.core.hc.hc().ru() || list == null || hcVar == null) {
            return;
        }
        for (com.bytedance.msdk.hc.b bVar : list) {
            if (bVar != null) {
                if (hcVar.an() == 1) {
                    bVar.j().put("gm_usb", u.b(hcVar.ba()));
                } else if (hcVar.an() == 2 && (obj = hcVar.u().get("user_label_value")) != null) {
                    bVar.j().put("gm_usb", ((com.bytedance.msdk.core.tc.b) obj).d());
                }
            }
        }
    }

    public static void d(boolean z, com.bytedance.msdk.u.c cVar, JSONObject jSONObject, Map<String, Object> map) {
        if (cVar == null || !com.bytedance.msdk.core.hc.hc().ru()) {
            return;
        }
        u.c().d(z, cVar, jSONObject, map);
    }

    public static void d(int i, List<tc> list, Map<String, Object> map) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (tc tcVar : list) {
            if (tcVar != null && tcVar.rf() == 0) {
                jSONArray.put(tcVar.yo());
            }
        }
        if (map != null) {
            map.put("rit_ids", jSONArray);
        }
    }
}
