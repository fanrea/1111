package com.qq.e.comm.plugin;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class pn extends f5 {
    public pn(f5 f5Var) throws JSONException {
        super(f5Var);
        a("wv_progress", (Object) 1);
        a("is_offline", (Object) 2);
    }

    public pn f(int i) throws JSONException {
        a("lp_type", Integer.valueOf(i));
        return this;
    }

    public pn a(long j) throws JSONException {
        a("cost_time", Long.valueOf(j));
        return this;
    }

    public pn d(int i) throws JSONException {
        a("js_inject_scene", Integer.valueOf(i));
        return this;
    }

    public pn g(int i) throws JSONException {
        a("click_req_type", Integer.valueOf(i));
        return this;
    }

    public pn e(int i) throws JSONException {
        a("origin_error_code", Integer.valueOf(i));
        return this;
    }

    public pn b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return this;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            a(next, jSONObject.opt(next));
        }
        return this;
    }
}
