package com.kwad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i extends f<PointF> {
    private final PointF bmt;
    private final float[] bmu;
    private h bmv;
    private PathMeasure bmw;

    public i(List<? extends com.kwad.lottie.e.a<PointF>> list) {
        super(list);
        this.bmt = new PointF();
        this.bmu = new float[2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.lottie.a.b.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public PointF a(com.kwad.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        h hVar = (h) aVar;
        Path path = hVar.getPath();
        if (path == null) {
            return aVar.bpN;
        }
        if (this.bmn != null && (pointF = (PointF) this.bmn.b(hVar.bjS, hVar.bpQ.floatValue(), hVar.bpN, hVar.bpO, QO(), f, getProgress())) != null) {
            return pointF;
        }
        if (this.bmv != hVar) {
            this.bmw = new PathMeasure(path, false);
            this.bmv = hVar;
        }
        PathMeasure pathMeasure = this.bmw;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.bmu, null);
        PointF pointF2 = this.bmt;
        float[] fArr = this.bmu;
        pointF2.set(fArr[0], fArr[1]);
        return this.bmt;
    }
}
