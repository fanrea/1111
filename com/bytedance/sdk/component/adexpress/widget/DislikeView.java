package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DislikeView extends View {
    private int an;
    private final RectF b;
    private Paint c;
    private int d;
    private int gb;
    private Paint h;
    private int hc;
    private Paint u;

    public DislikeView(Context context) {
        super(context);
        this.b = new RectF();
        d();
    }

    private void d() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.u = paint3;
        paint3.setAntiAlias(true);
    }

    public void setRadius(int i) {
        this.an = i;
    }

    public void setDislikeColor(int i) {
        this.h.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.h.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.c.setStrokeWidth(i);
        this.gb = i;
    }

    public void setBgColor(int i) {
        this.u.setStyle(Paint.Style.FILL);
        this.u.setColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.b;
        int i = this.an;
        canvas.drawRoundRect(rectF, i, i, this.u);
        RectF rectF2 = this.b;
        int i2 = this.an;
        canvas.drawRoundRect(rectF2, i2, i2, this.c);
        int i3 = this.d;
        int i4 = this.hc;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.h);
        int i5 = this.d;
        int i6 = this.hc;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.h);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = i;
        this.hc = i2;
        RectF rectF = this.b;
        int i5 = this.gb;
        rectF.set(i5, i5, i - i5, i2 - i5);
    }
}
