package com.bytedance.bdtracker;

import com.bytedance.bdtracker.l0;
import com.bytedance.bdtracker.q2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class s2 implements r2 {
    public final int a;

    public s2(int i) {
        this.a = i;
    }

    @Override // com.bytedance.bdtracker.p2
    public List<String> a() {
        return l0.b.a();
    }

    @Override // com.bytedance.bdtracker.q2
    public String b() {
        return "data_storage_count";
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
        return Integer.valueOf(this.a);
    }

    @Override // com.bytedance.bdtracker.q2
    public void a(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        q2.a.a(jSONObject);
    }
}
