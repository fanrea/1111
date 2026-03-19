package com.component.lottie.a.b;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class m extends i<PointF> {
    private final PointF d;

    public m(List<com.component.lottie.h.a<PointF>> list) {
        super(list);
        this.d = new PointF();
    }

    @Override // com.component.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(com.component.lottie.h.a<PointF> aVar, float f) {
        return a(aVar, f, f, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.component.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(com.component.lottie.h.a<PointF> aVar, float f, float f2, float f3) {
        PointF pointF;
        if (aVar.a == null || aVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.a;
        PointF pointF3 = aVar.b;
        if (this.c != null && (pointF = (PointF) this.c.a(aVar.f, aVar.g.floatValue(), pointF2, pointF3, f, d(), h())) != null) {
            return pointF;
        }
        this.d.set(pointF2.x + (f2 * (pointF3.x - pointF2.x)), pointF2.y + (f3 * (pointF3.y - pointF2.y)));
        return this.d;
    }
}
