package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ya extends View implements am {
    private static final float w = (float) Math.sin(Math.toRadians(55.0d));
    private static final float x = (float) Math.cos(Math.toRadians(55.0d));
    private final float a;
    private final float b;
    private final float c;
    private final PorterDuffXfermode d;
    private final Paint e;
    private final RectF f;
    private final Path g;
    private final float h;
    private final float i;
    private final float j;
    private final float m;
    private final float n;
    private final float o;
    private final float p;
    private final float q;
    private final float r;
    private final float s;
    private float t;
    private boolean u;
    private long v;

    @Override // com.qq.e.comm.plugin.ts
    public void a() {
    }

    public ya(Context context, int i) {
        super(context);
        float f = i / 2.0f;
        this.a = f;
        float f2 = 0.75f * f;
        this.b = f2;
        float f3 = 0.06666667f * f;
        this.c = f3;
        setLayerType(1, null);
        this.d = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        paint.setDither(true);
        float f4 = f - f2;
        float f5 = f + f2;
        this.f = new RectF(f4, f4, f5, f5);
        this.g = new Path();
        this.h = 0.4f * f3;
        float f6 = w;
        float f7 = f2 * f6;
        float f8 = f - f7;
        float f9 = f7 + f;
        float f10 = x;
        float f11 = f - (f2 * f10);
        float f12 = 2.0f * f3;
        float f13 = f12 * f10;
        this.i = f8 - f13;
        this.j = f13 + f9;
        this.m = (f12 * f6) + f11;
        float f14 = f3 * 1.5f;
        float f15 = f6 * f14;
        this.n = f8 - f15;
        this.o = f9 + f15;
        float f16 = f14 * f10;
        this.p = f11 - f16;
        this.q = f8 + f15;
        this.r = f9 - f15;
        this.s = f11 + f16;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.a * 2.0f;
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, f, f, null, 31);
        this.e.setStrokeWidth(this.c);
        this.e.setColor(LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        Paint paint = this.e;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.e.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawArc(this.f, -145.0f, 110.0f, false, this.e);
        this.e.setStyle(style);
        this.e.setStrokeCap(Paint.Cap.ROUND);
        this.e.setColor(-1);
        this.e.setStrokeWidth(this.c);
        RectF rectF = this.f;
        float f2 = this.t;
        canvas.drawArc(rectF, (-90.0f) - f2, f2 * 2.0f, false, this.e);
        a(canvas);
        canvas.restoreToCount(iSaveLayer);
    }

    private void a(Canvas canvas) {
        if (this.u) {
            this.e.setColor(-1);
        } else {
            this.e.setColor(LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        }
        this.e.setStrokeWidth(1.0f);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setPathEffect(new CornerPathEffect(this.h));
        this.e.setXfermode(this.d);
        this.g.moveTo(this.i, this.m);
        this.g.lineTo(this.n, this.p);
        this.g.lineTo(this.q, this.s);
        this.g.close();
        canvas.drawPath(this.g, this.e);
        this.g.moveTo(this.j, this.m);
        this.g.lineTo(this.o, this.p);
        this.g.lineTo(this.r, this.s);
        this.g.close();
        canvas.drawPath(this.g, this.e);
        this.e.setXfermode(null);
        this.e.setPathEffect(null);
    }

    @Override // com.qq.e.comm.plugin.ts
    public void b() {
        this.u = false;
        this.t = 0.0f;
        this.v = 0L;
        invalidate();
    }

    @Override // com.qq.e.comm.plugin.ts
    public void a(int i, int i2, int i3, int i4, float f) {
        if (this.u) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.v < 40) {
            return;
        }
        this.v = jCurrentTimeMillis;
        float f2 = f * 55.0f;
        if (Math.abs(this.t - f2) >= 1.0f) {
            this.t = f2;
            invalidate();
        }
    }

    @Override // com.qq.e.comm.plugin.ts
    public void a(int i, int i2, int i3, int i4, long j) {
        this.u = true;
        this.t = 55.0f;
        invalidate();
    }
}
