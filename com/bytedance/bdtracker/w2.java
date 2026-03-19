package com.bytedance.bdtracker;

import com.bytedance.bdtracker.l0;
import com.bytedance.bdtracker.q2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class w2 implements r2 {
    public String a;
    public long b;
    public int c = 1;

    @Override // com.bytedance.bdtracker.p2
    public List<String> a() {
        return l0.b.a();
    }

    @Override // com.bytedance.bdtracker.q2
    public void a(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        jSONObject.put(com.alipay.sdk.m.p.e.k, this.a);
        jSONObject.put("api_time", this.b);
    }

    @Override // com.bytedance.bdtracker.q2
    public String b() {
        return "api_call";
    }

    @Override // com.bytedance.bdtracker.p2
    public int c() {
        return 7;
    }

    @Override // com.bytedance.bdtracker.q2
    public JSONObject d() {
        return q2.a.a(this);
    }

    @Override // com.bytedance.bdtracker.q2
    public String e() {
        return "data_statistics";
    }

    @Override // com.bytedance.bdtracker.p2
    public List<Number> f() {
        return l0.b.d();
    }

    @Override // com.bytedance.bdtracker.q2
    public Object g() {
        return Integer.valueOf(this.c);
    }
}
