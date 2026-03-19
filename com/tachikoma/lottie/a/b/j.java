package com.tachikoma.lottie.a.b;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class j extends f<PointF> {
    private final PointF JS;

    public j(List<com.tachikoma.lottie.e.a<PointF>> list) {
        super(list);
        this.JS = new PointF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tachikoma.lottie.a.b.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public PointF a(com.tachikoma.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.NG == null || aVar.NH == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.NG;
        PointF pointF3 = aVar.NH;
        if (this.JG != null && (pointF = (PointF) this.JG.b(aVar.GT, aVar.NJ.floatValue(), pointF2, pointF3, f, kd(), getProgress())) != null) {
            return pointF;
        }
        this.JS.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + (f * (pointF3.y - pointF2.y)));
        return this.JS;
    }
}
