package com.baidu.mobads.container.rewardvideo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class dn extends TextView {
    final Rect a;
    private int b;
    private int c;
    private ColorStateList d;
    private int e;
    private int f;
    private int g;
    private Paint h;
    private RectF i;
    private int j;
    private float k;
    private b l;
    private long m;
    private a n;
    private c o;

    public interface a {
        void a();

        void a(float f);
    }

    public enum b {
        COUNT,
        COUNT_BACK
    }

    public dn(Context context) {
        this(context, null);
    }

    public dn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public dn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -16777216;
        this.c = 2;
        this.d = ColorStateList.valueOf(0);
        this.f = -16776961;
        this.g = 8;
        this.h = new Paint();
        this.i = new RectF();
        this.j = 100;
        this.l = b.COUNT;
        this.m = com.alipay.sdk.m.u.b.a;
        this.a = new Rect();
        a(context, attributeSet);
    }

    public void a(int i) {
        this.b = i;
        invalidate();
    }

    public void b(int i) {
        this.c = i;
        invalidate();
    }

    public void c(int i) {
        this.d = ColorStateList.valueOf(i);
        invalidate();
    }

    public void d(int i) {
        this.f = i;
        invalidate();
    }

    public void e(int i) {
        this.g = i;
        invalidate();
    }

    public void a(float f) {
        this.k = b(f);
        invalidate();
    }

    public float a() {
        return this.k;
    }

    public void a(long j) {
        this.m = j;
        invalidate();
    }

    public long b() {
        return this.m;
    }

    public void a(b bVar) {
        this.l = bVar;
        j();
        invalidate();
    }

    public b c() {
        return this.l;
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    public void d() {
        f();
        post(this.o);
    }

    public void e() {
        j();
        d();
    }

    public void f() {
        removeCallbacks(this.o);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.a);
        float fWidth = (this.a.height() > this.a.width() ? this.a.width() : this.a.height()) / 2;
        this.h.setStyle(Paint.Style.FILL);
        this.h.setColor(this.b);
        this.h.setAlpha(127);
        canvas.drawCircle(this.a.centerX(), this.a.centerY(), fWidth - this.c, this.h);
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setColor(this.b);
        this.h.setStrokeWidth(this.g);
        this.h.setStrokeCap(Paint.Cap.ROUND);
        this.h.setAlpha(204);
        canvas.drawCircle(this.a.centerX(), this.a.centerY(), fWidth - (this.g / 2), this.h);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(getText().toString(), this.a.centerX(), this.a.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        this.h.setColor(this.f);
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setStrokeWidth(this.g);
        this.h.setStrokeCap(Paint.Cap.ROUND);
        this.h.setAlpha(204);
        this.i.set(this.a.left + (this.g / 2), this.a.top + (this.g / 2), this.a.right - (this.g / 2), this.a.bottom - (this.g / 2));
        canvas.drawArc(this.i, 270.0f, (this.k * 360.0f) / this.j, false, this.h);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        i();
    }

    public void a(int i, int i2) {
        if (i <= 0) {
            return;
        }
        this.k = (this.j * i2) / i;
        invalidate();
    }

    public void f(int i) {
        this.j = i;
        j();
    }

    public int g() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        removeCallbacks(this.o);
        switch (Cdo.a[this.l.ordinal()]) {
            case 1:
                this.k += 1.0f;
                break;
            case 2:
                this.k -= 1.0f;
                break;
        }
        if (this.k >= 0.0f && this.k <= this.j) {
            if (this.n != null) {
                this.n.a(this.k);
            }
            invalidate();
            postDelayed(this.o, this.m / this.j);
            return;
        }
        this.k = b(this.k);
        if (this.n != null) {
            this.n.a();
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.h.setAntiAlias(true);
        this.d = ColorStateList.valueOf(0);
        this.e = this.d.getColorForState(getDrawableState(), 0);
        this.o = new c(this);
    }

    private void i() {
        int colorForState = this.d.getColorForState(getDrawableState(), 0);
        if (this.e != colorForState) {
            this.e = colorForState;
            invalidate();
        }
    }

    private void j() {
        switch (Cdo.a[this.l.ordinal()]) {
            case 1:
                this.k = 0.0f;
                break;
            case 2:
                this.k = this.j;
                break;
            default:
                this.k = 0.0f;
                break;
        }
    }

    private float b(float f) {
        if (f > this.j) {
            return this.j;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    static class c implements Runnable {
        private WeakReference<dn> a;

        c(dn dnVar) {
            this.a = new WeakReference<>(dnVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            dn dnVar = this.a.get();
            if (dnVar != null) {
                dnVar.h();
            }
        }
    }
}
