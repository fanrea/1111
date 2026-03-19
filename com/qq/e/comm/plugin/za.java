package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class za extends View implements am {
    private final float a;
    private final float b;
    private final float c;
    private final Paint d;
    private final RectF e;
    private float f;
    private boolean g;
    private long h;
    private boolean i;

    @Override // com.qq.e.comm.plugin.ts
    public void a() {
    }

    public za(Context context, int i) {
        super(context);
        this.i = false;
        float f = i / 2.0f;
        this.a = f;
        float f2 = 0.75f * f;
        this.b = f2;
        this.c = 0.06666667f * f;
        setLayerType(1, null);
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        paint.setDither(true);
        float f3 = f - f2;
        float f4 = f + f2;
        this.e = new RectF(f3, f3, f4, f4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.a * 2.0f;
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, f, f, null, 31);
        this.d.setStrokeWidth(this.c);
        this.d.setColor(LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        Paint paint = this.d;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint paint2 = this.d;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        canvas.drawArc(this.e, -150.0f, 120.0f, false, this.d);
        this.d.setStyle(style);
        this.d.setStrokeCap(cap);
        this.d.setColor(-1);
        this.d.setStrokeWidth(this.c);
        if (!this.i) {
            RectF rectF = this.e;
            float f2 = this.f;
            canvas.drawArc(rectF, (-90.0f) - f2, f2, false, this.d);
        } else {
            canvas.drawArc(this.e, -150.0f, this.f + 60.0f, false, this.d);
        }
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // com.qq.e.comm.plugin.ts
    public void a(int i, int i2, int i3, int i4, float f) {
        if (this.g) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.h < 40) {
            return;
        }
        boolean z = f >= 0.5f;
        this.i = z;
        this.h = jCurrentTimeMillis;
        if (z) {
            f -= 0.5f;
        }
        float f2 = f * 60.0f * 2.0f;
        if (Math.abs(this.f - f2) >= 1.0f || this.i) {
            this.f = f2;
            invalidate();
        }
    }

    @Override // com.qq.e.comm.plugin.ts
    public void b() {
        this.g = false;
        this.i = false;
        this.f = 0.0f;
        this.h = 0L;
        invalidate();
    }

    @Override // com.qq.e.comm.plugin.ts
    public void a(int i, int i2, int i3, int i4, long j) {
        this.g = true;
        this.f = 60.0f;
        invalidate();
    }
}
