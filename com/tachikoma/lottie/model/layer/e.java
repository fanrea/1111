package com.tachikoma.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.tachikoma.lottie.model.content.j;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e extends a {
    private final com.tachikoma.lottie.a.a.d Jx;

    e(com.tachikoma.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.Jx = new com.tachikoma.lottie.a.a.d(gVar, this, new j("__container", layer.kw(), false));
        this.Jx.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.tachikoma.lottie.model.layer.a
    final void b(Canvas canvas, Matrix matrix, int i) {
        this.Jx.a(canvas, matrix, i);
    }

    @Override // com.tachikoma.lottie.model.layer.a, com.tachikoma.lottie.a.a.e
    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.Jx.a(rectF, this.Mk, z);
    }

    @Override // com.tachikoma.lottie.model.layer.a
    protected final void b(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2) {
        this.Jx.a(dVar, i, list, dVar2);
    }
}
