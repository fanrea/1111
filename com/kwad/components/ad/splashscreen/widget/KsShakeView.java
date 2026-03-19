package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.u.r;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsShakeView extends KSFrameLayout {
    private int Mb;
    private float Mc;
    private int Md;
    private int Me;
    private int Mf;
    private float Mg;
    private float Mh;
    private int Mi;
    private Animator Mj;
    private boolean Mk;
    private ImageView jY;
    private Animator jZ;
    private Paint mPaint;

    public KsShakeView(Context context) {
        this(context, null, 0);
    }

    public KsShakeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.Mk = false;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.Mc = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_outerStrokeWidth, 1.0f);
        this.Md = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_outerStrokeColor, Color.parseColor("#4DFFFFFF"));
        this.Me = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_solidColor, Color.parseColor("#66000000"));
        this.Mb = typedArrayObtainStyledAttributes.getInteger(R.styleable.ksad_KsShakeView_ksad_shakeViewStyle, 1);
        this.Mf = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeColor, Color.parseColor("#B3FFFFFF"));
        this.Mg = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeWidth, 1.0f);
        this.Mi = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_shake_hand);
        this.Mh = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCirclePadding, com.kwad.sdk.c.a.a.a(context, 10.0f));
        typedArrayObtainStyledAttributes.recycle();
        this.jY = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.jY, layoutParams);
        ny();
    }

    private void ny() {
        this.jY.setImageResource(this.Mi);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        Animator animator = this.jZ;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void nB() {
        this.Mk = false;
        Animator animator = this.jZ;
        if (animator != null) {
            animator.cancel();
            this.jZ = null;
        }
        Animator animatorA = a(this.jY, 100L, 16.0f);
        this.jZ = animatorA;
        if (animatorA != null) {
            animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.KsShakeView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (KsShakeView.this.Mk || KsShakeView.this.jZ == null) {
                        return;
                    }
                    KsShakeView.this.jZ.start();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    KsShakeView.this.jY.setRotation(0.0f);
                }
            });
            this.jZ.start();
        }
    }

    public final void aq(int i) {
        this.Mb = i;
        if (i == 2) {
            setIconDrawableRes(R.drawable.ksad_ic_shake_phone);
        } else {
            setIconDrawableRes(R.drawable.ksad_ic_shake_hand);
        }
    }

    public final void b(AnimatorListenerAdapter animatorListenerAdapter) throws Resources.NotFoundException {
        this.Mk = true;
        Animator animator = this.jZ;
        if (animator != null) {
            animator.cancel();
        }
        this.jY.setRotation(0.0f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_splash_shake_animator_height);
        Animator animator2 = this.Mj;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animatorB = b(this, 100L, dimensionPixelSize);
        this.Mj = animatorB;
        animatorB.addListener(animatorListenerAdapter);
        this.Mj.start();
    }

    public final void nC() {
        Animator animator = this.jZ;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.Mj;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.jZ = null;
        this.Mj = null;
    }

    public void setIconDrawableRes(int i) {
        ImageView imageView = this.jY;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float fMin = Math.min(getWidth(), getHeight()) / 2.0f;
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, fMin, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, fMin, this.mPaint);
        if (this.Mb == 2) {
            setInnerCirclePaint(this.mPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, fMin - this.Mh, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.Me);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Mc);
        paint.setColor(this.Md);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Mg);
        paint.setColor(this.Mf);
        paint.setAntiAlias(true);
    }

    private Animator a(View view, long j, float f) {
        Interpolator interpolatorCreate;
        if (view == null) {
            return null;
        }
        if (this.Mb == 1) {
            interpolatorCreate = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else {
            interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth() / 2.0f);
            view.setPivotY(view.getHeight() / 2.0f);
        }
        return r.a(view, interpolatorCreate, 100L, 16.0f);
    }

    private static Animator b(View view, long j, float f) {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", f).setDuration(100L);
        duration.setInterpolator(interpolatorCreate);
        float f2 = -f;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(200L);
        duration2.setInterpolator(interpolatorCreate);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", f).setDuration(200L);
        duration3.setInterpolator(interpolatorCreate);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(200L);
        duration4.setInterpolator(interpolatorCreate);
        animatorSet.playSequentially(duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "translationY", f).setDuration(100L), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(100L));
        return animatorSet;
    }
}
