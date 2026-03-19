package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class JinniuCouponLayout extends LinearLayout {
    private float Fs;
    private Rect Ft;
    private RectF Fu;
    private RectF Fv;
    private RectF Fw;
    private RectF Fx;
    private Path Fy;
    private int endColor;
    private Paint mPaint;
    private float mRadius;
    private int startColor;

    public JinniuCouponLayout(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.Fs = 4.0f;
        this.mRadius = 10.0f;
        this.Ft = new Rect();
        this.Fu = new RectF();
        this.Fv = new RectF();
        this.Fw = new RectF();
        this.Fx = new RectF();
        this.Fy = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, null, 0);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.Fs = 4.0f;
        this.mRadius = 10.0f;
        this.Ft = new Rect();
        this.Fu = new RectF();
        this.Fv = new RectF();
        this.Fw = new RectF();
        this.Fx = new RectF();
        this.Fy = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, 0);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.Fs = 4.0f;
        this.mRadius = 10.0f;
        this.Ft = new Rect();
        this.Fu = new RectF();
        this.Fv = new RectF();
        this.Fw = new RectF();
        this.Fx = new RectF();
        this.Fy = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPaint = new Paint();
        this.Fs = 4.0f;
        this.mRadius = 10.0f;
        this.Ft = new Rect();
        this.Fu = new RectF();
        this.Fv = new RectF();
        this.Fw = new RectF();
        this.Fx = new RectF();
        this.Fy = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_JinniuCouponLayout, i, 0);
        this.mRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_outerRadius, 4.0f);
        this.Fs = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_verticalRadius, 10.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.Ft.setEmpty();
        getDrawingRect(this.Ft);
        this.Fu.set(this.Ft);
        if (getChildCount() > 1) {
            View childAt = getChildAt(0);
            RectF rectF = this.Fv;
            if (rectF == null) {
                this.Fv = new RectF();
            } else {
                rectF.setEmpty();
            }
            RectF rectF2 = this.Fw;
            if (rectF2 == null) {
                this.Fw = new RectF();
            } else {
                rectF2.setEmpty();
            }
            float measuredWidth = this.Ft.left + childAt.getMeasuredWidth();
            RectF rectF3 = this.Fv;
            float f = this.Ft.top;
            float f2 = this.Fs;
            rectF3.set(measuredWidth, f - f2, (f2 * 2.0f) + measuredWidth, this.Ft.top + this.Fs);
            this.Fw.set(this.Fv.left, this.Ft.bottom - this.Fs, this.Fv.right, this.Ft.bottom + this.Fs);
            a(this.Fy, this.Fu, this.Fv, this.Fw);
            setGradientPaint(this.Fu);
            canvas.drawPath(this.Fy, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    private void setGradientPaint(RectF rectF) {
        this.mPaint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(this.Fu.left, this.Fu.top + this.mRadius);
        this.Fx.set(rectF);
        RectF rectF4 = this.Fx;
        rectF4.bottom = rectF4.top + (this.mRadius * 2.0f);
        RectF rectF5 = this.Fx;
        rectF5.right = rectF5.left + (this.mRadius * 2.0f);
        path.arcTo(this.Fx, 180.0f, 90.0f);
        path.lineTo(rectF2.left, rectF2.top);
        path.arcTo(rectF2, -180.0f, -180.0f);
        path.lineTo(rectF.width() - this.mRadius, rectF.top);
        this.Fx.set(rectF);
        RectF rectF6 = this.Fx;
        rectF6.left = rectF6.right - (this.mRadius * 2.0f);
        RectF rectF7 = this.Fx;
        rectF7.bottom = rectF7.top + (this.mRadius * 2.0f);
        path.arcTo(this.Fx, 270.0f, 90.0f);
        this.Fx.set(rectF);
        RectF rectF8 = this.Fx;
        rectF8.left = rectF8.right - (this.mRadius * 2.0f);
        RectF rectF9 = this.Fx;
        rectF9.top = rectF9.bottom - (this.mRadius * 2.0f);
        path.arcTo(this.Fx, 0.0f, 90.0f);
        path.lineTo(rectF3.right, rectF3.bottom);
        path.arcTo(rectF3, 0.0f, -180.0f);
        path.lineTo(rectF.left + this.mRadius, rectF.bottom);
        this.Fx.set(rectF);
        RectF rectF10 = this.Fx;
        rectF10.right = rectF10.left + (this.mRadius * 2.0f);
        RectF rectF11 = this.Fx;
        rectF11.top = rectF11.bottom - (this.mRadius * 2.0f);
        path.arcTo(this.Fx, 90.0f, 90.0f);
    }
}
