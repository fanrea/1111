package com.component.lottie.a.a;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.baidu.mobads.container.util.bu;
import com.component.lottie.a.b.a;
import com.component.lottie.af;
import com.component.lottie.ba;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i implements f, l, a.InterfaceC0322a {
    private static final int b = 32;
    private final String c;
    private final boolean d;
    private final com.component.lottie.d.c.a e;
    private final com.component.lottie.d.b.g l;
    private final com.component.lottie.a.b.a<com.component.lottie.d.b.d, com.component.lottie.d.b.d> m;
    private final com.component.lottie.a.b.a<Integer, Integer> n;
    private final com.component.lottie.a.b.a<PointF, PointF> o;
    private final com.component.lottie.a.b.a<PointF, PointF> p;
    private com.component.lottie.a.b.a<ColorFilter, ColorFilter> q;
    private com.component.lottie.a.b.t r;
    private final af s;
    private final int t;
    private com.component.lottie.a.b.a<Float, Float> u;
    private com.component.lottie.a.b.d v;
    private final com.component.lottie.b.b<LinearGradient> f = new com.component.lottie.b.b<>();
    private final com.component.lottie.b.b<RadialGradient> g = new com.component.lottie.b.b<>();
    private final Path h = new Path();
    private final Paint i = new com.component.lottie.a.a(1);
    private final RectF j = new RectF();
    private final List<p> k = new ArrayList();
    float a = 0.0f;

    public i(af afVar, com.component.lottie.d.c.a aVar, com.component.lottie.d.b.e eVar) {
        this.e = aVar;
        this.c = eVar.a();
        this.d = eVar.h();
        this.s = afVar;
        this.l = eVar.b();
        this.h.setFillType(eVar.c());
        this.t = (int) (afVar.C().f() / 32.0f);
        this.m = eVar.d().a();
        this.m.a(this);
        aVar.a(this.m);
        this.n = eVar.e().a();
        this.n.a(this);
        aVar.a(this.n);
        this.o = eVar.f().a();
        this.o.a(this);
        aVar.a(this.o);
        this.p = eVar.g().a();
        this.p.a(this);
        aVar.a(this.p);
        if (aVar.f() != null) {
            this.u = aVar.f().a().a();
            this.u.a(this);
            aVar.a(this.u);
        }
        if (aVar.g() != null) {
            this.v = new com.component.lottie.a.b.d(this, aVar, aVar.g());
        }
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        this.s.invalidateSelf();
    }

    @Override // com.component.lottie.a.a.d
    public void a(List<d> list, List<d> list2) {
        for (int i = 0; i < list2.size(); i++) {
            d dVar = list2.get(i);
            if (dVar instanceof p) {
                this.k.add((p) dVar);
            }
        }
    }

    @Override // com.component.lottie.a.a.f
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader shaderD;
        if (this.d) {
            return;
        }
        com.component.lottie.c.a("GradientFillContent#draw");
        this.h.reset();
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            this.h.addPath(this.k.get(i2).e(), matrix);
        }
        this.h.computeBounds(this.j, false);
        if (this.l == com.component.lottie.d.b.g.LINEAR) {
            shaderD = c();
        } else {
            shaderD = d();
        }
        shaderD.setLocalMatrix(matrix);
        this.i.setShader(shaderD);
        if (this.q != null) {
            this.i.setColorFilter(this.q.g());
        }
        if (this.u != null) {
            float fFloatValue = this.u.g().floatValue();
            if (fFloatValue == 0.0f) {
                this.i.setMaskFilter(null);
            } else if (fFloatValue != this.a) {
                this.i.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.a = fFloatValue;
        }
        if (this.v != null) {
            this.v.a(this.i);
        }
        this.i.setAlpha(com.component.lottie.g.f.a((int) ((((i / 255.0f) * this.n.g().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.h, this.i);
        com.component.lottie.c.b("GradientFillContent#draw");
    }

    @Override // com.component.lottie.a.a.f
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.h.reset();
        for (int i = 0; i < this.k.size(); i++) {
            this.h.addPath(this.k.get(i).e(), matrix);
        }
        this.h.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.c;
    }

    private LinearGradient c() {
        long jE = e();
        LinearGradient linearGradientA = this.f.a(jE);
        if (linearGradientA != null) {
            return linearGradientA;
        }
        PointF pointFG = this.o.g();
        PointF pointFG2 = this.p.g();
        com.component.lottie.d.b.d dVarG = this.m.g();
        LinearGradient linearGradient = new LinearGradient(pointFG.x, pointFG.y, pointFG2.x, pointFG2.y, a(dVarG.b()), dVarG.a(), Shader.TileMode.CLAMP);
        this.f.d(jE, linearGradient);
        return linearGradient;
    }

    private RadialGradient d() {
        long jE = e();
        RadialGradient radialGradientA = this.g.a(jE);
        if (radialGradientA != null) {
            return radialGradientA;
        }
        PointF pointFG = this.o.g();
        PointF pointFG2 = this.p.g();
        com.component.lottie.d.b.d dVarG = this.m.g();
        int[] iArrA = a(dVarG.b());
        float[] fArrA = dVarG.a();
        float f = pointFG.x;
        float f2 = pointFG.y;
        float fHypot = (float) Math.hypot(pointFG2.x - f, pointFG2.y - f2);
        RadialGradient radialGradient = new RadialGradient(f, f2, fHypot <= 0.0f ? 0.001f : fHypot, iArrA, fArrA, Shader.TileMode.CLAMP);
        this.g.d(jE, radialGradient);
        return radialGradient;
    }

    private int e() {
        int i;
        int iRound = Math.round(this.o.h() * this.t);
        int iRound2 = Math.round(this.p.h() * this.t);
        int iRound3 = Math.round(this.m.h() * this.t);
        if (iRound == 0) {
            i = 17;
        } else {
            i = bu.g * iRound;
        }
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        if (iRound3 != 0) {
            return i * 31 * iRound3;
        }
        return i;
    }

    private int[] a(int[] iArr) {
        if (this.r != null) {
            Integer[] numArr = (Integer[]) this.r.g();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    @Override // com.component.lottie.d.f
    public void a(com.component.lottie.d.e eVar, int i, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
        com.component.lottie.g.f.a(eVar, i, list, eVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        if (t == ba.d) {
            this.n.a((com.component.lottie.h.j<Integer>) jVar);
            return;
        }
        if (t == ba.f759K) {
            if (this.q != null) {
                this.e.b(this.q);
            }
            if (jVar == null) {
                this.q = null;
                return;
            }
            this.q = new com.component.lottie.a.b.t(jVar);
            this.q.a(this);
            this.e.a(this.q);
            return;
        }
        if (t == ba.L) {
            if (this.r != null) {
                this.e.b(this.r);
            }
            if (jVar == null) {
                this.r = null;
                return;
            }
            this.f.d();
            this.g.d();
            this.r = new com.component.lottie.a.b.t(jVar);
            this.r.a(this);
            this.e.a(this.r);
            return;
        }
        if (t == ba.j) {
            if (this.u != null) {
                this.u.a((com.component.lottie.h.j<Float>) jVar);
                return;
            }
            this.u = new com.component.lottie.a.b.t(jVar);
            this.u.a(this);
            this.e.a(this.u);
            return;
        }
        if (t == ba.e && this.v != null) {
            this.v.a((com.component.lottie.h.j<Integer>) jVar);
            return;
        }
        if (t == ba.G && this.v != null) {
            this.v.b(jVar);
            return;
        }
        if (t == ba.H && this.v != null) {
            this.v.c(jVar);
            return;
        }
        if (t == ba.I && this.v != null) {
            this.v.d(jVar);
        } else if (t == ba.J && this.v != null) {
            this.v.e(jVar);
        }
    }
}
