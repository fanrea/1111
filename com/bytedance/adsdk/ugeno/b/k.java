package com.bytedance.adsdk.ugeno.b;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k {
    private JSONObject b;
    private Map<String, Object> c;
    private Context d;
    private JSONObject hc;

    public Context getContext() {
        return this.d;
    }

    public void d(Context context) {
        this.d = context;
    }

    public void d(JSONObject jSONObject) {
        this.hc = jSONObject;
    }

    public JSONObject d() {
        return this.b;
    }

    public void hc(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public Map<String, Object> hc() {
        return this.c;
    }

    public void d(Map<String, Object> map) {
        this.c = map;
    }
}
