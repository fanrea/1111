package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class am extends View {
    private Paint a;
    private RectF b;
    private float c;
    private float d;
    private float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private Path m;
    private AnimatorSet n;
    private boolean o;

    public am(Context context) {
        super(context);
        this.a = new Paint(1);
        this.m = new Path();
        this.b = new RectF();
        c();
    }

    public am(Context context, AttributeSet attrs) {
        super(context, attrs);
        c();
    }

    public am(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        c();
    }

    private Animator a(int angle) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rotation", 0.0f, angle, 0.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, (-this.l) * 0.6f, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.am$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.c(valueAnimator);
            }
        });
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(objectAnimatorOfFloat, valueAnimatorOfFloat);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        this.d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private void c() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.am.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                am.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                am.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(ValueAnimator valueAnimator) {
        this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.k = getWidth();
        int height = getHeight();
        this.l = height;
        if (this.k == 0 || height == 0) {
            return;
        }
        this.a.setStyle(Paint.Style.STROKE);
        int iDipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        this.g = iDipsToIntPixels;
        this.a.setStrokeWidth(iDipsToIntPixels);
        this.a.setColor(-1);
        this.f = (int) ((this.k / (this.g * 75.0f)) * Dips.dipsToIntPixels(5.0f, getContext()));
        setLayerType(2, null);
        float f = this.k;
        int i = this.g;
        this.h = Math.max((int) ((f / (i * 25.0f)) * i * 11.0f), i * 3);
        float f2 = this.k;
        int i2 = this.g;
        this.i = Math.max((int) ((f2 / (i2 * 25.0f)) * 3.0f * i2), i2 * 2);
        float f3 = this.k;
        int i3 = this.g;
        this.j = Math.max((int) ((f3 / (i3 * 25.0f)) * 11.0f * i3), i3 * 5);
        e();
    }

    private void e() {
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.n = new AnimatorSet();
        this.n.playSequentially(a(-45), a(45), getFlipLeftAnimation(), getFlipRightAnimation());
        this.n.addListener(new Animator.AnimatorListener() { // from class: com.sigmob.sdk.base.views.am.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (am.this.n == null || !am.this.o) {
                    return;
                }
                am.this.n.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        if (this.o) {
            this.n.start();
        }
    }

    private Animator getFlipLeftAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rotationY", 0.0f, 45.0f, 0.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.k * 0.6f, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.am$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.b(valueAnimator);
            }
        });
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(objectAnimatorOfFloat, valueAnimatorOfFloat);
        return animatorSet;
    }

    private Animator getFlipRightAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rotationY", 0.0f, -45.0f, 0.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, (-this.k) * 0.6f, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.am$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.a(valueAnimator);
            }
        });
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(objectAnimatorOfFloat, valueAnimatorOfFloat);
        return animatorSet;
    }

    public void a() {
        this.o = true;
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void b() {
        this.o = false;
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k == 0 || this.l == 0) {
            return;
        }
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(-1);
        this.m.reset();
        RectF rectF = this.b;
        int i = this.g;
        rectF.set(i, i, this.k - i, this.l - i);
        Path path = this.m;
        RectF rectF2 = this.b;
        int i2 = this.f;
        path.addRoundRect(rectF2, i2, i2, Path.Direction.CCW);
        canvas.drawPath(this.m, this.a);
        canvas.clipPath(this.m);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(-7829368);
        this.a.setAlpha(204);
        canvas.drawRect(0.0f, 0.0f, this.k, this.l, this.a);
        this.a.setColor(-3355444);
        this.a.setAlpha(255);
        int i3 = this.l;
        canvas.drawRect(0.0f, i3 + this.c, this.k, i3, this.a);
        float f = this.d;
        canvas.drawRect(((-this.k) * 0.6f) + f, 0.0f, f, this.l, this.a);
        int i4 = this.k;
        float f2 = this.e;
        canvas.drawRect(i4 + f2, 0.0f, (i4 * 1.6f) + f2, this.l, this.a);
        this.a.setStyle(Paint.Style.FILL);
        int i5 = (this.k - this.h) / 2;
        int i6 = this.l - this.j;
        if (Build.VERSION.SDK_INT < 21) {
            canvas.drawRect(i5, i6, i5 + this.h, i6 + this.i, this.a);
            return;
        }
        float f3 = i5 + this.h;
        int i7 = this.i;
        canvas.drawRoundRect(i5, i6, f3, i6 + i7, i7, i7, this.a);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        c();
    }
}
