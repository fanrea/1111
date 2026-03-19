package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import java.util.Arrays;

/* compiled from: A */
/* renamed from: com.qq.e.comm.plugin.do, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cdo extends View {
    private final Paint a;
    private int b;
    private int c;
    private final Paint d;
    private final Path e;
    private float[] f;
    private final RectF g;
    private boolean h;
    private Object[] i;
    private Shader j;

    public Cdo(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.a = paint;
        this.c = 100;
        Paint paint2 = new Paint(1);
        this.d = paint2;
        this.e = new Path();
        this.g = new RectF();
        this.h = false;
        setLayerType(1, null);
        paint2.setColor(Color.parseColor("#d8d8d8"));
        paint.setColor(Color.parseColor("#3185FC"));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float f = width;
        float f2 = height;
        this.g.set(0.0f, 0.0f, f, f2);
        float[] fArr = this.f;
        if (fArr != null) {
            this.e.addRoundRect(this.g, fArr, Path.Direction.CW);
            canvas.clipPath(this.e);
        }
        super.onDraw(canvas);
        int i = this.b;
        if (i >= 0) {
            float f3 = (i / this.c) * f;
            Object[] objArr = this.i;
            if (objArr != null && this.j == null) {
                Shader shaderA = ei.a(objArr, width, height);
                this.j = shaderA;
                this.a.setShader(shaderA);
            }
            a(canvas, f, f2, this.d);
            a(canvas, f3, f2);
        }
        this.e.reset();
    }

    private void a(Canvas canvas, float f, float f2) {
        int i;
        if (this.h && (i = this.b) > 0 && i < 100) {
            float f3 = f2 / 2.0f;
            y5.a(canvas, this.a, f, f2, 0.0f, 0.0f, f3, 0.0f, f3);
        } else {
            a(canvas, f, f2, this.a);
        }
    }

    public void c(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.a.setColor(i);
        postInvalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.d.setColor(i);
    }

    private void a(Canvas canvas, float f, float f2, Paint paint) {
        this.g.set(0.0f, 0.0f, f, f2);
        canvas.drawRect(this.g, paint);
    }

    public void a(int i) {
        if (i == this.b) {
            return;
        }
        if (i <= 0) {
            this.b = 0;
        } else if (i >= 100) {
            this.b = 100;
        } else {
            this.b = i;
        }
        postInvalidate();
    }

    public void a(Object[] objArr) {
        this.i = objArr;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a(float f) {
        if (this.f == null) {
            this.f = new float[8];
        }
        Arrays.fill(this.f, f);
    }
}
