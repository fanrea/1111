package com.kwad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.kwad.lottie.model.content.ShapeStroke;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class q extends a {
    private final com.kwad.lottie.a.b.a<Integer, Integer> blF;
    private final com.kwad.lottie.model.layer.a bln;
    private com.kwad.lottie.a.b.a<ColorFilter, ColorFilter> blv;
    private final String name;

    public q(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.RB().toPaintCap(), shapeStroke.RC().toPaintJoin(), shapeStroke.RF(), shapeStroke.Rp(), shapeStroke.RA(), shapeStroke.RD(), shapeStroke.RE());
        this.bln = aVar;
        this.name = shapeStroke.getName();
        com.kwad.lottie.a.b.a<Integer, Integer> aVarRj = shapeStroke.RV().Rj();
        this.blF = aVarRj;
        aVarRj.b(this);
        aVar.a(aVarRj);
    }

    @Override // com.kwad.lottie.a.a.a, com.kwad.lottie.a.a.d
    public final void a(Canvas canvas, Matrix matrix, int i) {
        this.blq.setColor(this.blF.getValue().intValue());
        if (this.blv != null) {
            this.blq.setColorFilter(this.blv.getValue());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.name;
    }

    @Override // com.kwad.lottie.a.a.a, com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        super.a((q) t, (com.kwad.lottie.e.c<q>) cVar);
        if (t == com.kwad.lottie.i.bky) {
            this.blF.a(cVar);
            return;
        }
        if (t == com.kwad.lottie.i.bkU) {
            if (cVar == null) {
                this.blv = null;
                return;
            }
            com.kwad.lottie.a.b.p pVar = new com.kwad.lottie.a.b.p(cVar);
            this.blv = pVar;
            pVar.b(this);
            this.bln.a(this.blF);
        }
    }
}
