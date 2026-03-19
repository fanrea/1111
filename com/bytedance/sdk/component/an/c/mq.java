package com.bytedance.sdk.component.an.c;

import com.bytedance.sdk.component.an.rf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq extends d {
    @Override // com.bytedance.sdk.component.an.c.tt
    public String d() {
        return "raw_cache";
    }

    @Override // com.bytedance.sdk.component.an.c.tt
    public void d(com.bytedance.sdk.component.an.b.b bVar) {
        byte[] bArrD = bVar.jh().hc(bVar.sy()).d((rf) bVar.an());
        if (bArrD == null) {
            bVar.d(new an());
        } else {
            bVar.d(new hc(bArrD, null));
        }
    }
}
