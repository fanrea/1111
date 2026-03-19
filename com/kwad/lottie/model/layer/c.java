package com.kwad.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.kwad.lottie.a.b.p;
import com.kwad.lottie.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends a {
    private final Paint blq;
    private com.kwad.lottie.a.b.a<ColorFilter, ColorFilter> blv;
    private final Rect boJ;
    private final Rect boK;

    c(com.kwad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.blq = new Paint(3);
        this.boJ = new Rect();
        this.boK = new Rect();
    }

    @Override // com.kwad.lottie.model.layer.a
    public final void b(Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmap = getBitmap();
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        float fSI = com.kwad.lottie.d.f.SI();
        this.blq.setAlpha(i);
        com.kwad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.blv;
        if (aVar != null) {
            this.blq.setColorFilter(aVar.getValue());
        }
        canvas.save();
        canvas.concat(matrix);
        this.boJ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.boK.set(0, 0, (int) (bitmap.getWidth() * fSI), (int) (bitmap.getHeight() * fSI));
        canvas.drawBitmap(bitmap, this.boJ, this.boK, this.blq);
        canvas.restore();
    }

    @Override // com.kwad.lottie.model.layer.a, com.kwad.lottie.a.a.d
    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        if (getBitmap() != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, r6.getWidth()), Math.min(rectF.bottom, r6.getHeight()));
            this.bou.mapRect(rectF);
        }
    }

    private Bitmap getBitmap() {
        return this.bjz.dk(this.bov.Sh());
    }

    @Override // com.kwad.lottie.model.layer.a, com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        super.a((c) t, (com.kwad.lottie.e.c<c>) cVar);
        if (t == i.bkU) {
            if (cVar == null) {
                this.blv = null;
            } else {
                this.blv = new p(cVar);
            }
        }
    }
}
