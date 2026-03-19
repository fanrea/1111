package com.bytedance.msdk.core.u.hc;

import com.bytedance.sdk.component.utils.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private int an;
    private String b;
    private String c;
    private int d;
    private int h;
    private int hc;
    private int u;

    public String d() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason", this.d);
            jSONObject.put("fill_error_code", this.hc);
            jSONObject.put("fill_error_msg", this.b);
            jSONObject.put("mediation_rit", this.c);
            jSONObject.put("load_sort", this.u);
            jSONObject.put("show_sort", this.an);
            jSONObject.put("has_shown", this.h);
            return jSONObject.toString();
        } catch (JSONException e) {
            mq.d(e);
            return "{\"name\": \"json err\"}";
        }
    }

    public void d(int i) {
        this.h = i;
    }

    public void hc(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.hc = i;
    }

    public void d(String str) {
        this.b = str;
    }

    public void hc(String str) {
        this.c = str;
    }

    public void c(int i) {
        this.u = i;
    }

    public void u(int i) {
        this.an = i;
    }
}
