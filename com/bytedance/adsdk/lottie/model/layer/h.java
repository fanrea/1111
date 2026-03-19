package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends b {
    private final Paint gb;
    protected final com.bytedance.adsdk.lottie.tt h;
    private com.bytedance.adsdk.lottie.d.hc.d<ColorFilter, ColorFilter> mk;
    private com.bytedance.adsdk.lottie.d.hc.d<Bitmap, Bitmap> mq;
    private final Rect tc;
    private final Rect tt;

    h(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2) {
        super(gbVar, gbVar2);
        this.gb = new com.bytedance.adsdk.lottie.d.d(3);
        this.tt = new Rect();
        this.tc = new Rect();
        this.h = gbVar.an(gbVar2.h());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b
    public void hc(Canvas canvas, Matrix matrix, int i) {
        super.hc(canvas, matrix, i);
        Bitmap bitmapK = k();
        if (bitmapK == null || bitmapK.isRecycled() || this.h == null) {
            return;
        }
        float fD = com.bytedance.adsdk.lottie.u.tt.d();
        this.gb.setAlpha(i);
        com.bytedance.adsdk.lottie.d.hc.d<ColorFilter, ColorFilter> dVar = this.mk;
        if (dVar != null) {
            this.gb.setColorFilter(dVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.tt.set(0, 0, bitmapK.getWidth(), bitmapK.getHeight());
        if (this.hc.an()) {
            this.tc.set(0, 0, (int) (this.h.d() * fD), (int) (this.h.hc() * fD));
        } else {
            this.tc.set(0, 0, (int) (bitmapK.getWidth() * fD), (int) (bitmapK.getHeight() * fD));
        }
        canvas.drawBitmap(bitmapK, this.tt, this.tc, this.gb);
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.b, com.bytedance.adsdk.lottie.d.d.u
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        if (this.h != null) {
            float fD = com.bytedance.adsdk.lottie.u.tt.d();
            rectF.set(0.0f, 0.0f, this.h.d() * fD, this.h.hc() * fD);
            this.d.mapRect(rectF);
        }
    }

    private Bitmap k() {
        Bitmap bitmapH;
        com.bytedance.adsdk.lottie.d.hc.d<Bitmap, Bitmap> dVar = this.mq;
        if (dVar != null && (bitmapH = dVar.h()) != null) {
            return bitmapH;
        }
        Bitmap bitmapU = this.hc.u(this.b.h());
        if (bitmapU != null) {
            return bitmapU;
        }
        com.bytedance.adsdk.lottie.tt ttVar = this.h;
        if (ttVar != null) {
            return ttVar.k();
        }
        return null;
    }
}
