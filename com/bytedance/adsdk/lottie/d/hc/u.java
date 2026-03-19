package com.bytedance.adsdk.lottie.d.hc;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends h<com.bytedance.adsdk.lottie.model.hc.c> {
    private final com.bytedance.adsdk.lottie.model.hc.c c;

    public u(List<com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.model.hc.c>> list) {
        super(list);
        com.bytedance.adsdk.lottie.model.hc.c cVar = list.get(0).d;
        int iB = cVar != null ? cVar.b() : 0;
        this.c = new com.bytedance.adsdk.lottie.model.hc.c(new float[iB], new int[iB]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.d.hc.d
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.hc.c d(com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.model.hc.c> dVar, float f) {
        this.c.d(dVar.d, dVar.hc, f);
        return this.c;
    }
}
