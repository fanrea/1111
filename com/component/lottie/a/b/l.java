package com.component.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class l extends i<PointF> {
    private final PointF d;
    private final float[] e;
    private final PathMeasure f;
    private k g;

    public l(List<? extends com.component.lottie.h.a<PointF>> list) {
        super(list);
        this.d = new PointF();
        this.e = new float[2];
        this.f = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.component.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(com.component.lottie.h.a<PointF> aVar, float f) {
        PointF pointF;
        k kVar = (k) aVar;
        Path pathB = kVar.b();
        if (pathB == null) {
            return aVar.a;
        }
        if (this.c != null && (pointF = (PointF) this.c.a(kVar.f, kVar.g.floatValue(), (PointF) kVar.a, (PointF) kVar.b, d(), f, h())) != null) {
            return pointF;
        }
        if (this.g != kVar) {
            this.f.setPath(pathB, false);
            this.g = kVar;
        }
        this.f.getPosTan(f * this.f.getLength(), this.e, null);
        this.d.set(this.e[0], this.e[1]);
        return this.d;
    }
}
