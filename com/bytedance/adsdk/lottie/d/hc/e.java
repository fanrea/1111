package com.bytedance.adsdk.lottie.d.hc;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e extends h<com.bytedance.adsdk.lottie.model.hc> {
    public e(List<com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.model.hc>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.d.hc.d
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.hc d(com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.model.hc> dVar, float f) {
        if (this.b != null) {
            return (com.bytedance.adsdk.lottie.model.hc) this.b.d(dVar.an, dVar.h == null ? Float.MAX_VALUE : dVar.h.floatValue(), dVar.d, dVar.hc == null ? dVar.d : dVar.hc, f, u(), gb());
        }
        if (f != 1.0f || dVar.hc == null) {
            return dVar.d;
        }
        return dVar.hc;
    }
}
