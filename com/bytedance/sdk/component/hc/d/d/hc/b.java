package com.bytedance.sdk.component.hc.d.d.hc;

import android.text.TextUtils;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends mq {
    public c uo;

    public b(mq.d dVar) {
        super(dVar);
        this.uo = new c();
    }

    @Override // com.bytedance.sdk.component.hc.d.mq
    public com.bytedance.sdk.component.hc.d.c d() {
        return this.uo;
    }

    @Override // com.bytedance.sdk.component.hc.d.mq
    public com.bytedance.sdk.component.hc.d.hc d(k kVar) {
        kVar.d(this);
        if (kVar == null || kVar.hc() == null || kVar.hc().d() == null || TextUtils.isEmpty(kVar.hc().d().toString())) {
            return null;
        }
        return new d(kVar, this.uo);
    }
}
