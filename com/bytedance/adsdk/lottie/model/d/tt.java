package com.bytedance.adsdk.lottie.model.d;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt implements uo<PointF, PointF> {
    private final hc d;
    private final hc hc;

    public tt(hc hcVar, hc hcVar2) {
        this.d = hcVar;
        this.hc = hcVar2;
    }

    @Override // com.bytedance.adsdk.lottie.model.d.uo
    public List<com.bytedance.adsdk.lottie.an.d<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.bytedance.adsdk.lottie.model.d.uo
    public boolean hc() {
        return this.d.hc() && this.hc.hc();
    }

    @Override // com.bytedance.adsdk.lottie.model.d.uo
    public com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> d() {
        return new com.bytedance.adsdk.lottie.d.hc.k(this.d.d(), this.hc.d());
    }
}
