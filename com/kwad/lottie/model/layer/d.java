package com.kwad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends a {
    @Override // com.kwad.lottie.model.layer.a
    final void b(Canvas canvas, Matrix matrix, int i) {
    }

    d(com.kwad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
    }

    @Override // com.kwad.lottie.model.layer.a, com.kwad.lottie.a.a.d
    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
