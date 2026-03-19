package com.bytedance.sdk.component.hc.d.d.d;

import com.bytedance.sdk.component.b.hc.v;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends com.bytedance.sdk.component.hc.d.c {
    v d;

    public h(v vVar) {
        this.d = vVar;
    }

    @Override // com.bytedance.sdk.component.hc.d.c
    public void d(int i) {
        this.d.rf().d(i);
    }

    @Override // com.bytedance.sdk.component.hc.d.c
    public void hc(int i) {
        if (i < 5) {
            this.d.rf().hc(5);
        } else {
            this.d.rf().hc(i);
        }
    }
}
