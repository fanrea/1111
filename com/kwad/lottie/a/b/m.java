package com.kwad.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m extends a<PointF, PointF> {
    private final a<Float, Float> bmA;
    private final PointF bmt;
    private final a<Float, Float> bmz;

    @Override // com.kwad.lottie.a.b.a
    final /* synthetic */ PointF a(com.kwad.lottie.e.a<PointF> aVar, float f) {
        return QW();
    }

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.bmt = new PointF();
        this.bmz = aVar;
        this.bmA = aVar2;
        setProgress(getProgress());
    }

    @Override // com.kwad.lottie.a.b.a
    public final void setProgress(float f) {
        this.bmz.setProgress(f);
        this.bmA.setProgress(f);
        this.bmt.set(this.bmz.getValue().floatValue(), this.bmA.getValue().floatValue());
        for (int i = 0; i < this.bmg.size(); i++) {
            this.bmg.get(i).Qz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.lottie.a.b.a
    /* renamed from: QV, reason: merged with bridge method [inline-methods] */
    public PointF getValue() {
        return QW();
    }

    private PointF QW() {
        return this.bmt;
    }
}
