package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.api.SplashAd;
import com.qq.e.comm.adevent.ADEvent;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yv {
    private static final Map<Integer, Pair<JSONObject, String>> a = new HashMap();
    private static final Map<String, Pair<String, String>> b = new HashMap();
    private static final Map<String, Integer> c = new HashMap();

    static void c(int i) {
        Pair<JSONObject, String> pair = a.get(Integer.valueOf(i));
        if (pair == null) {
            return;
        }
        a(1230003, new ja((JSONObject) pair.first), (String) pair.second);
    }

    private static boolean c(String str) {
        return r1.d().f().a("mreecpmg", str, 1) == 1;
    }

    public static Map<String, String> b(String str) {
        Pair<String, String> pair;
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str) || (pair = b.get(str)) == null) {
            return map;
        }
        map.put("adnid", pair.first);
        map.put("adnposid", pair.second);
        return map;
    }

    static void b(int i) {
        Pair<JSONObject, String> pair = a.get(Integer.valueOf(i));
        if (pair == null) {
            return;
        }
        a(1230004, new ja((JSONObject) pair.first), (String) pair.second);
    }

    private static boolean a(String str, tr trVar) {
        return trVar.u() && trVar.a() != 100 && c(str);
    }

    public static void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c.put(str, Integer.valueOf(i));
    }

    static void a(Object obj, tr trVar, String str, int i) {
        if (obj != null && trVar != null) {
            String strN = trVar.n();
            ja jaVar = new ja();
            jaVar.a("mediation_id", trVar.n()).a("adnet_id", Integer.valueOf(trVar.a())).a(PointParamKey.PLACEMENT_ID, trVar.p());
            jaVar.a("flow_group_id", Integer.valueOf(trVar.k()));
            jaVar.a(PointParamKey.TRACE_ID, str);
            jaVar.a("price", Integer.valueOf(trVar.q()));
            if (a(strN, trVar)) {
                jaVar.a(SplashAd.KEY_BIDFAIL_ECPM, -1);
                jaVar.a("bpg", Integer.valueOf(trVar.d()));
                jaVar.a("yecpm", Integer.valueOf(trVar.t()));
            } else {
                jaVar.a(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf(trVar.f()));
            }
            jaVar.a("request_id", trVar.s());
            jaVar.a("exp_group_id", Integer.valueOf(i));
            jaVar.a("report_json", new jn(trVar.j()).a().optString("report_json"));
            a.put(Integer.valueOf(obj.hashCode()), new Pair<>(jaVar.a(), strN));
            return;
        }
        qm$h$$ExternalSyntheticBackport0.m(obj);
        qm$h$$ExternalSyntheticBackport0.m(obj);
    }

    public static void a(ADEvent aDEvent, String str, e2 e2Var, Object obj) {
        String str2;
        int i;
        ja jaVar = new ja();
        try {
            str2 = (String) aDEvent.getParam(0, String.class);
            try {
                jaVar.a("appid", aDEvent.getParam(1, String.class));
                jaVar.a("request_id", aDEvent.getParam(2, String.class));
                jaVar.a("app_name", aDEvent.getParam(3, String.class));
                jaVar.a("m_posid", str);
                jaVar.a("adnet_id", ((JSONObject) a.get(Integer.valueOf(obj.hashCode())).first).optString("adnet_id"));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str2 = null;
        }
        f5 f5VarA = new f5().c(str2).a(e2Var);
        switch (aDEvent.getType()) {
            case 401:
                i = 1143001;
                break;
            case 402:
                i = 1143002;
                break;
            case 403:
                i = 1143003;
                break;
            case 404:
                i = 1143004;
                break;
            case 405:
                i = 1143005;
                break;
            case 406:
                i = 1143006;
                break;
            default:
                return;
        }
        b10.a(i, f5VarA, null, null, jaVar);
    }

    public static void a(Object obj, int i) {
        if (obj == null) {
            return;
        }
        ja jaVar = new ja();
        try {
            jaVar.a("adnet_id", ((JSONObject) a.get(Integer.valueOf(obj.hashCode())).first).optString("adnet_id"));
        } catch (Exception unused) {
        }
        b10.a(i, null, null, null, jaVar);
    }

    static void a(List<tr> list, String str, int i) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.size() <= 0) {
            return;
        }
        String strN = "";
        int iK = 0;
        for (tr trVar : list) {
            if (trVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    strN = trVar.n();
                    iK = trVar.k();
                    jSONObject.put("adnet_id", trVar.a());
                    jSONObject.put(PointParamKey.PLACEMENT_ID, trVar.p());
                    jSONObject.put("price", trVar.q());
                    if (a(strN, trVar)) {
                        jSONObject.put(SplashAd.KEY_BIDFAIL_ECPM, -1);
                        jSONObject.put("bpg", trVar.d());
                        jSONObject.put("yecpm", trVar.t());
                    } else {
                        jSONObject.put(SplashAd.KEY_BIDFAIL_ECPM, trVar.f());
                    }
                    jSONObject.put("request_id", trVar.s());
                    int i2 = trVar.m() == 3 ? 1 : 0;
                    jSONObject.put("is_fill", i2);
                    if (i2 == 0) {
                        jSONObject.put("unfill_reason", trVar.m());
                        jSONObject.put("load_ec", trVar.g());
                        jSONObject.put("load_em", trVar.h());
                    }
                    jSONObject.put("is_win", trVar.v() ? 1 : 0);
                    jSONObject.put("load_duration", trVar.l());
                    jSONObject.put("report_json", new jn(trVar.j()).a().optString("report_json"));
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                }
            }
        }
        ja jaVar = new ja();
        jaVar.a("mediation_id", strN);
        jaVar.a("flow_group_id", Integer.valueOf(iK));
        jaVar.a("adns", jSONArray);
        jaVar.a("exp_group_id", Integer.valueOf(i));
        jaVar.a(PointParamKey.TRACE_ID, str);
        a(1230002, jaVar, strN);
    }

    static void a(String str, String str2, String str3) {
        b.put(str, new Pair<>(str2, str3));
    }

    public static Integer a(String str) {
        return c.get(str);
    }

    static void a(int i, long j) throws JSONException {
        Pair<JSONObject, String> pair = a.get(Integer.valueOf(i));
        if (pair == null) {
            return;
        }
        ja jaVar = new ja((JSONObject) pair.first);
        jaVar.a("exposeDuration", Long.valueOf(j));
        a(1230000, jaVar, (String) pair.second);
    }

    static void a(int i) {
        Pair<JSONObject, String> pair = a.get(Integer.valueOf(i));
        if (pair == null) {
            return;
        }
        a(1230001, new ja((JSONObject) pair.first), (String) pair.second);
    }

    private static void a(int i, ja jaVar, String str) {
        qm$h$$ExternalSyntheticBackport0.m(jaVar);
        qc qcVar = new qc(i);
        qcVar.a(new f5().c(str));
        qcVar.a(jaVar);
        b10.a(qcVar, true);
    }
}
