package com.component.a.h;

import com.baidu.mobads.annotation.remote.template.ThemeJson;
import com.baidu.mobads.container.l.g;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    private final ThemeJson a = new ThemeJson();

    public void a(JSONObject jSONObject) {
        String strOptString;
        JSONObject jSONObjectA;
        c cVarA;
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.baidu.mobads.container.adrequest.a.a);
                if (jSONObjectOptJSONObject != null && (jSONObjectA = a((strOptString = jSONObjectOptJSONObject.optString("name")))) != null && (cVarA = a(strOptString, jSONObjectA)) != null) {
                    cVarA.a(jSONObject);
                    cVarA.b(jSONObject);
                }
            } catch (Throwable th) {
                g.b(th);
            }
        }
    }

    public JSONObject a(String str) {
        try {
            if ("bookmark_9_16".equals(str)) {
                return new JSONObject(this.a.get916Bookmark());
            }
            return null;
        } catch (Throwable th) {
            g.b(th);
            return null;
        }
    }

    public c a(String str, JSONObject jSONObject) {
        if ("bookmark_9_16".equals(str)) {
            return new a(jSONObject);
        }
        return null;
    }
}
