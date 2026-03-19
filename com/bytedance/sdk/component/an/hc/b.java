package com.bytedance.sdk.component.an.hc;

import com.bytedance.sdk.component.an.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements com.bytedance.sdk.component.an.u {
    private boolean b;
    private k c;
    private String d;
    private boolean hc;

    public b(String str, boolean z, boolean z2, k kVar) {
        this.d = str;
        this.hc = z;
        this.b = z2;
        this.c = kVar;
    }

    @Override // com.bytedance.sdk.component.an.u
    public String d() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.an.u
    public boolean hc() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.an.u
    public boolean b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.an.u
    public k c() {
        return this.c;
    }
}
