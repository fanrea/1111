package com.bytedance.adsdk.lottie.d.hc;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends h<Integer> {
    public hc(List<com.bytedance.adsdk.lottie.an.d<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.d.hc.d
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public Integer d(com.bytedance.adsdk.lottie.an.d<Integer> dVar, float f) {
        return Integer.valueOf(b(dVar, f));
    }

    public int b(com.bytedance.adsdk.lottie.an.d<Integer> dVar, float f) {
        Integer num;
        if (dVar.d == null || dVar.hc == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.b != null && (num = (Integer) this.b.d(dVar.an, dVar.h.floatValue(), dVar.d, dVar.hc, f, c(), gb())) != null) {
            return num.intValue();
        }
        return com.bytedance.adsdk.lottie.u.b.d(com.bytedance.adsdk.lottie.u.gb.hc(f, 0.0f, 1.0f), dVar.d.intValue(), dVar.hc.intValue());
    }

    public int tt() {
        return b(b(), u());
    }
}
