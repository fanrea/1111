package com.style;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends View {
    private int a;
    private int b;
    private final Paint c;
    private final RectF d;
    private int e;
    private int f;
    private final Rect g;
    private final RectF h;

    public a(Context context) {
        super(context);
        this.a = -16776961;
        this.b = 8;
        this.c = new Paint();
        this.d = new RectF();
        this.e = 100;
        this.f = this.e;
        this.g = new Rect();
        this.h = new RectF();
        this.c.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.g);
        this.h.set(this.g);
        this.c.setColor(this.a);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.b);
        this.c.setStrokeCap(Paint.Cap.ROUND);
        this.c.setAlpha(204);
        this.d.set(this.h.left + (this.b / 2), this.h.top + (this.b / 2), this.h.right - (this.b / 2), this.h.bottom - (this.b / 2));
        canvas.drawArc(this.d, 270.0f, (this.f * 360) / this.e, false, this.c);
    }

    public a a(int i) {
        this.a = i;
        invalidate();
        return this;
    }

    public a b(int i) {
        this.b = i;
        invalidate();
        return this;
    }

    public void c(int i) {
        this.f = d(i);
        invalidate();
    }

    private int d(int i) {
        if (i > this.e) {
            return this.e;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public void a(int i, int i2) {
        this.f = (this.e * i2) / i;
        invalidate();
    }
}
