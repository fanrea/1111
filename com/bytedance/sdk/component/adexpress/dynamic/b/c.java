package com.bytedance.sdk.component.adexpress.dynamic.b;

import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public String b;
    public String c;
    public List<d> d;
    public String hc;

    public static class d {
        public int d;
        public JSONObject hc;
    }

    public static c d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    d dVar = new d();
                    dVar.d = jSONObjectOptJSONObject.optInt("id");
                    dVar.hc = new JSONObject(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(dVar);
                }
            }
        } catch (JSONException e) {
            mq.d(e);
        }
        cVar.d = arrayList;
        cVar.hc = jSONObject.optString("diff_data");
        cVar.b = jSONObject.optString("style_diff");
        cVar.c = jSONObject.optString("tag_diff");
        return cVar;
    }
}
