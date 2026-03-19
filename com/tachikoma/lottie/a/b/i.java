package com.tachikoma.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class i extends f<PointF> {
    private final PointF JS;
    private final float[] JT;
    private h JU;
    private PathMeasure JV;

    public i(List<? extends com.tachikoma.lottie.e.a<PointF>> list) {
        super(list);
        this.JS = new PointF();
        this.JT = new float[2];
        this.JV = new PathMeasure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tachikoma.lottie.a.b.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public PointF a(com.tachikoma.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        h hVar = (h) aVar;
        Path path = hVar.getPath();
        if (path == null) {
            return aVar.NG;
        }
        if (this.JG != null && (pointF = (PointF) this.JG.b(hVar.GT, hVar.NJ.floatValue(), (PointF) hVar.NG, (PointF) hVar.NH, kd(), f, getProgress())) != null) {
            return pointF;
        }
        if (this.JU != hVar) {
            this.JV.setPath(path, false);
            this.JU = hVar;
        }
        PathMeasure pathMeasure = this.JV;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.JT, null);
        PointF pointF2 = this.JS;
        float[] fArr = this.JT;
        pointF2.set(fArr[0], fArr[1]);
        return this.JS;
    }
}
