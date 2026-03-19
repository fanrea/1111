package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class as extends View {
    private Paint a;
    private Path b;
    private int c;
    private RectF d;
    private RectF e;
    private RectF f;

    public as(Context context) {
        super(context);
    }

    public as(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public as(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void a() {
        this.a = new Paint();
        this.b = new Path();
        float fDipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        this.a.setStrokeWidth(fDipsToIntPixels);
        this.c = (int) ((getWidth() / (100.0f * fDipsToIntPixels)) * fDipsToIntPixels * 20.0f);
        int width = getWidth() - this.c;
        int height = getHeight();
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(-1);
        this.a.setAntiAlias(true);
        float f = height;
        float f2 = f / 2.2f;
        this.d = new RectF(this.c, f2, width / 2.0f, f - f2);
        this.e = new RectF(this.c, this.d.top, this.d.right, this.d.bottom);
        this.f = new RectF(this.d.right + this.e.width(), this.d.top, this.d.right + this.d.width() + this.e.width(), this.d.bottom);
    }

    private void a(Canvas canvas, RectF rectf) {
        this.b.reset();
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
        this.b.addArc(this.e, 90.0f, 180.0f);
        canvas.drawPath(this.b, this.a);
    }

    private void b(Canvas canvas, RectF rectf) {
        this.b.reset();
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
        this.b.addArc(this.f, 90.0f, -180.0f);
        canvas.drawPath(this.b, this.a);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas, this.d);
        b(canvas, this.d);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        a();
    }
}
