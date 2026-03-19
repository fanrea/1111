package com.bytedance.adsdk.lottie.d.hc;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq extends h<com.bytedance.adsdk.lottie.an.c> {
    private final com.bytedance.adsdk.lottie.an.c c;

    public mq(List<com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.an.c>> list) {
        super(list);
        this.c = new com.bytedance.adsdk.lottie.an.c();
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.an.c d(com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.an.c> dVar, float f) {
        com.bytedance.adsdk.lottie.an.c cVar;
        if (dVar.d == null || dVar.hc == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.an.c cVar2 = dVar.d;
        com.bytedance.adsdk.lottie.an.c cVar3 = dVar.hc;
        if (this.b != null && (cVar = (com.bytedance.adsdk.lottie.an.c) this.b.d(dVar.an, dVar.h.floatValue(), cVar2, cVar3, f, c(), gb())) != null) {
            return cVar;
        }
        this.c.d(com.bytedance.adsdk.lottie.u.gb.d(cVar2.d(), cVar3.d(), f), com.bytedance.adsdk.lottie.u.gb.d(cVar2.hc(), cVar3.hc(), f));
        return this.c;
    }
}
