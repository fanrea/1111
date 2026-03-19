package com.bytedance.adsdk.lottie.d.hc;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc extends h<PointF> {
    private final PathMeasure an;
    private final PointF c;
    private tt h;
    private final float[] u;

    public tc(List<? extends com.bytedance.adsdk.lottie.an.d<PointF>> list) {
        super(list);
        this.c = new PointF();
        this.u = new float[2];
        this.an = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.adsdk.lottie.d.hc.d
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public PointF d(com.bytedance.adsdk.lottie.an.d<PointF> dVar, float f) {
        PointF pointF;
        tt ttVar = (tt) dVar;
        Path pathHc = ttVar.hc();
        if (pathHc == null) {
            return dVar.d;
        }
        if (this.b != null && (pointF = (PointF) this.b.d(ttVar.an, ttVar.h.floatValue(), ttVar.d, ttVar.hc, c(), f, gb())) != null) {
            return pointF;
        }
        if (this.h != ttVar) {
            this.an.setPath(pathHc, false);
            this.h = ttVar;
        }
        PathMeasure pathMeasure = this.an;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.u, null);
        PointF pointF2 = this.c;
        float[] fArr = this.u;
        pointF2.set(fArr[0], fArr[1]);
        return this.c;
    }
}
