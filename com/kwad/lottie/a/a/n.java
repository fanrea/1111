package com.kwad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.kwad.lottie.a.b.a;
import com.kwad.lottie.model.content.ShapeTrimPath;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class n implements j, l, a.InterfaceC0568a {
    private final com.kwad.lottie.f bjz;
    private final com.kwad.lottie.a.b.a<?, PointF> blB;
    private final com.kwad.lottie.a.b.a<?, PointF> blC;
    private boolean blE;
    private final Path blk = new Path();
    private final RectF blm = new RectF();
    private r blx;
    private final com.kwad.lottie.a.b.a<?, Float> bma;
    private final String name;

    @Override // com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
    }

    public n(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, com.kwad.lottie.model.content.f fVar2) {
        this.name = fVar2.getName();
        this.bjz = fVar;
        com.kwad.lottie.a.b.a<PointF, PointF> aVarRj = fVar2.Rm().Rj();
        this.blC = aVarRj;
        com.kwad.lottie.a.b.a<PointF, PointF> aVarRj2 = fVar2.Rt().Rj();
        this.blB = aVarRj2;
        com.kwad.lottie.a.b.a<Float, Float> aVarRj3 = fVar2.RP().Rj();
        this.bma = aVarRj3;
        aVar.a(aVarRj);
        aVar.a(aVarRj2);
        aVar.a(aVarRj3);
        aVarRj.b(this);
        aVarRj2.b(this);
        aVarRj3.b(this);
    }

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.name;
    }

    @Override // com.kwad.lottie.a.b.a.InterfaceC0568a
    public final void Qz() {
        invalidate();
    }

    private void invalidate() {
        this.blE = false;
        this.bjz.invalidateSelf();
    }

    @Override // com.kwad.lottie.a.a.b
    public final void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.QI() == ShapeTrimPath.Type.Simultaneously) {
                    this.blx = rVar;
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.kwad.lottie.a.a.l
    public final Path getPath() {
        if (this.blE) {
            return this.blk;
        }
        this.blk.reset();
        PointF value = this.blB.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        com.kwad.lottie.a.b.a<?, Float> aVar = this.bma;
        float fFloatValue = aVar == null ? 0.0f : aVar.getValue().floatValue();
        float fMin = Math.min(f, f2);
        if (fFloatValue > fMin) {
            fFloatValue = fMin;
        }
        PointF value2 = this.blC.getValue();
        this.blk.moveTo(value2.x + f, (value2.y - f2) + fFloatValue);
        this.blk.lineTo(value2.x + f, (value2.y + f2) - fFloatValue);
        if (fFloatValue > 0.0f) {
            float f3 = fFloatValue * 2.0f;
            this.blm.set((value2.x + f) - f3, (value2.y + f2) - f3, value2.x + f, value2.y + f2);
            this.blk.arcTo(this.blm, 0.0f, 90.0f, false);
        }
        this.blk.lineTo((value2.x - f) + fFloatValue, value2.y + f2);
        if (fFloatValue > 0.0f) {
            float f4 = fFloatValue * 2.0f;
            this.blm.set(value2.x - f, (value2.y + f2) - f4, (value2.x - f) + f4, value2.y + f2);
            this.blk.arcTo(this.blm, 90.0f, 90.0f, false);
        }
        this.blk.lineTo(value2.x - f, (value2.y - f2) + fFloatValue);
        if (fFloatValue > 0.0f) {
            float f5 = fFloatValue * 2.0f;
            this.blm.set(value2.x - f, value2.y - f2, (value2.x - f) + f5, (value2.y - f2) + f5);
            this.blk.arcTo(this.blm, 180.0f, 90.0f, false);
        }
        this.blk.lineTo((value2.x + f) - fFloatValue, value2.y - f2);
        if (fFloatValue > 0.0f) {
            float f6 = fFloatValue * 2.0f;
            this.blm.set((value2.x + f) - f6, value2.y - f2, value2.x + f, (value2.y - f2) + f6);
            this.blk.arcTo(this.blm, 270.0f, 90.0f, false);
        }
        this.blk.close();
        com.kwad.lottie.d.f.a(this.blk, this.blx);
        this.blE = true;
        return this.blk;
    }

    @Override // com.kwad.lottie.model.f
    public final void a(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
        com.kwad.lottie.d.e.a(eVar, i, list, eVar2, this);
    }
}
