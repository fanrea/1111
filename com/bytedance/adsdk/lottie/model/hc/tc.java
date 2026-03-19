package com.bytedance.adsdk.lottie.model.hc;

import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc implements b {
    private final com.bytedance.adsdk.lottie.model.d.hc an;
    private final com.bytedance.adsdk.lottie.model.d.hc b;
    private final com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> c;
    private final String d;
    private final com.bytedance.adsdk.lottie.model.d.hc gb;
    private final com.bytedance.adsdk.lottie.model.d.hc h;
    private final d hc;
    private final boolean mk;
    private final boolean tc;
    private final com.bytedance.adsdk.lottie.model.d.hc tt;
    private final com.bytedance.adsdk.lottie.model.d.hc u;

    public enum d {
        STAR(1),
        POLYGON(2);

        private final int b;

        d(int i) {
            this.b = i;
        }

        public static d d(int i) {
            for (d dVar : values()) {
                if (dVar.b == i) {
                    return dVar;
                }
            }
            return null;
        }
    }

    public tc(String str, d dVar, com.bytedance.adsdk.lottie.model.d.hc hcVar, com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> uoVar, com.bytedance.adsdk.lottie.model.d.hc hcVar2, com.bytedance.adsdk.lottie.model.d.hc hcVar3, com.bytedance.adsdk.lottie.model.d.hc hcVar4, com.bytedance.adsdk.lottie.model.d.hc hcVar5, com.bytedance.adsdk.lottie.model.d.hc hcVar6, boolean z, boolean z2) {
        this.d = str;
        this.hc = dVar;
        this.b = hcVar;
        this.c = uoVar;
        this.u = hcVar2;
        this.an = hcVar3;
        this.h = hcVar4;
        this.gb = hcVar5;
        this.tt = hcVar6;
        this.tc = z;
        this.mk = z2;
    }

    public String d() {
        return this.d;
    }

    public d getType() {
        return this.hc;
    }

    public com.bytedance.adsdk.lottie.model.d.hc hc() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.d.uo<PointF, PointF> b() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.model.d.hc c() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.model.d.hc u() {
        return this.an;
    }

    public com.bytedance.adsdk.lottie.model.d.hc an() {
        return this.h;
    }

    public com.bytedance.adsdk.lottie.model.d.hc h() {
        return this.gb;
    }

    public com.bytedance.adsdk.lottie.model.d.hc gb() {
        return this.tt;
    }

    public boolean tt() {
        return this.tc;
    }

    public boolean tc() {
        return this.mk;
    }

    @Override // com.bytedance.adsdk.lottie.model.hc.b
    public com.bytedance.adsdk.lottie.d.d.b d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar) {
        return new com.bytedance.adsdk.lottie.d.d.k(gbVar, bVar, this);
    }
}
