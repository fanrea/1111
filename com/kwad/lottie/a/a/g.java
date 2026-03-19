package com.kwad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.baidu.mobads.container.util.bu;
import com.kwad.lottie.a.b.a;
import com.kwad.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g implements d, j, a.InterfaceC0568a {
    private final com.kwad.lottie.f bjz;
    private final com.kwad.lottie.a.b.a<com.kwad.lottie.model.content.c, com.kwad.lottie.model.content.c> blF;
    private final LongSparseArray<LinearGradient> blG = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> blH = new LongSparseArray<>();
    private final Matrix blI = new Matrix();
    private final RectF blJ;
    private final GradientType blK;
    private final com.kwad.lottie.a.b.a<PointF, PointF> blL;
    private final com.kwad.lottie.a.b.a<PointF, PointF> blM;
    private final int blN;
    private final Path blk;
    private final com.kwad.lottie.model.layer.a bln;
    private final Paint blq;
    private final com.kwad.lottie.a.b.a<Integer, Integer> bls;
    private com.kwad.lottie.a.b.a<ColorFilter, ColorFilter> blv;
    private final List<l> blw;
    private final String name;

    public g(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, com.kwad.lottie.model.content.d dVar) {
        Path path = new Path();
        this.blk = path;
        this.blq = new Paint(1);
        this.blJ = new RectF();
        this.blw = new ArrayList();
        this.bln = aVar;
        this.name = dVar.getName();
        this.bjz = fVar;
        this.blK = dVar.Rw();
        path.setFillType(dVar.getFillType());
        this.blN = (int) (fVar.getComposition().Qd() / 32.0f);
        com.kwad.lottie.a.b.a<com.kwad.lottie.model.content.c, com.kwad.lottie.model.content.c> aVarRj = dVar.Rx().Rj();
        this.blF = aVarRj;
        aVarRj.b(this);
        aVar.a(aVarRj);
        com.kwad.lottie.a.b.a<Integer, Integer> aVarRj2 = dVar.Rp().Rj();
        this.bls = aVarRj2;
        aVarRj2.b(this);
        aVar.a(aVarRj2);
        com.kwad.lottie.a.b.a<PointF, PointF> aVarRj3 = dVar.Ry().Rj();
        this.blL = aVarRj3;
        aVarRj3.b(this);
        aVar.a(aVarRj3);
        com.kwad.lottie.a.b.a<PointF, PointF> aVarRj4 = dVar.Rz().Rj();
        this.blM = aVarRj4;
        aVarRj4.b(this);
        aVar.a(aVarRj4);
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

    @Override // com.kwad.lottie.a.a.d
    public final void a(Canvas canvas, Matrix matrix, int i) {
        Shader shaderQD;
        com.kwad.lottie.c.beginSection("GradientFillContent#draw");
        this.blk.reset();
        for (int i2 = 0; i2 < this.blw.size(); i2++) {
            this.blk.addPath(this.blw.get(i2).getPath(), matrix);
        }
        this.blk.computeBounds(this.blJ, false);
        if (this.blK == GradientType.Linear) {
            shaderQD = QC();
        } else {
            shaderQD = QD();
        }
        this.blI.set(matrix);
        shaderQD.setLocalMatrix(this.blI);
        this.blq.setShader(shaderQD);
        com.kwad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.blv;
        if (aVar != null) {
            this.blq.setColorFilter(aVar.getValue());
        }
        this.blq.setAlpha(com.kwad.lottie.d.e.clamp((int) ((((i / 255.0f) * this.bls.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.blk, this.blq);
        com.kwad.lottie.c.dg("GradientFillContent#draw");
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

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.name;
    }

    private LinearGradient QC() {
        long jQE = QE();
        LinearGradient linearGradient = this.blG.get(jQE);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF value = this.blL.getValue();
        PointF value2 = this.blM.getValue();
        com.kwad.lottie.model.content.c value3 = this.blF.getValue();
        LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.Rv(), Shader.TileMode.CLAMP);
        this.blG.put(jQE, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient QD() {
        long jQE = QE();
        RadialGradient radialGradient = this.blH.get(jQE);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF value = this.blL.getValue();
        PointF value2 = this.blM.getValue();
        com.kwad.lottie.model.content.c value3 = this.blF.getValue();
        int[] colors = value3.getColors();
        float[] fArrRv = value3.Rv();
        RadialGradient radialGradient2 = new RadialGradient(value.x, value.y, (float) Math.hypot(value2.x - r6, value2.y - r7), colors, fArrRv, Shader.TileMode.CLAMP);
        this.blH.put(jQE, radialGradient2);
        return radialGradient2;
    }

    private int QE() {
        int iRound = Math.round(this.blL.getProgress() * this.blN);
        int iRound2 = Math.round(this.blM.getProgress() * this.blN);
        int iRound3 = Math.round(this.blF.getProgress() * this.blN);
        int i = iRound != 0 ? iRound * bu.g : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    @Override // com.kwad.lottie.model.f
    public final void a(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
        com.kwad.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
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
