package com.sigmob.sdk.base.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import com.sigmob.sdk.base.views.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class k extends h {
    private final Paint a;
    private final float b;

    public k() {
        this(8.0f);
    }

    private k(float strokeWidth) {
        this.b = strokeWidth / 2.0f;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(-1);
        paint.setStrokeWidth(strokeWidth);
        paint.setStrokeCap(r.a.f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(final Canvas canvas) {
        int iWidth = getBounds().width();
        int iHeight = getBounds().height();
        float f = this.b;
        float f2 = iHeight;
        float f3 = iWidth;
        canvas.drawLine(f + 0.0f, f2 - f, f3 - f, f + 0.0f, this.a);
        float f4 = this.b;
        canvas.drawLine(f4 + 0.0f, f4 + 0.0f, f3 - f4, f2 - f4, this.a);
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }
}
