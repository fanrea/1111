package com.bytedance.sdk.djx.core.business.view.loading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.pangle.cn.pangrowth.base.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDoubleColorBallAnimationView extends View {
    private boolean autoProgress;
    private int cycleBias;
    private boolean dataReady;
    private long mAnimateStartTime;
    private boolean mAnimating;
    private final float mBaseHorizon;
    private final float mBaseP;
    private float mBaseR;
    private float mBaseX;
    private int mColor1;
    private int mColor2;
    private final long mDelay;
    private float mDistance;
    private final float mDuration;
    private final float mMaxScale;
    private final float mMinScale;
    private Paint mPaint;
    private int mSide;
    private float mSideCenter;
    private final PorterDuffXfermode mode;
    private float progress;

    private float getRealProgress(float f) {
        return ((double) f) < 0.5d ? 2.0f * f * f : ((f * 2.0f) * (2.0f - f)) - 1.0f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DJXDoubleColorBallAnimationView(Context context) {
        this(context, null);
        init(context);
    }

    public DJXDoubleColorBallAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context);
    }

    public DJXDoubleColorBallAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxScale = 0.25f;
        this.mMinScale = 0.375f;
        this.mBaseHorizon = 0.16f;
        this.mBaseP = 0.32f;
        this.mDuration = 400.0f;
        this.mDelay = 17L;
        this.mode = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.autoProgress = false;
        this.dataReady = false;
        this.cycleBias = 0;
        this.mAnimating = false;
        this.mAnimateStartTime = -1L;
        this.mSide = -1;
        init(context);
    }

    private void init(Context context) {
        this.mColor1 = ContextCompat.getColor(context, R.color.djx_loading_color1);
        this.mColor2 = ContextCompat.getColor(context, R.color.djx_loading_color2);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            startAnimate();
        } else {
            stopAnimate();
        }
    }

    public void setProgressBarInfo(int i) {
        if (i > 0) {
            this.mSide = i;
            this.mSideCenter = i / 2.0f;
            float f = (i >> 1) * 0.32f;
            this.mBaseR = f;
            float f2 = (i * 0.16f) + f;
            this.mBaseX = f2;
            this.mDistance = i - (f2 * 2.0f);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimate();
    }

    public boolean isAnimating() {
        return this.mAnimating;
    }

    public void startAnimate() {
        checkData();
        this.mAnimating = true;
        this.autoProgress = true;
        postInvalidate();
    }

    public void stopAnimate() {
        this.mAnimating = false;
        this.dataReady = false;
        this.progress = 0.0f;
    }

    public void setProgress(float f) {
        if (!this.dataReady) {
            checkData();
        }
        this.progress = f;
        this.mAnimating = false;
        this.autoProgress = false;
        postInvalidate();
    }

    private Paint createPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMin = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (this.mSide <= iMin || iMin <= 0) {
            return;
        }
        setProgressBarInfo(iMin);
    }

    private void checkData() {
        this.mAnimateStartTime = -1L;
        if (this.mSide <= 0) {
            setProgressBarInfo(getContext().getResources().getDimensionPixelSize(R.dimen.djx_default_loading_side));
        }
        int iMin = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.mSide > iMin && iMin > 0) {
            setProgressBarInfo(iMin);
        }
        if (this.mPaint == null) {
            this.mPaint = createPaint();
        }
        this.dataReady = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if ((isAnimating() || !this.autoProgress) && this.dataReady) {
            if (this.autoProgress) {
                long jNanoTime = System.nanoTime() / 1000000;
                if (this.mAnimateStartTime < 0) {
                    this.mAnimateStartTime = jNanoTime;
                }
                float f = (jNanoTime - this.mAnimateStartTime) / 400.0f;
                this.progress = f;
                int i = (int) f;
                z = ((this.cycleBias + i) & 1) == 1;
                this.progress = f - i;
            }
            float realProgress = getRealProgress(this.progress);
            int i2 = this.mSide;
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, i2, i2, this.mPaint, 31);
            float f2 = (this.mDistance * realProgress) + this.mBaseX;
            float f3 = ((double) realProgress) < 0.5d ? realProgress * 2.0f : 2.0f - (realProgress * 2.0f);
            float f4 = this.mBaseR;
            float f5 = (0.25f * f3 * f4) + f4;
            this.mPaint.setColor(z ? this.mColor2 : this.mColor1);
            canvas.drawCircle(f2, this.mSideCenter, f5, this.mPaint);
            float f6 = this.mSide - f2;
            float f7 = this.mBaseR;
            float f8 = f7 - ((f3 * 0.375f) * f7);
            this.mPaint.setColor(z ? this.mColor1 : this.mColor2);
            this.mPaint.setXfermode(this.mode);
            canvas.drawCircle(f6, this.mSideCenter, f8, this.mPaint);
            this.mPaint.setXfermode(null);
            canvas.restoreToCount(iSaveLayer);
            postInvalidateDelayed(17L);
        }
    }

    public void setCycleBias(int i) {
        this.cycleBias = i;
    }
}
