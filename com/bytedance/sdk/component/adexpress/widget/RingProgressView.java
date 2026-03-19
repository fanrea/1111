package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RingProgressView extends View {
    private int an;
    private RectF b;
    private float c;
    private Context d;
    private boolean h;
    private Paint hc;
    private ValueAnimator u;

    public RingProgressView(Context context) {
        super(context);
        this.an = 1500;
        this.d = context;
        Paint paint = new Paint();
        this.hc = paint;
        paint.setAntiAlias(true);
        this.hc.setStyle(Paint.Style.STROKE);
        this.hc.setStrokeWidth(10.0f);
        this.hc.setColor(Color.parseColor("#80FFFFFF"));
        this.b = new RectF();
    }

    public void d() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.u = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.an);
        this.u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RingProgressView.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.u.start();
    }

    public void hc() {
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void b() {
        this.h = true;
        invalidate();
    }

    public void setDuration(int i) {
        this.an = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h) {
            return;
        }
        canvas.drawArc(this.b, 270.0f, this.c, false, this.hc);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.b.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }
}
