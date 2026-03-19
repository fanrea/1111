package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends Drawable {
    private int b;
    private RectF c;
    private Paint d;
    private int hc;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public b(int i, int i2) {
        this.b = i;
        this.hc = i2;
        Paint paint = new Paint();
        this.d = paint;
        paint.setColor(0);
        this.d.setAntiAlias(true);
        this.d.setShadowLayer(i2, 0.0f, 0.0f, -16777216);
        this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.hc;
        this.c = new RectF(i + i5, i2 + i5, i3 - i5, i4 - i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.c;
        int i = this.b;
        canvas.drawRoundRect(rectF, i, i, this.d);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }
}
