package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.view.View;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f6 extends View {
    private Paint a;
    private int b;
    private RectF c;
    private int d;
    private Matrix e;
    private SweepGradient f;
    private boolean g;
    Runnable h;

    static /* synthetic */ int a(f6 f6Var, int i) {
        int i2 = f6Var.d + i;
        f6Var.d = i2;
        return i2;
    }

    static /* synthetic */ int b(f6 f6Var, int i) {
        int i2 = f6Var.d % i;
        f6Var.d = i2;
        return i2;
    }

    public f6(Context context) {
        super(context);
        this.b = yu.a(getContext().getApplicationContext(), 4);
        this.d = 0;
        this.h = new a();
        setLayerType(1, null);
        a();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.g) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (this.f == null) {
                this.f = new SweepGradient(measuredWidth / 2, measuredHeight / 2, new int[]{0, Color.parseColor("#FFC3C4C5")}, (float[]) null);
            }
            this.f.setLocalMatrix(this.e);
            this.e.setRotate(this.d, measuredWidth / 2, measuredHeight / 2);
            this.a.setShader(this.f);
            RectF rectF = this.c;
            int i = this.b;
            float f = i;
            rectF.left = f;
            rectF.top = f;
            float f2 = measuredWidth - i;
            rectF.right = f2;
            rectF.bottom = f2;
            canvas.drawArc(rectF, this.d, 359.0f, false, this.a);
        }
    }

    public void c() {
        this.g = false;
        removeCallbacks(this.h);
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f6.a(f6.this, 10);
            f6.b(f6.this, 360);
            if (f6.this.g) {
                f6.this.postInvalidate();
                f6 f6Var = f6.this;
                f6Var.postDelayed(f6Var.h, 20L);
            }
        }
    }

    private void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.b);
        this.e = new Matrix();
        this.c = new RectF();
    }

    public void b() {
        if (this.g) {
            return;
        }
        this.g = true;
        post(this.h);
    }
}
