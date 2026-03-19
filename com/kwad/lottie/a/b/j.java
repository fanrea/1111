package com.kwad.lottie.a.b;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j extends f<PointF> {
    private final PointF bmt;

    public j(List<com.kwad.lottie.e.a<PointF>> list) {
        super(list);
        this.bmt = new PointF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.lottie.a.b.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public PointF a(com.kwad.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.bpN == null || aVar.bpO == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.bpN;
        PointF pointF3 = aVar.bpO;
        if (this.bmn != null && (pointF = (PointF) this.bmn.b(aVar.bjS, aVar.bpQ.floatValue(), pointF2, pointF3, f, QO(), getProgress())) != null) {
            return pointF;
        }
        this.bmt.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + (f * (pointF3.y - pointF2.y)));
        return this.bmt;
    }
}
