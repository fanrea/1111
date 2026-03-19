package com.component.lottie.h;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e extends f<PointF> {
    private final PointF a;

    @Override // com.component.lottie.h.f, com.component.lottie.h.j
    public /* bridge */ /* synthetic */ Object a(b bVar) {
        return super.a(bVar);
    }

    public e(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.a = new PointF();
    }

    public e(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.a = new PointF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.component.lottie.h.f
    public PointF a(PointF pointF, PointF pointF2, float f) {
        this.a.set(com.component.lottie.g.f.a(pointF.x, pointF2.x, f), com.component.lottie.g.f.a(pointF.y, pointF2.y, f));
        return this.a;
    }
}
