package com.tachikoma.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tachikoma.lottie.a.b.p;
import com.tachikoma.lottie.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends a {
    private final Paint IF;
    private com.tachikoma.lottie.a.b.a<ColorFilter, ColorFilter> IK;
    private final Rect MA;
    private final Rect Mz;

    c(com.tachikoma.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.IF = new com.tachikoma.lottie.a.a(3);
        this.Mz = new Rect();
        this.MA = new Rect();
    }

    @Override // com.tachikoma.lottie.model.layer.a
    public final void b(Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmap = getBitmap();
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        float fMf = com.tachikoma.lottie.d.f.mf();
        this.IF.setAlpha(i);
        com.tachikoma.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.IK;
        if (aVar != null) {
            this.IF.setColorFilter(aVar.getValue());
        }
        canvas.save();
        canvas.concat(matrix);
        this.Mz.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.MA.set(0, 0, (int) (bitmap.getWidth() * fMf), (int) (bitmap.getHeight() * fMf));
        canvas.drawBitmap(bitmap, this.Mz, this.MA, this.IF);
        canvas.restore();
    }

    @Override // com.tachikoma.lottie.model.layer.a, com.tachikoma.lottie.a.a.e
    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        if (getBitmap() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * com.tachikoma.lottie.d.f.mf(), r3.getHeight() * com.tachikoma.lottie.d.f.mf());
            this.Mk.mapRect(rectF);
        }
    }

    private Bitmap getBitmap() {
        return this.Gt.Y(this.Ml.lE());
    }

    @Override // com.tachikoma.lottie.model.layer.a, com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        super.a((c) t, (com.tachikoma.lottie.e.c<c>) cVar);
        if (t == k.Ik) {
            if (cVar == null) {
                this.IK = null;
            } else {
                this.IK = new p(cVar);
            }
        }
    }
}
