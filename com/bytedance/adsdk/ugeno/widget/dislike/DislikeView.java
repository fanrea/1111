package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.ugeno.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DislikeView extends View {
    private Paint an;
    private int b;
    private RectF c;
    private b d;
    private Paint gb;
    private float h;
    private int hc;
    private int tt;
    private Paint u;

    public DislikeView(Context context) {
        super(context);
        d();
    }

    private void d() {
        Paint paint = new Paint();
        this.u = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.gb = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.an = paint3;
        paint3.setAntiAlias(true);
        setBackgroundColor(0);
    }

    public void setRadius(float f) {
        this.h = f;
    }

    public void setDislikeColor(int i) {
        this.gb.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.gb.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.u.setStrokeWidth(i);
        this.tt = i;
    }

    public void setBgColor(int i) {
        this.an.setStyle(Paint.Style.FILL);
        this.an.setColor(i);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        b bVar = this.d;
        if (bVar != null) {
            int[] iArrD = bVar.d(i, i2);
            super.onMeasure(iArrD[0], iArrD[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.d(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(0);
        RectF rectF = this.c;
        float f = this.h;
        canvas.drawRoundRect(rectF, f, f, this.an);
        RectF rectF2 = this.c;
        float f2 = this.h;
        canvas.drawRoundRect(rectF2, f2, f2, this.u);
        int i = this.hc;
        int i2 = this.b;
        canvas.drawLine(i * 0.3f, i2 * 0.3f, i * 0.7f, i2 * 0.7f, this.gb);
        int i3 = this.hc;
        int i4 = this.b;
        canvas.drawLine(i3 * 0.7f, i4 * 0.3f, i3 * 0.3f, i4 * 0.7f, this.gb);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.hc = i;
        this.b = i2;
        int i5 = this.tt;
        this.c = new RectF(i5, i5, this.hc - i5, this.b - i5);
        b bVar = this.d;
        if (bVar != null) {
            bVar.hc(i, i2, i3, i4);
        }
    }

    public void d(com.bytedance.adsdk.ugeno.hc.b bVar) {
        this.d = bVar;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.an();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b bVar = this.d;
        if (bVar != null) {
            bVar.d(z);
        }
    }
}
