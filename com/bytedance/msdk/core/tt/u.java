package com.bytedance.msdk.core.tt;

import android.text.TextUtils;
import com.alipay.sdk.m.t.a;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.msdk.core.u.hc.h;
import com.bytedance.msdk.gb.us;
import com.bytedance.sdk.component.utils.mq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends d {
    private static volatile u u;
    protected final Map<String, String> b;
    private final Map<String, double[]> c;

    private u() {
        super("label_v_v_s");
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        hc();
    }

    public static u c() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    protected void d(int i, double d) {
        if (com.bytedance.msdk.core.hc.hc().ru()) {
            d(2, String.valueOf(i), 1, d);
        }
    }

    private void c(int i) {
        if (i == 2) {
            this.c.clear();
            return;
        }
        this.b.clear();
        if (this.hc != null) {
            this.hc.b();
        }
    }

    public Map<String, JSONObject> hc(int i) {
        if (!com.bytedance.msdk.core.hc.hc().ru()) {
            return new HashMap();
        }
        HashMap map = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = null;
        for (Map.Entry<String, double[]> entry : (i == 2 ? this.c : hc(this.b)).entrySet()) {
            String key = entry.getKey();
            double[] value = entry.getValue();
            try {
                if (!TextUtils.isEmpty(key)) {
                    Map<String, JSONObject> mapD = d(key, value);
                    JSONObject jSONObject3 = mapD.get("config_req_label_value");
                    JSONObject jSONObject4 = mapD.get("event_label_value");
                    if (jSONObject4 != null) {
                        jSONObject.putOpt(key, jSONObject4);
                    }
                    if (jSONObject3 != null) {
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        jSONObject2.putOpt(key, jSONObject3);
                    }
                }
            } catch (Exception e) {
                mq.d(e);
            }
        }
        map.put("event_label_value_root", jSONObject);
        if (jSONObject2 != null) {
            map.put("config_req_label_value_root", jSONObject2);
        }
        c(i);
        return map;
    }

    private Map<String, double[]> hc(Map<String, String> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (map != null && map.size() != 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    String value = it.next().getValue();
                    if (!TextUtils.isEmpty(value)) {
                        String[] strArrSplit = value.split(Config.replace);
                        String str = strArrSplit[0];
                        String str2 = strArrSplit[1];
                        String str3 = strArrSplit[2];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            if (com.bytedance.msdk.core.hc.hc().d(System.currentTimeMillis() - Long.parseLong(strArrSplit[2]))) {
                                double[] dArr = (double[]) concurrentHashMap.get(str);
                                if (dArr == null) {
                                    dArr = new double[2];
                                }
                                dArr[0] = dArr[0] + 1.0d;
                                dArr[1] = dArr[1] + Double.parseDouble(str2);
                                concurrentHashMap.put(str, dArr);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return concurrentHashMap;
    }

    private Map<String, JSONObject> d(String str, double[] dArr) throws JSONException {
        JSONObject jSONObject;
        JSONException e;
        HashMap map = new HashMap();
        String strD = d(dArr);
        JSONObject jSONObject2 = null;
        try {
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        if (!strD.equals("-1")) {
            jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(Config.INPUT_PART, hc(strD));
                jSONObject.putOpt(a.k, String.valueOf(System.currentTimeMillis()));
            } catch (JSONException e3) {
                e = e3;
                mq.d(e);
                jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt(SplashAd.KEY_BIDFAIL_ECPM, strD);
                jSONObject4.putOpt(a.k, String.valueOf(System.currentTimeMillis()));
                jSONObject3.putOpt("ecpm_info", jSONObject4);
                map.put("config_req_label_value", jSONObject2);
                map.put("event_label_value", jSONObject3);
                return map;
            }
            jSONObject2 = jSONObject;
        }
        JSONObject jSONObject32 = new JSONObject();
        JSONObject jSONObject42 = new JSONObject();
        try {
            jSONObject42.putOpt(SplashAd.KEY_BIDFAIL_ECPM, strD);
            jSONObject42.putOpt(a.k, String.valueOf(System.currentTimeMillis()));
            jSONObject32.putOpt("ecpm_info", jSONObject42);
        } catch (JSONException e4) {
            mq.d(e4);
        }
        map.put("config_req_label_value", jSONObject2);
        map.put("event_label_value", jSONObject32);
        return map;
    }

    public void d(JSONObject jSONObject, JSONObject jSONObject2) {
        if (com.bytedance.msdk.core.hc.hc().ru() && jSONObject2 != null) {
            try {
                jSONObject.putOpt("label_inputs", jSONObject2);
            } catch (JSONException e) {
                mq.d(e);
            }
        }
    }

    public void d(JSONObject jSONObject) {
        if (com.bytedance.msdk.core.hc.hc().ru()) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, com.bytedance.msdk.core.tc.b> entry : com.bytedance.msdk.core.hc.hc().y().entrySet()) {
                String key = entry.getKey();
                com.bytedance.msdk.core.tc.b value = entry.getValue();
                if (value != null) {
                    try {
                        jSONObject2.putOpt(key, d(value));
                    } catch (JSONException e) {
                        mq.d(e);
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject2.length();
            }
            try {
                jSONObject.putOpt("last_label_outputs", jSONObject2);
            } catch (JSONException e2) {
                mq.d(e2);
            }
        }
    }

    private void hc(JSONObject jSONObject) throws JSONException {
        Map<String, com.bytedance.msdk.core.tc.b> mapY = com.bytedance.msdk.core.hc.hc().y();
        if (mapY.size() > 0 && jSONObject == null) {
            jSONObject = new JSONObject();
        }
        for (Map.Entry<String, com.bytedance.msdk.core.tc.b> entry : mapY.entrySet()) {
            String key = entry.getKey();
            com.bytedance.msdk.core.tc.b value = entry.getValue();
            if (value != null) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(String.valueOf(key));
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(key), jSONObjectOptJSONObject);
                        jSONObjectOptJSONObject.put("ecpm_info", new JSONObject());
                    }
                    jSONObjectOptJSONObject.putOpt("label_info", d(value));
                    jSONObjectOptJSONObject.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.hc.hc().yn()));
                } catch (JSONException e) {
                    mq.d(e);
                }
            }
        }
    }

    @Override // com.bytedance.msdk.core.tt.d
    protected boolean hc(String str, JSONObject jSONObject, Map<String, Object> map) throws JSONException {
        com.bytedance.msdk.core.tc.b bVar = com.bytedance.msdk.core.hc.hc().y().get(str);
        if (bVar == null) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", d(bVar));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.hc.hc().yn()));
            return true;
        } catch (JSONException e) {
            mq.d(e);
            return false;
        }
    }

    protected void d(boolean z, com.bytedance.msdk.u.c cVar, JSONObject jSONObject, Map<String, Object> map) {
        cVar.d("reason", Integer.valueOf(!z ? 1 : 0));
        if (map != null) {
            hc(jSONObject);
            if (jSONObject != null) {
                map.put("label", jSONObject);
            }
        }
    }

    @Override // com.bytedance.msdk.core.tt.d
    protected JSONObject d(com.bytedance.msdk.core.tc.b bVar) throws JSONException {
        if (bVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", bVar.d());
            jSONObject.putOpt("label_id", Integer.valueOf(bVar.b()));
            jSONObject.putOpt("label_version", bVar.c());
            jSONObject.putOpt("upper_bound", Double.valueOf(bVar.u()));
            jSONObject.putOpt("lower_bound", Double.valueOf(bVar.an()));
            jSONObject.putOpt(a.k, bVar.hc());
            return jSONObject;
        } catch (JSONException e) {
            mq.d(e);
            return null;
        }
    }

    public static String u() throws JSONException {
        if (!com.bytedance.msdk.core.hc.hc().ru()) {
            return null;
        }
        Set<Map.Entry<String, com.bytedance.msdk.core.tc.b>> setEntrySet = com.bytedance.msdk.core.hc.hc().y().entrySet();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, com.bytedance.msdk.core.tc.b> entry : setEntrySet) {
            String key = entry.getKey();
            com.bytedance.msdk.core.tc.b value = entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("label_name", value.d());
                jSONObject2.putOpt(a.k, value.hc());
                jSONObject2.putOpt("lower_bound", Double.valueOf(value.an()));
                jSONObject2.putOpt("upper_bound", Double.valueOf(value.u()));
                jSONObject.putOpt(d(Integer.parseInt(key)), jSONObject2);
            } catch (Exception e) {
                mq.d(e);
            }
        }
        return jSONObject.toString();
    }

    public static String b(int i) {
        com.bytedance.msdk.core.tc.b bVar;
        if (com.bytedance.msdk.core.hc.hc().ru() && (bVar = com.bytedance.msdk.core.hc.hc().y().get(String.valueOf(i))) != null) {
            return bVar.d();
        }
        return null;
    }

    public void d(Map<String, ConcurrentHashMap<String, List<h>>> map) {
        int iEl;
        ConcurrentHashMap<String, List<h>> value;
        if (!com.bytedance.msdk.core.hc.hc().ru() || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ConcurrentHashMap<String, List<h>>> entry : map.entrySet()) {
            String key = entry.getKey();
            ConcurrentHashMap<String, List<h>> value2 = entry.getValue();
            if (value2 != null) {
                Iterator<Map.Entry<String, List<h>>> it = value2.entrySet().iterator();
                while (it.hasNext()) {
                    List<h> value3 = it.next().getValue();
                    if (value3 != null && !value3.isEmpty() && value3.get(0) != null && value3.get(0).d != null) {
                        iEl = value3.get(0).d.el();
                        break;
                    }
                }
                iEl = 0;
            } else {
                iEl = 0;
            }
            com.bytedance.msdk.core.tc.hc hcVarD = com.bytedance.msdk.h.d.b.d().d(key, iEl, 101);
            if (hcVarD != null && hcVarD.an() == 1 && (value = entry.getValue()) != null) {
                Iterator<Map.Entry<String, List<h>>> it2 = value.entrySet().iterator();
                while (it2.hasNext()) {
                    List<h> value4 = it2.next().getValue();
                    if (value4 != null && !value4.isEmpty() && value4.get(0) != null && value4.get(0).d != null) {
                        us.d(value4);
                        h hVar = value4.get(0);
                        hc(hVar.d.el(), hVar.d.kb());
                    }
                }
            }
        }
        com.bytedance.msdk.core.k.hc.d(com.bytedance.msdk.core.hc.hc()).d(2);
    }

    public void hc(int i, double d) {
        if (com.bytedance.msdk.core.hc.hc().ru()) {
            String strValueOf = String.valueOf(i);
            double[] dArr = this.c.get(strValueOf);
            if (dArr == null) {
                dArr = new double[2];
            }
            dArr[0] = dArr[0] + 1.0d;
            dArr[1] = dArr[1] + d;
            this.c.put(strValueOf, dArr);
        }
    }

    @Override // com.bytedance.msdk.core.tt.d
    protected void d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("cpm_key_")) {
            return;
        }
        this.b.put(str, str2);
    }

    @Override // com.bytedance.msdk.core.tt.d
    protected Map<String, String> d() {
        return this.b;
    }

    @Override // com.bytedance.msdk.core.tt.d
    protected void d(String str, int i, String str2) {
        if (i == 2) {
            this.b.put(str, str2);
        }
    }
}
