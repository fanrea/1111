package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class j extends View {
    private static float a;
    private Paint b;
    private Path c;
    private PointF d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private Paint i;

    public j(Context context) {
        super(context);
        a();
    }

    public j(Context context, AttributeSet attrs) {
        super(context, attrs);
        a();
    }

    public j(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a();
    }

    private void a() {
        this.b = new Paint();
        this.i = new Paint();
        a = Dips.dipsToIntPixels(6.0f, getContext());
        this.b.setColor(-1);
        this.b.setStrokeWidth(a);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setAntiAlias(true);
        this.i.setAntiAlias(true);
        this.i.setColor(-16777216);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setAlpha(51);
    }

    private void b() {
        double d = 0.62831855f;
        this.e = ((this.f / 2.0f) * ((float) Math.tan(d))) / ((float) Math.sin(d));
        this.d = new PointF(this.f / 2.0f, this.e + Dips.dipsToIntPixels(30.0f, getContext()));
        this.c = new Path();
        this.c.addArc(new RectF(this.d.x - this.e, this.d.y - this.e, this.d.x + this.e, this.d.y + this.e), 0.0f, -180.0f);
    }

    public void a(boolean isShow) {
        this.h = isShow;
    }

    public float getLineWidth() {
        return this.b.getStrokeWidth();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h) {
            canvas.drawPath(this.c, this.i);
        }
        canvas.drawPath(this.c, this.b);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.f = w;
        this.g = h;
        b();
    }

    public void setLineWidth(float lineWidth) {
        this.b.setStrokeWidth(lineWidth);
        invalidate();
    }
}
