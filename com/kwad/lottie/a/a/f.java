package com.kwad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.kwad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f implements d, j, a.InterfaceC0568a {
    private final com.kwad.lottie.f bjz;
    private final com.kwad.lottie.a.b.a<Integer, Integer> blF;
    private final Path blk;
    private final com.kwad.lottie.model.layer.a bln;
    private final Paint blq;
    private final com.kwad.lottie.a.b.a<Integer, Integer> bls;
    private com.kwad.lottie.a.b.a<ColorFilter, ColorFilter> blv;
    private final List<l> blw;
    private final String name;

    public f(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, com.kwad.lottie.model.content.i iVar) {
        Path path = new Path();
        this.blk = path;
        this.blq = new Paint(1);
        this.blw = new ArrayList();
        this.bln = aVar;
        this.name = iVar.getName();
        this.bjz = fVar;
        if (iVar.RV() == null || iVar.Rp() == null) {
            this.blF = null;
            this.bls = null;
            return;
        }
        path.setFillType(iVar.getFillType());
        com.kwad.lottie.a.b.a<Integer, Integer> aVarRj = iVar.RV().Rj();
        this.blF = aVarRj;
        aVarRj.b(this);
        aVar.a(aVarRj);
        com.kwad.lottie.a.b.a<Integer, Integer> aVarRj2 = iVar.Rp().Rj();
        this.bls = aVarRj2;
        aVarRj2.b(this);
        aVar.a(aVarRj2);
    }

    @Override // com.kwad.lottie.a.b.a.InterfaceC0568a
    public final void Qz() {
        this.bjz.invalidateSelf();
    }

    @Override // com.kwad.lottie.a.a.b
    public final void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list2.size(); i++) {
            b bVar = list2.get(i);
            if (bVar instanceof l) {
                this.blw.add((l) bVar);
            }
        }
    }

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.name;
    }

    @Override // com.kwad.lottie.a.a.d
    public final void a(Canvas canvas, Matrix matrix, int i) {
        com.kwad.lottie.c.beginSection("FillContent#draw");
        this.blq.setColor(this.blF.getValue().intValue());
        this.blq.setAlpha(com.kwad.lottie.d.e.clamp((int) ((((i / 255.0f) * this.bls.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.kwad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.blv;
        if (aVar != null) {
            this.blq.setColorFilter(aVar.getValue());
        }
        this.blk.reset();
        for (int i2 = 0; i2 < this.blw.size(); i2++) {
            this.blk.addPath(this.blw.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.blk, this.blq);
        com.kwad.lottie.c.dg("FillContent#draw");
    }

    @Override // com.kwad.lottie.a.a.d
    public final void a(RectF rectF, Matrix matrix) {
        this.blk.reset();
        for (int i = 0; i < this.blw.size(); i++) {
            this.blk.addPath(this.blw.get(i).getPath(), matrix);
        }
        this.blk.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.kwad.lottie.model.f
    public final void a(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
        com.kwad.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        if (t == com.kwad.lottie.i.bkx) {
            this.blF.a(cVar);
            return;
        }
        if (t == com.kwad.lottie.i.bkA) {
            this.bls.a(cVar);
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
            this.bln.a(this.blv);
        }
    }
}
