package com.bytedance.adsdk.lottie.model.d;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements uo<PointF, PointF> {
    private final List<com.bytedance.adsdk.lottie.an.d<PointF>> d;

    public u(List<com.bytedance.adsdk.lottie.an.d<PointF>> list) {
        this.d = list;
    }

    @Override // com.bytedance.adsdk.lottie.model.d.uo
    public List<com.bytedance.adsdk.lottie.an.d<PointF>> b() {
        return this.d;
    }

    @Override // com.bytedance.adsdk.lottie.model.d.uo
    public boolean hc() {
        return this.d.size() == 1 && this.d.get(0).u();
    }

    @Override // com.bytedance.adsdk.lottie.model.d.uo
    public com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> d() {
        if (this.d.get(0).u()) {
            return new com.bytedance.adsdk.lottie.d.hc.mk(this.d);
        }
        return new com.bytedance.adsdk.lottie.d.hc.tc(this.d);
    }
}
