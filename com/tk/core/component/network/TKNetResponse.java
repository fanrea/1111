package com.tk.core.component.network;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKNetResponse implements Serializable {
    public String data;
    public String headers;
    public int statusCode;

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("statusCode", this.statusCode);
            jSONObject.put("headers", this.headers);
            jSONObject.put("data", this.data);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
