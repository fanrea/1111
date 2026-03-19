package com.bytedance.sdk.djx.core.business.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXLoadingView extends TextView {
    private ValueAnimator mAnimator;
    private Bitmap mBitmapLight;
    private ValueAnimator.AnimatorUpdateListener mListener;
    private Matrix mMatrix;
    private Paint mPaint;
    private float mProgress;

    public DJXLoadingView(Context context) {
        super(context);
        this.mProgress = 0.0f;
        this.mListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXLoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    DJXLoadingView.this.mProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                } catch (Throwable unused) {
                }
                DJXLoadingView.this.postInvalidate();
            }
        };
        init(context);
    }

    public DJXLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0.0f;
        this.mListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXLoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    DJXLoadingView.this.mProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                } catch (Throwable unused) {
                }
                DJXLoadingView.this.postInvalidate();
            }
        };
        init(context);
    }

    public DJXLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0.0f;
        this.mListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXLoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    DJXLoadingView.this.mProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                } catch (Throwable unused) {
                }
                DJXLoadingView.this.postInvalidate();
            }
        };
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setDither(true);
        this.mPaint.setFilterBitmap(true);
        this.mMatrix = new Matrix();
        this.mBitmapLight = BitmapFactory.decodeResource(getResources(), R.drawable.djx_loading_light);
        start();
    }

    public void toggle() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isStarted() && this.mAnimator.isRunning()) {
            stop();
        } else {
            start();
        }
    }

    public void stop() {
        this.mProgress = 0.0f;
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isStarted() && this.mAnimator.isRunning()) {
            this.mAnimator.end();
        }
    }

    public void start() {
        this.mProgress = 0.0f;
        if (this.mAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setRepeatMode(1);
            this.mAnimator.setRepeatCount(-1);
            this.mAnimator.setDuration(1200L);
            this.mAnimator.setInterpolator(new LinearInterpolator());
        }
        this.mAnimator.removeAllUpdateListeners();
        this.mAnimator.addUpdateListener(this.mListener);
        this.mAnimator.start();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            start();
        } else {
            stop();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.mAnimator.addUpdateListener(this.mListener);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            drawLight(canvas);
        } catch (Throwable unused) {
        }
    }

    private void drawLight(Canvas canvas) {
        this.mMatrix.reset();
        float fFloatValue = Float.valueOf(this.mBitmapLight.getWidth()).floatValue();
        float fFloatValue2 = Float.valueOf(this.mBitmapLight.getHeight()).floatValue();
        if (fFloatValue2 == 0.0f) {
            fFloatValue2 = 1.0f;
        }
        float measuredHeight = getMeasuredHeight() / fFloatValue2;
        int iIntValue = Float.valueOf(fFloatValue * measuredHeight).intValue();
        this.mMatrix.postScale(measuredHeight, measuredHeight);
        this.mMatrix.postTranslate((-iIntValue) + ((iIntValue + getMeasuredWidth()) * this.mProgress), 0.0f);
        canvas.drawBitmap(this.mBitmapLight, this.mMatrix, this.mPaint);
    }
}
