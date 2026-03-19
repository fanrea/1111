package com.kwad.components.ct.emotion.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends Drawable {
    private Bitmap mBitmap;
    private Paint mPaint = new Paint(3);

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, (Rect) null, getBounds(), this.mPaint);
    }

    public final void setBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.sameAs(this.mBitmap)) {
            return;
        }
        this.mBitmap = bitmap;
        invalidateSelf();
    }
}
