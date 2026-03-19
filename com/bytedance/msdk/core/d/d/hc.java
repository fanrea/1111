package com.bytedance.msdk.core.d.d;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.sy.rf;
import com.bytedance.sdk.openadsdk.core.tc;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements an {
    private Function<SparseArray<Object>, Object> d;
    private String hc;

    @Override // com.bytedance.msdk.core.d.d.an
    public String b() {
        return "g_class_name";
    }

    @Override // com.bytedance.msdk.core.d.d.an
    public String c() {
        return "g_adn_version";
    }

    @Override // com.bytedance.msdk.core.d.d.an
    public String gb() {
        return "gdt";
    }

    @Override // com.bytedance.msdk.core.d.d.an
    public boolean d() {
        return rf.d();
    }

    @Override // com.bytedance.msdk.core.d.d.an
    public Function<SparseArray<Object>, Object> hc() {
        return u.hc("gdt");
    }

    @Override // com.bytedance.msdk.core.d.d.an
    public String u() {
        return tc.w().mt();
    }

    @Override // com.bytedance.msdk.core.d.d.an
    public void d(Function<SparseArray<Object>, Object> function) {
        this.d = function;
    }

    @Override // com.bytedance.msdk.core.d.d.an
    public Function<SparseArray<Object>, Object> an() {
        return this.d;
    }

    @Override // com.bytedance.msdk.core.d.d.an
    public void d(String str) {
        this.hc = str;
    }

    @Override // com.bytedance.msdk.core.d.d.an
    public String h() {
        return this.hc;
    }
}
