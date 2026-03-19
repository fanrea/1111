package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ae extends View {
    private Paint a;
    private RectF b;
    private Paint c;
    private int d;
    private int e;
    private int f;

    public ae(Context context) {
        super(context);
        this.e = 15;
    }

    public ae(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.e = 15;
    }

    public ae(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.e = 15;
    }

    private void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.a.setColor(-1);
        int iAsIntPixels = Dips.asIntPixels(1.0f, getContext());
        this.f = iAsIntPixels;
        this.a.setStrokeWidth(iAsIntPixels);
        this.a.setAlpha(127);
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setColor(-1);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setTextSize(TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics()));
        this.d = Dips.asIntPixels(10.0f, getContext());
        int i = this.f;
        this.b = new RectF(i, i, getWidth() - this.f, getHeight() - this.f);
    }

    public void a(int timer) {
        this.e = timer;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String strValueOf;
        float f;
        super.onDraw(canvas);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(-16777216);
        this.a.setAlpha(127);
        RectF rectF = this.b;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.b.right / 2.0f, this.a);
        canvas.drawText("跳过", this.d, ((this.b.bottom / 2.0f) + ((this.c.getFontMetrics().bottom - this.c.getFontMetrics().top) / 2.0f)) - this.c.getFontMetrics().bottom, this.c);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(-1);
        int iAsIntPixels = Dips.asIntPixels(1.0f, getContext());
        this.f = iAsIntPixels;
        this.a.setStrokeWidth(iAsIntPixels);
        this.a.setAlpha(127);
        RectF rectF2 = this.b;
        canvas.drawRoundRect(rectF2, rectF2.right / 2.0f, this.b.right / 2.0f, this.a);
        float fMeasureText = this.d + this.c.measureText("跳过") + (this.d / 2.0f);
        int i = this.f;
        canvas.drawLine(fMeasureText + (i * 2), i * 2, fMeasureText + (i * 2), this.b.bottom - (this.f * 2), this.a);
        int i2 = this.e;
        if (i2 > 9) {
            strValueOf = String.valueOf(i2);
            f = this.d / 2.0f;
        } else {
            strValueOf = String.valueOf(i2);
            f = this.d;
        }
        canvas.drawText(strValueOf, fMeasureText + f, ((this.b.bottom / 2.0f) + ((this.c.getFontMetrics().bottom - this.c.getFontMetrics().top) / 2.0f)) - this.c.getFontMetrics().bottom, this.c);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        a();
    }
}
