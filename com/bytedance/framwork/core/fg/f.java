package com.bytedance.framwork.core.fg;

import org.json.JSONObject;

/* compiled from: JsonUtils.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class f {
    public static JSONObject a(JSONObject jSONObject, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject(str2);
    }
}
