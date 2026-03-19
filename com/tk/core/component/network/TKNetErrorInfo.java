package com.tk.core.component.network;

import com.baidu.mobads.container.util.cm;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKNetErrorInfo implements Serializable {
    public SubErrorInfo apiErrorInfo;
    public int code;
    public String message;

    public static class SubErrorInfo implements Serializable {
        public int code;
        public String message;
    }

    public TKNetErrorInfo(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.code);
            jSONObject.put(cm.V, this.message);
            if (this.apiErrorInfo != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", this.apiErrorInfo.code);
                jSONObject2.put(cm.V, this.apiErrorInfo.message);
                jSONObject.put("apiErrorInfo", jSONObject2);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
