package com.bytedance.msdk.b.gb;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.gb.us;
import com.bytedance.sdk.openadsdk.w.b.b.hc;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public static Map<String, List<com.bytedance.msdk.core.tc.u>> d = new ConcurrentHashMap();
    public static Map<String, String> hc = new ConcurrentHashMap();

    public static PluginValueSet d(String str, hc.d dVar, int i) throws JSONException {
        long j;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return com.bytedance.sdk.openadsdk.mediation.hc.hc.d.d(dVar.d());
        }
        if (com.bytedance.msdk.core.mk.d.d().d(str)) {
            return com.bytedance.sdk.openadsdk.mediation.hc.hc.d.d(dVar.d());
        }
        String strD = d(str);
        if (TextUtils.isEmpty(strD)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            strD = hc(str);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (TextUtils.isEmpty(strD)) {
                i2 = 3;
                j = jCurrentTimeMillis2;
            } else {
                j = jCurrentTimeMillis2;
                i2 = 2;
            }
        } else {
            j = 0;
            i2 = 1;
        }
        com.bytedance.msdk.u.an.d(i, i2, j, str, strD);
        if (TextUtils.isEmpty(strD)) {
            return com.bytedance.sdk.openadsdk.mediation.hc.hc.d.d(dVar.d());
        }
        dVar.c(strD);
        return com.bytedance.sdk.openadsdk.mediation.hc.hc.d.d(dVar.d(), str, i2 == 2);
    }

    public static void d(final JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null) {
            return;
        }
        d.clear();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(next)) != null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        String strOptString = jSONObject2.optString("price");
                        long jOptLong = jSONObject2.optLong("csj_code_id");
                        double dDoubleValue = 0.0d;
                        try {
                            dDoubleValue = Double.valueOf(strOptString).doubleValue();
                        } catch (Throwable unused) {
                        }
                        copyOnWriteArrayList.add(new com.bytedance.msdk.core.tc.u(String.valueOf(jOptLong), dDoubleValue, 0, 0));
                    }
                    d.put(next, copyOnWriteArrayList);
                }
            }
        } catch (Throwable unused2) {
        }
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.b.gb.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.h.d.b().d("mediation_csj_map", jSONObject.toString());
            }
        });
    }

    public static void d() throws JSONException {
        if (hc.size() == 0) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : hc.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.b.gb.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.h.d.b().d("mediation_adn_map", jSONObject.toString());
            }
        });
    }

    public static boolean d(String str, String str2) {
        List<com.bytedance.msdk.core.tc.u> list;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (list = d.get(str)) == null || list.size() == 0) {
            return true;
        }
        us.d(list);
        return str2.equals(list.get(0).d());
    }

    private static String d(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (d.size() == 0) {
            hc();
        }
        for (String str2 : d.keySet()) {
            List<com.bytedance.msdk.core.tc.u> list = d.get(str2);
            if (list != null) {
                Iterator<com.bytedance.msdk.core.tc.u> it = list.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().d())) {
                        return str2;
                    }
                }
            }
        }
        return null;
    }

    private static String hc(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (hc.size() == 0) {
            b();
        }
        return hc.get(str);
    }

    private static void hc() throws JSONException {
        String strHc = com.bytedance.msdk.h.d.b().hc("mediation_csj_map");
        if (TextUtils.isEmpty(strHc)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strHc);
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray.length() > 0) {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            String strOptString = jSONObjectOptJSONObject.optString("csj_code_id");
                            if (TextUtils.isEmpty(strOptString)) {
                                strOptString = jSONObjectOptJSONObject.optString("csj_rit_id");
                            }
                            double dOptDouble = jSONObjectOptJSONObject.optDouble("price");
                            if (dOptDouble <= 0.0d) {
                                dOptDouble = jSONObjectOptJSONObject.optDouble(SplashAd.KEY_BIDFAIL_ECPM);
                            }
                            copyOnWriteArrayList.add(new com.bytedance.msdk.core.tc.u(strOptString, dOptDouble, jSONObjectOptJSONObject.optInt("load_sort"), jSONObjectOptJSONObject.optInt("show_sort")));
                        }
                        d.put(next, copyOnWriteArrayList);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static void b() throws JSONException {
        String strHc = com.bytedance.msdk.h.d.b().hc("mediation_adn_map");
        if (TextUtils.isEmpty(strHc)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strHc);
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                        hc.put(next, string);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
