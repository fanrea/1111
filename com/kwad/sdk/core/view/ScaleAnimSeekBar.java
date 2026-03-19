package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ScaleAnimSeekBar extends View {
    private Drawable alj;
    private boolean als;
    private int bKA;
    private int bKB;
    private int bKC;
    private int bKD;
    private int bKE;
    private int bKF;
    private boolean bKG;
    private int bKH;
    private int bKI;
    private int bKJ;
    private int bKK;
    private int bKL;
    private int bKM;
    private int bKN;
    private GradientDrawable bKO;
    private GradientDrawable bKP;
    private GradientDrawable bKQ;
    private Rect bKR;
    private Rect bKS;
    private Rect bKT;
    private Rect bKU;
    private boolean bKV;
    private boolean bKW;
    private boolean bKX;
    private boolean bKY;
    private WeakReference<a> bKZ;
    private Paint bKx;
    private int bKy;
    private int bKz;
    private boolean bLa;
    private boolean bLb;
    private ValueAnimator bLc;
    private ValueAnimator bLd;
    private ValueAnimator bLe;
    private float bLf;
    private float bLg;
    private float bLh;
    private float bLi;
    private int bLj;
    private boolean bLk;

    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z);

        void wF();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKD = 100;
        this.bKG = false;
        this.alj = null;
        this.bKV = false;
        this.bKW = false;
        this.bKX = false;
        this.bKY = true;
        this.bLa = true;
        this.bLb = false;
        this.bLf = 1.0f;
        this.bLg = 1.34f;
        this.bLh = 1.0f;
        this.bLi = 2.0f;
        init(context, attributeSet);
    }

    private void ci(Context context) {
        this.bLa = true;
        this.bLj = com.kwad.sdk.c.a.a.a(context, 10.0f);
        this.bKB = com.kwad.sdk.c.a.a.a(context, 3.0f);
        this.bKI = com.kwad.sdk.c.a.a.a(context, 20.0f);
        this.alj = null;
        this.bLb = false;
        this.bKF = com.kwad.sdk.c.a.a.a(context, 0.5f);
        this.bKE = com.kwad.sdk.c.a.a.a(context, 1.0f);
        this.bKy = 654311423;
        this.bKz = -1;
        this.bKA = 1090519039;
        this.bKC = 0;
        this.bKD = 100;
        this.bKG = false;
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            ci(context);
        }
        Paint paint = new Paint();
        this.bKx = paint;
        paint.setStyle(Paint.Style.FILL);
        this.bKx.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.bKO = gradientDrawable;
        gradientDrawable.setShape(0);
        this.bKO.setColor(this.bKy);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.bKP = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.bKP.setColor(this.bKz);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.bKQ = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.bKQ.setColor(this.bKA);
        this.bKR = new Rect();
        this.bKS = new Rect();
        this.bKU = new Rect();
        this.bKT = new Rect();
        this.bKJ = this.bKC;
    }

    private void K(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (this.bLa) {
            this.bKH = (int) (i - ((this.bLj * 2) * (this.bLg - this.bLf)));
        } else {
            this.bKH = i - (this.bLj * 2);
        }
        this.bKR.top = -this.bKF;
        Rect rect = this.bKR;
        rect.bottom = -rect.top;
        this.bKR.left = (this.bKG ? -i : -this.bKH) / 2;
        this.bKR.right = this.bKG ? i / 2 : this.bKH / 2;
        this.bKS.top = -this.bKF;
        Rect rect2 = this.bKS;
        rect2.bottom = -rect2.top;
        this.bKS.left = (this.bKG ? -i : -this.bKH) / 2;
        this.bKS.right = (-this.bKH) / 2;
        this.bKT.top = -this.bKF;
        this.bKT.bottom = -this.bKS.top;
        Rect rect3 = this.bKT;
        if (!this.bKG) {
            i = this.bKH;
        }
        rect3.left = (-i) / 2;
        this.bKT.right = (-this.bKH) / 2;
        this.bKU.top = -this.bKB;
        this.bKU.bottom = this.bKB;
        this.bKU.left = ((-this.bKH) / 2) - this.bKB;
        this.bKU.right = ((-this.bKH) / 2) + this.bKB;
        setThumbDrawable(this.alj);
        setProgress(this.bKJ);
        setSecondaryProgress(this.bKL);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.bKN = size;
        } else {
            this.bKN = getWidth();
        }
        if (mode2 == 1073741824) {
            this.bKM = size2;
        } else {
            this.bKM = getHeight();
        }
        K(this.bKN, this.bKM);
        setMeasuredDimension(this.bKN, this.bKM);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.bKN / 2, this.bKM / 2);
        a(canvas, this.bKR, this.bKO);
        a(canvas, this.bKT, this.bKQ);
        a(canvas, this.bKS, this.bKP);
        if (this.bLk) {
            i(canvas);
        }
        canvas.restore();
    }

    public final void cC(boolean z) {
        this.bLk = z;
        cD(z);
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        rect2.top = (int) (rect.top * this.bLh);
        rect2.bottom = (int) (rect.bottom * this.bLh);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.bKE * this.bLh);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void i(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.alj;
        if (drawable != null) {
            drawable.setBounds(this.bKU);
            this.alj.draw(canvas);
        } else {
            this.bKx.setColor(this.bKz);
            canvas.drawCircle(this.bKU.centerX(), this.bKU.centerY(), (this.bKU.width() * this.bLf) / 2.0f, this.bKx);
        }
        canvas.restore();
    }

    private boolean n(float f, float f2) {
        return this.bKU.left < this.bKU.right && this.bKU.top < this.bKU.bottom && f >= (((float) this.bKU.left) * this.bLf) - ((float) this.bKI) && f <= (((float) this.bKU.right) * this.bLf) + ((float) this.bKI) && f2 >= (((float) this.bKU.top) * this.bLf) - ((float) this.bKI) && f2 <= (((float) this.bKU.bottom) * this.bLf) + ((float) this.bKI);
    }

    private boolean o(float f, float f2) {
        return this.bKR.left < this.bKR.right && this.bKR.top < this.bKR.bottom && f >= (((float) this.bKR.left) * this.bLh) - ((float) this.bKI) && f <= (((float) this.bKR.right) * this.bLh) + ((float) this.bKI) && f2 >= (((float) this.bKR.top) * this.bLh) - ((float) this.bKI) && f2 <= (((float) this.bKR.bottom) * this.bLh) + ((float) this.bKI);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - (this.bKN / 2);
        float y = motionEvent.getY() - (this.bKM / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (this.bKV || this.bKW)) {
                    b(fH((int) x), false, true);
                }
            } else {
                this.als = false;
                if (this.bKW || this.bKV) {
                    this.bKW = false;
                    this.bKV = false;
                    b(fH((int) x), this.bLb, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        } else {
            if (!this.bKY) {
                return super.onTouchEvent(motionEvent);
            }
            if (n(x, y)) {
                cD(true);
                this.bKV = true;
                this.als = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.wF();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (o(x, y)) {
                cD(true);
                this.bKW = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.wF();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.bKZ;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void b(int i, boolean z, boolean z2) {
        int i2 = this.bKC;
        if (i <= i2 || i >= (i2 = this.bKD)) {
            i = i2;
        }
        l(z, i);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.bKK != this.bKJ) {
            this.bKX = z2;
            onSeekBarChangedListener.a(this, z2);
            this.bKX = false;
        }
        this.bKK = this.bKJ;
    }

    private void l(boolean z, int i) {
        if (z) {
            float fN = N(fG(this.bKJ));
            float fN2 = N(fG(i));
            ValueAnimator valueAnimator = this.bLe;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.bLe = valueAnimator2;
                valueAnimator2.setDuration(300L);
                this.bLe.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f) {
                        float f2 = f - 1.0f;
                        return (f2 * f2 * f2) + 1.0f;
                    }
                });
                this.bLe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        float fFloatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                        ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                        scaleAnimSeekBar.bKJ = scaleAnimSeekBar.fH((int) fFloatValue);
                        ScaleAnimSeekBar.this.M(fFloatValue);
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.bLe.setFloatValues(fN, fN2);
            this.bLe.start();
            return;
        }
        this.bKJ = i;
        M(N(fG(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(float f) {
        this.bKU.left = (int) (f - this.bKB);
        this.bKU.right = (int) (this.bKB + f);
        this.bKS.right = (int) f;
        invalidate();
    }

    public void setSecondaryProgress(int i) {
        int i2 = this.bKC;
        if (i <= i2 || i >= (i2 = this.bKD)) {
            i = i2;
        }
        this.bKL = i;
        this.bKT.right = (int) N(fG(i));
        invalidate();
    }

    public int getSecondaryProgress() {
        return this.bKL;
    }

    private void cD(boolean z) {
        if (this.bLa) {
            if (z) {
                cE(true);
                cF(true);
            } else {
                cE(false);
                cF(false);
            }
        }
    }

    private void cE(boolean z) {
        float f = this.bLf;
        float f2 = z ? this.bLg : 1.0f;
        ValueAnimator valueAnimator = this.bLc;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.bLc = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.bLc.setInterpolator(new LinearInterpolator());
            this.bLc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.bLf = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.bLc.setFloatValues(f, f2);
        this.bLc.start();
    }

    private void cF(boolean z) {
        float f = this.bLh;
        float f2 = z ? this.bLi : 1.0f;
        ValueAnimator valueAnimator = this.bLd;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.bLd = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.bLd.setInterpolator(new LinearInterpolator());
            this.bLd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.bLh = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.bLd.setFloatValues(f, f2);
        this.bLd.start();
    }

    private float N(float f) {
        float f2 = this.bKH / 2;
        if (f > f2) {
            return f2;
        }
        float f3 = -f2;
        return f < f3 ? f3 : f;
    }

    public final boolean isFinished() {
        return (this.bKW || this.bKV) ? false : true;
    }

    public int getProgress() {
        return this.bKJ;
    }

    public void setProgress(int i) {
        b(i, false, false);
    }

    public void setMinProgress(int i) {
        this.bKC = i;
        if (this.bKJ < i) {
            this.bKJ = i;
        }
    }

    public void setMaxProgress(int i) {
        this.bKD = i;
    }

    public int getMaxProgress() {
        return this.bKD;
    }

    public void setProgressBackgroundColor(int i) {
        this.bKy = i;
        this.bKO.setColor(i);
    }

    public void setProgressColor(int i) {
        this.bKz = i;
        this.bKP.setColor(i);
    }

    public void setSecondaryProgressColor(int i) {
        this.bKA = i;
        this.bKQ.setColor(i);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.alj = drawable;
    }

    public void setThumbEnable(boolean z) {
        this.bKY = z;
    }

    public void setThumbTouchOffset(int i) {
        this.bKI = i;
        invalidate();
    }

    private float fG(int i) {
        int i2 = this.bKH;
        int i3 = this.bKC;
        return ((i2 * (i - i3)) / (this.bKD - i3)) - (i2 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fH(int i) {
        int i2 = this.bKH;
        if (i > i2 / 2) {
            return this.bKD;
        }
        if (i < (-i2) / 2) {
            return this.bKC;
        }
        return Math.round(((i + (i2 / 2.0f)) * (this.bKD - this.bKC)) / i2) + this.bKC;
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.bKZ = new WeakReference<>(aVar);
    }

    public int getProgressX() {
        return (int) (getX() + (this.bKB * this.bLg));
    }

    public int getProgressLength() {
        return this.bKH;
    }

    public void setThumbScale(float f) {
        this.bLf = f;
    }
}
