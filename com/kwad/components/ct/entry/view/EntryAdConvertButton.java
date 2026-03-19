package com.kwad.components.ct.entry.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EntryAdConvertButton extends LinearLayout {
    private float aDA;
    private volatile boolean aDB;
    private Runnable aDC;
    private Animation aDD;
    private Bitmap aDw;
    private Bitmap aDx;
    private Paint aDy;
    private float aDz;
    private AnimatorSet apT;

    public EntryAdConvertButton(Context context) {
        super(context);
        this.aDA = -100.0f;
        this.aDB = true;
        this.aDC = new Runnable() { // from class: com.kwad.components.ct.entry.view.EntryAdConvertButton.1
            @Override // java.lang.Runnable
            public final void run() {
                if (EntryAdConvertButton.this.apT == null) {
                    EntryAdConvertButton.this.Eg();
                } else if (EntryAdConvertButton.this.apT.isRunning()) {
                    EntryAdConvertButton.this.apT.cancel();
                }
                EntryAdConvertButton.this.apT.start();
            }
        };
        this.aDD = null;
        init();
    }

    public EntryAdConvertButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init();
    }

    public EntryAdConvertButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDA = -100.0f;
        this.aDB = true;
        this.aDC = new Runnable() { // from class: com.kwad.components.ct.entry.view.EntryAdConvertButton.1
            @Override // java.lang.Runnable
            public final void run() {
                if (EntryAdConvertButton.this.apT == null) {
                    EntryAdConvertButton.this.Eg();
                } else if (EntryAdConvertButton.this.apT.isRunning()) {
                    EntryAdConvertButton.this.apT.cancel();
                }
                EntryAdConvertButton.this.apT.start();
            }
        };
        this.aDD = null;
        init();
    }

    private void Ef() {
        if (this.aDx == null) {
            this.aDx = a(this.aDw, getHeight(), getHeight());
            this.aDw.recycle();
            this.aDw = null;
        }
    }

    private static Bitmap a(Bitmap bitmap, float f, float f2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(f / width, f2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private void init() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        this.aDw = BitmapFactory.decodeResource(getResources(), R.drawable.ksad_round_light, options);
        this.aDA = getLightImgStartX();
        Paint paint = new Paint(1);
        this.aDy = paint;
        paint.setDither(true);
        this.aDy.setFilterBitmap(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        lz();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Ef();
        this.aDz = getLightImgStartX();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aDx != null) {
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.aDy, 31);
            canvas.drawBitmap(this.aDx, this.aDz, 0.0f, this.aDy);
            canvas.restoreToCount(iSaveLayer);
        }
    }

    private float getLightImgStartX() {
        if (this.aDx != null) {
            this.aDA = -r0.getWidth();
        }
        return this.aDA - com.kwad.sdk.c.a.a.a(getContext(), 10.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eg() {
        this.aDz = getLightImgStartX();
        AnimatorSet animatorSet = new AnimatorSet();
        this.apT = animatorSet;
        animatorSet.playSequentially(Eh());
        this.apT.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.entry.view.EntryAdConvertButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                EntryAdConvertButton.this.Ei();
            }
        });
    }

    private ValueAnimator Eh() {
        final float f = this.aDz;
        final float width = getWidth() + com.kwad.sdk.c.a.a.a(getContext(), 20.0f);
        final FloatEvaluator floatEvaluator = new FloatEvaluator();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(1, 16);
        valueAnimatorOfInt.setDuration(800L);
        valueAnimatorOfInt.setRepeatCount(0);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ct.entry.view.EntryAdConvertButton.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EntryAdConvertButton.this.aDz = floatEvaluator.evaluate(((Integer) valueAnimator.getAnimatedValue()).intValue() / 16.0f, (Number) Float.valueOf(f), (Number) Float.valueOf(width)).floatValue();
                EntryAdConvertButton.this.postInvalidate();
            }
        });
        return valueAnimatorOfInt;
    }

    public final void ly() {
        this.aDB = false;
        post(this.aDC);
    }

    public final void lz() {
        this.aDB = true;
        AnimatorSet animatorSet = this.apT;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.apT.cancel();
        }
        removeCallbacks(this.aDC);
        Ej();
        this.aDz = this.aDA;
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ei() {
        if (this.aDD == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.06f, 1.0f, 1.04f, 1, 0.5f, 1, 0.5f);
            this.aDD = scaleAnimation;
            scaleAnimation.setDuration(300L);
            this.aDD.setRepeatMode(2);
            this.aDD.setRepeatCount(3);
            this.aDD.setInterpolator(new AccelerateDecelerateInterpolator());
            this.aDD.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ct.entry.view.EntryAdConvertButton.4
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    EntryAdConvertButton entryAdConvertButton = EntryAdConvertButton.this;
                    entryAdConvertButton.removeCallbacks(entryAdConvertButton.aDC);
                    if (EntryAdConvertButton.this.aDB) {
                        return;
                    }
                    EntryAdConvertButton.this.ly();
                }
            });
        }
        startAnimation(this.aDD);
    }

    private void Ej() {
        clearAnimation();
    }
}
