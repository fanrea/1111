package com.component.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.component.lottie.af;
import com.component.lottie.ba;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class x extends a {
    private final com.component.lottie.d.c.a d;
    private final String e;
    private final boolean f;
    private final com.component.lottie.a.b.a<Integer, Integer> g;
    private com.component.lottie.a.b.a<ColorFilter, ColorFilter> h;

    public x(af afVar, com.component.lottie.d.c.a aVar, com.component.lottie.d.b.r rVar) {
        super(afVar, aVar, rVar.g().b(), rVar.h().b(), rVar.i(), rVar.c(), rVar.d(), rVar.e(), rVar.f());
        this.d = aVar;
        this.e = rVar.a();
        this.f = rVar.j();
        this.g = rVar.b().a();
        this.g.a(this);
        aVar.a(this.g);
    }

    @Override // com.component.lottie.a.a.a, com.component.lottie.a.a.f
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (this.f) {
            return;
        }
        this.b.setColor(((com.component.lottie.a.b.c) this.g).i());
        if (this.h != null) {
            this.b.setColorFilter(this.h.g());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.e;
    }

    @Override // com.component.lottie.a.a.a, com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        super.a((x) t, (com.component.lottie.h.j<x>) jVar);
        if (t == ba.b) {
            this.g.a((com.component.lottie.h.j<Integer>) jVar);
            return;
        }
        if (t == ba.f759K) {
            if (this.h != null) {
                this.d.b(this.h);
            }
            if (jVar == null) {
                this.h = null;
                return;
            }
            this.h = new com.component.lottie.a.b.t(jVar);
            this.h.a(this);
            this.d.a(this.g);
        }
    }
}
