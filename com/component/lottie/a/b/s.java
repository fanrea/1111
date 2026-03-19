package com.component.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.component.lottie.a.b.a;
import com.component.lottie.ba;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class s {
    private final Matrix a = new Matrix();
    private final Matrix b;
    private final Matrix c;
    private final Matrix d;
    private final float[] e;
    private a<PointF, PointF> f;
    private a<?, PointF> g;
    private a<com.component.lottie.h.k, com.component.lottie.h.k> h;
    private a<Float, Float> i;
    private a<Integer, Integer> j;
    private f k;
    private f l;
    private a<?, Float> m;
    private a<?, Float> n;

    public s(com.component.lottie.d.a.l lVar) {
        this.f = lVar.a() == null ? null : lVar.a().a();
        this.g = lVar.b() == null ? null : lVar.b().a();
        this.h = lVar.c() == null ? null : lVar.c().a();
        this.i = lVar.d() == null ? null : lVar.d().a();
        this.k = lVar.h() == null ? null : (f) lVar.h().a();
        if (this.k != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.l = lVar.i() == null ? null : (f) lVar.i().a();
        if (lVar.e() != null) {
            this.j = lVar.e().a();
        }
        if (lVar.f() != null) {
            this.m = lVar.f().a();
        } else {
            this.m = null;
        }
        if (lVar.g() != null) {
            this.n = lVar.g().a();
        } else {
            this.n = null;
        }
    }

    public void a(com.component.lottie.d.c.a aVar) {
        aVar.a(this.j);
        aVar.a(this.m);
        aVar.a(this.n);
        aVar.a(this.f);
        aVar.a(this.g);
        aVar.a(this.h);
        aVar.a(this.i);
        aVar.a(this.k);
        aVar.a(this.l);
    }

    public void a(a.InterfaceC0322a interfaceC0322a) {
        if (this.j != null) {
            this.j.a(interfaceC0322a);
        }
        if (this.m != null) {
            this.m.a(interfaceC0322a);
        }
        if (this.n != null) {
            this.n.a(interfaceC0322a);
        }
        if (this.f != null) {
            this.f.a(interfaceC0322a);
        }
        if (this.g != null) {
            this.g.a(interfaceC0322a);
        }
        if (this.h != null) {
            this.h.a(interfaceC0322a);
        }
        if (this.i != null) {
            this.i.a(interfaceC0322a);
        }
        if (this.k != null) {
            this.k.a(interfaceC0322a);
        }
        if (this.l != null) {
            this.l.a(interfaceC0322a);
        }
    }

    public void a(float f) {
        if (this.j != null) {
            this.j.a(f);
        }
        if (this.m != null) {
            this.m.a(f);
        }
        if (this.n != null) {
            this.n.a(f);
        }
        if (this.f != null) {
            this.f.a(f);
        }
        if (this.g != null) {
            this.g.a(f);
        }
        if (this.h != null) {
            this.h.a(f);
        }
        if (this.i != null) {
            this.i.a(f);
        }
        if (this.k != null) {
            this.k.a(f);
        }
        if (this.l != null) {
            this.l.a(f);
        }
    }

    public a<?, Integer> a() {
        return this.j;
    }

    public a<?, Float> b() {
        return this.m;
    }

    public a<?, Float> c() {
        return this.n;
    }

    public Matrix d() {
        float fI;
        PointF pointFG;
        this.a.reset();
        a<?, PointF> aVar = this.g;
        if (aVar != null && (pointFG = aVar.g()) != null && (pointFG.x != 0.0f || pointFG.y != 0.0f)) {
            this.a.preTranslate(pointFG.x, pointFG.y);
        }
        a<Float, Float> aVar2 = this.i;
        if (aVar2 != null) {
            if (aVar2 instanceof t) {
                fI = aVar2.g().floatValue();
            } else {
                fI = ((f) aVar2).i();
            }
            if (fI != 0.0f) {
                this.a.preRotate(fI);
            }
        }
        if (this.k != null) {
            float fCos = this.l == null ? 0.0f : (float) Math.cos(Math.toRadians((-this.l.i()) + 90.0f));
            float fSin = this.l == null ? 1.0f : (float) Math.sin(Math.toRadians((-this.l.i()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(r0.i()));
            e();
            this.e[0] = fCos;
            this.e[1] = fSin;
            float f = -fSin;
            this.e[3] = f;
            this.e[4] = fCos;
            this.e[8] = 1.0f;
            this.b.setValues(this.e);
            e();
            this.e[0] = 1.0f;
            this.e[3] = fTan;
            this.e[4] = 1.0f;
            this.e[8] = 1.0f;
            this.c.setValues(this.e);
            e();
            this.e[0] = fCos;
            this.e[1] = f;
            this.e[3] = fSin;
            this.e[4] = fCos;
            this.e[8] = 1.0f;
            this.d.setValues(this.e);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        a<com.component.lottie.h.k, com.component.lottie.h.k> aVar3 = this.h;
        if (aVar3 != null) {
            com.component.lottie.h.k kVarG = aVar3.g();
            if (kVarG.a() != 1.0f || kVarG.b() != 1.0f) {
                this.a.preScale(kVarG.a(), kVarG.b());
            }
        }
        a<PointF, PointF> aVar4 = this.f;
        if (aVar4 != null) {
            PointF pointFG2 = aVar4.g();
            if (pointFG2.x != 0.0f || pointFG2.y != 0.0f) {
                this.a.preTranslate(-pointFG2.x, -pointFG2.y);
            }
        }
        return this.a;
    }

    private void e() {
        for (int i = 0; i < 9; i++) {
            this.e[i] = 0.0f;
        }
    }

    public Matrix b(float f) {
        PointF pointFG = this.g == null ? null : this.g.g();
        com.component.lottie.h.k kVarG = this.h == null ? null : this.h.g();
        this.a.reset();
        if (pointFG != null) {
            this.a.preTranslate(pointFG.x * f, pointFG.y * f);
        }
        if (kVarG != null) {
            double d = f;
            this.a.preScale((float) Math.pow(kVarG.a(), d), (float) Math.pow(kVarG.b(), d));
        }
        if (this.i != null) {
            float fFloatValue = this.i.g().floatValue();
            PointF pointFG2 = this.f != null ? this.f.g() : null;
            this.a.preRotate(fFloatValue * f, pointFG2 == null ? 0.0f : pointFG2.x, pointFG2 != null ? pointFG2.y : 0.0f);
        }
        return this.a;
    }

    public <T> boolean a(T t, com.component.lottie.h.j<T> jVar) {
        if (t == ba.f) {
            if (this.f == null) {
                this.f = new t(jVar, new PointF());
                return true;
            }
            this.f.a((com.component.lottie.h.j<PointF>) jVar);
            return true;
        }
        if (t == ba.g) {
            if (this.g == null) {
                this.g = new t(jVar, new PointF());
                return true;
            }
            this.g.a((com.component.lottie.h.j<PointF>) jVar);
            return true;
        }
        if (t == ba.h && (this.g instanceof p)) {
            ((p) this.g).b(jVar);
            return true;
        }
        if (t == ba.i && (this.g instanceof p)) {
            ((p) this.g).c(jVar);
            return true;
        }
        if (t == ba.o) {
            if (this.h == null) {
                this.h = new t(jVar, new com.component.lottie.h.k());
                return true;
            }
            this.h.a((com.component.lottie.h.j<com.component.lottie.h.k>) jVar);
            return true;
        }
        if (t == ba.p) {
            if (this.i == null) {
                this.i = new t(jVar, Float.valueOf(0.0f));
                return true;
            }
            this.i.a((com.component.lottie.h.j<Float>) jVar);
            return true;
        }
        if (t == ba.c) {
            if (this.j == null) {
                this.j = new t(jVar, 100);
                return true;
            }
            this.j.a((com.component.lottie.h.j<Integer>) jVar);
            return true;
        }
        if (t == ba.C) {
            if (this.m == null) {
                this.m = new t(jVar, Float.valueOf(100.0f));
                return true;
            }
            this.m.a((com.component.lottie.h.j<Float>) jVar);
            return true;
        }
        if (t == ba.D) {
            if (this.n == null) {
                this.n = new t(jVar, Float.valueOf(100.0f));
                return true;
            }
            this.n.a((com.component.lottie.h.j<Float>) jVar);
            return true;
        }
        if (t == ba.q) {
            if (this.k == null) {
                this.k = new f(Collections.singletonList(new com.component.lottie.h.a(Float.valueOf(0.0f))));
            }
            this.k.a(jVar);
            return true;
        }
        if (t == ba.r) {
            if (this.l == null) {
                this.l = new f(Collections.singletonList(new com.component.lottie.h.a(Float.valueOf(0.0f))));
            }
            this.l.a(jVar);
            return true;
        }
        return false;
    }
}
