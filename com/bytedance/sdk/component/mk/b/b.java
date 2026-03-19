package com.bytedance.sdk.component.mk.b;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.component.mk.b.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private JSONObject an;
    private boolean b;
    private final Map<String, d> c = new HashMap();
    private String d;
    private String hc;
    private d u;

    public b(JSONObject jSONObject) {
        this.b = false;
        String next = jSONObject.keys().next();
        this.hc = next;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
        this.d = jSONObjectOptJSONObject.optString(Config.INPUT_DEF_VERSION);
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("lazyLoad");
        this.b = zOptBoolean;
        if (!zOptBoolean) {
            d(jSONObjectOptJSONObject);
        } else {
            this.an = jSONObjectOptJSONObject;
        }
    }

    private void d(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("events");
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            d dVar = new d(jSONArrayOptJSONArray.optJSONObject(i));
            this.c.put(dVar.d(), dVar);
            if (dVar.d().equals(jSONObject.optString(LiveConfigKey.MAIN))) {
                this.u = dVar;
            }
        }
    }

    public d d(String str) {
        if (this.b) {
            d(this.an);
        }
        return this.c.get(str);
    }

    public d d() {
        if (this.b) {
            d(this.an);
        }
        return this.u;
    }

    public String hc() {
        return this.hc;
    }

    public List<d> d(d dVar, JSONObject jSONObject, Map<String, Object> map) {
        return d(jSONObject, map, dVar.u());
    }

    public List<d> hc(d dVar, JSONObject jSONObject, Map<String, Object> map) {
        return d(jSONObject, map, dVar.an());
    }

    private List<d> d(JSONObject jSONObject, Map<String, Object> map, List<d.C0281d> list) {
        d dVarD;
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (d.C0281d c0281d : list) {
            if (c0281d != null && (dVarD = d(c0281d.d())) != null && d(c0281d.hc(), jSONObject, map)) {
                arrayList.add(dVarD);
            }
        }
        return arrayList;
    }

    private static boolean d(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return true;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject.put(key, entry.getValue());
                }
            }
            if (str.startsWith("${") && str.endsWith(i.d)) {
                return Boolean.parseBoolean(com.bytedance.adsdk.hc.hc.d.d(str.substring(2, str.length() - 1)).d(jSONObject).toString());
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public List<d> b(d dVar, JSONObject jSONObject, Map<String, Object> map) {
        List<d.C0281d> listC = dVar.c();
        ArrayList arrayList = new ArrayList();
        for (d.C0281d c0281d : listC) {
            if (c0281d != null && d(c0281d.hc(), jSONObject, map)) {
                arrayList.add(d(c0281d.d()));
            }
        }
        return arrayList;
    }
}
