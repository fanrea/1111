package com.component.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.component.lottie.a.b.a;
import com.component.lottie.af;
import com.component.lottie.ba;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class s implements l, p, a.InterfaceC0322a {
    private final String c;
    private final boolean d;
    private final af e;
    private final com.component.lottie.a.b.a<?, PointF> f;
    private final com.component.lottie.a.b.a<?, PointF> g;
    private final com.component.lottie.a.b.a<?, Float> h;
    private boolean k;
    private final Path a = new Path();
    private final RectF b = new RectF();
    private final c i = new c();
    private com.component.lottie.a.b.a<Float, Float> j = null;

    public s(af afVar, com.component.lottie.d.c.a aVar, com.component.lottie.d.b.k kVar) {
        this.c = kVar.a();
        this.d = kVar.e();
        this.e = afVar;
        this.f = kVar.d().a();
        this.g = kVar.c().a();
        this.h = kVar.b().a();
        aVar.a(this.f);
        aVar.a(this.g);
        aVar.a(this.h);
        this.f.a(this);
        this.g.a(this);
        this.h.a(this);
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.c;
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        c();
    }

    private void c() {
        this.k = false;
        this.e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // com.component.lottie.a.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.List<com.component.lottie.a.a.d> r5, java.util.List<com.component.lottie.a.a.d> r6) {
        /*
            r4 = this;
            r6 = 0
        L1:
            int r0 = r5.size()
            if (r6 >= r0) goto L37
            java.lang.Object r0 = r5.get(r6)
            com.component.lottie.a.a.d r0 = (com.component.lottie.a.a.d) r0
            boolean r1 = r0 instanceof com.component.lottie.a.a.y
            if (r1 == 0) goto L26
            r1 = r0
            com.component.lottie.a.a.y r1 = (com.component.lottie.a.a.y) r1
            com.component.lottie.d.b.t$a r2 = r1.c()
            com.component.lottie.d.b.t$a r3 = com.component.lottie.d.b.t.a.SIMULTANEOUSLY
            if (r2 != r3) goto L26
        L1d:
            com.component.lottie.a.a.c r0 = r4.i
            r0.a(r1)
            r1.a(r4)
            goto L33
        L26:
            boolean r1 = r0 instanceof com.component.lottie.a.a.u
            if (r1 == 0) goto L33
            com.component.lottie.a.a.u r0 = (com.component.lottie.a.a.u) r0
            com.component.lottie.a.b.a r0 = r0.c()
            r4.j = r0
            goto L34
        L33:
        L34:
            int r6 = r6 + 1
            goto L1
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.a.a.s.a(java.util.List, java.util.List):void");
    }

    @Override // com.component.lottie.a.a.p
    public Path e() {
        if (this.k) {
            return this.a;
        }
        this.a.reset();
        if (this.d) {
            this.k = true;
            return this.a;
        }
        PointF pointFG = this.g.g();
        float f = pointFG.x / 2.0f;
        float f2 = pointFG.y / 2.0f;
        float fI = this.h == null ? 0.0f : ((com.component.lottie.a.b.f) this.h).i();
        if (fI == 0.0f && this.j != null) {
            fI = Math.min(this.j.g().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fI > fMin) {
            fI = fMin;
        }
        PointF pointFG2 = this.f.g();
        this.a.moveTo(pointFG2.x + f, (pointFG2.y - f2) + fI);
        this.a.lineTo(pointFG2.x + f, (pointFG2.y + f2) - fI);
        if (fI > 0.0f) {
            float f3 = fI * 2.0f;
            this.b.set((pointFG2.x + f) - f3, (pointFG2.y + f2) - f3, pointFG2.x + f, pointFG2.y + f2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointFG2.x - f) + fI, pointFG2.y + f2);
        if (fI > 0.0f) {
            float f4 = fI * 2.0f;
            this.b.set(pointFG2.x - f, (pointFG2.y + f2) - f4, (pointFG2.x - f) + f4, pointFG2.y + f2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointFG2.x - f, (pointFG2.y - f2) + fI);
        if (fI > 0.0f) {
            float f5 = fI * 2.0f;
            this.b.set(pointFG2.x - f, pointFG2.y - f2, (pointFG2.x - f) + f5, (pointFG2.y - f2) + f5);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointFG2.x + f) - fI, pointFG2.y - f2);
        if (fI > 0.0f) {
            float f6 = fI * 2.0f;
            this.b.set((pointFG2.x + f) - f6, pointFG2.y - f2, pointFG2.x + f, (pointFG2.y - f2) + f6);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.i.a(this.a);
        this.k = true;
        return this.a;
    }

    @Override // com.component.lottie.d.f
    public void a(com.component.lottie.d.e eVar, int i, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
        com.component.lottie.g.f.a(eVar, i, list, eVar2, this);
    }

    @Override // com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        if (t == ba.l) {
            this.g.a((com.component.lottie.h.j<PointF>) jVar);
        } else if (t == ba.n) {
            this.f.a((com.component.lottie.h.j<PointF>) jVar);
        } else if (t == ba.m) {
            this.h.a((com.component.lottie.h.j<Float>) jVar);
        }
    }
}
