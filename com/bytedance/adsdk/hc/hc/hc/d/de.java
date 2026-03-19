package com.bytedance.adsdk.hc.hc.hc.d;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class de implements com.bytedance.adsdk.hc.hc.hc.d {
    private final String d;

    public de(String str) {
        this.d = str;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public Object d(Map<String, JSONObject> map) {
        Object objD;
        if (map == null || map.size() <= 0 || (objD = d(this.d, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objD;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public com.bytedance.adsdk.hc.hc.c.u d() {
        return com.bytedance.adsdk.hc.hc.c.an.VARIABLE;
    }

    public String toString() {
        return "VariableNode [literals=" + this.d + "]";
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public String hc() {
        return this.d;
    }

    public Object d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d(str.split("\\."), 0, jSONObject);
    }

    private Object d(String[] strArr, int i, JSONObject jSONObject) throws NumberFormatException {
        Object objOpt;
        if (strArr != null && strArr.length > 0 && i < strArr.length && jSONObject != null) {
            String str = strArr[i];
            int iIndexOf = str.indexOf("[");
            int iIndexOf2 = str.indexOf("]");
            if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf > iIndexOf2) {
                objOpt = jSONObject.opt(str);
            } else {
                String strSubstring = str.substring(0, iIndexOf);
                try {
                    int i2 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                    Object objOpt2 = jSONObject.opt(strSubstring);
                    objOpt = objOpt2 instanceof JSONArray ? ((JSONArray) objOpt2).opt(i2) : null;
                } catch (NumberFormatException e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                    return null;
                }
            }
            if (i == strArr.length - 1) {
                return objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return d(strArr, i + 1, new JSONObject((String) objOpt));
                } catch (JSONException e2) {
                    com.bytedance.sdk.component.utils.mq.d(e2);
                    return objOpt;
                }
            }
            if (objOpt instanceof JSONObject) {
                return d(strArr, i + 1, (JSONObject) objOpt);
            }
        }
        return null;
    }
}
