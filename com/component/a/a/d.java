package com.component.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.x;
import com.component.a.f.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends View implements com.baidu.mobads.container.util.animation.a.d, com.component.a.c.c {
    private static final String d = d.class.getSimpleName();
    private boolean A;
    private com.baidu.mobads.container.util.animation.a.c B;
    private com.component.a.i.f C;
    protected String a;
    protected int b;
    protected int c;
    private Paint e;
    private int f;
    private Paint g;
    private int h;
    private int i;
    private int j;
    private Path k;
    private RectF l;
    private boolean m;
    private float n;
    private int o;
    private float p;
    private Typeface q;
    private boolean r;
    private int s;
    private int t;
    private float u;
    private float v;
    private PorterDuffXfermode w;
    private Bitmap x;
    private Bitmap y;
    private boolean z;

    public d(Context context) {
        super(context);
        this.f = 255;
        this.h = Color.parseColor("#3388FF");
        this.i = 3;
        this.j = 255;
        this.k = new Path();
        this.l = new RectF();
        this.m = false;
        this.n = 10.0f;
        this.o = -1;
        this.p = 1.0f;
        this.r = false;
        this.b = -1;
        this.c = 100;
        this.u = 12.0f;
        this.v = -2.0f;
        this.w = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        a();
    }

    public d(Context context, com.component.a.f.e eVar) {
        super(context);
        this.f = 255;
        this.h = Color.parseColor("#3388FF");
        this.i = 3;
        this.j = 255;
        this.k = new Path();
        this.l = new RectF();
        this.m = false;
        this.n = 10.0f;
        this.o = -1;
        this.p = 1.0f;
        this.r = false;
        this.b = -1;
        this.c = 100;
        this.u = 12.0f;
        this.v = -2.0f;
        this.w = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        if (eVar != null) {
            this.C = new com.component.a.i.f(eVar);
            a(eVar.o(""));
            e.g gVarI = eVar.i();
            a(gVarI.b() ? eVar.a("@res/white_right_arrow") : null);
            b(gVarI.c() ? eVar.a("@res/white_right_arrow") : null);
            a(eVar);
        }
        a();
    }

    private void a(com.component.a.f.e eVar) {
        if (eVar != null) {
            Context context = getContext();
            e.f fVarH = eVar.h();
            e.g gVarI = eVar.i();
            this.f = (int) (fVarH.a(1.0f) * 255.0f);
            this.s = com.component.a.i.r.a(fVarH.a(Color.parseColor("#3388FF")), fVarH.a(1.0f));
            this.t = com.component.a.i.r.a(gVarI.a(Color.parseColor("#D7E6FF")), fVarH.a(1.0f));
            this.u = ab.a(context, fVarH.g(3));
            this.v = fVarH.f(-2.0f);
            this.i = ab.a(context, fVarH.f(0));
            if (this.i > 0) {
                this.m = true;
            }
            this.h = com.component.a.i.r.a(fVarH.e(Color.parseColor("#3388FF")), fVarH.e(1.0f));
            this.j = (int) (fVarH.e(1.0f) * 255.0f);
            e.i iVarG = eVar.g();
            this.p = iVarG.a(1.0f);
            this.o = com.component.a.i.r.a(iVarG.d(Color.parseColor("#F5F5F5")), iVarG.a(1.0f));
            this.n = ab.a(context, iVarG.c(12));
            this.q = com.component.a.i.n.a(iVarG, 0);
            this.r = com.component.a.i.n.a(iVarG.e(0));
        }
    }

    @Override // com.component.a.c.c
    public void switchViewStyle(com.component.a.f.e eVar) {
        if (eVar != null) {
            a(eVar);
            a();
        }
        invalidate();
    }

    @Override // com.component.a.c.c
    public void setLifeCycle(com.component.a.i.f fVar) {
        this.C = fVar;
    }

    @Override // com.component.a.c.c
    public com.component.a.i.f getLifeCycle() {
        return this.C;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.C != null) {
            this.C.a(this, z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.C != null) {
            this.C.a((View) this, i);
        }
    }

    @Override // com.baidu.mobads.container.util.animation.a.d
    public void a(com.baidu.mobads.container.util.animation.a.c cVar) {
        this.B = cVar;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C != null) {
            this.C.e(this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.C != null) {
            this.C.f(this);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.C != null) {
            this.C.b(view, i);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.C != null) {
            this.C.a(motionEvent, zDispatchTouchEvent);
        }
        return zDispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.C != null) {
            this.C.b(motionEvent, zOnTouchEvent);
        }
        return zOnTouchEvent;
    }

    public void a(int i) {
        if (i > 0) {
            this.c = i;
        }
    }

    public int b() {
        return this.c;
    }

    public void b(int i) {
        this.s = i;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.t = i;
    }

    public void c(int i) {
        this.u = i;
    }

    public float c() {
        return this.u;
    }

    public void a(String str) {
        this.a = str;
        postInvalidate();
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void d(int i) {
        this.o = i;
        postInvalidate();
    }

    public void e(int i) {
        this.n = i;
    }

    public void a(Typeface typeface) {
        this.q = typeface;
    }

    public void f(int i) {
        if (i > this.c) {
            return;
        }
        this.b = i;
        postInvalidate();
    }

    public void b(boolean z) {
        this.z = z;
    }

    public void c(boolean z) {
        this.A = z;
    }

    public void a(Bitmap bitmap) {
        this.x = bitmap;
    }

    public void b(Bitmap bitmap) {
        this.y = bitmap;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.u = com.component.a.i.r.a(getWidth(), getHeight(), this.v, this.u);
        if (this.m) {
            this.k.reset();
            this.l.set(0.0f, 0.0f, getWidth(), getHeight());
            this.k.addRoundRect(this.l, this.u, this.u, Path.Direction.CW);
            if (getWidth() >= this.i * 2 && getHeight() >= this.i * 2) {
                float f = this.u > ((float) this.i) ? this.u - this.i : 0.0f;
                this.l.inset(this.i, this.i);
                this.k.addRoundRect(this.l, f, f, Path.Direction.CCW);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b < 0 || this.b >= this.c) {
            this.e.setColor(this.s);
            a(canvas, 0, 0, getWidth(), getHeight(), this.u, this.e);
            b(canvas);
            a(canvas, this.a, this.e, this.o, this.n, this.q);
            return;
        }
        a(canvas);
        b(canvas);
        if (!TextUtils.isEmpty(this.a)) {
            c(canvas);
        }
    }

    private void a(Canvas canvas) {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        this.e.setColor(this.t);
        a(canvas2, 0, 0, getWidth(), getHeight(), this.u, this.e, false);
        a(canvas2, this.e, this.s, true);
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
        if (!bitmapCreateBitmap.isRecycled()) {
            bitmapCreateBitmap.recycle();
        }
    }

    private void b(Canvas canvas) {
        if (this.m && !this.k.isEmpty()) {
            canvas.drawPath(this.k, this.g);
        }
    }

    private void c(Canvas canvas) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        a(canvas2, this.a, this.e, com.component.a.i.r.a(this.s, this.p), this.n, this.q);
        a(canvas2, this.e, this.o, false);
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
        if (!bitmapCreateBitmap.isRecycled()) {
            bitmapCreateBitmap.recycle();
        }
    }

    private void a() {
        this.e = new Paint();
        this.e.setAlpha(this.f);
        this.e.setAntiAlias(true);
        this.e.setStrokeWidth(3.0f);
        this.g = new Paint();
        this.g.setAntiAlias(true);
        this.g.setColor(this.h);
        this.g.setAlpha(this.j);
        this.g.setStrokeWidth(0.0f);
        this.g.setStyle(Paint.Style.FILL_AND_STROKE);
        this.g.setStrokeJoin(Paint.Join.ROUND);
    }

    private void a(Canvas canvas, String str, Paint paint, int i, float f, Typeface typeface) {
        if (canvas != null && paint != null && !TextUtils.isEmpty(str)) {
            paint.setColor(i);
            paint.setTextSize(f);
            if (typeface != null) {
                paint.setTypeface(typeface);
            }
            if (this.r) {
                paint.setFlags(8);
            }
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f2 = -fontMetrics.ascent;
            float fMeasureText = paint.measureText(str);
            float width = d() ? (this.x.getWidth() * f2) / this.x.getHeight() : 0.0f;
            float width2 = e() ? (this.y.getWidth() * f2) / this.y.getHeight() : 0.0f;
            float measuredWidth = (((getMeasuredWidth() - width) - width2) - fMeasureText) / 2.0f;
            float height = (getHeight() - f2) / 2.0f;
            float height2 = (getHeight() + f2) / 2.0f;
            ColorFilter colorFilter = paint.getColorFilter();
            paint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            if (width > 0.0f) {
                float f3 = width + measuredWidth;
                canvas.drawBitmap(this.x, (Rect) null, new RectF(measuredWidth, height, f3, height2), paint);
                measuredWidth = f3;
            }
            canvas.drawText(str, measuredWidth, (getHeight() / 2) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f), paint);
            float f4 = measuredWidth + fMeasureText;
            if (width2 > 0.0f) {
                canvas.drawBitmap(this.y, (Rect) null, new RectF(f4, height, width2 + f4, height2), paint);
            }
            paint.setColorFilter(colorFilter);
        }
    }

    private boolean d() {
        return this.x != null && this.z;
    }

    private boolean e() {
        return this.y != null && this.A;
    }

    private void a(Canvas canvas, Paint paint, int i, boolean z) {
        paint.setXfermode(this.w);
        paint.setColor(i);
        a(canvas, 0, 0, (getWidth() * this.b) / this.c, getHeight(), 0.0f, paint, z);
        paint.setXfermode(null);
    }

    private void a(Canvas canvas, int i, int i2, int i3, int i4, float f, Paint paint) {
        a(canvas, i, i2, i3, i4, f, paint, true);
    }

    private void a(Canvas canvas, int i, int i2, int i3, int i4, float f, Paint paint, boolean z) {
        paint.setAntiAlias(true);
        if (this.B != null && z) {
            this.B.a(canvas, com.baidu.mobads.container.util.animation.a.a, paint);
        }
        if (x.a(null).a() >= 21) {
            canvas.drawRoundRect(i, i2, i3, i4, f, f, paint);
        } else {
            canvas.drawRoundRect(new RectF(i, i2, i3, i4), f, f, paint);
        }
        if (this.B != null && z) {
            this.B.b(canvas, com.baidu.mobads.container.util.animation.a.a, paint);
        }
    }
}
