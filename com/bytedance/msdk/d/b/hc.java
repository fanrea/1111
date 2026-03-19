package com.bytedance.msdk.d.b;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cm;
import com.bytedance.msdk.api.c.tc;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.openadsdk.w.b.b.hc;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static boolean d(String str) {
        String strB = b();
        return (TextUtils.isEmpty(strB) || TextUtils.isEmpty(str) || strB.compareTo(str) < 0) ? false : true;
    }

    public static String d(String str, String str2, String str3) throws JSONException {
        JSONArray jSONArray;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONArray = new JSONArray(str);
                    } catch (JSONException unused) {
                        jSONArray = new JSONArray();
                    }
                } else {
                    jSONArray = new JSONArray();
                }
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i < jSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null && str2.equals(jSONObjectOptJSONObject.getString("name"))) {
                            jSONObjectOptJSONObject.put(com.alipay.sdk.m.p0.b.d, str3);
                            z = true;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (!z) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", str2);
                    jSONObject.put(com.alipay.sdk.m.p0.b.d, str3);
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (Exception e) {
                mq.d(e);
            }
        }
        return str;
    }

    public static double d(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Float) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        try {
            if (obj instanceof String) {
                return Double.valueOf((String) obj).doubleValue();
            }
            return 0.0d;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static long d(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get("creative_id") != null) {
                return ((Long) map.get("creative_id")).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            mq.d(th);
            return 0L;
        }
    }

    public static long hc(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get(IDJXAd.AD_CODE_ID) != null) {
                return ((Long) map.get(IDJXAd.AD_CODE_ID)).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            mq.d(th);
            return 0L;
        }
    }

    public static String b(Map<String, Object> map) {
        if (map == null || map.get("request_id") == null) {
            return null;
        }
        return (String) map.get("request_id");
    }

    public static void hc(String str) {
        tc.hc(str);
    }

    public static String d() {
        return tc.h();
    }

    private static Map<String, String> hc() {
        return tc.gb();
    }

    private static JSONArray hc(com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.de())) {
            return null;
        }
        try {
            return new JSONArray(dVar.de());
        } catch (Throwable th) {
            mq.d(th);
            return null;
        }
    }

    public static JSONArray d(com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar) throws JSONException {
        JSONArray jSONArrayB = b(d());
        try {
            Map<String, String> mapHc = hc();
            if (mapHc != null && mapHc.size() > 0) {
                for (String str : mapHc.keySet()) {
                    String str2 = mapHc.get(str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("name", str);
                        jSONObject.putOpt(com.alipay.sdk.m.p0.b.d, str2);
                        jSONArrayB.put(jSONObject);
                    }
                }
            }
            JSONArray jSONArrayHc = hc(dVar);
            if (jSONArrayHc != null) {
                for (int i = 0; i < jSONArrayHc.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayHc.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && !TextUtils.equals("personal_ads_type", jSONObjectOptJSONObject.optString("name"))) {
                        jSONArrayB.put(jSONObjectOptJSONObject);
                    }
                }
            }
        } catch (Exception e) {
            mq.d(e);
        }
        return jSONArrayB;
    }

    private static void d(hc.d dVar, String str, String str2, boolean z, com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar2) throws JSONException {
        JSONArray jSONArrayD = d(dVar2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", "mediation_sdk_version");
            jSONObject.putOpt(com.alipay.sdk.m.p0.b.d, com.bytedance.msdk.hc.hc.hc());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("name", "mediation_req_type");
            jSONObject2.putOpt(com.alipay.sdk.m.p0.b.d, "1");
            JSONObject jSONObject3 = null;
            if (!TextUtils.isEmpty(str)) {
                jSONObject3 = new JSONObject();
                jSONObject3.putOpt("name", "waterfall_abtest");
                jSONObject3.putOpt(com.alipay.sdk.m.p0.b.d, str);
            }
            jSONArrayD.put(jSONObject2);
            jSONArrayD.put(jSONObject);
            if (jSONObject3 != null) {
                jSONArrayD.put(jSONObject3);
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("name", "m_req_id");
                jSONObject4.putOpt(com.alipay.sdk.m.p0.b.d, str2);
                jSONArrayD.put(jSONObject4);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        if (!z) {
            d(dVar);
        }
        com.bytedance.sdk.gromore.init.d.d(tc.an());
        if (dVar != null) {
            dVar.tt(jSONArrayD.toString());
        }
    }

    static JSONArray b(String str) {
        JSONArray jSONArray;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(str);
            }
        } catch (Exception e) {
            mq.d(e);
            jSONArray = null;
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static void d(hc.d dVar) {
        if (dVar != null && tc.tt()) {
            try {
                String strB = tc.b("tt_pangle_preview_ad_id");
                String strB2 = tc.b("tt_pangle_preview_creative_id");
                String strB3 = tc.b("tt_pangle_preview_ext");
                com.bytedance.msdk.d.u.b.d("TTMediationSDK", "pangle preview adId:" + strB + " creativeId:" + strB2 + " ext" + strB3);
                if (!TextUtils.isEmpty(strB) && !TextUtils.isEmpty(strB2)) {
                    dVar.d(strB).hc(strB2);
                }
                if (TextUtils.isEmpty(strB3)) {
                    return;
                }
                dVar.b(strB3);
            } catch (Throwable th) {
                mq.d(th);
            }
        }
    }

    public static hc.d d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.b.an.hc.hc hcVar2, boolean z) {
        return d(hcVar, hcVar2.mq(), hcVar2.cb(), hcVar2.w(), hcVar2.yi(), z);
    }

    public static hc.d d(com.bytedance.msdk.api.d.hc hcVar, String str, String str2, String str3, String str4, boolean z) {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVarSy;
        hc.d dVarB = new hc.d().c(str).b(1);
        if (hcVar != null) {
            dVarB.an(hcVar.hc()).h(hcVar.v()).hc(hcVar.zw());
            dVarSy = hcVar.sy();
            if (dVarSy != null) {
                dVarB.an(dVarSy.k()).d(dVarSy.u()).c(dVarSy.he()).d(dVarSy.d()).hc(dVarSy.hc()).c(dVarSy.e()).d(dVarSy.v()).u(dVarSy.uo()).b(dVarSy.b());
                String strRf = dVarSy.rf();
                if (!TextUtils.isEmpty(strRf)) {
                    dVarB.h(strRf);
                }
                if (dVarSy.yo() != 0) {
                    dVarB.an(dVarSy.yo());
                }
            }
            int[] iArrD = d(hcVar, dVarSy);
            if (iArrD != null && iArrD.length > 0) {
                dVarB.d(iArrD);
            }
            if (5 == hcVar.de() || 9 == hcVar.de()) {
                dVarB.b(hcVar.vv());
            }
        } else {
            dVarSy = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            dVarB.gb(str4);
        }
        d(dVarB, str2, str3, z, dVarSy);
        return dVarB;
    }

    private static int[] d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar) {
        if (dVar != null && dVar.w() != null && dVar.w().length > 0) {
            return dVar.w();
        }
        try {
            Map<String, Object> mapHv = hcVar.hv();
            if (mapHv != null) {
                return (int[]) mapHv.get("pangle_vid");
            }
            return null;
        } catch (Throwable th) {
            mq.d(th);
            return null;
        }
    }

    private static String b() {
        try {
            return com.bytedance.sdk.gromore.init.d.b();
        } catch (Throwable unused) {
            return cm.d;
        }
    }

    public static boolean d(com.bytedance.msdk.api.d.hc hcVar) {
        if (hcVar != null && hcVar.hv() != null) {
            Object obj = hcVar.hv().get("banner_native_exp_auto_height");
            try {
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
