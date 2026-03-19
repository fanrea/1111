package com.bytedance.adsdk.lottie.d.hc;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends h<Float> {
    public c(List<com.bytedance.adsdk.lottie.an.d<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.d.hc.d
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public Float d(com.bytedance.adsdk.lottie.an.d<Float> dVar, float f) {
        return Float.valueOf(b(dVar, f));
    }

    float b(com.bytedance.adsdk.lottie.an.d<Float> dVar, float f) {
        Float f2;
        if (dVar.d == null || dVar.hc == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.b != null && (f2 = (Float) this.b.d(dVar.an, dVar.h.floatValue(), dVar.d, dVar.hc, f, c(), gb())) != null) {
            return f2.floatValue();
        }
        return com.bytedance.adsdk.lottie.u.gb.d(dVar.an(), dVar.h(), f);
    }

    public float tt() {
        return b(b(), u());
    }
}
