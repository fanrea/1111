package com.bytedance.adsdk.ugeno.u;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private d d;
    private List<d> hc;

    public d d() {
        return this.d;
    }

    public List<d> hc() {
        return this.hc;
    }

    public static class d {
        private Map<String, Object> an;
        private String b = "global";
        private String c;
        private String d;
        private String hc;
        private Map<String, String> u;

        public String d() {
            return this.b;
        }

        public void d(String str) {
            this.b = str;
        }

        public String hc() {
            return this.c;
        }

        public void hc(String str) {
            this.c = str;
        }

        public Map<String, String> b() {
            return this.u;
        }

        public void d(Map<String, String> map) {
            this.u = map;
        }

        public void b(String str) {
            this.d = str;
        }

        public String c() {
            return this.d;
        }

        public void c(String str) {
            this.hc = str;
        }

        public String u() {
            return this.hc;
        }

        public String toString() {
            return "Action{scheme='" + this.b + "', name='" + this.c + "', params=" + this.u + ", host='" + this.hc + "', origin='" + this.d + "', extra=" + this.an + '}';
        }
    }

    public static an d(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        an anVar = new an();
        String strOptString = jSONObject.optString(DebugKt.DEBUG_PROPERTY_VALUE_ON);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("handlers");
        anVar.d = mq.d(strOptString, jSONObject2);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            d dVarD = mq.d(jSONArrayOptJSONArray.optString(i), jSONObject2);
            if (dVarD != null) {
                arrayList.add(dVarD);
            }
        }
        anVar.hc = arrayList;
        return anVar;
    }
}
