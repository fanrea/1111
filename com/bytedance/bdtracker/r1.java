package com.bytedance.bdtracker;

import com.bytedance.applog.log.EventBus;
import com.bytedance.bdtracker.l0;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class r1 implements EventBus.DataFetcher {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ q1 b;

    public r1(q1 q1Var, JSONObject jSONObject) {
        this.b = q1Var;
        this.a = jSONObject;
    }

    @Override // com.bytedance.applog.log.EventBus.DataFetcher
    public Object fetch() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        l0.b.b(this.a, jSONObject2);
        try {
            jSONObject.put("appId", this.b.b.m);
            jSONObject.put("config", jSONObject2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
