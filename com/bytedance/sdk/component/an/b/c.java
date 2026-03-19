package com.bytedance.sdk.component.an.b;

import com.bytedance.sdk.component.an.mk;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c<T> implements mk {
    private int an;
    private T b;
    private T c;
    private String d;
    private boolean gb;
    private Map<String, String> h;
    private String hc;
    private int mk;
    private com.bytedance.sdk.component.an.h tc;
    private boolean tt;
    private int u;

    public c d(b bVar, T t) {
        this.b = t;
        this.d = bVar.h();
        this.hc = bVar.hc();
        this.u = bVar.b();
        this.an = bVar.c();
        this.tt = bVar.cb();
        this.tc = bVar.w();
        this.mk = bVar.yo();
        return this;
    }

    public c d(b bVar, T t, Map<String, String> map, boolean z) {
        this.h = map;
        this.gb = z;
        return d(bVar, t);
    }

    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(1)
    public String d() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(2)
    public String hc() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(3)
    public T b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(4)
    public T c() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(5)
    public void setResult(Object obj) {
        this.c = this.b;
        this.b = obj;
    }

    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(6)
    public int u() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(7)
    public int an() {
        return this.an;
    }

    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(8)
    public Map<String, String> h() {
        return this.h;
    }

    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(9)
    public boolean gb() {
        return this.gb;
    }

    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(10)
    public boolean tt() {
        return this.tt;
    }

    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(11)
    public com.bytedance.sdk.component.an.h tc() {
        return this.tc;
    }

    @Override // com.bytedance.sdk.component.an.mk
    @ATSMethod(12)
    public int mk() {
        return this.mk;
    }
}
