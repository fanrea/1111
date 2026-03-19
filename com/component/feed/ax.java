package com.component.feed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSIllegalArgumentException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.component.a.f.e;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ax extends ImageView implements com.component.a.c.c {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private final Paint A;
    private Matrix B;
    private c C;
    private float D;
    private final Paint d;
    private final Paint e;
    private Bitmap f;
    private final RectF g;
    private int h;
    private final Rect i;
    private final Path j;
    private float[] k;
    private b l;
    private int m;
    private boolean n;
    private float o;
    private com.component.a.i.f p;
    private float q;
    private Canvas r;
    private Bitmap s;
    private Canvas t;
    private Bitmap u;
    private boolean v;
    private int w;
    private boolean x;
    private Bitmap y;
    private Rect z;

    public enum b {
        RoundRect,
        Circle
    }

    public enum c {
        MATRIX_KEEP_BOTTOM,
        MATRIX_KEEP_TOP
    }

    public ax(Context context) {
        this(context, null);
    }

    public ax(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ax(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Paint();
        this.e = new Paint();
        this.g = new RectF();
        this.h = 0;
        this.i = new Rect();
        this.j = new Path();
        this.k = new float[8];
        this.l = b.RoundRect;
        this.o = 1.0f;
        this.v = false;
        this.w = 0;
        this.x = false;
        this.z = new Rect();
        this.A = new Paint();
        this.B = new Matrix();
        this.D = 0.0f;
        b();
    }

    private void b() {
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setAntiAlias(true);
        this.A.setStyle(Paint.Style.FILL);
        this.A.setAntiAlias(true);
        this.A.setColor(Color.parseColor("#000000"));
        this.A.setAlpha(75);
    }

    @Override // com.component.a.c.c
    public void switchViewStyle(com.component.a.f.e eVar) {
        e.f fVarH;
        if (eVar == null || (fVarH = eVar.h()) == null) {
            return;
        }
        Context context = getContext();
        float[] fArrA = fVarH.a(new float[8]);
        com.component.a.i.n.a(context, fArrA);
        a(fArrA);
        c(fVarH.f(-2.0f));
        a(e.f.a.equals(fVarH.a(e.f.a)) ? b.RoundRect : b.Circle);
        c(fVarH.f(0));
        b(com.component.a.i.r.a(fVarH.e(-1), fVarH.e(1.0f)));
        Drawable drawableA = com.component.a.i.r.a(context, fVarH);
        if (com.baidu.mobads.container.util.x.a(context).a() > 16) {
            setBackground(drawableA);
        } else {
            setBackgroundDrawable(drawableA);
        }
        setScaleType(com.component.a.a.e.a(eVar.p("fit_center")));
        invalidate();
    }

    @Override // com.component.a.c.c
    public void setLifeCycle(com.component.a.i.f fVar) {
        this.p = fVar;
    }

    @Override // com.component.a.c.c
    public com.component.a.i.f getLifeCycle() {
        return this.p;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.p != null) {
            this.p.a(this, z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.p != null) {
            this.p.a((View) this, i);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.p != null) {
            this.p.e(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.p != null) {
            this.p.f(this);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.p != null) {
            this.p.b(view, i);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.p != null) {
            this.p.a(motionEvent, zDispatchTouchEvent);
        }
        return zDispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.p != null) {
            this.p.b(motionEvent, zOnTouchEvent);
        }
        return zOnTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f) {
        this.o = f;
    }

    public void a(boolean z) {
        this.v = z;
    }

    public void a(int i) {
        this.w = i;
    }

    public void b(boolean z) {
        this.x = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        this.n = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f) {
        this.q = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float[] fArr) {
        this.k = fArr;
    }

    public void a(b bVar) {
        this.l = bVar;
    }

    public void a(c cVar) {
        this.C = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.d.setColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        this.m = i;
        this.d.setStrokeWidth(this.m);
    }

    public void a(float f) {
        this.D = f;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        d();
        invalidate();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        d();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Bitmap bitmap;
        if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            this.f = bitmap;
            this.y = null;
            drawable = new BitmapDrawable(this.f);
        }
        if (this.n) {
            c();
        }
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f = bitmap;
        this.y = null;
        if (this.n) {
            c();
        }
        super.setImageBitmap(this.f);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
    }

    public Bitmap a() {
        return this.f;
    }

    private void c() {
        if (this.f == null || com.baidu.mobads.container.util.x.a(null).a() < 17) {
            return;
        }
        try {
            this.f = Bitmap.createScaledBitmap(this.f, Math.round(this.f.getWidth() * 0.4f), Math.round(this.f.getHeight() * 0.4f), true);
            RenderScript renderScriptCreate = RenderScript.create(getContext());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, this.f);
            Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            scriptIntrinsicBlurCreate.setRadius(this.o);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            allocationCreateTyped.copyTo(this.f);
            renderScriptCreate.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.D > 0.0f) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 != 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) ((size / this.D) + 0.5f), 1073741824);
            } else if (mode != 1073741824 && mode2 == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec((int) ((size2 * this.D) + 0.5f), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        try {
            if (this.C == c.MATRIX_KEEP_BOTTOM || this.C == c.MATRIX_KEEP_TOP) {
                int width = getWidth();
                int height = getHeight();
                if (getDrawable() instanceof BitmapDrawable) {
                    int intrinsicWidth = getDrawable().getIntrinsicWidth();
                    int intrinsicHeight = getDrawable().getIntrinsicHeight();
                    float f = width / intrinsicWidth;
                    this.B.setScale(f, f);
                    if (this.C == c.MATRIX_KEEP_BOTTOM) {
                        this.B.postTranslate(0.0f, height - (intrinsicHeight * f));
                    }
                    setScaleType(ImageView.ScaleType.MATRIX);
                    setImageMatrix(this.B);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            if (this.h == 1 && !this.j.isEmpty()) {
                canvas.clipPath(this.j);
            }
            if (this.v && this.f != null) {
                b(canvas);
            }
            super.onDraw(canvas);
            if (this.m > 0) {
                a(canvas);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Canvas canvas) {
        canvas.drawPath(this.j, this.d);
    }

    private Bitmap a(Bitmap bitmap) {
        this.e.setAntiAlias(true);
        this.e.setColor(-16777216);
        this.t.drawPath(this.j, this.e);
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.t.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), this.e);
        return this.s;
    }

    private void d() {
        Rect rectE = e();
        if (rectE == null) {
            return;
        }
        this.g.set(rectE);
        this.i.set(rectE);
        if (this.m > 0) {
            this.g.inset(this.m, this.m);
        }
        float fA = com.component.a.i.r.a(this.g.width(), this.g.height(), this.q, -10.0f);
        if (fA >= 0.0f) {
            Arrays.fill(this.k, fA);
        }
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 27) {
            this.h = 2;
            setClipToOutline(true);
            setOutlineProvider(new ay(this));
        } else {
            this.h = 1;
        }
        if (this.l == b.RoundRect) {
            this.j.reset();
            this.j.addRoundRect(this.g, this.k, Path.Direction.CW);
        } else {
            if (this.l == b.Circle) {
                this.j.reset();
                this.j.addCircle(this.g.centerX(), this.g.centerY(), Math.min(this.g.height() / 2.0f, this.g.width() / 2.0f), Path.Direction.CW);
                return;
            }
            this.h = 0;
        }
    }

    private Rect e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (this.l == b.Circle) {
            int iMin = Math.min(width, height);
            int paddingLeft = getPaddingLeft() + ((width - iMin) / 2);
            int paddingTop = getPaddingTop() + ((height - iMin) / 2);
            return new Rect(paddingLeft, paddingTop, paddingLeft + iMin, iMin + paddingTop);
        }
        if (this.l == b.RoundRect) {
            int paddingLeft2 = getPaddingLeft();
            int paddingTop2 = getPaddingTop();
            return new Rect(paddingLeft2, paddingTop2, width + paddingLeft2, height + paddingTop2);
        }
        return null;
    }

    public static class a {
        private final Context a;
        private int e;
        private float h;
        private float[] b = {25.0f, 25.0f, 25.0f, 25.0f, 25.0f, 25.0f, 25.0f, 25.0f};
        private float c = 0.0f;
        private b d = b.RoundRect;
        private int f = -16777216;
        private boolean g = false;
        private boolean i = false;
        private float j = 0.0f;

        public a(Context context) {
            this.a = context;
        }

        public a a(b bVar) {
            this.d = bVar;
            return this;
        }

        public a a(float[] fArr) {
            if (fArr != null && fArr.length != 8) {
                throw new ArrayIndexOutOfBoundsException("outer radii must have 8 values");
            }
            this.b = fArr;
            return this;
        }

        public a a(float f) {
            this.c = f;
            return this;
        }

        public a a(int i) {
            this.e = i;
            return this;
        }

        public a a(boolean z) {
            this.i = z;
            return this;
        }

        public a b(int i) {
            this.f = i;
            return this;
        }

        public a b(boolean z) {
            this.g = z;
            return this;
        }

        public a b(float f) {
            if (f <= 0.0f || f > 25.0f) {
                throw new RSIllegalArgumentException("GaussianRadius out of range (0 < r <= 25).");
            }
            this.h = f;
            return this;
        }

        public a c(float f) {
            this.j = f;
            return this;
        }

        public ax a() {
            ax axVar = new ax(this.a);
            axVar.a(this.d);
            axVar.c(this.c);
            axVar.a(this.b);
            axVar.c(this.e);
            axVar.b(this.f);
            axVar.c(this.g);
            axVar.b(this.h);
            axVar.a(this.i);
            axVar.a(this.j);
            return axVar;
        }
    }

    private void b(Canvas canvas) {
        if (this.y == null && this.f != null) {
            this.y = com.component.a.i.r.a(getContext(), this.f, this.g, this.w, 0.4f, true);
            if (this.y != null) {
                this.z = new Rect(0, 0, this.y.getWidth(), this.y.getHeight());
            }
        }
        if (this.y != null) {
            canvas.drawBitmap(this.y, this.z, this.g, (Paint) null);
            if (this.x) {
                canvas.drawRect(this.g, this.A);
            }
        }
    }
}
