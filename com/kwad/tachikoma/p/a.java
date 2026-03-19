package com.kwad.tachikoma.p;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends View {
    private float EA;
    private float EB;
    private RectF Ex;
    private Rect Ey;
    private int Ez;
    private Paint mPaint;

    public a(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.Ex = new RectF();
        this.Ey = new Rect();
        this.Ez = 1;
        this.EA = 30.0f;
    }

    public final void setCurrent(int i) {
        this.Ez = i;
        invalidate();
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.EB = getMeasuredWidth();
        this.EA = this.EB / 20.0f;
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.EA);
        this.mPaint.setColor(-1);
        float f = this.EB / 2.0f;
        canvas.drawCircle(f, f, f - this.EA, this.mPaint);
        this.mPaint.setColor(-7829368);
        RectF rectF = this.Ex;
        float f2 = this.EA;
        float f3 = this.EB;
        rectF.set(f2, f2, f3 - f2, f3 - f2);
        canvas.drawArc(this.Ex, -90.0f, this.Ez * 3.6f, false, this.mPaint);
    }
}
