package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk extends b {
    private final Paint gb;
    private final RectF h;
    private final gb mk;
    private com.bytedance.adsdk.lottie.d.hc.d<ColorFilter, ColorFilter> mq;
    private final Path tc;
    private final float[] tt;

    mk(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2) {
        super(gbVar, gbVar2);
        this.h = new RectF();
        com.bytedance.adsdk.lottie.d.d dVar = new com.bytedance.adsdk.lottie.d.d();
        this.gb = dVar;
        this.tt = new float[8];
        this.tc = new Path();
        this.mk = gbVar2;
        dVar.setAlpha(0);
        dVar.setStyle(Paint.Style.FILL);
        dVar.setColor(gbVar2.cb());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b
    public void hc(Canvas canvas, Matrix matrix, int i) {
        super.hc(canvas, matrix, i);
        int iAlpha = Color.alpha(this.mk.cb());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.c.d() == null ? 100 : this.c.d().h().intValue())) / 100.0f) * 255.0f);
        this.gb.setAlpha(iIntValue);
        com.bytedance.adsdk.lottie.d.hc.d<ColorFilter, ColorFilter> dVar = this.mq;
        if (dVar != null) {
            this.gb.setColorFilter(dVar.h());
        }
        if (iIntValue > 0) {
            float[] fArr = this.tt;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.mk.yo();
            float[] fArr2 = this.tt;
            fArr2[3] = 0.0f;
            fArr2[4] = this.mk.yo();
            this.tt[5] = this.mk.w();
            float[] fArr3 = this.tt;
            fArr3[6] = 0.0f;
            fArr3[7] = this.mk.w();
            matrix.mapPoints(this.tt);
            this.tc.reset();
            Path path = this.tc;
            float[] fArr4 = this.tt;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.tc;
            float[] fArr5 = this.tt;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.tc;
            float[] fArr6 = this.tt;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.tc;
            float[] fArr7 = this.tt;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.tc;
            float[] fArr8 = this.tt;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.tc.close();
            canvas.drawPath(this.tc, this.gb);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b, com.bytedance.adsdk.lottie.d.d.u
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        this.h.set(0.0f, 0.0f, this.mk.yo(), this.mk.w());
        this.d.mapRect(this.h);
        rectF.set(this.h);
    }
}
