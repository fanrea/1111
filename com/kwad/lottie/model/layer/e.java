package com.kwad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.kwad.lottie.model.content.j;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends a {
    private final com.kwad.lottie.a.a.c bme;

    e(com.kwad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        com.kwad.lottie.a.a.c cVar = new com.kwad.lottie.a.a.c(fVar, this, new j("__container", layer.Re()));
        this.bme = cVar;
        cVar.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.kwad.lottie.model.layer.a
    final void b(Canvas canvas, Matrix matrix, int i) {
        this.bme.a(canvas, matrix, i);
    }

    @Override // com.kwad.lottie.model.layer.a, com.kwad.lottie.a.a.d
    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.bme.a(rectF, this.bou);
    }

    @Override // com.kwad.lottie.model.layer.a
    protected final void b(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
        this.bme.a(eVar, i, list, eVar2);
    }
}
