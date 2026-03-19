package com.bytedance.sdk.component.hc.d.d.hc;

import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.tt;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements tt.d {
    int b = 0;
    List<tt> d;
    k hc;

    hc(List<tt> list, k kVar) {
        this.d = list;
        this.hc = kVar;
    }

    @Override // com.bytedance.sdk.component.hc.d.tt.d
    public k d() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.hc.d.tt.d
    public cb d(k kVar) throws IOException {
        this.hc = kVar;
        int i = this.b + 1;
        this.b = i;
        return this.d.get(i).d(this);
    }
}
