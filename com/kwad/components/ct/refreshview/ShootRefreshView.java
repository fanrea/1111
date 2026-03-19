package com.kwad.components.ct.refreshview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ShootRefreshView extends View implements d {
    public static final Property<ShootRefreshView, Float> aSW;
    public static final Property<ShootRefreshView, Float> aSX;
    private static final float aSY = (float) Math.toDegrees(0.5235987901687622d);
    private static final float aSZ = (float) Math.sqrt(3.0d);
    private final RectF aTa;
    private int aTb;
    private int aTc;
    private int aTd;
    private int aTe;
    private int aTf;
    private int aTg;
    private float aTh;
    private float aTi;
    private float aTj;
    private Shader aTk;
    private boolean aTl;
    private ValueAnimator aTm;
    private float aTn;
    private float aTo;
    private boolean aTp;
    private AnimatorSet apT;
    private final Paint mPaint;
    private int mRadius;

    static {
        String str = null;
        aSW = new Property<ShootRefreshView, Float>(Float.class, str) { // from class: com.kwad.components.ct.refreshview.ShootRefreshView.1
            @Override // android.util.Property
            public final /* synthetic */ Float get(ShootRefreshView shootRefreshView) {
                return c(shootRefreshView);
            }

            @Override // android.util.Property
            public final /* synthetic */ void set(ShootRefreshView shootRefreshView, Float f) {
                a(shootRefreshView, f);
            }

            private static Float c(ShootRefreshView shootRefreshView) {
                return Float.valueOf(shootRefreshView.aTi);
            }

            private static void a(ShootRefreshView shootRefreshView, Float f) {
                shootRefreshView.aTi = f.floatValue();
                shootRefreshView.invalidate();
            }
        };
        aSX = new Property<ShootRefreshView, Float>(Float.class, str) { // from class: com.kwad.components.ct.refreshview.ShootRefreshView.2
            @Override // android.util.Property
            public final /* synthetic */ Float get(ShootRefreshView shootRefreshView) {
                return c(shootRefreshView);
            }

            @Override // android.util.Property
            public final /* synthetic */ void set(ShootRefreshView shootRefreshView, Float f) {
                a(shootRefreshView, f);
            }

            private static Float c(ShootRefreshView shootRefreshView) {
                return Float.valueOf(shootRefreshView.aTj);
            }

            private static void a(ShootRefreshView shootRefreshView, Float f) {
                shootRefreshView.aTj = f.floatValue();
                shootRefreshView.invalidate();
            }
        };
    }

    public ShootRefreshView(Context context) {
        this(context, null);
    }

    public ShootRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShootRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint(1);
        this.aTa = new RectF();
        this.aTp = false;
        JH();
        dJ();
        Eg();
        reset();
    }

    private void JH() {
        this.aTd = -1044481;
        this.aTe = InputDeviceCompat.SOURCE_ANY;
        this.aTf = 234880768;
        this.aTg = com.kwad.sdk.c.a.a.a(getContext(), 1.5f);
        this.aTk = new SweepGradient(0.0f, 0.0f, new int[]{this.aTe, this.aTf}, new float[]{0.3f, 1.0f});
    }

    private void dJ() {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.aTg);
        this.mPaint.setColor(this.aTd);
    }

    private void Eg() {
        JI();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.aTm = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(-1);
        this.aTm.setInterpolator(new LinearInterpolator());
        this.aTm.setDuration(400L);
        this.aTm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ct.refreshview.ShootRefreshView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShootRefreshView.this.aTh = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShootRefreshView.this.invalidate();
            }
        });
    }

    private void JI() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.5235988f);
        valueAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        valueAnimatorOfFloat.setDuration(30L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ct.refreshview.ShootRefreshView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShootRefreshView.this.aTh = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShootRefreshView.this.invalidate();
            }
        });
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(aSW, 0.5235988f, 1.2566371f);
        Property<ShootRefreshView, Float> property = aSX;
        float f = aSY;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolderOfFloat, PropertyValuesHolder.ofFloat(property, -(f / 2.0f), (-(f / 2.0f)) - 120.0f));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfPropertyValuesHolder.setDuration(350L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.apT = animatorSet;
        animatorSet.play(objectAnimatorOfPropertyValuesHolder).after(valueAnimatorOfFloat);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aTl) {
            e(canvas);
        }
        d(canvas);
    }

    private void d(Canvas canvas) {
        canvas.save();
        canvas.translate(this.aTb, this.aTc);
        if (this.aTm.isRunning()) {
            canvas.rotate(this.aTh - 90.0f);
            Shader shader = this.mPaint.getShader();
            Shader shader2 = this.aTk;
            if (shader != shader2) {
                this.mPaint.setShader(shader2);
            }
        } else {
            this.mPaint.setShader(null);
        }
        float f = this.aTo;
        int i = this.mRadius;
        if (f < i * 2) {
            this.aTn = 0.0f;
        } else {
            this.aTn = ((f - (i * 2)) * 360.0f) / (i * 4.0f);
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        int i2 = this.mRadius;
        RectF rectF = new RectF(0.0f - i2, 0.0f - i2, i2 + 0.0f, i2 + 0.0f);
        if (this.aTp) {
            canvas.drawArc(rectF, -90.0f, 360.0f, false, this.mPaint);
        } else {
            canvas.drawArc(rectF, -90.0f, this.aTn, false, this.mPaint);
        }
        canvas.restore();
    }

    private void e(Canvas canvas) {
        int i;
        Canvas canvas2 = canvas;
        this.mPaint.setShader(null);
        canvas.save();
        canvas2.translate(this.aTb, this.aTc);
        canvas2.rotate(-this.aTj);
        int i2 = 0;
        while (i2 < 6) {
            canvas.save();
            canvas2.rotate(i2 * (-60));
            float f = this.aTi;
            if (f > 0.5235988f) {
                double dTan = Math.tan(f);
                double dTan2 = Math.tan(this.aTi + 1.0471976f);
                float f2 = aSZ;
                double d = (dTan - dTan2) * 2.0d;
                int i3 = this.mRadius;
                i = i2;
                canvas.drawLine(0.0f, -i3, i3 * ((float) ((1.0d - (f2 * dTan2)) / d)), ((float) ((((2.0d * dTan2) - dTan) - ((f2 * dTan) * dTan2)) / d)) * i3, this.mPaint);
            } else {
                i = i2;
                double dTan3 = Math.tan(f);
                canvas.drawLine(0.0f, -this.mRadius, (float) (((dTan3 * 2.0d) * this.mRadius) / (Math.pow(dTan3, 2.0d) + 1.0d)), (float) (((Math.pow(dTan3, 2.0d) - 1.0d) * this.mRadius) / (Math.pow(dTan3, 2.0d) + 1.0d)), this.mPaint);
            }
            canvas.restore();
            i2 = i + 1;
            canvas2 = canvas;
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.aTa.set(getPaddingLeft() + 0, getPaddingTop() + 0, i - getPaddingRight(), i2 - getPaddingBottom());
        RectF rectF = this.aTa;
        int i5 = this.aTg;
        rectF.inset(i5, i5);
        this.mRadius = (int) (Math.min(this.aTa.width(), this.aTa.height()) / 2.0f);
        this.aTb = (int) this.aTa.centerX();
        this.aTc = (int) this.aTa.centerY();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        reset();
        super.onDetachedFromWindow();
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void reset() {
        this.aTi = 1.2566371f;
        this.aTj = (-(aSY / 2.0f)) - 240.0f;
        this.aTh = 0.0f;
        invalidate();
        this.aTp = false;
        this.aTl = false;
        this.apT.end();
        this.aTm.end();
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void GT() {
        this.aTh = 0.0f;
        this.aTj = 0.0f;
        this.aTi = 0.0f;
        if (this.apT.isRunning()) {
            this.aTm.end();
        } else {
            this.aTm.start();
        }
        this.aTl = true;
        this.aTp = true;
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void GU() {
        this.apT.start();
        this.aTm.end();
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void x(float f) {
        this.aTo = f;
        invalidate();
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final int GV() {
        return Build.VERSION.SDK_INT > 19 ? 500 : 800;
    }
}
