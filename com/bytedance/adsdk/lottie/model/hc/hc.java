package com.bytedance.adsdk.lottie.model.hc;

import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements b {
    private final com.bytedance.adsdk.lottie.model.d.an b;
    private final boolean c;
    private final String d;
    private final com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> hc;
    private final boolean u;

    public hc(String str, com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> uoVar, com.bytedance.adsdk.lottie.model.d.an anVar, boolean z, boolean z2) {
        this.d = str;
        this.hc = uoVar;
        this.b = anVar;
        this.c = z;
        this.u = z2;
    }

    @Override // com.bytedance.adsdk.lottie.model.hc.b
    public com.bytedance.adsdk.lottie.d.d.b d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar) {
        return new com.bytedance.adsdk.lottie.d.d.an(gbVar, bVar, this);
    }

    public String d() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> hc() {
        return this.hc;
    }

    public com.bytedance.adsdk.lottie.model.d.an b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean u() {
        return this.u;
    }
}
