package com.component.a.d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.bq;
import com.component.a.d.b;
import com.component.a.f.e;
import com.component.a.i.n;
import com.component.a.i.p;
import com.component.a.i.r;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c extends RelativeLayout implements com.component.a.c.b {
    private static final String a = "JsonRelativeLayout";
    private static final int b = 360;
    private static final int d = 779;
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    private final Paint A;
    private MotionEvent B;
    private MotionEvent C;
    private float D;
    private float E;
    private float F;
    private float G;
    private boolean H;
    private int I;
    private boolean J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f755K;
    private boolean L;
    protected final com.component.a.d.b c;
    private com.component.a.i.f h;
    private final b.a i;
    private float j;
    private float[] k;
    private float l;
    private final Path m;
    private final RectF n;
    private float o;
    private final Rect p;
    private int q;
    private Drawable r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private float w;
    private b x;
    private boolean y;
    private final Path z;

    public interface b {
        void a(View view, boolean z, MotionEvent motionEvent, MotionEvent motionEvent2);
    }

    public c(Context context, com.component.a.f.e eVar) {
        super(context);
        this.i = new b.a();
        this.j = -1.0f;
        this.c = new com.component.a.d.b(this);
        this.k = new float[8];
        this.l = -2.0f;
        this.m = new Path();
        this.n = new RectF();
        this.o = 0.0f;
        this.p = new Rect();
        this.q = 0;
        this.s = false;
        this.t = true;
        this.u = false;
        this.v = 0;
        this.w = -1.0f;
        this.y = false;
        this.z = new Path();
        this.A = new Paint();
        this.H = true;
        this.I = 3;
        this.J = false;
        this.f755K = false;
        this.L = false;
        if (eVar != null) {
            this.h = new com.component.a.i.f(eVar);
            a(context, eVar);
        }
    }

    public boolean p() {
        return this.s;
    }

    @Override // com.component.a.c.c
    public void switchViewStyle(com.component.a.f.e eVar) {
        if (eVar != null) {
            a(getContext(), eVar);
        }
        invalidate();
    }

    private void a(Context context, com.component.a.f.e eVar) {
        e.f fVarH = eVar.h();
        Drawable drawableA = r.a(context, fVarH);
        if (Build.VERSION.SDK_INT > 16) {
            setBackground(drawableA);
        } else {
            setBackgroundDrawable(drawableA);
        }
        this.k = fVarH.a(this.k);
        n.a(context, this.k);
        this.l = fVarH.f(-2.0f);
        JSONObject jSONObjectC = eVar.c();
        if (jSONObjectC != null) {
            this.s = jSONObjectC.optInt("slide_enable", 0) == 1;
            this.u = jSONObjectC.optInt("slide_check", 0) == 1;
            this.t = jSONObjectC.optInt("slide_click", 1) == 1;
            this.v = jSONObjectC.optInt("slide_dir", 0);
            this.w = b(jSONObjectC.optInt("slide_angle", -1));
            this.y = jSONObjectC.optInt("slide_path", 0) == 1;
            this.A.setColor(-1);
            this.A.setStyle(Paint.Style.STROKE);
            this.A.setStrokeWidth(20.0f);
            this.A.setStrokeCap(Paint.Cap.ROUND);
            this.A.setShadowLayer(5.0f, 3.0f, 3.0f, -16777216);
        }
        a(context, fVarH);
        if (b()) {
            if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 27) {
                this.q = 2;
                this.o = b(context, fVarH);
                setClipToOutline(true);
                setOutlineProvider(new d(this));
                return;
            }
            this.q = 1;
            return;
        }
        this.q = 0;
    }

    public void a(b bVar) {
        this.x = bVar;
    }

    public void a(View view, com.component.a.f.e eVar, int i) {
        if (view != null && eVar != null) {
            p.a(this, view, eVar, i, new a(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(0, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        b.C0314b c0314bA;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((layoutParams instanceof a) && (c0314bA = ((a) layoutParams).a()) != null && c0314bA.u > 0.0f) {
            this.j = c0314bA.u;
        }
        a(i, i2);
        if (this.j == -1.0f) {
            super.onMeasure(i, i2);
        } else {
            b(i, i2);
            super.onMeasure(this.i.a, this.i.b);
        }
        if (this.c.b()) {
            if (this.j == -1.0f) {
                super.onMeasure(i, i2);
            } else {
                b(i, i2);
                super.onMeasure(this.i.a, this.i.b);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(android.content.Context r9, com.component.a.f.e.f r10) {
        /*
            r8 = this;
            java.lang.String r9 = "round_rect"
            org.json.JSONObject r0 = r10.a()     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L40
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            int r0 = r10.b(r0)     // Catch: java.lang.Throwable -> L4e
            r1 = 0
            float r2 = r10.b(r1)     // Catch: java.lang.Throwable -> L4e
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 > 0) goto L1c
            boolean r1 = r8.y     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L40
        L1c:
            int r0 = com.component.a.i.r.a(r0, r2)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r10 = r10.a(r9)     // Catch: java.lang.Throwable -> L4e
            boolean r9 = r9.equals(r10)     // Catch: java.lang.Throwable -> L4e
            if (r9 == 0) goto L2d
            r9 = 0
            r1 = 0
            goto L2f
        L2d:
            r9 = 1
            r1 = 1
        L2f:
            android.graphics.drawable.GradientDrawable$Orientation r2 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM     // Catch: java.lang.Throwable -> L4e
            int[] r3 = new int[]{r0}     // Catch: java.lang.Throwable -> L4e
            float[] r6 = r8.k     // Catch: java.lang.Throwable -> L4e
            float r7 = r8.l     // Catch: java.lang.Throwable -> L4e
            r4 = -1
            r5 = 0
            android.graphics.drawable.Drawable r9 = com.component.a.i.r.a(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L4e
            goto L41
        L40:
            r9 = 0
        L41:
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L4e
            r0 = 23
            if (r10 < r0) goto L4b
            r8.setForeground(r9)     // Catch: java.lang.Throwable -> L4e
            goto L4d
        L4b:
            r8.r = r9     // Catch: java.lang.Throwable -> L4e
        L4d:
            goto L52
        L4e:
            r9 = move-exception
            r9.printStackTrace()
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.a.d.c.a(android.content.Context, com.component.a.f.e$f):void");
    }

    protected void a(int i, int i2) {
        a aVar;
        int i3;
        View viewC;
        this.c.a(i, i2);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof a) && (i3 = (aVar = (a) layoutParams).a) != 0 && (viewC = c(i3)) != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredWidth2 = viewC.getMeasuredWidth();
                if (measuredWidth > 0 && measuredWidth2 > 0) {
                    aVar.addRule(5, i3);
                    aVar.leftMargin = (measuredWidth2 - measuredWidth) / 2;
                    aVar.rightMargin = 0;
                }
                int measuredHeight = childAt.getMeasuredHeight();
                int measuredHeight2 = viewC.getMeasuredHeight();
                if (measuredHeight > 0 && measuredHeight2 > 0) {
                    aVar.addRule(6, i3);
                    aVar.topMargin = (measuredHeight2 - measuredHeight) / 2;
                    aVar.bottomMargin = 0;
                }
            }
        }
    }

    protected void b(int i, int i2) {
        this.i.a = i;
        this.i.b = i2;
        b.a.a(this.i, this.j, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
    }

    private boolean a(float[] fArr) {
        int iFloatToIntBits = Float.floatToIntBits(0.0f);
        for (float f2 : fArr) {
            if (Float.floatToIntBits(f2) != iFloatToIntBits) {
                return false;
            }
        }
        return true;
    }

    private boolean a(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View viewA;
        super.onLayout(z, i, i2, i3, i4);
        this.c.a();
        int childCount = getChildCount();
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if ((layoutParams instanceof a) && a(childAt, (a) layoutParams, width, height) != 1.0f && (viewA = a(com.component.a.i.f.c(childAt).l(""))) != null) {
                        a(childAt, viewA);
                    }
                }
            }
            if (this.q > 0) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                int width2 = (getWidth() - paddingLeft) - getPaddingRight();
                int height2 = (getHeight() - paddingTop) - getPaddingBottom();
                float fA = r.a(width2, height2, this.l, -1.0f);
                if (fA > 0.001f) {
                    this.o = fA;
                    Arrays.fill(this.k, fA);
                }
                if (this.q == 2) {
                    this.p.set(paddingLeft, paddingTop, width2 + paddingLeft, height2 + paddingTop);
                } else if (this.q == 1) {
                    this.n.set(paddingLeft, paddingTop, paddingLeft + width2, paddingTop + height2);
                    this.m.reset();
                    this.m.addRoundRect(this.n, this.k, Path.Direction.CCW);
                }
            }
        }
    }

    private static float a(View view, a aVar, int i, int i2) {
        float fA;
        Context context = view.getContext();
        if (aVar.a().a >= 0.0f || aVar.a().b >= 0.0f) {
            return 1.0f;
        }
        int i3 = aVar.f;
        if (i3 == 1) {
            fA = ab.a(context, 360.0f) / com.component.a.i.a.c(context);
        } else if (i3 != 2) {
            fA = 1.0f;
        } else {
            fA = ab.a(context, 779.0f) / com.component.a.i.a.d(context);
        }
        int left = view.getLeft();
        int top = view.getTop();
        int right = view.getRight();
        int bottom = view.getBottom();
        int i4 = right - left;
        int i5 = bottom - top;
        float f2 = (left + right) / 2.0f;
        float f3 = (top + bottom) / 2.0f;
        if ((aVar.b != 0 || aVar.c != 0 || aVar.d != 0 || aVar.e != 0) && i4 > 0 && i5 > 0 && i > 0 && i2 > 0) {
            float fMin = Math.min(Math.min((f2 - aVar.b) / (f2 - left), (f3 - aVar.c) / (f3 - top)), Math.min(((i - f2) - aVar.d) / (right - f2), ((i2 - f3) - aVar.e) / (bottom - f3)));
            if (fA > 0.0f && fMin > 0.0f) {
                fA = Math.min(fMin, fA);
            }
        }
        if (fA != 1.0f && !Float.isNaN(fA)) {
            view.setScaleX(fA);
            view.setScaleY(fA);
        }
        return fA;
    }

    private View a(String str) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                com.component.a.f.e eVarC = com.component.a.i.f.c(childAt);
                if (str.equals(eVarC.d("")) || str.equals(eVarC.b("")) || str.equals(eVarC.e("")) || str.equals(eVarC.c(""))) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private static void a(View view, View view2) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        float left = (view.getLeft() + view.getRight()) / 2.0f;
        view2.setTranslationX((((view2.getLeft() + view2.getRight()) / 2.0f) - left) * (scaleX - 1.0f));
        view2.setTranslationY((((view2.getTop() + view2.getBottom()) / 2.0f) - ((view.getTop() + view.getBottom()) / 2.0f)) * (scaleY - 1.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.q == 1 && !this.m.isEmpty()) {
            canvas.clipPath(this.m);
        }
        super.dispatchDraw(canvas);
        if (this.r != null) {
            this.r.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.r.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
        if (this.y) {
            canvas.drawPath(this.z, this.A);
        }
    }

    public void setLifeCycle(com.component.a.i.f fVar) {
        this.h = fVar;
    }

    public com.component.a.i.f getLifeCycle() {
        return this.h;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.h != null) {
            this.h.a(this, z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.h != null) {
            this.h.a((View) this, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h != null) {
            this.h.e(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.h != null) {
            this.h.f(this);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.h != null) {
            this.h.b(view, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.s && motionEvent != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                a(true);
            } else if (action == 1) {
                a(false);
            }
        }
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.h != null) {
            this.h.a(motionEvent, zDispatchTouchEvent);
        }
        return zDispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.s) {
            try {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                switch (motionEvent.getAction()) {
                    case 0:
                        a(motionEvent, x, y);
                        zOnTouchEvent = true;
                        break;
                    case 1:
                        if (a(this.t, motionEvent)) {
                            zOnTouchEvent = true;
                            break;
                        }
                        break;
                    case 2:
                        if (!this.L) {
                            if (!this.f755K) {
                                this.f755K = Math.abs(x - this.D) >= ((float) this.I) || Math.abs(y - this.E) >= ((float) this.I);
                            }
                            if (this.f755K) {
                                boolean zA = a(x, y);
                                if (zA) {
                                    if (!this.H) {
                                        bq.a().a(a, "SlideView slide into view from outside");
                                    } else {
                                        this.J = true;
                                        d(x, y);
                                    }
                                } else if (this.H) {
                                    this.L = true;
                                    a(false);
                                } else {
                                    this.L = true;
                                }
                                this.H = zA;
                                this.F = x;
                                this.G = y;
                                this.C = motionEvent;
                                break;
                            }
                        } else {
                            break;
                        }
                        break;
                    case 3:
                        a(false);
                        if (a(false, motionEvent)) {
                            zOnTouchEvent = true;
                            break;
                        }
                        break;
                }
            } catch (Throwable th) {
                bq.a().a(a, th);
            }
        }
        if (this.h != null) {
            this.h.b(motionEvent, zOnTouchEvent);
        }
        return zOnTouchEvent;
    }

    private void a(MotionEvent motionEvent, float f2, float f3) {
        this.f755K = false;
        this.L = false;
        this.J = false;
        this.B = MotionEvent.obtainNoHistory(motionEvent);
        this.D = f2;
        this.E = f3;
        this.F = f2;
        this.G = f3;
        this.H = true;
    }

    private void a(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean a(float f2, float f3) {
        if (this.u) {
            return b(f2, f3);
        }
        return f2 >= 0.0f && f2 <= ((float) getWidth()) && f3 >= 0.0f && f3 <= ((float) getHeight());
    }

    private boolean b(float f2, float f3) {
        if (this.v <= 0) {
            return true;
        }
        if ((this.v & 1) == 1 && f2 < this.D) {
            return c(this.E - f3, this.D - f2);
        }
        if ((this.v & 2) == 2 && f3 < this.E) {
            return c(this.D - f2, this.E - f3);
        }
        if ((this.v & 4) == 4 && this.D < f2) {
            return c(f3 - this.E, f2 - this.D);
        }
        if ((this.v & 8) == 8 && this.E < f3) {
            return c(f2 - this.D, f3 - this.E);
        }
        return false;
    }

    private float b(int i) {
        if (i >= 0 && i < 90) {
            double d2 = i;
            Double.isNaN(d2);
            try {
                return (float) Math.tan(d2 * 0.01745d);
            } catch (Throwable th) {
                bq.a().a(a, th);
                return -1.0f;
            }
        }
        return -1.0f;
    }

    private boolean c(float f2, float f3) {
        try {
            if (this.w >= 0.0f) {
                float f4 = f2 / f3;
                if ((-this.w) <= f4) {
                    if (f4 <= this.w) {
                        return true;
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            bq.a().a(a, th);
        }
        return true;
    }

    private boolean a(boolean z, MotionEvent motionEvent) {
        this.C = MotionEvent.obtainNoHistory(motionEvent);
        a();
        if (b(z)) {
            return true;
        }
        return false;
    }

    private boolean b(boolean z) {
        if (this.J) {
            if (this.x != null) {
                this.x.a(this, false, this.B, this.C);
            }
            return true;
        }
        if (!z || this.f755K) {
            return false;
        }
        if (this.x != null) {
            this.x.a(this, true, this.B, this.C);
        }
        return true;
    }

    private void d(float f2, float f3) {
        if (this.y) {
            if (this.z.isEmpty()) {
                this.z.moveTo(this.D, this.E);
            } else {
                this.z.quadTo(this.F, this.G, (this.F + f2) / 2.0f, (this.G + f3) / 2.0f);
            }
            invalidate();
        }
    }

    private void a() {
        if (this.y) {
            this.z.reset();
            invalidate();
        }
    }

    public View a(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getId() == i) {
                return childAt;
            }
        }
        return null;
    }

    private boolean b() {
        return !a(this.k) || (this.l >= -1.0f && this.l <= 1.0f);
    }

    private float b(Context context, e.f fVar) {
        JSONObject jSONObjectA;
        JSONArray jSONArrayOptJSONArray;
        if (fVar != null && (jSONObjectA = fVar.a()) != null && (jSONArrayOptJSONArray = jSONObjectA.optJSONArray("radius")) != null) {
            float fA = com.component.a.i.a.a(context);
            if (jSONArrayOptJSONArray.length() == 9) {
                return ((float) jSONArrayOptJSONArray.optDouble(8)) * fA;
            }
            if (jSONArrayOptJSONArray.length() > 0) {
                return ((float) jSONArrayOptJSONArray.optDouble(0)) * fA;
            }
            return 0.0f;
        }
        return 0.0f;
    }

    private View c(int i) {
        if (i == 0) {
            return null;
        }
        try {
            View viewA = a(i);
            if (viewA == null) {
                return null;
            }
            while (viewA.getVisibility() == 8) {
                int iB = ((a) viewA.getLayoutParams()).b();
                if (iB != 0) {
                    View viewA2 = a(iB);
                    if (viewA2 == null || viewA == viewA2) {
                        return null;
                    }
                    viewA = viewA2;
                }
            }
            return viewA;
        } catch (Throwable th) {
            return null;
        }
    }

    public static class a extends RelativeLayout.LayoutParams implements b.c {
        int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        private b.C0314b g;

        public a(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
        }

        public void a(int i) {
            this.a = i;
        }

        public int b() {
            return this.a;
        }

        @Override // com.component.a.d.b.c
        public b.C0314b a() {
            if (this.g == null) {
                this.g = new b.C0314b();
            }
            return this.g;
        }
    }
}
