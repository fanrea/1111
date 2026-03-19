package com.qq.e.comm.plugin;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vg {
    private String a;
    private String b;
    private a c;
    private int d;

    /* compiled from: A */
    public enum a {
        OK,
        ERROR,
        HANDLER_NOT_FOUND_EXCEPTION,
        JSON_PARSE_EXCEPTION
    }

    public String a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("callbackid", this.a);
            jSONObject.put("status", this.c.ordinal());
            jSONObject.put("data", this.b);
            jSONObject.put("keep", this.d);
        } catch (JSONException unused) {
        }
        return "bridge.callback(" + jSONObject.toString() + ");";
    }

    public vg(ug ugVar, a aVar, String str) {
        this.d = 0;
        this.a = ugVar.b();
        this.c = aVar;
        this.b = str;
    }

    public vg(ug ugVar, a aVar, String str, int i) {
        this(ugVar, aVar, str);
        this.d = i;
    }

    public vg(ug ugVar, a aVar, JSONObject jSONObject) {
        this(ugVar, aVar, jSONObject != null ? jSONObject.toString() : "");
    }

    public vg(ug ugVar, a aVar, JSONObject jSONObject, int i) {
        this(ugVar, aVar, jSONObject != null ? jSONObject.toString() : "");
        this.d = i;
    }
}
