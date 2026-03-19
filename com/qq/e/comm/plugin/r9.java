package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class r9 {
    String a;
    String b;

    public r9(JSONObject jSONObject) {
        s9.a(this, jSONObject);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public static List<r9> a(JSONObject jSONObject) {
        int length;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("materials");
        if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (!JSONObject.NULL.equals(jSONObjectOptJSONObject)) {
                arrayList.add(new r9(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }
}
