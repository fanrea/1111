package com.kwad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.baidu.mobads.container.util.bu;
import com.kwad.lottie.model.content.GradientType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends a {
    private final com.kwad.lottie.a.b.a<com.kwad.lottie.model.content.c, com.kwad.lottie.model.content.c> blF;
    private final LongSparseArray<LinearGradient> blG;
    private final LongSparseArray<RadialGradient> blH;
    private final RectF blJ;
    private final GradientType blK;
    private final com.kwad.lottie.a.b.a<PointF, PointF> blL;
    private final com.kwad.lottie.a.b.a<PointF, PointF> blM;
    private final int blN;
    private final String name;

    public h(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, com.kwad.lottie.model.content.e eVar) {
        super(fVar, aVar, eVar.RB().toPaintCap(), eVar.RC().toPaintJoin(), eVar.RF(), eVar.Rp(), eVar.RA(), eVar.RD(), eVar.RE());
        this.blG = new LongSparseArray<>();
        this.blH = new LongSparseArray<>();
        this.blJ = new RectF();
        this.name = eVar.getName();
        this.blK = eVar.Rw();
        this.blN = (int) (fVar.getComposition().Qd() / 32.0f);
        com.kwad.lottie.a.b.a<com.kwad.lottie.model.content.c, com.kwad.lottie.model.content.c> aVarRj = eVar.Rx().Rj();
        this.blF = aVarRj;
        aVarRj.b(this);
        aVar.a(aVarRj);
        com.kwad.lottie.a.b.a<PointF, PointF> aVarRj2 = eVar.Ry().Rj();
        this.blL = aVarRj2;
        aVarRj2.b(this);
        aVar.a(aVarRj2);
        com.kwad.lottie.a.b.a<PointF, PointF> aVarRj3 = eVar.Rz().Rj();
        this.blM = aVarRj3;
        aVarRj3.b(this);
        aVar.a(aVarRj3);
    }

    @Override // com.kwad.lottie.a.a.a, com.kwad.lottie.a.a.d
    public final void a(Canvas canvas, Matrix matrix, int i) {
        a(this.blJ, matrix);
        if (this.blK == GradientType.Linear) {
            this.blq.setShader(QC());
        } else {
            this.blq.setShader(QD());
        }
        super.a(canvas, matrix, i);
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
        LinearGradient linearGradient2 = new LinearGradient((int) (this.blJ.left + (this.blJ.width() / 2.0f) + value.x), (int) (this.blJ.top + (this.blJ.height() / 2.0f) + value.y), (int) (this.blJ.left + (this.blJ.width() / 2.0f) + value2.x), (int) (this.blJ.top + (this.blJ.height() / 2.0f) + value2.y), value3.getColors(), value3.Rv(), Shader.TileMode.CLAMP);
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
        RadialGradient radialGradient2 = new RadialGradient((int) (this.blJ.left + (this.blJ.width() / 2.0f) + value.x), (int) (this.blJ.top + (this.blJ.height() / 2.0f) + value.y), (float) Math.hypot(((int) ((this.blJ.left + (this.blJ.width() / 2.0f)) + value2.x)) - r4, ((int) ((this.blJ.top + (this.blJ.height() / 2.0f)) + value2.y)) - r0), colors, fArrRv, Shader.TileMode.CLAMP);
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
}
