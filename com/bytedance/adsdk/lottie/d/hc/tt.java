package com.bytedance.adsdk.lottie.d.hc;

import android.graphics.Path;
import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt extends com.bytedance.adsdk.lottie.an.d<PointF> {
    private final com.bytedance.adsdk.lottie.an.d<PointF> mk;
    private Path tc;

    public tt(com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.an.d<PointF> dVar) {
        super(anVar, dVar.d, dVar.hc, dVar.b, dVar.c, dVar.u, dVar.an, dVar.h);
        this.mk = dVar;
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d() {
        boolean z = (this.hc == 0 || this.d == 0 || !((PointF) this.d).equals(((PointF) this.hc).x, ((PointF) this.hc).y)) ? false : true;
        if (this.d == 0 || this.hc == 0 || z) {
            return;
        }
        this.tc = com.bytedance.adsdk.lottie.u.tt.d((PointF) this.d, (PointF) this.hc, this.mk.gb, this.mk.tt);
    }

    Path hc() {
        return this.tc;
    }
}
