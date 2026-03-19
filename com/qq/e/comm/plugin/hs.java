package com.qq.e.comm.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Region;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.HashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hs extends View {
    private GradientDrawable A;
    private GradientDrawable B;
    private GradientDrawable C;
    private GradientDrawable D;
    private GradientDrawable E;
    private GradientDrawable F;
    private GradientDrawable G;
    private GradientDrawable H;
    private GradientDrawable I;
    private Bitmap J;

    /* renamed from: K, reason: collision with root package name */
    private Bitmap f777K;
    private Bitmap L;
    private boolean M;
    private boolean N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private final HashMap<Integer, Integer> S;
    private Paint T;
    private float U;
    private float V;
    private k W;
    private i a;
    private String a0;
    private Paint b;
    private boolean b0;
    private final Paint c;
    private int c0;
    private final Paint d;
    private int d0;
    private final Paint e;
    private int e0;
    private Path f;
    private Path g;
    private j h;
    private j i;
    private j j;
    private j m;
    private j n;
    private j o;
    private j p;
    private j q;
    private j r;
    private j s;
    private j t;
    private float u;
    private float v;
    private int w;
    private int x;
    private final float[] y;
    private Matrix z;

    /* compiled from: A */
    static /* synthetic */ class h {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.values().length];
            a = iArr;
            try {
                iArr[i.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.CENTER_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[i.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: A */
    private enum i {
        LEFT,
        RIGHT,
        TOP_RIGHT,
        CENTER_RIGHT,
        BOTTOM_RIGHT,
        NONE
    }

    /* compiled from: A */
    public interface k {
        void a();

        void a(float f);

        void b();

        void c();

        void d();
    }

    private TypeEvaluator<PointF> i() {
        return new f();
    }

    private void j() {
        Paint paint = new Paint();
        this.T = paint;
        paint.setAntiAlias(true);
        this.T.setColor(-16777216);
        this.U = 14.0f;
        this.V = 10.0f;
        this.h = new j();
        this.i = new j();
        this.j = new j();
        this.m = new j();
        this.n = new j();
        this.o = new j();
        this.p = new j();
        this.q = new j();
        this.r = new j();
        this.s = new j();
        this.t = new j();
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(-16777216);
        this.b.setAntiAlias(true);
        this.d.setColor(-16777216);
        this.e.setColor(-1);
        this.z = new Matrix();
        b();
    }

    public hs(Context context) {
        super(context);
        this.a = i.NONE;
        this.c = new Paint();
        this.d = new Paint();
        this.e = new Paint();
        this.u = 0.0f;
        this.v = 0.0f;
        this.y = new float[9];
        this.M = true;
        this.N = true;
        this.O = 0;
        this.P = 0;
        this.R = 0;
        this.S = new HashMap<>();
        this.a0 = "";
        this.b0 = true;
        this.c0 = 2;
        this.d0 = 400;
        this.e0 = 5;
        j();
    }

    public void q() {
        if (this.J == null) {
            int i2 = this.w;
            int i3 = this.x;
            Bitmap.Config config = Bitmap.Config.RGB_565;
            this.J = Bitmap.createBitmap(i2, i3, config);
            this.f777K = Bitmap.createBitmap(this.w, this.x, config);
            this.L = Bitmap.createBitmap(this.w, this.x, config);
        }
        c();
        invalidate();
    }

    private void r() {
        int paddingStart;
        int paddingEnd;
        int i2 = this.P - 1;
        float width = getWidth();
        float height = getHeight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (Build.VERSION.SDK_INT >= 17) {
            paddingStart = getPaddingStart();
            paddingEnd = getPaddingEnd();
        } else {
            paddingStart = 0;
            paddingEnd = 0;
        }
        float f2 = height - paddingBottom;
        this.T.setTextSize(this.U);
        while (f2 >= this.U + paddingTop && i2 >= 0) {
            float fA = 0.0f;
            int i3 = i2;
            int i4 = 0;
            while (true) {
                if (i3 >= 0) {
                    String strSubstring = this.a0.substring(i3, i3 + 1);
                    if (strSubstring.equals("\n")) {
                        i4++;
                        break;
                    }
                    fA += a(this.T, strSubstring);
                    if (fA >= (width - paddingStart) - paddingEnd) {
                        break;
                    }
                    i4++;
                    i3--;
                }
            }
            i2 -= i4;
            f2 -= this.U + this.V;
        }
        this.P = Math.max(i2 - 1, 0);
    }

    private void c() {
        Canvas canvas = new Canvas(this.J);
        canvas.drawPath(h(), this.c);
        a(canvas, this.T);
        boolean z = this.Q < this.a0.length();
        this.M = z;
        if (z) {
            Canvas canvas2 = new Canvas(this.f777K);
            canvas2.drawPath(h(), this.c);
            b(canvas2, this.T);
            Canvas canvas3 = new Canvas(this.L);
            canvas3.drawPath(h(), this.e);
            a(canvas3, this.d);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        j jVar = this.h;
        jVar.a = -1.0f;
        jVar.b = -1.0f;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.w = getWidth();
        this.x = getHeight();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.a0.length() == 0) {
            return;
        }
        j jVar = this.h;
        if (jVar.a == -1.0f && jVar.b == -1.0f) {
            a(canvas, h());
            return;
        }
        j jVar2 = this.i;
        float f2 = jVar2.a;
        float f3 = this.w;
        if (f2 == f3 && jVar2.b == 0.0f) {
            a(canvas, f());
            f(canvas, f());
            e(canvas, f());
        } else if (f2 == f3 && jVar2.b == this.x) {
            a(canvas, e());
            f(canvas, e());
            e(canvas, e());
        }
    }

    private void b(j jVar, j jVar2) {
        j jVar3 = this.j;
        float f2 = (jVar.a + jVar2.a) / 2.0f;
        jVar3.a = f2;
        float f3 = (jVar.b + jVar2.b) / 2.0f;
        jVar3.b = f3;
        j jVar4 = this.m;
        float f4 = jVar2.b;
        float f5 = f4 - f3;
        jVar4.a = f2 - ((f5 * f5) / (jVar2.a - f2));
        jVar4.b = f4;
        j jVar5 = this.n;
        jVar5.a = jVar2.a;
        float f6 = jVar3.b;
        float f7 = jVar2.a;
        float f8 = f7 - jVar3.a;
        jVar5.b = f6 - ((f8 * f8) / (jVar2.b - f6));
        j jVar6 = this.o;
        float f9 = jVar4.a;
        jVar6.a = f9 - ((f7 - f9) / 2.0f);
        jVar6.b = jVar2.b;
        j jVar7 = this.p;
        jVar7.a = jVar2.a;
        float f10 = jVar5.b;
        jVar7.b = f10 - ((jVar2.b - f10) / 2.0f);
        this.q = a(jVar, jVar4, jVar6, jVar7);
        j jVarA = a(jVar, this.n, this.o, this.p);
        this.r = jVarA;
        j jVar8 = this.s;
        j jVar9 = this.o;
        float f11 = jVar9.a;
        j jVar10 = this.m;
        float f12 = f11 + (jVar10.a * 2.0f);
        j jVar11 = this.q;
        jVar8.a = (f12 + jVar11.a) / 4.0f;
        jVar8.b = (((jVar10.b * 2.0f) + jVar9.b) + jVar11.b) / 4.0f;
        j jVar12 = this.t;
        j jVar13 = this.p;
        float f13 = jVar13.a;
        j jVar14 = this.n;
        jVar12.a = ((f13 + (jVar14.a * 2.0f)) + jVarA.a) / 4.0f;
        jVar12.b = (((jVar14.b * 2.0f) + jVar13.b) + jVarA.b) / 4.0f;
        float f14 = jVar.b;
        float f15 = jVar10.b;
        float f16 = f14 - f15;
        float f17 = jVar10.a;
        float f18 = jVar.a;
        float f19 = f17 - f18;
        this.u = Math.abs((((jVar8.a * f16) + (jVar8.b * f19)) + ((f18 * f15) - (f17 * f14))) / ((float) Math.hypot(f16, f19)));
        float f20 = jVar.b;
        j jVar15 = this.n;
        float f21 = jVar15.b;
        float f22 = f20 - f21;
        float f23 = jVar15.a;
        float f24 = jVar.a;
        float f25 = f23 - f24;
        float f26 = (f24 * f21) - (f23 * f20);
        j jVar16 = this.t;
        this.v = Math.abs((((jVar16.a * f22) + (jVar16.b * f25)) + f26) / ((float) Math.hypot(f22, f25)));
    }

    private Path g() {
        Path path = this.g;
        if (path == null) {
            this.g = new Path();
        } else {
            path.reset();
        }
        Path path2 = this.g;
        j jVar = this.t;
        path2.moveTo(jVar.a, jVar.b);
        Path path3 = this.g;
        j jVar2 = this.s;
        path3.lineTo(jVar2.a, jVar2.b);
        Path path4 = this.g;
        j jVar3 = this.q;
        path4.lineTo(jVar3.a, jVar3.b);
        Path path5 = this.g;
        j jVar4 = this.h;
        path5.lineTo(jVar4.a, jVar4.b);
        Path path6 = this.g;
        j jVar5 = this.r;
        path6.lineTo(jVar5.a, jVar5.b);
        this.g.close();
        return this.g;
    }

    private Path h() {
        Path path = this.f;
        if (path == null) {
            this.f = new Path();
        } else {
            path.reset();
        }
        this.f.lineTo(0.0f, this.x);
        this.f.lineTo(this.w, this.x);
        this.f.lineTo(this.w, 0.0f);
        this.f.close();
        return this.f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.M) {
            a(motionEvent);
            return true;
        }
        b(motionEvent);
        return true;
    }

    private void p() {
        ValueAnimator valueAnimatorOfObject;
        int i2 = h.a[this.a.ordinal()];
        if (i2 == 3) {
            TypeEvaluator<PointF> typeEvaluatorI = i();
            j jVar = this.h;
            valueAnimatorOfObject = ValueAnimator.ofObject(typeEvaluatorI, new PointF(jVar.a, jVar.b), new PointF((-this.w) / 2.0f, 0.0f));
        } else if (i2 == 4 || i2 == 5) {
            TypeEvaluator<PointF> typeEvaluatorI2 = i();
            j jVar2 = this.h;
            valueAnimatorOfObject = ValueAnimator.ofObject(typeEvaluatorI2, new PointF(jVar2.a, jVar2.b), new PointF((-this.w) / 2.0f, this.x));
        } else {
            valueAnimatorOfObject = null;
        }
        if (valueAnimatorOfObject == null) {
            return;
        }
        valueAnimatorOfObject.setDuration(300L);
        valueAnimatorOfObject.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfObject.addUpdateListener(new a());
        valueAnimatorOfObject.addListener(new b());
        valueAnimatorOfObject.start();
    }

    /* compiled from: A */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PointF pointF = (PointF) valueAnimator.getAnimatedValue();
            hs.this.b(pointF.x, pointF.y);
        }
    }

    /* compiled from: A */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            hs.this.k();
        }
    }

    private void b() {
        int[] iArr = {36909875, 1077097267};
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
        this.A = gradientDrawable;
        gradientDrawable.setGradientType(0);
        GradientDrawable.Orientation orientation2 = GradientDrawable.Orientation.RIGHT_LEFT;
        GradientDrawable gradientDrawable2 = new GradientDrawable(orientation2, iArr);
        this.B = gradientDrawable2;
        gradientDrawable2.setGradientType(0);
        int[] iArr2 = {1077097267, 36909875, 36909875};
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, iArr2);
        this.C = gradientDrawable3;
        gradientDrawable3.setGradientType(0);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr2);
        this.D = gradientDrawable4;
        gradientDrawable4.setGradientType(0);
        GradientDrawable gradientDrawable5 = new GradientDrawable(orientation, new int[]{36909875, 1077097267});
        this.E = gradientDrawable5;
        gradientDrawable5.setGradientType(0);
        int[] iArr3 = {-1726934767, 1118481};
        GradientDrawable gradientDrawable6 = new GradientDrawable(orientation, iArr3);
        this.F = gradientDrawable6;
        gradientDrawable6.setGradientType(0);
        GradientDrawable gradientDrawable7 = new GradientDrawable(orientation2, iArr3);
        this.G = gradientDrawable7;
        gradientDrawable7.setGradientType(0);
        int[] iArr4 = {1118481, -1726934767};
        GradientDrawable gradientDrawable8 = new GradientDrawable(orientation, iArr4);
        this.H = gradientDrawable8;
        gradientDrawable8.setGradientType(0);
        GradientDrawable gradientDrawable9 = new GradientDrawable(orientation2, iArr4);
        this.I = gradientDrawable9;
        gradientDrawable9.setGradientType(0);
    }

    private void o() {
        if (l()) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.w / 5.0f, r0 - 1);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new c());
            valueAnimatorOfFloat.start();
        }
    }

    /* compiled from: A */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            hs.this.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public void g(int i2) {
        this.T.setColor(i2);
    }

    private void n() {
        ValueAnimator valueAnimatorOfObject;
        int i2 = h.a[this.a.ordinal()];
        if (i2 == 3) {
            TypeEvaluator<PointF> typeEvaluatorD = d();
            j jVar = this.h;
            valueAnimatorOfObject = ValueAnimator.ofObject(typeEvaluatorD, new PointF(jVar.a, jVar.b), new PointF(this.w, 0.0f));
        } else if (i2 == 4 || i2 == 5) {
            TypeEvaluator<PointF> typeEvaluatorD2 = d();
            j jVar2 = this.h;
            valueAnimatorOfObject = ValueAnimator.ofObject(typeEvaluatorD2, new PointF(jVar2.a, jVar2.b), new PointF(this.w, this.x));
        } else {
            valueAnimatorOfObject = null;
        }
        if (valueAnimatorOfObject == null) {
            return;
        }
        valueAnimatorOfObject.setDuration(300L);
        valueAnimatorOfObject.setInterpolator(new LinearInterpolator());
        valueAnimatorOfObject.addUpdateListener(new d());
        valueAnimatorOfObject.addListener(new e());
        valueAnimatorOfObject.start();
    }

    /* compiled from: A */
    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PointF pointF = (PointF) valueAnimator.getAnimatedValue();
            hs.this.b(pointF.x, pointF.y);
        }
    }

    /* compiled from: A */
    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            hs.this.m();
        }
    }

    /* compiled from: A */
    class f implements TypeEvaluator<PointF> {
        f() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF evaluate(float f, PointF pointF, PointF pointF2) {
            float f2 = pointF.x;
            float f3 = pointF.y;
            float f4 = pointF2.x;
            float f5 = pointF2.y;
            float f6 = f2 + ((f4 - f2) * f);
            if (f6 > f4 - (f4 / 4.0f)) {
                f5 = ((f5 - f3) * f) + f3;
            }
            return new PointF(f6, f5);
        }
    }

    /* compiled from: A */
    class g implements TypeEvaluator<PointF> {
        g() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF evaluate(float f, PointF pointF, PointF pointF2) {
            float f2 = pointF.x;
            float f3 = pointF.y;
            return new PointF(f2 + ((pointF2.x - f2) * f), f3 + ((pointF2.y - f3) * f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.P = this.Q;
        this.W.b();
        this.R++;
        j jVar = this.h;
        jVar.a = -1.0f;
        jVar.b = -1.0f;
        q();
    }

    private boolean l() {
        if (this.P == 0) {
            this.W.c();
            return false;
        }
        int i2 = this.R - 1;
        this.R = i2;
        if (this.S.containsKey(Integer.valueOf(i2))) {
            this.P = this.S.get(Integer.valueOf(this.R)).intValue();
        } else {
            r();
        }
        this.W.d();
        q();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        j jVar = this.h;
        jVar.a = -1.0f;
        jVar.b = -1.0f;
        invalidate();
    }

    private void d(Canvas canvas, Path path) {
        GradientDrawable gradientDrawable;
        int i2;
        float f2;
        j jVar = this.h;
        if (jVar.a == -1.0f || jVar.b == -1.0f) {
            return;
        }
        float fHypot = (float) Math.hypot(this.w, this.x);
        float f3 = this.n.a;
        int i3 = (int) f3;
        int i4 = (int) (f3 + (fHypot * 10.0f));
        if (this.a.equals(i.TOP_RIGHT)) {
            gradientDrawable = this.C;
            f2 = this.n.b;
            i2 = (int) (f2 - (this.v / 2.0f));
        } else {
            gradientDrawable = this.D;
            float f4 = this.n.b;
            i2 = (int) f4;
            f2 = f4 + (this.v / 2.0f);
        }
        gradientDrawable.setBounds(i3, i2, i4, (int) f2);
        canvas.restore();
        canvas.save();
        Path path2 = new Path();
        path2.moveTo(this.h.a - (Math.max(this.v, this.u) / 2.0f), this.h.b);
        j jVar2 = this.n;
        path2.lineTo(jVar2.a, jVar2.b);
        j jVar3 = this.h;
        path2.lineTo(jVar3.a, jVar3.b);
        path2.close();
        canvas.clipPath(path);
        canvas.clipPath(path2, Region.Op.INTERSECT);
        float f5 = this.h.b;
        j jVar4 = this.n;
        float degrees = (float) Math.toDegrees(Math.atan2(f5 - jVar4.b, r9.a - jVar4.a));
        j jVar5 = this.n;
        canvas.rotate(degrees, jVar5.a, jVar5.b);
        gradientDrawable.draw(canvas);
    }

    private void a() {
        float f2 = this.w - this.o.a;
        float fAbs = Math.abs(this.i.a - this.h.a);
        float f3 = (this.w * fAbs) / f2;
        this.h.a = Math.abs(this.i.a - f3);
        this.h.b = Math.abs(this.i.b - ((f3 * Math.abs(this.i.b - this.h.b)) / fAbs));
    }

    private void e(Canvas canvas, Path path) {
        canvas.save();
        Region.Op op = Region.Op.DIFFERENCE;
        canvas.clipPath(path, op);
        canvas.clipPath(g(), op);
        canvas.drawBitmap(this.f777K, 0.0f, 0.0f, (Paint) null);
        a(canvas);
        canvas.restore();
    }

    private void f(Canvas canvas, Path path) {
        canvas.save();
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        canvas.clipPath(g());
        canvas.drawPath(g(), this.b);
        j jVar = this.i;
        float fHypot = (float) Math.hypot(jVar.a - this.m.a, this.n.b - jVar.b);
        j jVar2 = this.i;
        float f2 = (jVar2.a - this.m.a) / fHypot;
        float f3 = (this.n.b - jVar2.b) / fHypot;
        float[] fArr = this.y;
        float f4 = 2.0f * f2;
        float f5 = 1.0f - (f2 * f4);
        fArr[0] = -f5;
        float f6 = f4 * f3;
        fArr[1] = f6;
        fArr[3] = f6;
        fArr[4] = f5;
        fArr[8] = 1.0f;
        this.z.reset();
        this.z.setValues(this.y);
        Matrix matrix = this.z;
        j jVar3 = this.m;
        matrix.preTranslate(-jVar3.a, -jVar3.b);
        Matrix matrix2 = this.z;
        j jVar4 = this.m;
        matrix2.postTranslate(jVar4.a, jVar4.b);
        canvas.drawBitmap(this.L, this.z, null);
        b(canvas);
        canvas.restore();
    }

    /* compiled from: A */
    private static class j {
        float a;
        float b;

        j() {
        }

        j(float f, float f2) {
            this.a = f;
            this.b = f2;
        }
    }

    public void d(int i2) {
        if (i2 <= 0 || i2 >= 50) {
            this.b0 = false;
        }
        this.c0 = i2;
    }

    private void c(Canvas canvas, Path path) {
        GradientDrawable gradientDrawable;
        int i2;
        float f2;
        j jVar = this.h;
        if (jVar.a == -1.0f || jVar.b == -1.0f) {
            return;
        }
        float f3 = this.m.b;
        int i3 = (int) f3;
        int i4 = (int) (f3 + this.x);
        if (this.a.equals(i.TOP_RIGHT)) {
            gradientDrawable = this.A;
            f2 = this.m.a;
            i2 = (int) (f2 - (this.u / 2.0f));
        } else {
            gradientDrawable = this.B;
            float f4 = this.m.a;
            i2 = (int) f4;
            f2 = f4 + (this.u / 2.0f);
        }
        canvas.restore();
        canvas.save();
        Path path2 = new Path();
        path2.moveTo(this.h.a - (Math.max(this.v, this.u) / 2.0f), this.h.b);
        j jVar2 = this.s;
        path2.lineTo(jVar2.a, jVar2.b);
        j jVar3 = this.m;
        path2.lineTo(jVar3.a, jVar3.b);
        j jVar4 = this.h;
        path2.lineTo(jVar4.a, jVar4.b);
        path2.close();
        canvas.clipPath(path);
        canvas.clipPath(path2, Region.Op.INTERSECT);
        float f5 = this.m.a;
        j jVar5 = this.h;
        float degrees = (float) Math.toDegrees(Math.atan2(f5 - jVar5.a, jVar5.b - r13.b));
        j jVar6 = this.m;
        canvas.rotate(degrees, jVar6.a, jVar6.b);
        gradientDrawable.setBounds(i2, i3, (int) f2, i4);
        gradientDrawable.draw(canvas);
    }

    public void c(int i2) {
        this.c.setColor(i2);
    }

    private Path e() {
        Path path = this.f;
        if (path == null) {
            this.f = new Path();
        } else {
            path.reset();
        }
        Path path2 = new Path();
        path2.lineTo(0.0f, this.x);
        j jVar = this.o;
        path2.lineTo(jVar.a, jVar.b);
        j jVar2 = this.m;
        float f2 = jVar2.a;
        float f3 = jVar2.b;
        j jVar3 = this.q;
        path2.quadTo(f2, f3, jVar3.a, jVar3.b);
        j jVar4 = this.h;
        path2.lineTo(jVar4.a, jVar4.b);
        j jVar5 = this.r;
        path2.lineTo(jVar5.a, jVar5.b);
        j jVar6 = this.n;
        float f4 = jVar6.a;
        float f5 = jVar6.b;
        j jVar7 = this.p;
        path2.quadTo(f4, f5, jVar7.a, jVar7.b);
        path2.lineTo(this.w, 0.0f);
        path2.close();
        return path2;
    }

    private Path f() {
        Path path = this.f;
        if (path == null) {
            this.f = new Path();
        } else {
            path.reset();
        }
        Path path2 = this.f;
        j jVar = this.o;
        path2.lineTo(jVar.a, jVar.b);
        Path path3 = this.f;
        j jVar2 = this.m;
        float f2 = jVar2.a;
        float f3 = jVar2.b;
        j jVar3 = this.q;
        path3.quadTo(f2, f3, jVar3.a, jVar3.b);
        Path path4 = this.f;
        j jVar4 = this.h;
        path4.lineTo(jVar4.a, jVar4.b);
        Path path5 = this.f;
        j jVar5 = this.r;
        path5.lineTo(jVar5.a, jVar5.b);
        Path path6 = this.f;
        j jVar6 = this.n;
        float f4 = jVar6.a;
        float f5 = jVar6.b;
        j jVar7 = this.p;
        path6.quadTo(f4, f5, jVar7.a, jVar7.b);
        this.f.lineTo(this.w, this.x);
        this.f.lineTo(0.0f, this.x);
        this.f.close();
        return this.f;
    }

    public void c(float f2) {
        this.U = f2;
    }

    public void e(int i2) {
        if (i2 <= 0) {
            this.b0 = false;
        }
        this.d0 = i2;
    }

    private void b(Canvas canvas, Path path) {
        j jVar = this.h;
        float f2 = jVar.a;
        if (f2 == -1.0f || jVar.b == -1.0f) {
            return;
        }
        int iMin = (int) (f2 - Math.min(30, this.v / 2.0f));
        int i2 = (int) this.h.a;
        int i3 = this.x;
        GradientDrawable gradientDrawable = this.E;
        gradientDrawable.setBounds(iMin, 0, i2, i3);
        canvas.restore();
        canvas.save();
        canvas.clipPath(path, Region.Op.INTERSECT);
        j jVar2 = this.i;
        float degrees = (float) Math.toDegrees(Math.atan2(jVar2.a - this.h.a, jVar2.b - this.n.b));
        j jVar3 = this.h;
        canvas.rotate(degrees, jVar3.a, jVar3.b);
        gradientDrawable.draw(canvas);
    }

    public void f(int i2) {
        if (i2 <= 0) {
            this.b0 = false;
        }
        this.e0 = i2;
    }

    private float a(j jVar, j jVar2) {
        j jVar3 = new j();
        j jVar4 = new j();
        float f2 = (jVar.a + jVar2.a) / 2.0f;
        jVar3.a = f2;
        float f3 = (jVar.b + jVar2.b) / 2.0f;
        jVar3.b = f3;
        float f4 = jVar2.b;
        float f5 = f4 - f3;
        float f6 = f2 - ((f5 * f5) / (jVar2.a - f2));
        jVar4.a = f6;
        jVar4.b = f4;
        return f6 - ((jVar2.a - f6) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(float f2) {
        j jVar = this.h;
        jVar.a = f2;
        int i2 = this.x;
        jVar.b = i2 - 1;
        j jVar2 = this.i;
        jVar2.a = this.w;
        jVar2.b = i2;
        b(jVar, jVar2);
        invalidate();
    }

    private TypeEvaluator<PointF> d() {
        return new g();
    }

    private void a(Canvas canvas, Path path) {
        canvas.save();
        canvas.clipPath(path, Region.Op.INTERSECT);
        canvas.drawBitmap(this.J, 0.0f, 0.0f, (Paint) null);
        if (this.a.equals(i.CENTER_RIGHT)) {
            b(canvas, path);
        } else {
            c(canvas, path);
            d(canvas, path);
        }
        canvas.restore();
    }

    private void b(Canvas canvas) {
        GradientDrawable gradientDrawable;
        int i2;
        int i3;
        float f2 = this.h.a;
        j jVar = this.i;
        int iHypot = (int) (((float) Math.hypot(f2 - jVar.a, r0.b - jVar.b)) / 4.0f);
        float fHypot = (float) Math.hypot(this.w, this.x);
        float f3 = this.o.b;
        int i4 = (int) f3;
        int i5 = (int) (fHypot + f3);
        if (this.a.equals(i.TOP_RIGHT)) {
            gradientDrawable = this.H;
            float f4 = this.o.a;
            i2 = (int) (f4 - 0);
            i3 = (int) (f4 + iHypot);
        } else {
            gradientDrawable = this.I;
            float f5 = this.o.a;
            i2 = (int) (f5 - iHypot);
            i3 = (int) (f5 + 0);
        }
        gradientDrawable.setBounds(i2, i4, i3, i5);
        float f6 = this.m.a;
        j jVar2 = this.i;
        float degrees = (float) Math.toDegrees(Math.atan2(f6 - jVar2.a, this.n.b - jVar2.b));
        j jVar3 = this.o;
        canvas.rotate(degrees, jVar3.a, jVar3.b);
        gradientDrawable.draw(canvas);
    }

    private void b(Canvas canvas, Paint paint) {
        paint.setTextSize(this.U);
        a(canvas, paint, this.U + getPaddingTop(), this.a0, this.Q);
    }

    private void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getX() < this.w / 2) {
                this.a = i.LEFT;
                return;
            } else {
                this.a = i.RIGHT;
                return;
            }
        }
        if (action != 1) {
            if (action != 3) {
                return;
            }
            m();
            return;
        }
        int i2 = h.a[this.a.ordinal()];
        if (i2 == 1) {
            o();
        } else {
            if (i2 != 2) {
                return;
            }
            this.W.a();
        }
    }

    private void a(Canvas canvas) {
        GradientDrawable gradientDrawable;
        int i2;
        int i3;
        float f2 = this.h.a;
        j jVar = this.i;
        int iHypot = (int) (((float) Math.hypot(f2 - jVar.a, r0.b - jVar.b)) / 4.0f);
        float fHypot = (float) Math.hypot(this.w, this.x);
        float f3 = this.o.b;
        int i4 = (int) f3;
        int i5 = (int) (fHypot + f3);
        if (this.a.equals(i.TOP_RIGHT)) {
            gradientDrawable = this.F;
            float f4 = this.o.a;
            i2 = (int) (f4 - 0);
            i3 = (int) (f4 + iHypot);
        } else {
            gradientDrawable = this.G;
            float f5 = this.o.a;
            i2 = (int) (f5 - iHypot);
            i3 = (int) (f5 + 0);
        }
        gradientDrawable.setBounds(i2, i4, i3, i5);
        float f6 = this.m.a;
        j jVar2 = this.i;
        float degrees = (float) Math.toDegrees(Math.atan2(f6 - jVar2.a, this.n.b - jVar2.b));
        j jVar3 = this.o;
        canvas.rotate(degrees, jVar3.a, jVar3.b);
        gradientDrawable.draw(canvas);
    }

    public void b(int i2) {
        this.d.setColor(i2);
    }

    public void b(float f2) {
        this.V = f2;
    }

    private void a(Canvas canvas, Paint paint) {
        paint.setTextSize(this.U);
        this.Q = a(canvas, paint, this.U + getPaddingTop(), this.a0, this.P);
        this.S.put(Integer.valueOf(this.R), Integer.valueOf(this.P));
    }

    private int a(Canvas canvas, Paint paint, float f2, String str, int i2) {
        int paddingStart;
        int paddingEnd;
        float f3;
        boolean z;
        float fA;
        String str2 = str;
        float width = getWidth();
        float height = getHeight();
        int paddingBottom = getPaddingBottom();
        if (Build.VERSION.SDK_INT >= 17) {
            paddingStart = getPaddingStart();
            paddingEnd = getPaddingEnd();
        } else {
            paddingStart = 0;
            paddingEnd = 0;
        }
        float f4 = paddingStart;
        float fA2 = f2;
        int i3 = i2;
        int i4 = 0;
        while (fA2 < height - paddingBottom && i3 < str.length()) {
            int i5 = i3;
            float f5 = 0.0f;
            int i6 = 0;
            while (true) {
                f3 = height;
                if (i5 >= str.length()) {
                    break;
                }
                int i7 = i5 + 1;
                String strSubstring = str2.substring(i5, i7);
                if (strSubstring.equals("\n")) {
                    i6++;
                    break;
                }
                float fA3 = a(paint, strSubstring) + f5;
                if (fA3 >= (width - f4) - paddingEnd) {
                    z = true;
                    break;
                }
                i6++;
                f5 = fA3;
                height = f3;
                i5 = i7;
            }
            z = false;
            float f6 = i6 <= 1 ? 0.0f : (((width - f4) - paddingEnd) - f5) / (i6 - 1);
            float f7 = f4;
            int i8 = 0;
            while (i8 < i6) {
                float f8 = width;
                int i9 = i3 + 1;
                String strSubstring2 = str2.substring(i3, i9);
                if (!strSubstring2.equals("\n")) {
                    canvas.drawText(strSubstring2, f7, fA2, paint);
                    if (z) {
                        fA = a(paint, strSubstring2) + f6;
                    } else {
                        fA = a(paint, strSubstring2);
                    }
                    f7 += fA;
                }
                i8++;
                str2 = str;
                i3 = i9;
                width = f8;
            }
            float f9 = width;
            i4++;
            fA2 += this.U + this.V;
            if (i4 == this.c0) {
                fA2 = a(fA2);
            }
            str2 = str;
            height = f3;
            width = f9;
        }
        return i3;
    }

    private float a(float f2) {
        if (!this.b0) {
            return f2;
        }
        int i2 = this.R;
        if (i2 > 0 && i2 % this.e0 == 0) {
            this.W.a(f2 - this.V);
            return f2 + this.d0 + this.V;
        }
        this.W.a(-1.0f);
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, float f3) {
        j jVar = this.h;
        jVar.a = f2;
        jVar.b = f3;
        int i2 = h.a[this.a.ordinal()];
        if (i2 == 3) {
            j jVar2 = this.i;
            jVar2.a = this.w;
            jVar2.b = 0.0f;
            b(this.h, jVar2);
        } else if (i2 == 4 || i2 == 5) {
            j jVar3 = this.i;
            jVar3.a = this.w;
            jVar3.b = this.x;
            b(this.h, jVar3);
        }
        invalidate();
    }

    private j a(j jVar, j jVar2, j jVar3, j jVar4) {
        float f2 = jVar.a;
        float f3 = jVar.b;
        float f4 = jVar2.a;
        float f5 = jVar2.b;
        float f6 = jVar3.a;
        float f7 = jVar3.b;
        float f8 = jVar4.a;
        float f9 = jVar4.b;
        float f10 = f2 - f4;
        float f11 = (f6 * f9) - (f8 * f7);
        float f12 = f6 - f8;
        float f13 = (f2 * f5) - (f4 * f3);
        float f14 = (f10 * f11) - (f12 * f13);
        float f15 = f3 - f5;
        float f16 = f7 - f9;
        float f17 = (f12 * f15) - (f10 * f16);
        return new j(f14 / f17, ((f15 * f11) - (f13 * f16)) / f17);
    }

    private float a(Paint paint, String str) {
        float f2 = 0.0f;
        if (str != null && str.length() > 0) {
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            for (int i2 = 0; i2 < length; i2++) {
                f2 += fArr[i2];
            }
        }
        return f2;
    }

    private void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (this.a == i.LEFT) {
                    o();
                    return;
                } else if (this.N) {
                    p();
                    return;
                } else {
                    n();
                    return;
                }
            }
            if (action != 2) {
                if (action != 3) {
                    return;
                }
                m();
                return;
            } else {
                if (this.a != i.LEFT) {
                    a(motionEvent.getX(), motionEvent.getY());
                }
                if (Math.abs(motionEvent.getX() - this.O) >= 5.0f) {
                    this.N = motionEvent.getX() < ((float) this.O);
                }
                this.O = (int) motionEvent.getX();
                return;
            }
        }
        this.O = (int) motionEvent.getX();
        this.N = true;
        float x = motionEvent.getX();
        int i2 = this.w;
        if (x > i2 - (i2 / 2) && motionEvent.getY() < this.x / 3) {
            this.a = i.TOP_RIGHT;
            a(motionEvent.getX(), motionEvent.getY());
            return;
        }
        float x2 = motionEvent.getX();
        int i3 = this.w;
        if (x2 > i3 - (i3 / 2)) {
            float y = motionEvent.getY();
            int i4 = this.x;
            if (y >= i4 - (i4 / 3)) {
                this.a = i.BOTTOM_RIGHT;
                a(motionEvent.getX(), motionEvent.getY());
                return;
            }
        }
        float x3 = motionEvent.getX();
        int i5 = this.w;
        if (x3 > i5 - (i5 / 2)) {
            this.a = i.CENTER_RIGHT;
            a(motionEvent.getX(), motionEvent.getY());
        } else {
            this.a = i.LEFT;
        }
    }

    public void a(int i2) {
        this.e.setColor(i2);
        this.b.setColor(i2);
    }

    public void a(String str) {
        this.a0 = str;
        this.P = 0;
        this.R = 0;
        this.S.clear();
    }

    public void a(k kVar) {
        this.W = kVar;
    }

    private void a(float f2, float f3) {
        j jVar = this.h;
        jVar.a = f2;
        jVar.b = f3;
        int i2 = h.a[this.a.ordinal()];
        if (i2 == 3) {
            j jVar2 = this.i;
            jVar2.a = this.w;
            jVar2.b = 0.0f;
            b(this.h, jVar2);
            if (a(new j(f2, f3), this.i) < 0.0f) {
                a();
                b(this.h, this.i);
            }
            invalidate();
            return;
        }
        if (i2 == 4) {
            j jVar3 = this.h;
            int i3 = this.x;
            jVar3.b = i3 - 1;
            j jVar4 = this.i;
            jVar4.a = this.w;
            jVar4.b = i3;
            b(jVar3, jVar4);
            invalidate();
            return;
        }
        if (i2 != 5) {
            return;
        }
        j jVar5 = this.i;
        jVar5.a = this.w;
        jVar5.b = this.x;
        b(this.h, jVar5);
        if (a(new j(f2, f3), this.i) < 0.0f) {
            a();
            b(this.h, this.i);
        }
        invalidate();
    }
}
