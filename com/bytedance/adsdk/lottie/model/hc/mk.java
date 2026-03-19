package com.bytedance.adsdk.lottie.model.hc;

import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk implements b {
    private final com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> b;
    private final com.bytedance.adsdk.lottie.model.d.hc c;
    private final String d;
    private final com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> hc;
    private final boolean u;

    public mk(String str, com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> uoVar, com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> uoVar2, com.bytedance.adsdk.lottie.model.d.hc hcVar, boolean z) {
        this.d = str;
        this.hc = uoVar;
        this.b = uoVar2;
        this.c = hcVar;
        this.u = z;
    }

    public String d() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.d.hc hc() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> b() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> c() {
        return this.hc;
    }

    public boolean u() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.model.hc.b
    public com.bytedance.adsdk.lottie.d.d.b d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar) {
        return new com.bytedance.adsdk.lottie.d.d.e(gbVar, bVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.hc + ", size=" + this.b + '}';
    }
}
