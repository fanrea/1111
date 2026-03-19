package com.component.player;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b extends View {
    private static final int b = 100;
    final Rect a;
    private float c;
    private int d;
    private int e;
    private int f;
    private Paint g;

    public b(Context context) {
        super(context);
        this.d = -7829368;
        this.e = -16777216;
        this.f = 4;
        this.g = new Paint();
        this.a = new Rect();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = -7829368;
        this.e = -16777216;
        this.f = 4;
        this.g = new Paint();
        this.a = new Rect();
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = -7829368;
        this.e = -16777216;
        this.f = 4;
        this.g = new Paint();
        this.a = new Rect();
    }

    public void a(float f) {
        this.c = f * 100.0f;
        invalidate();
    }

    public float a() {
        return this.c;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.f = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.a);
        int i = (this.a.top + this.a.bottom) / 2;
        int i2 = (int) (((this.a.right - this.a.left) * this.c) / 100.0f);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(this.f);
        this.g.setStrokeCap(Paint.Cap.SQUARE);
        this.g.setAlpha(204);
        this.g.setAntiAlias(true);
        this.g.setColor(this.e);
        float f = i;
        canvas.drawLine(this.a.left, f, this.a.right, f, this.g);
        this.g.setColor(this.d);
        canvas.drawLine(this.a.left, f, this.a.left + i2, f, this.g);
    }
}
