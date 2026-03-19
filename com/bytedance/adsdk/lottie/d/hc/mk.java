package com.bytedance.adsdk.lottie.d.hc;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk extends h<PointF> {
    private final PointF c;

    public mk(List<com.bytedance.adsdk.lottie.an.d<PointF>> list) {
        super(list);
        this.c = new PointF();
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public PointF d(com.bytedance.adsdk.lottie.an.d<PointF> dVar, float f) {
        return d(dVar, f, f, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.lottie.d.hc.d
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public PointF d(com.bytedance.adsdk.lottie.an.d<PointF> dVar, float f, float f2, float f3) {
        PointF pointF;
        if (dVar.d == null || dVar.hc == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = dVar.d;
        PointF pointF3 = dVar.hc;
        if (this.b != null && (pointF = (PointF) this.b.d(dVar.an, dVar.h.floatValue(), pointF2, pointF3, f, c(), gb())) != null) {
            return pointF;
        }
        this.c.set(pointF2.x + (f2 * (pointF3.x - pointF2.x)), pointF2.y + (f3 * (pointF3.y - pointF2.y)));
        return this.c;
    }
}
