package com.bytedance.sdk.component.adexpress.dynamic.c;

import com.bytedance.sdk.component.utils.mq;
import com.luck.picture.lib.config.PictureMimeType;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt {
    public static void d(String str, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectPh = com.bytedance.sdk.component.adexpress.hc.ph(str);
        if (jSONObjectPh == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectPh.optJSONObject("values");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        d(jSONObjectOptJSONObject, jSONObject);
    }

    public static JSONObject d(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectPh = com.bytedance.sdk.component.adexpress.hc.ph(str);
        if (jSONObjectPh == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return d(jSONObject2, jSONObjectPh.optJSONObject("themeValues"), jSONObject);
    }

    private static void d(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    mq.d(e);
                }
            }
        }
    }

    public static JSONObject d(JSONObject... jSONObjectArr) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException e) {
                        mq.d(e);
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String d(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectPh = com.bytedance.sdk.component.adexpress.hc.ph(str);
        if (jSONObjectPh == null || (jSONObjectOptJSONObject = jSONObjectPh.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("data");
    }

    public static String d(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectPh = com.bytedance.sdk.component.adexpress.hc.ph(str);
        if (jSONObjectPh == null || (jSONObjectOptJSONObject = jSONObjectPh.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(str2);
    }

    public static JSONObject d(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject("values");
    }

    public static String hc(String str, String str2) {
        if (com.bytedance.sdk.component.adexpress.c.d()) {
            if (str.indexOf(46) < 0) {
                str = str + PictureMimeType.PNG;
            }
            return str2 + "static/images/" + str;
        }
        return d.d(str);
    }
}
