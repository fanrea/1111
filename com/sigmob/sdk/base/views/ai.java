package com.sigmob.sdk.base.views;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ai extends View {
    private float a;
    private Paint b;
    private Paint c;
    private Paint d;
    private Path e;
    private Path f;
    private Path g;
    private PointF h;
    private PointF i;
    private PointF j;
    private float k;

    public ai(Context context) {
        super(context);
        b();
    }

    public ai(Context context, AttributeSet attrs) {
        super(context, attrs);
        b();
    }

    public ai(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        b();
    }

    private AnimatorSet a(final PointF point, final Paint paint, int duration) {
        int alpha = paint.getAlpha();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(point.y, (point.y - getHeight()) - this.a);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.ai$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.a(point, valueAnimator);
            }
        });
        valueAnimatorOfFloat.setRepeatCount(-1);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(alpha, 0);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.ai$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.a(paint, valueAnimator);
            }
        });
        valueAnimatorOfInt.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(duration * 1000);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfInt);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Paint paint, ValueAnimator valueAnimator) {
        paint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        invalidate();
    }

    private void a(Path path, PointF point) {
        float fTan = (float) (point.x - (this.k * Math.tan(2.0943951023931953d)));
        float f = point.y + this.k;
        float fTan2 = (float) (point.x + (this.k * Math.tan(2.0943951023931953d)));
        float f2 = point.y + this.k;
        path.moveTo(fTan, f);
        path.lineTo(point.x, point.y);
        path.lineTo(fTan2, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(PointF pointF, ValueAnimator valueAnimator) {
        pointF.y = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        c();
        invalidate();
    }

    private void b() {
        float fDipsToIntPixels = Dips.dipsToIntPixels(5.0f, getContext());
        this.a = fDipsToIntPixels;
        this.k = fDipsToIntPixels * 2.0f;
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.a);
        this.b.setColor(-1);
        this.b.setAlpha(255);
        Paint paint2 = new Paint(1);
        this.c = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.a);
        this.c.setColor(-1);
        this.c.setAlpha(127);
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(this.a);
        this.d.setColor(-1);
        this.d.setAlpha(76);
        this.e = new Path();
        this.f = new Path();
        this.g = new Path();
    }

    private void c() {
        this.e.reset();
        this.f.reset();
        this.g.reset();
        a(this.e, this.h);
        a(this.f, this.i);
        a(this.g, this.j);
    }

    public void a() {
        AnimatorSet animatorSetA = a(this.h, this.b, 2);
        AnimatorSet animatorSetA2 = a(this.i, this.c, 2);
        AnimatorSet animatorSetA3 = a(this.j, this.d, 2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorSetA, animatorSetA2, animatorSetA3);
        animatorSet.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.e, this.b);
        canvas.drawPath(this.f, this.c);
        canvas.drawPath(this.g, this.d);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float f = w / 2.0f;
        float f2 = h;
        float fDipsToIntPixels = Dips.dipsToIntPixels(13.0f, getContext());
        this.h = new PointF(f, this.a + f2);
        this.i = new PointF(f, this.a + f2 + fDipsToIntPixels);
        this.j = new PointF(f, f2 + this.a + (fDipsToIntPixels * 2.0f));
        c();
        a();
    }
}
