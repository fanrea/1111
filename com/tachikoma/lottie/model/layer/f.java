package com.tachikoma.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tachikoma.lottie.a.b.p;
import com.tachikoma.lottie.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f extends a {
    private final RectF IB;
    private final Paint IF;
    private com.tachikoma.lottie.a.b.a<ColorFilter, ColorFilter> IK;
    private final Path Iz;
    private final Layer Ml;
    private final float[] points;

    f(com.tachikoma.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.IB = new RectF();
        this.IF = new com.tachikoma.lottie.a.a();
        this.points = new float[8];
        this.Iz = new Path();
        this.Ml = layer;
        this.IF.setAlpha(0);
        this.IF.setStyle(Paint.Style.FILL);
        this.IF.setColor(layer.getSolidColor());
    }

    @Override // com.tachikoma.lottie.model.layer.a
    public final void b(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.Ml.getSolidColor());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.Jw.ko() == null ? 100 : this.Jw.ko().getValue().intValue())) / 100.0f) * 255.0f);
        this.IF.setAlpha(iIntValue);
        com.tachikoma.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.IK;
        if (aVar != null) {
            this.IF.setColorFilter(aVar.getValue());
        }
        if (iIntValue > 0) {
            float[] fArr = this.points;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.Ml.lL();
            float[] fArr2 = this.points;
            fArr2[3] = 0.0f;
            fArr2[4] = this.Ml.lL();
            this.points[5] = this.Ml.lK();
            float[] fArr3 = this.points;
            fArr3[6] = 0.0f;
            fArr3[7] = this.Ml.lK();
            matrix.mapPoints(this.points);
            this.Iz.reset();
            Path path = this.Iz;
            float[] fArr4 = this.points;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.Iz;
            float[] fArr5 = this.points;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.Iz;
            float[] fArr6 = this.points;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.Iz;
            float[] fArr7 = this.points;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.Iz;
            float[] fArr8 = this.points;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.Iz.close();
            canvas.drawPath(this.Iz, this.IF);
        }
    }

    @Override // com.tachikoma.lottie.model.layer.a, com.tachikoma.lottie.a.a.e
    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.IB.set(0.0f, 0.0f, this.Ml.lL(), this.Ml.lK());
        this.Mk.mapRect(this.IB);
        rectF.set(this.IB);
    }

    @Override // com.tachikoma.lottie.model.layer.a, com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        super.a((f) t, (com.tachikoma.lottie.e.c<f>) cVar);
        if (t == k.Ik) {
            if (cVar == null) {
                this.IK = null;
            } else {
                this.IK = new p(cVar);
            }
        }
    }
}
