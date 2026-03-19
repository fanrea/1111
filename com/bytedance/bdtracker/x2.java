package com.bytedance.bdtracker;

import com.bytedance.bdtracker.l0;
import com.bytedance.bdtracker.q2;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class x2 implements b3 {
    public long a;

    public x2(long j) {
        this.a = j;
    }

    @Override // com.bytedance.bdtracker.p2
    public List<String> a() {
        return l0.b.a();
    }

    @Override // com.bytedance.bdtracker.q2
    public void a(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        l0.b.a((b3) this, jSONObject);
    }

    @Override // com.bytedance.bdtracker.q2
    public String b() {
        return "db_delay_interval";
    }

    @Override // com.bytedance.bdtracker.p2
    public int c() {
        return 23;
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
    public List<Integer> f() {
        return CollectionsKt.listOf(new Integer[]{0, 1000, 10000, 60000, Integer.valueOf(com.alipay.sdk.m.e0.a.a), 1200000, 3600000, 21600000});
    }

    @Override // com.bytedance.bdtracker.q2
    public Object g() {
        return Long.valueOf(h());
    }

    public long h() {
        return this.a;
    }
}
