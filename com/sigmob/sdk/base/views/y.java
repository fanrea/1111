package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.views.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class y extends h {
    private final Paint a;
    private final Paint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private final int h;

    public y(final Context context) {
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(-1);
        paint.setAlpha(128);
        paint.setStyle(r.b.e);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(r.b.f);
        paint2.setAlpha(255);
        paint2.setStyle(r.b.h);
        paint2.setAntiAlias(true);
        this.h = Dips.dipsToIntPixels(4.0f, context);
    }

    private void d() {
        this.e = this.c;
    }

    public void a() {
        this.f = 0;
    }

    public void a(final int currentProgress) {
        int i = this.f;
        if (currentProgress >= i) {
            this.e = currentProgress;
            this.f = currentProgress;
        } else if (currentProgress != 0) {
            SigmobLog.d(String.format("Progress not monotonically increasing: last = %d, current = %d", Integer.valueOf(i), Integer.valueOf(currentProgress)));
            d();
        }
        invalidateSelf();
    }

    public void a(final int duration, final int skipOffset) {
        this.c = duration;
        this.d = skipOffset;
        this.g = duration > 0 ? skipOffset / duration : 0.0f;
    }

    @Deprecated
    public float b() {
        return this.g;
    }

    @Deprecated
    public int c() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(final Canvas canvas) {
        canvas.drawRect(getBounds(), this.a);
        int i = this.c;
        canvas.drawRect(getBounds().left, getBounds().top, getBounds().right * (i > 0 ? this.e / i : 0.0f), getBounds().bottom, this.b);
        int i2 = this.d;
        if (i2 <= 0 || i2 >= this.c) {
            return;
        }
        float f = getBounds().right * this.g;
        canvas.drawRect(f, getBounds().top, f + this.h, getBounds().bottom, this.b);
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
