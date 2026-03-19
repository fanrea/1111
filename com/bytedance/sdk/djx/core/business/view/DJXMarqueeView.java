package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXMarqueeView extends View {
    static final int PAUSED = 1;
    static final int RUNNING = 0;
    static final int STOPPED = 2;
    private boolean isRtl;
    private long mAnimateMillis;
    private float mCurOffset;
    private float mLength;
    private TextPaint mPaint;
    private float mSpeed;
    private int mState;
    private String mText;

    public DJXMarqueeView(Context context) {
        this(context, null);
    }

    public DJXMarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DJXMarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSpeed = 50.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TextPaint textPaint = new TextPaint();
        this.mPaint = textPaint;
        textPaint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DJXMarqueeView);
        this.mSpeed = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DJXMarqueeView_djx_speed, 50);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.DJXMarqueeView_djx_text_color, -1);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DJXMarqueeView_djx_text_size, UIUtil.sp2px(12.0f));
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.DJXMarqueeView_djx_text_shadow, -16777216);
        typedArrayObtainStyledAttributes.recycle();
        this.mPaint.setTextSize(dimensionPixelSize);
        this.mPaint.setShadowLayer(1.0f, 1.0f, 1.0f, color2);
        this.mPaint.setColor(color);
        this.mState = 2;
    }

    public void setText(String str) {
        String str2 = str + "    ";
        this.mText = str2;
        this.mLength = this.mPaint.measureText(str2);
        this.mCurOffset = 0.0f;
        this.mAnimateMillis = 0L;
        requestLayout();
    }

    public void setTextSize(int i) {
        this.mPaint.setTextSize(UIUtil.sp2px(i));
        requestLayout();
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.isEmpty(this.mText)) {
            return;
        }
        float f = 0.0f;
        if (this.mLength == 0.0f) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.mAnimateMillis > 0) {
            this.mCurOffset = (this.mCurOffset + ((((jUptimeMillis - r4) * this.mSpeed) / 1000.0f) * (this.isRtl ? 1 : -1))) % this.mLength;
        }
        if (this.mState == 0) {
            this.mAnimateMillis = jUptimeMillis;
        }
        while (true) {
            float measuredWidth = getMeasuredWidth();
            float f2 = this.mCurOffset;
            boolean z = this.isRtl;
            if (f >= measuredWidth + ((z ? 1 : -1) * f2)) {
                break;
            }
            canvas.drawText(this.mText, f2 + ((z ? -1 : 1) * f), -this.mPaint.ascent(), this.mPaint);
            f += this.mLength;
        }
        if (this.mState == 0) {
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), (int) (this.mPaint.descent() - this.mPaint.ascent()));
        this.isRtl = ViewCompat.getLayoutDirection(this) == 1;
    }

    public void startMarquee() {
        int i = this.mState;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            this.mState = 0;
            postInvalidate();
        } else if (i == 2) {
            this.mCurOffset = 0.0f;
            this.mAnimateMillis = 0L;
            this.mState = 0;
            postInvalidate();
        }
    }

    public void pauseMarquee() {
        this.mState = 1;
        postInvalidate();
    }

    public void stopMarquee() {
        this.mState = 2;
        this.mCurOffset = 0.0f;
        this.mAnimateMillis = 0L;
        postInvalidate();
    }
}
