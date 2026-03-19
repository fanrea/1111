package com.component.lottie.a.b;

import android.graphics.Color;
import android.graphics.Paint;
import com.component.lottie.a.b.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d implements a.InterfaceC0322a {
    private static final double a = 0.017453292519943295d;
    private final a.InterfaceC0322a b;
    private final a<Integer, Integer> c;
    private final a<Float, Float> d;
    private final a<Float, Float> e;
    private final a<Float, Float> f;
    private final a<Float, Float> g;
    private boolean h = true;

    public d(a.InterfaceC0322a interfaceC0322a, com.component.lottie.d.c.a aVar, com.component.lottie.f.j jVar) {
        this.b = interfaceC0322a;
        this.c = jVar.a().a();
        this.c.a(this);
        aVar.a(this.c);
        this.d = jVar.b().a();
        this.d.a(this);
        aVar.a(this.d);
        this.e = jVar.c().a();
        this.e.a(this);
        aVar.a(this.e);
        this.f = jVar.d().a();
        this.f.a(this);
        aVar.a(this.f);
        this.g = jVar.e().a();
        this.g.a(this);
        aVar.a(this.g);
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        this.h = true;
        this.b.a();
    }

    public void a(Paint paint) {
        if (!this.h) {
            return;
        }
        this.h = false;
        double dFloatValue = this.e.g().floatValue();
        Double.isNaN(dFloatValue);
        double d = dFloatValue * a;
        float fFloatValue = this.f.g().floatValue();
        float fSin = ((float) Math.sin(d)) * fFloatValue;
        float fCos = ((float) Math.cos(d + 3.141592653589793d)) * fFloatValue;
        int iIntValue = this.c.g().intValue();
        paint.setShadowLayer(this.g.g().floatValue(), fSin, fCos, Color.argb(Math.round(this.d.g().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
    }

    public void a(com.component.lottie.h.j<Integer> jVar) {
        this.c.a(jVar);
    }

    public void b(com.component.lottie.h.j<Float> jVar) {
        if (jVar == null) {
            this.d.a((com.component.lottie.h.j<Float>) null);
        } else {
            this.d.a(new e(this, jVar));
        }
    }

    public void c(com.component.lottie.h.j<Float> jVar) {
        this.e.a(jVar);
    }

    public void d(com.component.lottie.h.j<Float> jVar) {
        this.f.a(jVar);
    }

    public void e(com.component.lottie.h.j<Float> jVar) {
        this.g.a(jVar);
    }
}
