package com.tachikoma.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d extends a {
    @Override // com.tachikoma.lottie.model.layer.a
    final void b(Canvas canvas, Matrix matrix, int i) {
    }

    d(com.tachikoma.lottie.g gVar, Layer layer) {
        super(gVar, layer);
    }

    @Override // com.tachikoma.lottie.model.layer.a, com.tachikoma.lottie.a.a.e
    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
