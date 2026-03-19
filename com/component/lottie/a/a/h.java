package com.component.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.component.lottie.a.b.a;
import com.component.lottie.af;
import com.component.lottie.ba;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class h implements f, l, a.InterfaceC0322a {
    float a;
    private final com.component.lottie.d.c.a d;
    private final String e;
    private final boolean f;
    private final com.component.lottie.a.b.a<Integer, Integer> h;
    private final com.component.lottie.a.b.a<Integer, Integer> i;
    private com.component.lottie.a.b.a<ColorFilter, ColorFilter> j;
    private final af k;
    private com.component.lottie.a.b.a<Float, Float> l;
    private com.component.lottie.a.b.d m;
    private final Path b = new Path();
    private final Paint c = new com.component.lottie.a.a(1);
    private final List<p> g = new ArrayList();

    public h(af afVar, com.component.lottie.d.c.a aVar, com.component.lottie.d.b.o oVar) {
        this.d = aVar;
        this.e = oVar.a();
        this.f = oVar.e();
        this.k = afVar;
        if (aVar.f() != null) {
            this.l = aVar.f().a().a();
            this.l.a(this);
            aVar.a(this.l);
        }
        if (aVar.g() != null) {
            this.m = new com.component.lottie.a.b.d(this, aVar, aVar.g());
        }
        if (oVar.b() == null || oVar.c() == null) {
            this.h = null;
            this.i = null;
            return;
        }
        this.b.setFillType(oVar.d());
        this.h = oVar.b().a();
        this.h.a(this);
        aVar.a(this.h);
        this.i = oVar.c().a();
        this.i.a(this);
        aVar.a(this.i);
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        this.k.invalidateSelf();
    }

    @Override // com.component.lottie.a.a.d
    public void a(List<d> list, List<d> list2) {
        for (int i = 0; i < list2.size(); i++) {
            d dVar = list2.get(i);
            if (dVar instanceof p) {
                this.g.add((p) dVar);
            }
        }
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.e;
    }

    @Override // com.component.lottie.a.a.f
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (this.f) {
            return;
        }
        com.component.lottie.c.a("FillContent#draw");
        this.c.setColor((com.component.lottie.g.f.a((int) ((((i / 255.0f) * this.i.g().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.component.lottie.a.b.c) this.h).i() & 16777215));
        if (this.j != null) {
            this.c.setColorFilter(this.j.g());
        }
        if (this.l != null) {
            float fFloatValue = this.l.g().floatValue();
            if (fFloatValue == 0.0f) {
                this.c.setMaskFilter(null);
            } else if (fFloatValue != this.a) {
                this.c.setMaskFilter(this.d.b(fFloatValue));
            }
            this.a = fFloatValue;
        }
        if (this.m != null) {
            this.m.a(this.c);
        }
        this.b.reset();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            this.b.addPath(this.g.get(i2).e(), matrix);
        }
        canvas.drawPath(this.b, this.c);
        com.component.lottie.c.b("FillContent#draw");
    }

    @Override // com.component.lottie.a.a.f
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.b.reset();
        for (int i = 0; i < this.g.size(); i++) {
            this.b.addPath(this.g.get(i).e(), matrix);
        }
        this.b.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.component.lottie.d.f
    public void a(com.component.lottie.d.e eVar, int i, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
        com.component.lottie.g.f.a(eVar, i, list, eVar2, this);
    }

    @Override // com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        if (t == ba.a) {
            this.h.a((com.component.lottie.h.j<Integer>) jVar);
            return;
        }
        if (t == ba.d) {
            this.i.a((com.component.lottie.h.j<Integer>) jVar);
            return;
        }
        if (t == ba.f759K) {
            if (this.j != null) {
                this.d.b(this.j);
            }
            if (jVar == null) {
                this.j = null;
                return;
            }
            this.j = new com.component.lottie.a.b.t(jVar);
            this.j.a(this);
            this.d.a(this.j);
            return;
        }
        if (t == ba.j) {
            if (this.l != null) {
                this.l.a((com.component.lottie.h.j<Float>) jVar);
                return;
            }
            this.l = new com.component.lottie.a.b.t(jVar);
            this.l.a(this);
            this.d.a(this.l);
            return;
        }
        if (t == ba.e && this.m != null) {
            this.m.a((com.component.lottie.h.j<Integer>) jVar);
            return;
        }
        if (t == ba.G && this.m != null) {
            this.m.b(jVar);
            return;
        }
        if (t == ba.H && this.m != null) {
            this.m.c(jVar);
            return;
        }
        if (t == ba.I && this.m != null) {
            this.m.d(jVar);
        } else if (t == ba.J && this.m != null) {
            this.m.e(jVar);
        }
    }
}
