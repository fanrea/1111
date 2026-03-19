package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends GradientDrawable {
    protected Path d;
    private final Paint hc;

    public hc() {
        this.d = new Path();
        Paint paint = new Paint(1);
        this.hc = paint;
        paint.setColor(-1);
    }

    public hc(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
        this.d = new Path();
        Paint paint = new Paint(1);
        this.hc = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.d;
        if (path == null || path.isEmpty()) {
            d(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.hc, 31);
        d(canvas);
        this.hc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.d, this.hc);
        this.hc.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    protected void d(Canvas canvas) {
        super.draw(canvas);
    }

    public void update(int i, int i2, int i3, int i4) {
        this.d.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }
}
