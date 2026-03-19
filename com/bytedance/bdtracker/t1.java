package com.bytedance.bdtracker;

import com.bytedance.applog.log.EventBus;
import com.bytedance.bdtracker.l0;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class t1 implements EventBus.DataFetcher {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ s1 b;

    public t1(s1 s1Var, JSONObject jSONObject) {
        this.b = s1Var;
        this.a = jSONObject;
    }

    @Override // com.bytedance.applog.log.EventBus.DataFetcher
    public Object fetch() {
        JSONObject jSONObject = new JSONObject();
        l0.b.b(this.a, jSONObject);
        try {
            jSONObject.put("appId", this.b.i.m);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
