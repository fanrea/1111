package com.baidu.mobads.container.components;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.mobads.container.util.bv;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends TextView {
    private int a;
    private int b;
    private float c;
    private float d;
    private boolean e;
    private int f;
    private ColorStateList g;
    private int h;
    private int i;
    private int j;
    private Paint k;
    private RectF l;
    private int m;
    private int n;
    private b o;
    private long p;
    private int q;
    private final Rect r;
    private final RectF s;
    private final RectF t;
    private InterfaceC0120a u;
    private com.baidu.mobads.container.d.a v;

    /* renamed from: com.baidu.mobads.container.components.a$a, reason: collision with other inner class name */
    public interface InterfaceC0120a {
        void a();

        void a(int i);
    }

    public enum b {
        TEXT,
        TEXT_CD,
        CIRCLE
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -16777216;
        this.b = -16777216;
        this.c = 0.5f;
        this.d = 0.5f;
        this.e = false;
        this.f = 2;
        this.g = ColorStateList.valueOf(0);
        this.i = -16776961;
        this.j = 8;
        this.k = new Paint();
        this.l = new RectF();
        this.m = 100;
        this.n = this.m;
        this.o = b.TEXT_CD;
        this.p = com.alipay.sdk.m.u.b.a;
        this.r = new Rect();
        this.s = new RectF();
        this.t = new RectF();
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.k.setAntiAlias(true);
        this.g = ColorStateList.valueOf(0);
        this.h = this.g.getColorForState(getDrawableState(), 0);
    }

    public a a(int i) {
        this.a = i;
        invalidate();
        return this;
    }

    public a b(int i) {
        this.b = i;
        return this;
    }

    public a a(float f) {
        this.c = f;
        return this;
    }

    public a b(float f) {
        this.d = f;
        return this;
    }

    public a c(int i) {
        this.f = i;
        invalidate();
        return this;
    }

    public void d(int i) {
        this.g = ColorStateList.valueOf(i);
        invalidate();
    }

    private void g() {
        int colorForState = this.g.getColorForState(getDrawableState(), 0);
        if (this.h != colorForState) {
            this.h = colorForState;
            invalidate();
        }
    }

    public a e(int i) {
        this.i = i;
        invalidate();
        return this;
    }

    public a f(int i) {
        this.j = i;
        invalidate();
        return this;
    }

    public void g(int i) {
        this.n = i(i);
        invalidate();
    }

    private int i(int i) {
        if (i > this.m) {
            return this.m;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int a() {
        return this.n;
    }

    public void a(long j) {
        this.p = j;
        h();
        invalidate();
    }

    public void a(boolean z) {
        this.e = z;
    }

    public long b() {
        return this.p;
    }

    public a a(b bVar) {
        this.o = bVar;
        h();
        invalidate();
        return this;
    }

    public void a(RectF rectF) {
        this.t.set(bv.a(getContext(), rectF.left), bv.a(getContext(), rectF.top), bv.a(getContext(), rectF.right), bv.a(getContext(), rectF.bottom));
    }

    private void h() {
        switch (this.o) {
            case TEXT_CD:
                this.m = (int) (this.p / 1000);
                break;
            case CIRCLE:
                this.m = 100;
                break;
            default:
                this.n = 0;
                break;
        }
        this.n = this.m;
        j();
    }

    public b c() {
        return this.o;
    }

    public void a(InterfaceC0120a interfaceC0120a) {
        this.u = interfaceC0120a;
    }

    public void d() {
        f();
        i();
    }

    public void e() {
        h();
        d();
    }

    public synchronized void f() {
        if (this.v != null) {
            this.v.a_();
            this.v = null;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float fWidth;
        getDrawingRect(this.r);
        this.s.set(this.r);
        if (!this.t.isEmpty()) {
            this.t.offset(this.s.left, this.s.top);
            this.s.set(this.t);
        }
        float fMin = Math.min(this.s.height(), this.s.width()) / 2.0f;
        this.k.setStyle(Paint.Style.FILL);
        this.k.setColor(this.b);
        if (b.CIRCLE.equals(this.o)) {
            this.k.setAlpha((int) (this.c * 255.0f));
            canvas.drawCircle(this.s.centerX(), this.s.centerY(), fMin - this.f, this.k);
            this.k.setStyle(Paint.Style.STROKE);
            this.k.setColor(this.a);
            this.k.setStrokeWidth(this.j);
            this.k.setStrokeCap(Paint.Cap.ROUND);
            this.k.setAlpha(204);
            canvas.drawCircle(this.s.centerX(), this.s.centerY(), fMin - (this.j / 2), this.k);
        } else {
            if (this.d > 0.0f) {
                f = this.d;
                fWidth = this.s.height();
            } else {
                f = this.d;
                fWidth = this.s.width();
            }
            float f2 = f * fWidth;
            this.k.setAlpha((int) (this.c * 255.0f));
            canvas.drawRoundRect(this.s, f2, f2, this.k);
        }
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        float fCenterY = this.s.centerY() - ((paint.descent() + paint.ascent()) / 2.0f);
        String string = getText().toString();
        if (this.e) {
            string = String.format(Locale.getDefault(), string + " %02d", Integer.valueOf(this.q));
        }
        canvas.drawText(string, this.s.centerX(), fCenterY, paint);
        if (b.CIRCLE.equals(this.o)) {
            this.k.setColor(this.i);
            this.k.setStyle(Paint.Style.STROKE);
            this.k.setStrokeWidth(this.j);
            this.k.setStrokeCap(Paint.Cap.ROUND);
            this.k.setAlpha(204);
            this.l.set(this.s.left + (this.j / 2), this.s.top + (this.j / 2), this.s.right - (this.j / 2), this.s.bottom - (this.j / 2));
            canvas.drawArc(this.l, 270.0f, (this.n * 360) / this.m, false, this.k);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        g();
    }

    private void i() {
        this.n++;
        j();
        this.v = new com.baidu.mobads.container.components.b(this);
        com.baidu.mobads.container.d.b.a().a(this.v, 0L, this.p / this.m, TimeUnit.MILLISECONDS);
    }

    private void j() {
        this.q = (int) ((this.n * this.p) / (this.m * 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.n--;
        j();
        if (this.n > 0 && this.n <= this.m) {
            if (this.u != null) {
                this.u.a(this.n);
            }
            postInvalidate();
        } else {
            this.n = i(this.n);
            if (this.u != null) {
                this.u.a();
            }
            f();
        }
    }

    public void a(int i, int i2) {
        if (i <= 0) {
            return;
        }
        this.n = (this.m * i2) / i;
        j();
        invalidate();
    }

    public void h(int i) {
        this.m = i;
        h();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }
}
