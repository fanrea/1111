package com.component.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class p extends a<PointF, PointF> {
    protected com.component.lottie.h.j<Float> d;
    protected com.component.lottie.h.j<Float> e;
    private final PointF f;
    private final PointF g;
    private final a<Float, Float> h;
    private final a<Float, Float> i;

    public p(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f = new PointF();
        this.g = new PointF();
        this.h = aVar;
        this.i = aVar2;
        a(h());
    }

    public void b(com.component.lottie.h.j<Float> jVar) {
        if (this.d != null) {
            this.d.a((a<?, ?>) null);
        }
        this.d = jVar;
        if (jVar != null) {
            jVar.a(this);
        }
    }

    public void c(com.component.lottie.h.j<Float> jVar) {
        if (this.e != null) {
            this.e.a((a<?, ?>) null);
        }
        this.e = jVar;
        if (jVar != null) {
            jVar.a(this);
        }
    }

    @Override // com.component.lottie.a.b.a
    public void a(float f) {
        this.h.a(f);
        this.i.a(f);
        this.f.set(this.h.g().floatValue(), this.i.g().floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).a();
        }
    }

    @Override // com.component.lottie.a.b.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public PointF g() {
        return a(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.component.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(com.component.lottie.h.a<PointF> aVar, float f) {
        Float fA;
        com.component.lottie.h.a<Float> aVarC;
        com.component.lottie.h.a<Float> aVarC2;
        Float fA2 = null;
        if (this.d != null && (aVarC2 = this.h.c()) != null) {
            float fE = this.h.e();
            Float f2 = aVarC2.g;
            fA = this.d.a(aVarC2.f, f2 == null ? aVarC2.f : f2.floatValue(), aVarC2.a, aVarC2.b, f, f, fE);
        } else {
            fA = null;
        }
        if (this.e != null && (aVarC = this.i.c()) != null) {
            float fE2 = this.i.e();
            Float f3 = aVarC.g;
            fA2 = this.e.a(aVarC.f, f3 == null ? aVarC.f : f3.floatValue(), aVarC.a, aVarC.b, f, f, fE2);
        }
        if (fA == null) {
            this.g.set(this.f.x, 0.0f);
        } else {
            this.g.set(fA.floatValue(), 0.0f);
        }
        if (fA2 == null) {
            this.g.set(this.g.x, this.f.y);
        } else {
            this.g.set(this.g.x, fA2.floatValue());
        }
        return this.g;
    }
}
