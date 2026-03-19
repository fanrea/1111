package com.kwad.components.ct.wallpaper.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class SectorProgressView extends View {
    private int bas;
    private RectF bat;
    private RectF bau;
    private float bav;
    private float baw;
    private float bax;
    private float bay;
    private float baz;
    private Paint mPaint;

    public SectorProgressView(Context context) {
        this(context, null);
    }

    public SectorProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SectorProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baz = 2.5f;
        init();
    }

    private void init() {
        this.bas = -1;
        this.baw = 0.0f;
        this.bax = -90.0f;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.bas);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        cY(i3 - i);
        Lu();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF;
        super.onDraw(canvas);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.bav);
        if (this.bat == null || (rectF = this.bau) == null) {
            return;
        }
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.mPaint);
        this.mPaint.reset();
        this.mPaint.setColor(this.bas);
        this.mPaint.setAntiAlias(true);
        canvas.drawArc(this.bat, this.bax, this.baw * 3.6f, true, this.mPaint);
    }

    private void cY(int i) {
        if (i <= 0) {
            this.bav = 0.0f;
            return;
        }
        float f = this.bay;
        if (f > 0.0f) {
            this.bav = f;
        } else {
            this.bav = i * 0.05f;
        }
    }

    private void Lu() {
        float f = this.baz;
        float f2 = this.bav;
        this.bat = new RectF(f * f2, f * f2, getWidth() - (this.baz * this.bav), getHeight() - (this.baz * this.bav));
        float f3 = this.bav;
        this.bau = new RectF(f3, f3, getWidth() - this.bav, getHeight() - this.bav);
    }

    public int getColor() {
        return this.bas;
    }

    public void setColor(int i) {
        this.bas = i;
        invalidate();
    }

    public float getStartAngle() {
        return this.bax;
    }

    public void setStartAngle(float f) {
        this.bax = f - 90.0f;
        invalidate();
    }

    public float getPercent() {
        return this.baw;
    }

    public void setPercent(float f) {
        this.baw = f;
        invalidate();
    }

    public void setOvalSpaceScale(float f) {
        this.baz = f;
    }

    public void setCustomStrokeWidth(float f) {
        this.bay = f;
    }
}
