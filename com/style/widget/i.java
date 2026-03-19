package com.style.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i extends View {
    RectF a;
    private int b;
    private int c;
    private Paint d;
    private int e;
    private int f;

    public i(Context context, int i, int i2, int i3, int i4) {
        super(context);
        this.e = i3;
        this.f = i4;
        this.c = i2;
        this.b = i;
        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.d.setColor(Color.parseColor("#F5F5F5"));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a = new RectF();
        this.a.left = 0.0f;
        this.a.right = this.b;
        this.a.top = 0.0f;
        this.a.bottom = this.c;
        canvas.drawRoundRect(this.a, this.e, this.f, this.d);
    }

    public void a(int i) {
        if (this.d != null) {
            this.d.setColor(i);
        }
    }

    public void b(int i) {
        this.b = i;
    }

    public void c(int i) {
        this.c = i;
    }
}
