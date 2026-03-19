package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RippleView extends View {
    private long an;
    private ValueAnimator b;
    private ValueAnimator c;
    private float d;
    private float gb;
    private float h;
    private float hc;
    private int tc;
    private Animator.AnimatorListener tt;
    private Paint u;

    public RippleView(Context context, int i) {
        super(context);
        this.an = 300L;
        this.h = 0.0f;
        this.tc = i;
        d();
    }

    public void d() {
        Paint paint = new Paint(1);
        this.u = paint;
        paint.setStyle(Paint.Style.FILL);
        this.u.setColor(this.tc);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = i / 2.0f;
        this.hc = i2 / 2.0f;
        this.gb = (float) (Math.hypot(i, i2) / 2.0d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.d, this.hc, this.h, this.u);
    }

    public void hc() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.gb);
        this.b = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.an);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.b.start();
    }

    public void b() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.gb, 0.0f);
        this.c = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.an);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.tt;
        if (animatorListener != null) {
            this.c.addListener(animatorListener);
        }
        this.c.start();
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.tt = animatorListener;
    }
}
