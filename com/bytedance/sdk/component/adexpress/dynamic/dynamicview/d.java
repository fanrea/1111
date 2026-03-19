package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends hc {
    private final Bitmap b;
    private final Rect hc = new Rect();
    private final Paint c = new Paint(1);

    public d(Bitmap bitmap, hc hcVar) {
        this.b = bitmap;
        if (hcVar != null) {
            this.d = hcVar.d;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        int iWidth = rect.width();
        int width = this.b.getWidth();
        int height = this.b.getHeight();
        this.hc.set(0, 0, width, height);
        if (height >= iHeight && width >= iWidth) {
            if (width > iWidth) {
                this.hc.left = (width - iWidth) / 2;
                Rect rect2 = this.hc;
                rect2.right = rect2.left + iWidth;
            }
            if (height > iHeight) {
                this.hc.top = (height - iHeight) / 2;
                Rect rect3 = this.hc;
                rect3.bottom = rect3.top + iHeight;
                return;
            }
            return;
        }
        float f = iHeight;
        float f2 = f * 1.0f;
        float f3 = height;
        float f4 = f2 / f3;
        float f5 = iWidth;
        float f6 = 1.0f * f5;
        float f7 = width;
        if (Math.max(f4, f6 / f7) > f4) {
            int i = (int) ((f2 / f5) * f7);
            this.hc.top = (height - i) / 2;
            Rect rect4 = this.hc;
            rect4.bottom = rect4.top + i;
            return;
        }
        int i2 = (int) ((f6 / f) * f3);
        this.hc.left = (width - i2) / 2;
        Rect rect5 = this.hc;
        rect5.right = rect5.left + i2;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hc
    protected void d(Canvas canvas) {
        canvas.drawBitmap(this.b, this.hc, getBounds(), this.c);
    }
}
