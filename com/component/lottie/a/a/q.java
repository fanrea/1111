package com.component.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.component.lottie.a.b.a;
import com.component.lottie.af;
import com.component.lottie.ba;
import com.component.lottie.d.b.j;
import com.component.lottie.d.b.t;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class q implements l, p, a.InterfaceC0322a {
    private static final float a = 0.47829f;
    private static final float b = 0.25f;
    private final String d;
    private final af e;
    private final j.a f;
    private final boolean g;
    private final boolean h;
    private final com.component.lottie.a.b.a<?, Float> i;
    private final com.component.lottie.a.b.a<?, PointF> j;
    private final com.component.lottie.a.b.a<?, Float> k;
    private final com.component.lottie.a.b.a<?, Float> l;
    private final com.component.lottie.a.b.a<?, Float> m;
    private final com.component.lottie.a.b.a<?, Float> n;
    private final com.component.lottie.a.b.a<?, Float> o;
    private boolean q;
    private final Path c = new Path();
    private final c p = new c();

    public q(af afVar, com.component.lottie.d.c.a aVar, com.component.lottie.d.b.j jVar) {
        this.e = afVar;
        this.d = jVar.a();
        this.f = jVar.b();
        this.g = jVar.j();
        this.h = jVar.k();
        this.i = jVar.c().a();
        this.j = jVar.d().a();
        this.k = jVar.e().a();
        this.m = jVar.g().a();
        this.o = jVar.i().a();
        if (this.f == j.a.STAR) {
            this.l = jVar.f().a();
            this.n = jVar.h().a();
        } else {
            this.l = null;
            this.n = null;
        }
        aVar.a(this.i);
        aVar.a(this.j);
        aVar.a(this.k);
        aVar.a(this.m);
        aVar.a(this.o);
        if (this.f == j.a.STAR) {
            aVar.a(this.l);
            aVar.a(this.n);
        }
        this.i.a(this);
        this.j.a(this);
        this.k.a(this);
        this.m.a(this);
        this.o.a(this);
        if (this.f == j.a.STAR && this.l != null && this.n != null) {
            this.l.a(this);
            this.n.a(this);
        }
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        c();
    }

    private void c() {
        this.q = false;
        this.e.invalidateSelf();
    }

    @Override // com.component.lottie.a.a.d
    public void a(List<d> list, List<d> list2) {
        for (int i = 0; i < list.size(); i++) {
            d dVar = list.get(i);
            if (dVar instanceof y) {
                y yVar = (y) dVar;
                if (yVar.c() == t.a.SIMULTANEOUSLY) {
                    this.p.a(yVar);
                    yVar.a(this);
                }
            }
        }
    }

    @Override // com.component.lottie.a.a.p
    public Path e() {
        if (this.q) {
            return this.c;
        }
        this.c.reset();
        if (this.g) {
            this.q = true;
            return this.c;
        }
        switch (r.a[this.f.ordinal()]) {
            case 1:
                d();
                break;
            case 2:
                f();
                break;
        }
        this.c.close();
        this.p.a(this.c);
        this.q = true;
        return this.c;
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.d;
    }

    private void d() {
        float fFloatValue;
        float fFloatValue2;
        float f;
        float f2;
        float f3;
        double d;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        double d2;
        float f14;
        float fFloatValue3 = this.i.g().floatValue();
        double radians = Math.toRadians((this.k == null ? 0.0d : this.k.g().floatValue()) - 90.0d);
        double d3 = fFloatValue3;
        Double.isNaN(d3);
        float f15 = (float) (6.283185307179586d / d3);
        if (this.h) {
            f15 *= -1.0f;
        }
        float f16 = f15 / 2.0f;
        float f17 = fFloatValue3 - ((int) fFloatValue3);
        if (f17 != 0.0f) {
            double d4 = (1.0f - f17) * f16;
            Double.isNaN(d4);
            radians += d4;
        }
        float fFloatValue4 = this.m.g().floatValue();
        float fFloatValue5 = this.l.g().floatValue();
        if (this.n == null) {
            fFloatValue = 0.0f;
        } else {
            fFloatValue = this.n.g().floatValue() / 100.0f;
        }
        if (this.o == null) {
            fFloatValue2 = 0.0f;
        } else {
            fFloatValue2 = this.o.g().floatValue() / 100.0f;
        }
        if (f17 != 0.0f) {
            float f18 = ((fFloatValue4 - fFloatValue5) * f17) + fFloatValue5;
            f2 = fFloatValue4;
            double d5 = f18;
            double dCos = Math.cos(radians);
            Double.isNaN(d5);
            f4 = (float) (d5 * dCos);
            double dSin = Math.sin(radians);
            Double.isNaN(d5);
            f5 = (float) (d5 * dSin);
            this.c.moveTo(f4, f5);
            double d6 = (f15 * f17) / 2.0f;
            Double.isNaN(d6);
            d = radians + d6;
            f6 = f18;
            f3 = f16;
            f = fFloatValue5;
        } else {
            double d7 = fFloatValue4;
            double dCos2 = Math.cos(radians);
            Double.isNaN(d7);
            f = fFloatValue5;
            float f19 = (float) (d7 * dCos2);
            double dSin2 = Math.sin(radians);
            Double.isNaN(d7);
            float f20 = (float) (d7 * dSin2);
            this.c.moveTo(f19, f20);
            f2 = fFloatValue4;
            f3 = f16;
            double d8 = f3;
            Double.isNaN(d8);
            d = radians + d8;
            f4 = f19;
            f5 = f20;
            f6 = 0.0f;
        }
        double dCeil = Math.ceil(d3) * 2.0d;
        int i = 0;
        boolean z = false;
        while (true) {
            float f21 = f4;
            float f22 = f5;
            double d9 = i;
            if (d9 < dCeil) {
                float f23 = z ? f2 : f;
                if (f6 != 0.0f && d9 == dCeil - 2.0d) {
                    f7 = (f15 * f17) / 2.0f;
                } else {
                    f7 = f3;
                }
                if (f6 != 0.0f && d9 == dCeil - 1.0d) {
                    f8 = f15;
                    f9 = f6;
                } else {
                    f8 = f15;
                    f9 = f23;
                }
                float f24 = f3;
                float f25 = f6;
                double d10 = f9;
                double dCos3 = Math.cos(d);
                Double.isNaN(d10);
                float f26 = (float) (d10 * dCos3);
                double dSin3 = Math.sin(d);
                Double.isNaN(d10);
                f5 = (float) (d10 * dSin3);
                if (fFloatValue == 0.0f && fFloatValue2 == 0.0f) {
                    this.c.lineTo(f26, f5);
                    d2 = d;
                    f10 = f26;
                    f11 = fFloatValue;
                    f12 = f;
                    f13 = fFloatValue2;
                    f14 = f7;
                } else {
                    f10 = f26;
                    double d11 = f22;
                    f11 = fFloatValue;
                    f12 = f;
                    f13 = fFloatValue2;
                    double dAtan2 = (float) (Math.atan2(d11, f21) - 1.5707963267948966d);
                    float fCos = (float) Math.cos(dAtan2);
                    float fSin = (float) Math.sin(dAtan2);
                    d2 = d;
                    f14 = f7;
                    double dAtan22 = (float) (Math.atan2(f5, f10) - 1.5707963267948966d);
                    float fCos2 = (float) Math.cos(dAtan22);
                    float fSin2 = (float) Math.sin(dAtan22);
                    float f27 = z ? f11 : f13;
                    float f28 = z ? f13 : f11;
                    float f29 = z ? f12 : f2;
                    float f30 = z ? f2 : f12;
                    float f31 = f29 * f27 * a;
                    float f32 = fCos * f31;
                    float f33 = f31 * fSin;
                    float f34 = f30 * f28 * a;
                    float f35 = fCos2 * f34;
                    float f36 = f34 * fSin2;
                    if (f17 != 0.0f) {
                        if (i == 0) {
                            f32 *= f17;
                            f33 *= f17;
                        } else if (d9 == dCeil - 1.0d) {
                            f35 *= f17;
                            f36 *= f17;
                        }
                    }
                    this.c.cubicTo(f21 - f32, f22 - f33, f10 + f35, f5 + f36, f10, f5);
                }
                double d12 = f14;
                Double.isNaN(d12);
                z = !z;
                i++;
                d = d2 + d12;
                f4 = f10;
                fFloatValue2 = f13;
                fFloatValue = f11;
                f3 = f24;
                f15 = f8;
                f6 = f25;
                f = f12;
            } else {
                PointF pointFG = this.j.g();
                this.c.offset(pointFG.x, pointFG.y);
                this.c.close();
                return;
            }
        }
    }

    private void f() {
        int i;
        double d;
        double d2;
        double d3;
        int iFloor = (int) Math.floor(this.i.g().floatValue());
        double radians = Math.toRadians((this.k == null ? 0.0d : this.k.g().floatValue()) - 90.0d);
        double d4 = iFloor;
        Double.isNaN(d4);
        float fFloatValue = this.o.g().floatValue() / 100.0f;
        float fFloatValue2 = this.m.g().floatValue();
        double d5 = fFloatValue2;
        double dCos = Math.cos(radians);
        Double.isNaN(d5);
        float f = (float) (dCos * d5);
        double dSin = Math.sin(radians);
        Double.isNaN(d5);
        float f2 = (float) (dSin * d5);
        this.c.moveTo(f, f2);
        double d6 = (float) (6.283185307179586d / d4);
        Double.isNaN(d6);
        double d7 = radians + d6;
        double dCeil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < dCeil) {
            double dCos2 = Math.cos(d7);
            Double.isNaN(d5);
            float f3 = (float) (dCos2 * d5);
            double dSin2 = Math.sin(d7);
            Double.isNaN(d5);
            double d8 = dCeil;
            float f4 = (float) (d5 * dSin2);
            if (fFloatValue != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double dAtan2 = (float) (Math.atan2(f2, f) - 1.5707963267948966d);
                float fCos = (float) Math.cos(dAtan2);
                float fSin = (float) Math.sin(dAtan2);
                d3 = d6;
                double dAtan22 = (float) (Math.atan2(f4, f3) - 1.5707963267948966d);
                float fCos2 = (float) Math.cos(dAtan22);
                float fSin2 = (float) Math.sin(dAtan22);
                float f5 = fFloatValue2 * fFloatValue * b;
                this.c.cubicTo(f - (fCos * f5), f2 - (fSin * f5), f3 + (fCos2 * f5), f4 + (f5 * fSin2), f3, f4);
            } else {
                i = i2;
                d = d7;
                d2 = d5;
                d3 = d6;
                this.c.lineTo(f3, f4);
            }
            Double.isNaN(d3);
            d7 = d + d3;
            i2 = i + 1;
            f2 = f4;
            f = f3;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF pointFG = this.j.g();
        this.c.offset(pointFG.x, pointFG.y);
        this.c.close();
    }

    @Override // com.component.lottie.d.f
    public void a(com.component.lottie.d.e eVar, int i, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
        com.component.lottie.g.f.a(eVar, i, list, eVar2, this);
    }

    @Override // com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        if (t == ba.w) {
            this.i.a((com.component.lottie.h.j<Float>) jVar);
            return;
        }
        if (t == ba.x) {
            this.k.a((com.component.lottie.h.j<Float>) jVar);
            return;
        }
        if (t == ba.n) {
            this.j.a((com.component.lottie.h.j<PointF>) jVar);
            return;
        }
        if (t == ba.y && this.l != null) {
            this.l.a((com.component.lottie.h.j<Float>) jVar);
            return;
        }
        if (t == ba.z) {
            this.m.a((com.component.lottie.h.j<Float>) jVar);
            return;
        }
        if (t == ba.A && this.n != null) {
            this.n.a((com.component.lottie.h.j<Float>) jVar);
        } else if (t == ba.B) {
            this.o.a((com.component.lottie.h.j<Float>) jVar);
        }
    }
}
