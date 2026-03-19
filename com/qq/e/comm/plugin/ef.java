package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ef {
    public String a;
    public String b;

    public static boolean a(h4 h4Var) {
        return (h4Var == null || h4Var.Z() == null || h4Var.Z().size() <= 0) ? false : true;
    }

    public static List<ef> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(4);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("element_structure_content");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                ef efVar = new ef();
                JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i);
                efVar.a = jSONObject2.optString("content");
                efVar.b = jSONObject2.optString("icon_url");
                arrayList.add(efVar);
            }
        }
        return arrayList;
    }
}
