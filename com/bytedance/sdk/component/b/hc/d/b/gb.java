package com.bytedance.sdk.component.b.hc.d.b;

import com.bytedance.sdk.component.b.hc.s;
import com.bytedance.sdk.component.b.hc.sy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class gb extends s {
    private final com.bytedance.sdk.component.b.d.u b;
    private final String d;
    private final long hc;

    public gb(String str, long j, com.bytedance.sdk.component.b.d.u uVar) {
        this.d = str;
        this.hc = j;
        this.b = uVar;
    }

    @Override // com.bytedance.sdk.component.b.hc.s
    public sy d() {
        String str = this.d;
        if (str != null) {
            return sy.d(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.b.hc.s
    public long hc() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.b.hc.s
    public com.bytedance.sdk.component.b.d.u b() {
        return this.b;
    }
}
