package com.bytedance.sdk.component.an.c;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends d {
    @Override // com.bytedance.sdk.component.an.c.tt
    public String d() {
        return "generate_key";
    }

    @Override // com.bytedance.sdk.component.an.c.tt
    public void d(com.bytedance.sdk.component.an.b.b bVar) {
        if (TextUtils.isEmpty(bVar.h())) {
            com.bytedance.sdk.component.an.mq mqVarU = bVar.jh().u();
            bVar.hc(mqVarU.d(bVar));
            bVar.d(mqVarU.hc(bVar));
        }
        bVar.d(new h());
    }
}
