package com.tachikoma.lottie.model.a;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class i implements m<PointF, PointF> {
    private final b KZ;
    private final b La;

    public i(b bVar, b bVar2) {
        this.KZ = bVar;
        this.La = bVar2;
    }

    @Override // com.tachikoma.lottie.model.a.m
    public final List<com.tachikoma.lottie.e.a<PointF>> kD() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.tachikoma.lottie.model.a.m
    public final boolean kC() {
        return this.KZ.kC() && this.La.kC();
    }

    @Override // com.tachikoma.lottie.model.a.m
    public final com.tachikoma.lottie.a.b.a<PointF, PointF> kB() {
        return new com.tachikoma.lottie.a.b.m(this.KZ.kB(), this.La.kB());
    }
}
