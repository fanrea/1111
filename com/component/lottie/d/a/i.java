package com.component.lottie.d.a;

import android.graphics.PointF;
import com.component.lottie.a.b.p;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i implements m<PointF, PointF> {
    private final b a;
    private final b b;

    public i(b bVar, b bVar2) {
        this.a = bVar;
        this.b = bVar2;
    }

    @Override // com.component.lottie.d.a.m
    public List<com.component.lottie.h.a<PointF>> c() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.component.lottie.d.a.m
    public boolean b() {
        return this.a.b() && this.b.b();
    }

    @Override // com.component.lottie.d.a.m
    public com.component.lottie.a.b.a<PointF, PointF> a() {
        return new p(this.a.a(), this.b.a());
    }
}
