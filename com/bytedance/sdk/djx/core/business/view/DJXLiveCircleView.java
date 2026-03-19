package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXLiveCircleView extends View {
    private int cx;
    private int cy;
    public boolean isCatonFuncOptEnabled;
    private int mCircleAlpha;
    private Paint mCirclePaint;
    private float mCircleRadius;
    private float mCircleStrokeWidth;
    private Context mContext;
    private int mInterval;
    private Paint mPaint;
    private float mStrokeWidth;
    private float radius;

    public DJXLiveCircleView(Context context) {
        this(context, null);
    }

    public DJXLiveCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DJXLiveCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCircleAlpha = 255;
        this.isCatonFuncOptEnabled = false;
        init(context, attributeSet);
    }

    public void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LiveCircleView);
        this.mStrokeWidth = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.LiveCircleView_live_strokeWidth, UIUtil.dp2px(1.5f));
        typedArrayObtainStyledAttributes.recycle();
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, Color.parseColor("#FF1764"), Color.parseColor("#ED3495"), Shader.TileMode.MIRROR));
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(UIUtil.dp2px(1.5f));
        this.mCirclePaint = new Paint(this.mPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.cx = getMeasuredWidth() / 2;
        this.cy = getMeasuredHeight() / 2;
        float measuredHeight = (getMeasuredHeight() / 2) - getPaddingBottom();
        this.radius = measuredHeight;
        this.mCircleRadius = measuredHeight;
        this.mInterval = getPaddingBottom();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.cx, this.cy, this.radius, this.mPaint);
        canvas.drawCircle(this.cx, this.cy, this.mCircleRadius, this.mCirclePaint);
    }

    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
    }

    public void setFraction(float f) {
        float f2 = this.radius + (this.mInterval * f);
        float f3 = this.mStrokeWidth * (1.0f - f);
        if (!this.isCatonFuncOptEnabled || Math.abs(f2 - this.mCircleRadius) >= 0.5f || Math.abs(this.mCircleStrokeWidth - f3) >= 0.5f) {
            this.mCircleRadius = f2;
            this.mCircleStrokeWidth = f3;
            this.mCirclePaint.setStrokeWidth(f3);
            postInvalidate();
        }
    }

    public void setColors(int i, int i2) {
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, i, i2, Shader.TileMode.MIRROR);
        this.mPaint.setShader(linearGradient);
        this.mCirclePaint.setShader(linearGradient);
    }
}
