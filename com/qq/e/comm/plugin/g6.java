package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class g6 extends View {
    private Paint a;
    private Paint b;
    private int c;
    private int d;
    private int e;
    private RectF f;

    public g6(Context context) {
        super(context);
        this.d = yu.a(getContext().getApplicationContext(), 4);
        this.e = 100;
        setLayerType(1, null);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setColor(Color.parseColor("#C3C4C5"));
        Paint paint2 = this.a;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.a.setStrokeWidth(this.d);
        Paint paint3 = new Paint();
        this.b = paint3;
        paint3.setAntiAlias(true);
        this.b.setStyle(style);
        this.b.setColor(-1);
        this.b.setStrokeWidth(this.d);
        this.f = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        canvas.drawCircle(measuredWidth / 2, getMeasuredHeight() / 2, r2 - this.d, this.a);
        int i = this.c;
        if (i > 0) {
            RectF rectF = this.f;
            int i2 = this.d;
            float f = i2;
            rectF.left = f;
            rectF.top = f;
            float f2 = measuredWidth - i2;
            rectF.right = f2;
            rectF.bottom = f2;
            canvas.drawArc(rectF, -90.0f, (i / this.e) * 360.0f, false, this.b);
        }
    }

    public void a(int i) {
        if (i <= 0) {
            this.c = 0;
        } else if (i >= 100) {
            this.c = 100;
        } else {
            this.c = i;
        }
        postInvalidate();
    }
}
