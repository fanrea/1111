package com.kwad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.kwad.lottie.a.b.a;
import com.kwad.lottie.model.content.ShapeTrimPath;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e implements j, l, a.InterfaceC0568a {
    private final com.kwad.lottie.f bjz;
    private final com.kwad.lottie.a.b.a<?, PointF> blB;
    private final com.kwad.lottie.a.b.a<?, PointF> blC;
    private final com.kwad.lottie.model.content.a blD;
    private boolean blE;
    private final Path blk = new Path();
    private r blx;
    private final String name;

    public e(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, com.kwad.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.bjz = fVar;
        com.kwad.lottie.a.b.a<PointF, PointF> aVarRj = aVar2.Rt().Rj();
        this.blB = aVarRj;
        com.kwad.lottie.a.b.a<PointF, PointF> aVarRj2 = aVar2.Rm().Rj();
        this.blC = aVarRj2;
        this.blD = aVar2;
        aVar.a(aVarRj);
        aVar.a(aVarRj2);
        aVarRj.b(this);
        aVarRj2.b(this);
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

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.name;
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
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.blk.reset();
        if (this.blD.Ru()) {
            float f5 = -f2;
            this.blk.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.blk.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.blk.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.blk.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.blk.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.blk.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.blk.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.blk.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.blk.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.blk.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF value2 = this.blC.getValue();
        this.blk.offset(value2.x, value2.y);
        this.blk.close();
        com.kwad.lottie.d.f.a(this.blk, this.blx);
        this.blE = true;
        return this.blk;
    }

    @Override // com.kwad.lottie.model.f
    public final void a(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
        com.kwad.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        if (t == com.kwad.lottie.i.bkD) {
            this.blB.a(cVar);
        } else if (t == com.kwad.lottie.i.bkE) {
            this.blC.a(cVar);
        }
    }
}
