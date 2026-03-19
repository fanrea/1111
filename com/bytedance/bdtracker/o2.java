package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.bdtracker.l0;
import com.bytedance.bdtracker.q2;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class o2 implements b3 {
    public final long a = 1;
    public String b;
    public long c;

    public o2(String str, long j) {
        this.b = str;
        this.c = j;
    }

    @Override // com.bytedance.bdtracker.p2
    public List<String> a() {
        return TextUtils.isEmpty(this.b) ? l0.b.a() : CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name", com.alipay.sdk.m.p.e.k});
    }

    @Override // com.bytedance.bdtracker.q2
    public void a(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        jSONObject.put(com.alipay.sdk.m.p.e.k, this.b);
        jSONObject.put("api_time", this.c);
    }

    @Override // com.bytedance.bdtracker.q2
    public String b() {
        return "api_usage";
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
        return "sdk_usage";
    }

    @Override // com.bytedance.bdtracker.p2
    public List<Number> f() {
        return l0.b.d();
    }

    @Override // com.bytedance.bdtracker.q2
    public Object g() {
        return Long.valueOf(h());
    }

    public long h() {
        return this.a;
    }
}
