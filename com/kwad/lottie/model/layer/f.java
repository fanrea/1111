package com.kwad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.kwad.lottie.a.b.p;
import com.kwad.lottie.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends a {
    private final Path blk;
    private final RectF blm;
    private final Paint blq;
    private com.kwad.lottie.a.b.a<ColorFilter, ColorFilter> blv;
    private final Layer bov;
    private final float[] points;

    f(com.kwad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.blm = new RectF();
        Paint paint = new Paint();
        this.blq = paint;
        this.points = new float[8];
        this.blk = new Path();
        this.bov = layer;
        paint.setAlpha(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(layer.getSolidColor());
    }

    @Override // com.kwad.lottie.model.layer.a
    public final void b(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.bov.getSolidColor());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * this.bmd.QX().getValue().intValue()) / 100.0f) * 255.0f);
        this.blq.setAlpha(iIntValue);
        com.kwad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.blv;
        if (aVar != null) {
            this.blq.setColorFilter(aVar.getValue());
        }
        if (iIntValue > 0) {
            float[] fArr = this.points;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.bov.So();
            float[] fArr2 = this.points;
            fArr2[3] = 0.0f;
            fArr2[4] = this.bov.So();
            this.points[5] = this.bov.Sn();
            float[] fArr3 = this.points;
            fArr3[6] = 0.0f;
            fArr3[7] = this.bov.Sn();
            matrix.mapPoints(this.points);
            this.blk.reset();
            Path path = this.blk;
            float[] fArr4 = this.points;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.blk;
            float[] fArr5 = this.points;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.blk;
            float[] fArr6 = this.points;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.blk;
            float[] fArr7 = this.points;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.blk;
            float[] fArr8 = this.points;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.blk.close();
            canvas.drawPath(this.blk, this.blq);
        }
    }

    @Override // com.kwad.lottie.model.layer.a, com.kwad.lottie.a.a.d
    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.blm.set(0.0f, 0.0f, this.bov.So(), this.bov.Sn());
        this.bou.mapRect(this.blm);
        rectF.set(this.blm);
    }

    @Override // com.kwad.lottie.model.layer.a, com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        super.a((f) t, (com.kwad.lottie.e.c<f>) cVar);
        if (t == i.bkU) {
            if (cVar == null) {
                this.blv = null;
            } else {
                this.blv = new p(cVar);
            }
        }
    }
}
