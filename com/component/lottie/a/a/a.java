package com.component.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.component.lottie.a.b.a;
import com.component.lottie.af;
import com.component.lottie.ba;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class a implements f, l, a.InterfaceC0322a {
    protected final com.component.lottie.d.c.a a;
    private final af h;
    private final float[] j;
    private final com.component.lottie.a.b.a<?, Float> k;
    private final com.component.lottie.a.b.a<?, Integer> l;
    private final List<com.component.lottie.a.b.a<?, Float>> m;
    private final com.component.lottie.a.b.a<?, Float> n;
    private com.component.lottie.a.b.a<ColorFilter, ColorFilter> o;
    private com.component.lottie.a.b.a<Float, Float> p;
    private com.component.lottie.a.b.d q;
    private final PathMeasure d = new PathMeasure();
    private final Path e = new Path();
    private final Path f = new Path();
    private final RectF g = new RectF();
    private final List<C0321a> i = new ArrayList();
    final Paint b = new com.component.lottie.a.a(1);
    float c = 0.0f;

    a(af afVar, com.component.lottie.d.c.a aVar, Paint.Cap cap, Paint.Join join, float f, com.component.lottie.d.a.d dVar, com.component.lottie.d.a.b bVar, List<com.component.lottie.d.a.b> list, com.component.lottie.d.a.b bVar2) {
        this.h = afVar;
        this.a = aVar;
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeCap(cap);
        this.b.setStrokeJoin(join);
        this.b.setStrokeMiter(f);
        this.l = dVar.a();
        this.k = bVar.a();
        if (bVar2 == null) {
            this.n = null;
        } else {
            this.n = bVar2.a();
        }
        this.m = new ArrayList(list.size());
        this.j = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.m.add(list.get(i).a());
        }
        aVar.a(this.l);
        aVar.a(this.k);
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            aVar.a(this.m.get(i2));
        }
        if (this.n != null) {
            aVar.a(this.n);
        }
        this.l.a(this);
        this.k.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.m.get(i3).a(this);
        }
        if (this.n != null) {
            this.n.a(this);
        }
        if (aVar.f() != null) {
            this.p = aVar.f().a().a();
            this.p.a(this);
            aVar.a(this.p);
        }
        if (aVar.g() != null) {
            this.q = new com.component.lottie.a.b.d(this, aVar, aVar.g());
        }
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        this.h.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    @Override // com.component.lottie.a.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.List<com.component.lottie.a.a.d> r8, java.util.List<com.component.lottie.a.a.d> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L9:
            if (r0 < 0) goto L23
            java.lang.Object r3 = r8.get(r0)
            com.component.lottie.a.a.d r3 = (com.component.lottie.a.a.d) r3
            boolean r4 = r3 instanceof com.component.lottie.a.a.y
            if (r4 == 0) goto L20
            com.component.lottie.a.a.y r3 = (com.component.lottie.a.a.y) r3
            com.component.lottie.d.b.t$a r4 = r3.c()
            com.component.lottie.d.b.t$a r5 = com.component.lottie.d.b.t.a.INDIVIDUALLY
            if (r4 != r5) goto L20
            r2 = r3
        L20:
            int r0 = r0 + (-1)
            goto L9
        L23:
            if (r2 == 0) goto L28
            r2.a(r7)
        L28:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L30:
            if (r8 < 0) goto L6e
            java.lang.Object r3 = r9.get(r8)
            com.component.lottie.a.a.d r3 = (com.component.lottie.a.a.d) r3
            boolean r4 = r3 instanceof com.component.lottie.a.a.y
            if (r4 == 0) goto L57
            r4 = r3
            com.component.lottie.a.a.y r4 = (com.component.lottie.a.a.y) r4
            com.component.lottie.d.b.t$a r5 = r4.c()
            com.component.lottie.d.b.t$a r6 = com.component.lottie.d.b.t.a.INDIVIDUALLY
            if (r5 != r6) goto L57
            if (r0 == 0) goto L4e
            java.util.List<com.component.lottie.a.a.a$a> r3 = r7.i
            r3.add(r0)
        L4e:
            com.component.lottie.a.a.a$a r0 = new com.component.lottie.a.a.a$a
            r0.<init>(r4)
            r4.a(r7)
            goto L6b
        L57:
            boolean r4 = r3 instanceof com.component.lottie.a.a.p
            if (r4 == 0) goto L6b
            if (r0 != 0) goto L62
            com.component.lottie.a.a.a$a r0 = new com.component.lottie.a.a.a$a
            r0.<init>(r2)
        L62:
            java.util.List r4 = com.component.lottie.a.a.a.C0321a.a(r0)
            com.component.lottie.a.a.p r3 = (com.component.lottie.a.a.p) r3
            r4.add(r3)
        L6b:
            int r8 = r8 + (-1)
            goto L30
        L6e:
            if (r0 == 0) goto L75
            java.util.List<com.component.lottie.a.a.a$a> r8 = r7.i
            r8.add(r0)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.a.a.a.a(java.util.List, java.util.List):void");
    }

    @Override // com.component.lottie.a.a.f
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.component.lottie.c.a("StrokeContent#draw");
        if (com.component.lottie.g.g.b(matrix)) {
            com.component.lottie.c.b("StrokeContent#draw");
            return;
        }
        this.b.setAlpha(com.component.lottie.g.f.a((int) ((((i / 255.0f) * ((com.component.lottie.a.b.h) this.l).i()) / 100.0f) * 255.0f), 0, 255));
        this.b.setStrokeWidth(((com.component.lottie.a.b.f) this.k).i() * com.component.lottie.g.g.a(matrix));
        if (this.b.getStrokeWidth() <= 0.0f) {
            com.component.lottie.c.b("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.o != null) {
            this.b.setColorFilter(this.o.g());
        }
        if (this.p != null) {
            float fFloatValue = this.p.g().floatValue();
            if (fFloatValue == 0.0f) {
                this.b.setMaskFilter(null);
            } else if (fFloatValue != this.c) {
                this.b.setMaskFilter(this.a.b(fFloatValue));
            }
            this.c = fFloatValue;
        }
        if (this.q != null) {
            this.q.a(this.b);
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            C0321a c0321a = this.i.get(i2);
            if (c0321a.b != null) {
                a(canvas, c0321a, matrix);
            } else {
                com.component.lottie.c.a("StrokeContent#buildPath");
                this.e.reset();
                for (int size = c0321a.a.size() - 1; size >= 0; size--) {
                    this.e.addPath(((p) c0321a.a.get(size)).e(), matrix);
                }
                com.component.lottie.c.b("StrokeContent#buildPath");
                com.component.lottie.c.a("StrokeContent#drawPath");
                canvas.drawPath(this.e, this.b);
                com.component.lottie.c.b("StrokeContent#drawPath");
            }
        }
        com.component.lottie.c.b("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.graphics.Canvas r17, com.component.lottie.a.a.a.C0321a r18, android.graphics.Matrix r19) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.a.a.a.a(android.graphics.Canvas, com.component.lottie.a.a.a$a, android.graphics.Matrix):void");
    }

    @Override // com.component.lottie.a.a.f
    public void a(RectF rectF, Matrix matrix, boolean z) {
        com.component.lottie.c.a("StrokeContent#getBounds");
        this.e.reset();
        for (int i = 0; i < this.i.size(); i++) {
            C0321a c0321a = this.i.get(i);
            for (int i2 = 0; i2 < c0321a.a.size(); i2++) {
                this.e.addPath(((p) c0321a.a.get(i2)).e(), matrix);
            }
        }
        this.e.computeBounds(this.g, false);
        float fI = ((com.component.lottie.a.b.f) this.k).i() / 2.0f;
        this.g.set(this.g.left - fI, this.g.top - fI, this.g.right + fI, this.g.bottom + fI);
        rectF.set(this.g);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.component.lottie.c.b("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.component.lottie.c.a("StrokeContent#applyDashPattern");
        if (this.m.isEmpty()) {
            com.component.lottie.c.b("StrokeContent#applyDashPattern");
            return;
        }
        float fA = com.component.lottie.g.g.a(matrix);
        for (int i = 0; i < this.m.size(); i++) {
            this.j[i] = this.m.get(i).g().floatValue();
            if (i % 2 == 0) {
                if (this.j[i] < 1.0f) {
                    this.j[i] = 1.0f;
                }
            } else if (this.j[i] < 0.1f) {
                this.j[i] = 0.1f;
            }
            float[] fArr = this.j;
            fArr[i] = fArr[i] * fA;
        }
        this.b.setPathEffect(new DashPathEffect(this.j, this.n == null ? 0.0f : fA * this.n.g().floatValue()));
        com.component.lottie.c.b("StrokeContent#applyDashPattern");
    }

    @Override // com.component.lottie.d.f
    public void a(com.component.lottie.d.e eVar, int i, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
        com.component.lottie.g.f.a(eVar, i, list, eVar2, this);
    }

    @Override // com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        if (t == ba.d) {
            this.l.a((com.component.lottie.h.j<Integer>) jVar);
            return;
        }
        if (t == ba.s) {
            this.k.a((com.component.lottie.h.j<Float>) jVar);
            return;
        }
        if (t == ba.f759K) {
            if (this.o != null) {
                this.a.b(this.o);
            }
            if (jVar == null) {
                this.o = null;
                return;
            }
            this.o = new com.component.lottie.a.b.t(jVar);
            this.o.a(this);
            this.a.a(this.o);
            return;
        }
        if (t == ba.j) {
            if (this.p != null) {
                this.p.a((com.component.lottie.h.j<Float>) jVar);
                return;
            }
            this.p = new com.component.lottie.a.b.t(jVar);
            this.p.a(this);
            this.a.a(this.p);
            return;
        }
        if (t == ba.e && this.q != null) {
            this.q.a((com.component.lottie.h.j<Integer>) jVar);
            return;
        }
        if (t == ba.G && this.q != null) {
            this.q.b(jVar);
            return;
        }
        if (t == ba.H && this.q != null) {
            this.q.c(jVar);
            return;
        }
        if (t == ba.I && this.q != null) {
            this.q.d(jVar);
        } else if (t == ba.J && this.q != null) {
            this.q.e(jVar);
        }
    }

    /* renamed from: com.component.lottie.a.a.a$a, reason: collision with other inner class name */
    private static final class C0321a {
        private final List<p> a;
        private final y b;

        private C0321a(y yVar) {
            this.a = new ArrayList();
            this.b = yVar;
        }
    }
}
