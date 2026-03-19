package com.component.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.component.lottie.a.b.a;
import com.component.lottie.af;
import com.component.lottie.ba;
import com.component.lottie.d.b.t;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g implements l, p, a.InterfaceC0322a {
    private static final float a = 0.55228f;
    private final String c;
    private final af d;
    private final com.component.lottie.a.b.a<?, PointF> e;
    private final com.component.lottie.a.b.a<?, PointF> f;
    private final com.component.lottie.d.b.b g;
    private boolean i;
    private final Path b = new Path();
    private final c h = new c();

    public g(af afVar, com.component.lottie.d.c.a aVar, com.component.lottie.d.b.b bVar) {
        this.c = bVar.a();
        this.d = afVar;
        this.e = bVar.c().a();
        this.f = bVar.b().a();
        this.g = bVar;
        aVar.a(this.e);
        aVar.a(this.f);
        this.e.a(this);
        this.f.a(this);
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        c();
    }

    private void c() {
        this.i = false;
        this.d.invalidateSelf();
    }

    @Override // com.component.lottie.a.a.d
    public void a(List<d> list, List<d> list2) {
        for (int i = 0; i < list.size(); i++) {
            d dVar = list.get(i);
            if (dVar instanceof y) {
                y yVar = (y) dVar;
                if (yVar.c() == t.a.SIMULTANEOUSLY) {
                    this.h.a(yVar);
                    yVar.a(this);
                }
            }
        }
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.c;
    }

    @Override // com.component.lottie.a.a.p
    public Path e() {
        if (this.i) {
            return this.b;
        }
        this.b.reset();
        if (this.g.e()) {
            this.i = true;
            return this.b;
        }
        PointF pointFG = this.e.g();
        float f = pointFG.x / 2.0f;
        float f2 = pointFG.y / 2.0f;
        float f3 = f * a;
        float f4 = a * f2;
        this.b.reset();
        if (this.g.d()) {
            float f5 = -f2;
            this.b.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.b.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.b.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.b.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.b.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.b.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.b.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.b.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.b.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.b.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFG2 = this.f.g();
        this.b.offset(pointFG2.x, pointFG2.y);
        this.b.close();
        this.h.a(this.b);
        this.i = true;
        return this.b;
    }

    @Override // com.component.lottie.d.f
    public void a(com.component.lottie.d.e eVar, int i, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
        com.component.lottie.g.f.a(eVar, i, list, eVar2, this);
    }

    @Override // com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        if (t == ba.k) {
            this.e.a((com.component.lottie.h.j<PointF>) jVar);
        } else if (t == ba.n) {
            this.f.a((com.component.lottie.h.j<PointF>) jVar);
        }
    }
}
