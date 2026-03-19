package com.bytedance.sdk.component.an.hc;

import com.bytedance.sdk.component.an.an;
import com.bytedance.sdk.component.an.h;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c<T> implements an {
    private T b;
    private String c;
    Map<String, String> d;
    private int hc;
    private h u;

    public c(int i, T t, String str) {
        this.hc = i;
        this.b = t;
        this.c = str;
    }

    public c(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.d = map;
    }

    @Override // com.bytedance.sdk.component.an.an
    public h d() {
        return this.u;
    }

    public void d(h hVar) {
        this.u = hVar;
    }

    @Override // com.bytedance.sdk.component.an.an
    public int hc() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.an.an
    public T b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.an.an
    public String c() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.an.an
    public Map<String, String> u() {
        return this.d;
    }
}
