package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import com.kwad.components.core.widget.e;
import com.kwad.components.core.widget.f;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KSCouponLabelTextView extends TextView implements e {
    private float FA;
    private float FB;
    private final RectF FC;
    private final RectF FD;
    private final Path FE;
    private Path FF;
    private Path FG;
    private boolean FH;
    private final Rect Ft;
    private final RectF Fu;
    private final RectF Fx;
    private float Fz;
    private final Paint mPaint;
    private int strokeColor;

    public KSCouponLabelTextView(Context context) throws Resources.NotFoundException {
        super(context);
        this.mPaint = new Paint();
        this.Ft = new Rect();
        this.Fu = new RectF();
        this.FC = new RectF();
        this.FD = new RectF();
        this.FE = new Path();
        this.Fx = new RectF();
        this.FH = true;
        a(context, null, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.Ft = new Rect();
        this.Fu = new RectF();
        this.FC = new RectF();
        this.FD = new RectF();
        this.FE = new Path();
        this.Fx = new RectF();
        this.FH = true;
        a(context, attributeSet, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.Ft = new Rect();
        this.Fu = new RectF();
        this.FC = new RectF();
        this.FD = new RectF();
        this.FE = new Path();
        this.Fx = new RectF();
        this.FH = true;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i, 0);
        int color = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Fz = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.FA = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.strokeColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.FB = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        typedArrayObtainStyledAttributes.recycle();
        lq();
    }

    private void lq() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.FA);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.FH) {
            if (((float) (getPaddingLeft() + getPaddingRight())) + getPaint().measureText(getText().toString()) <= ((float) getMeasuredWidth())) {
                return;
            }
            setVisibility(8);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Ft.setEmpty();
        getDrawingRect(this.Ft);
        float f = this.FA / 2.0f;
        this.Fu.set(this.Ft);
        this.Fu.left += f;
        this.Fu.top += f;
        this.Fu.right -= f;
        this.Fu.bottom -= f;
        a(this.Fu, this.FC);
        b(this.Fu, this.FD);
        if (Build.VERSION.SDK_INT >= 19) {
            Path path = this.FF;
            if (path == null) {
                this.FF = new Path();
            } else {
                path.reset();
            }
            Path path2 = this.FG;
            if (path2 == null) {
                this.FG = new Path();
            } else {
                path2.reset();
            }
            a(this.FE, this.FF, this.FG, this.Fu, this.FC, this.FD);
            canvas.drawPath(this.FE, this.mPaint);
            return;
        }
        b(this.FE, this.Fu, this.FC, this.FD);
        canvas.drawPath(this.FE, this.mPaint);
    }

    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f = this.Fz;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        path.op(this.FF, Path.Op.DIFFERENCE);
        path.op(this.FG, Path.Op.DIFFERENCE);
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.Fz);
        this.Fx.set(rectF);
        RectF rectF4 = this.Fx;
        rectF4.bottom = rectF4.top + (this.Fz * 2.0f);
        RectF rectF5 = this.Fx;
        rectF5.right = rectF5.left + (this.Fz * 2.0f);
        path.arcTo(this.Fx, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.Fz, rectF.top);
        this.Fx.set(rectF);
        RectF rectF6 = this.Fx;
        rectF6.left = rectF6.right - (this.Fz * 2.0f);
        RectF rectF7 = this.Fx;
        rectF7.bottom = rectF7.top + (this.Fz * 2.0f);
        path.arcTo(this.Fx, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.Fz);
        this.Fx.set(rectF);
        RectF rectF8 = this.Fx;
        rectF8.left = rectF8.right - (this.Fz * 2.0f);
        RectF rectF9 = this.Fx;
        rectF9.top = rectF9.bottom - (this.Fz * 2.0f);
        path.arcTo(this.Fx, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.Fz, rectF.bottom);
        this.Fx.set(rectF);
        RectF rectF10 = this.Fx;
        rectF10.right = rectF10.left + (this.Fz * 2.0f);
        RectF rectF11 = this.Fx;
        rectF11.top = rectF11.bottom - (this.Fz * 2.0f);
        path.arcTo(this.Fx, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        rectF2.left -= this.FB;
        rectF2.right = rectF2.left + (this.FB * 2.0f);
        rectF2.top += (rectF.height() - (this.FB * 2.0f)) / 2.0f;
        rectF2.bottom = rectF2.top + (this.FB * 2.0f);
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        rectF2.right += this.FB;
        rectF2.left = rectF2.right - (this.FB * 2.0f);
        rectF2.top += (rectF.height() - (this.FB * 2.0f)) / 2.0f;
        rectF2.bottom = rectF2.top + (this.FB * 2.0f);
    }

    @Override // com.kwad.components.core.widget.e
    public final void a(f fVar) throws Resources.NotFoundException {
        int color = getResources().getColor(R.color.ksad_reward_main_color);
        this.strokeColor = color;
        setTextColor(color);
        lq();
        invalidate();
    }
}
