package com.component.a.i;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    private static final String[] b = {com.baidu.mobads.container.adrequest.a.a};
    private static final String c = "target";
    public HashMap<String, JSONObject> a = new HashMap<>();

    public void a(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                for (String str2 : b) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str2);
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                        String strOptString = jSONObjectOptJSONObject.optString("target");
                        if (!str.equals(strOptString) && !TextUtils.isEmpty(strOptString)) {
                            jSONObject.remove(str2);
                            JSONObject jSONObject2 = this.a.get(strOptString);
                            if (jSONObject2 == null) {
                                jSONObject2 = new JSONObject();
                            }
                            jSONObject2.put(str2, jSONObjectOptJSONObject);
                            this.a.put(strOptString, jSONObject2);
                        }
                    }
                }
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
            }
        }
    }

    public void b(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                JSONObject jSONObject2 = this.a.get(str);
                if (jSONObject2 != null && jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, jSONObject2.get(next));
                    }
                }
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
            }
        }
    }
}
