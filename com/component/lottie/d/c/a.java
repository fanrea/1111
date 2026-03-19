package com.component.lottie.d.c;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.component.lottie.a.b.a;
import com.component.lottie.a.b.s;
import com.component.lottie.af;
import com.component.lottie.d.b.h;
import com.component.lottie.d.c.g;
import com.component.lottie.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class a implements com.component.lottie.a.a.f, a.InterfaceC0322a, com.component.lottie.d.f {
    private static final int g = 2;
    private static final int h = 16;
    private static final int i = 1;
    private static final int j = 19;
    private a A;
    private a B;
    private List<a> C;
    private boolean F;
    private Paint G;
    final af b;
    final g c;
    final s d;
    BlurMaskFilter f;
    private final String x;
    private com.component.lottie.a.b.j y;
    private com.component.lottie.a.b.f z;
    private final Path k = new Path();
    private final Matrix l = new Matrix();
    private final Matrix m = new Matrix();
    private final Paint n = new com.component.lottie.a.a(1);
    private final Paint o = new com.component.lottie.a.a(1, PorterDuff.Mode.DST_IN);
    private final Paint p = new com.component.lottie.a.a(1, PorterDuff.Mode.DST_OUT);
    private final Paint q = new com.component.lottie.a.a(1);
    private final Paint r = new com.component.lottie.a.a(PorterDuff.Mode.CLEAR);
    private final RectF s = new RectF();
    private final RectF t = new RectF();
    private final RectF u = new RectF();
    private final RectF v = new RectF();
    private final RectF w = new RectF();
    final Matrix a = new Matrix();
    private final List<com.component.lottie.a.b.a<?, ?>> D = new ArrayList();
    private boolean E = true;
    float e = 0.0f;

    abstract void b(Canvas canvas, Matrix matrix, int i2);

    static a a(d dVar, g gVar, af afVar, t tVar) {
        switch (c.a[gVar.k().ordinal()]) {
            case 1:
                return new i(afVar, gVar, dVar);
            case 2:
                return new d(afVar, gVar, tVar.b(gVar.g()), tVar);
            case 3:
                return new j(afVar, gVar);
            case 4:
                return new f(afVar, gVar);
            case 5:
                return new h(afVar, gVar);
            case 6:
                return new k(afVar, gVar);
            default:
                com.component.lottie.g.c.b("Unknown layer type " + gVar.k());
                return null;
        }
    }

    a(af afVar, g gVar) {
        this.b = afVar;
        this.c = gVar;
        this.x = gVar.f() + "#draw";
        if (gVar.l() == g.b.INVERT) {
            this.q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.d = gVar.o().j();
        this.d.a((a.InterfaceC0322a) this);
        if (gVar.j() != null && !gVar.j().isEmpty()) {
            this.y = new com.component.lottie.a.b.j(gVar.j());
            Iterator<com.component.lottie.a.b.a<com.component.lottie.d.b.n, Path>> it = this.y.b().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (com.component.lottie.a.b.a<Integer, Integer> aVar : this.y.c()) {
                a(aVar);
                aVar.a(this);
            }
        }
        h();
    }

    void a(boolean z) {
        if (z && this.G == null) {
            this.G = new com.component.lottie.a.a();
        }
        this.F = z;
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        i();
    }

    g c() {
        return this.c;
    }

    void a(a aVar) {
        this.A = aVar;
    }

    boolean d() {
        return this.A != null;
    }

    void b(a aVar) {
        this.B = aVar;
    }

    private void h() {
        if (!this.c.d().isEmpty()) {
            this.z = new com.component.lottie.a.b.f(this.c.d());
            this.z.a();
            this.z.a(new b(this));
            b(this.z.g().floatValue() == 1.0f);
            a(this.z);
            return;
        }
        b(true);
    }

    private void i() {
        this.b.invalidateSelf();
    }

    public void a(com.component.lottie.a.b.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.D.add(aVar);
    }

    public void b(com.component.lottie.a.b.a<?, ?> aVar) {
        this.D.remove(aVar);
    }

    @Override // com.component.lottie.a.a.f
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.s.set(0.0f, 0.0f, 0.0f, 0.0f);
        k();
        this.a.set(matrix);
        if (z) {
            if (this.C != null) {
                for (int size = this.C.size() - 1; size >= 0; size--) {
                    this.a.preConcat(this.C.get(size).d.d());
                }
            } else if (this.B != null) {
                this.a.preConcat(this.B.d.d());
            }
        }
        this.a.preConcat(this.d.d());
    }

    @Override // com.component.lottie.a.a.f
    public void a(Canvas canvas, Matrix matrix, int i2) {
        com.component.lottie.c.a(this.x);
        if (!this.E || this.c.v()) {
            com.component.lottie.c.b(this.x);
            return;
        }
        k();
        com.component.lottie.c.a("Layer#parentMatrix");
        this.l.reset();
        this.l.set(matrix);
        for (int size = this.C.size() - 1; size >= 0; size--) {
            this.l.preConcat(this.C.get(size).d.d());
        }
        com.component.lottie.c.b("Layer#parentMatrix");
        int iIntValue = (int) ((((i2 / 255.0f) * (this.d.a() == null ? 100 : this.d.a().g().intValue())) / 100.0f) * 255.0f);
        if (!d() && !e()) {
            this.l.preConcat(this.d.d());
            com.component.lottie.c.a("Layer#drawLayer");
            b(canvas, this.l, iIntValue);
            com.component.lottie.c.b("Layer#drawLayer");
            c(com.component.lottie.c.b(this.x));
            return;
        }
        com.component.lottie.c.a("Layer#computeBounds");
        a(this.s, this.l, false);
        b(this.s, matrix);
        this.l.preConcat(this.d.d());
        a(this.s, this.l);
        this.t.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.m);
        if (!this.m.isIdentity()) {
            this.m.invert(this.m);
            this.m.mapRect(this.t);
        }
        if (!this.s.intersect(this.t)) {
            this.s.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.component.lottie.c.b("Layer#computeBounds");
        if (this.s.width() >= 1.0f && this.s.height() >= 1.0f) {
            com.component.lottie.c.a("Layer#saveLayer");
            this.n.setAlpha(255);
            com.component.lottie.g.g.a(canvas, this.s, this.n);
            com.component.lottie.c.b("Layer#saveLayer");
            a(canvas);
            com.component.lottie.c.a("Layer#drawLayer");
            b(canvas, this.l, iIntValue);
            com.component.lottie.c.b("Layer#drawLayer");
            if (e()) {
                a(canvas, this.l);
            }
            if (d()) {
                com.component.lottie.c.a("Layer#drawMatte");
                com.component.lottie.c.a("Layer#saveLayer");
                com.component.lottie.g.g.a(canvas, this.s, this.q, 19);
                com.component.lottie.c.b("Layer#saveLayer");
                a(canvas);
                this.A.a(canvas, matrix, iIntValue);
                com.component.lottie.c.a("Layer#restoreLayer");
                canvas.restore();
                com.component.lottie.c.b("Layer#restoreLayer");
                com.component.lottie.c.b("Layer#drawMatte");
            }
            com.component.lottie.c.a("Layer#restoreLayer");
            canvas.restore();
            com.component.lottie.c.b("Layer#restoreLayer");
        }
        if (this.F && this.G != null) {
            this.G.setStyle(Paint.Style.STROKE);
            this.G.setColor(-251901);
            this.G.setStrokeWidth(4.0f);
            canvas.drawRect(this.s, this.G);
            this.G.setStyle(Paint.Style.FILL);
            this.G.setColor(1357638635);
            canvas.drawRect(this.s, this.G);
        }
        c(com.component.lottie.c.b(this.x));
    }

    private void c(float f) {
        this.b.C().d().a(this.c.f(), f);
    }

    private void a(Canvas canvas) {
        com.component.lottie.c.a("Layer#clearLayer");
        canvas.drawRect(this.s.left - 1.0f, this.s.top - 1.0f, this.s.right + 1.0f, this.s.bottom + 1.0f, this.r);
        com.component.lottie.c.b("Layer#clearLayer");
    }

    private void a(RectF rectF, Matrix matrix) {
        this.u.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (!e()) {
            return;
        }
        int size = this.y.a().size();
        for (int i2 = 0; i2 < size; i2++) {
            com.component.lottie.d.b.h hVar = this.y.a().get(i2);
            Path pathG = this.y.b().get(i2).g();
            if (pathG != null) {
                this.k.set(pathG);
                this.k.transform(matrix);
                switch (c.b[hVar.a().ordinal()]) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                    case 4:
                        if (hVar.d()) {
                            break;
                        }
                    default:
                        this.k.computeBounds(this.w, false);
                        if (i2 == 0) {
                            this.u.set(this.w);
                            break;
                        } else {
                            this.u.set(Math.min(this.u.left, this.w.left), Math.min(this.u.top, this.w.top), Math.max(this.u.right, this.w.right), Math.max(this.u.bottom, this.w.bottom));
                            break;
                        }
                }
                return;
            }
        }
        if (!rectF.intersect(this.u)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void b(RectF rectF, Matrix matrix) {
        if (!d() || this.c.l() == g.b.INVERT) {
            return;
        }
        this.v.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.A.a(this.v, matrix, true);
        if (!rectF.intersect(this.v)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        com.component.lottie.c.a("Layer#saveLayer");
        com.component.lottie.g.g.a(canvas, this.s, this.o, 19);
        if (Build.VERSION.SDK_INT < 28) {
            a(canvas);
        }
        com.component.lottie.c.b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.y.a().size(); i2++) {
            com.component.lottie.d.b.h hVar = this.y.a().get(i2);
            com.component.lottie.a.b.a<com.component.lottie.d.b.n, Path> aVar = this.y.b().get(i2);
            com.component.lottie.a.b.a<Integer, Integer> aVar2 = this.y.c().get(i2);
            switch (c.b[hVar.a().ordinal()]) {
                case 1:
                    if (j()) {
                        this.n.setAlpha(255);
                        canvas.drawRect(this.s, this.n);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (i2 == 0) {
                        this.n.setColor(-16777216);
                        this.n.setAlpha(255);
                        canvas.drawRect(this.s, this.n);
                    }
                    if (hVar.d()) {
                        c(canvas, matrix, aVar, aVar2);
                        break;
                    } else {
                        a(canvas, matrix, aVar);
                        break;
                    }
                case 3:
                    if (hVar.d()) {
                        e(canvas, matrix, aVar, aVar2);
                        break;
                    } else {
                        d(canvas, matrix, aVar, aVar2);
                        break;
                    }
                case 4:
                    if (hVar.d()) {
                        b(canvas, matrix, aVar, aVar2);
                        break;
                    } else {
                        a(canvas, matrix, aVar, aVar2);
                        break;
                    }
            }
        }
        com.component.lottie.c.a("Layer#restoreLayer");
        canvas.restore();
        com.component.lottie.c.b("Layer#restoreLayer");
    }

    private boolean j() {
        if (this.y.b().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.y.a().size(); i2++) {
            if (this.y.a().get(i2).a() != h.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void a(Canvas canvas, Matrix matrix, com.component.lottie.a.b.a<com.component.lottie.d.b.n, Path> aVar, com.component.lottie.a.b.a<Integer, Integer> aVar2) {
        this.k.set(aVar.g());
        this.k.transform(matrix);
        this.n.setAlpha((int) (aVar2.g().intValue() * 2.55f));
        canvas.drawPath(this.k, this.n);
    }

    private void b(Canvas canvas, Matrix matrix, com.component.lottie.a.b.a<com.component.lottie.d.b.n, Path> aVar, com.component.lottie.a.b.a<Integer, Integer> aVar2) {
        com.component.lottie.g.g.a(canvas, this.s, this.n);
        canvas.drawRect(this.s, this.n);
        this.k.set(aVar.g());
        this.k.transform(matrix);
        this.n.setAlpha((int) (aVar2.g().intValue() * 2.55f));
        canvas.drawPath(this.k, this.p);
        canvas.restore();
    }

    private void a(Canvas canvas, Matrix matrix, com.component.lottie.a.b.a<com.component.lottie.d.b.n, Path> aVar) {
        this.k.set(aVar.g());
        this.k.transform(matrix);
        canvas.drawPath(this.k, this.p);
    }

    private void c(Canvas canvas, Matrix matrix, com.component.lottie.a.b.a<com.component.lottie.d.b.n, Path> aVar, com.component.lottie.a.b.a<Integer, Integer> aVar2) {
        com.component.lottie.g.g.a(canvas, this.s, this.p);
        canvas.drawRect(this.s, this.n);
        this.p.setAlpha((int) (aVar2.g().intValue() * 2.55f));
        this.k.set(aVar.g());
        this.k.transform(matrix);
        canvas.drawPath(this.k, this.p);
        canvas.restore();
    }

    private void d(Canvas canvas, Matrix matrix, com.component.lottie.a.b.a<com.component.lottie.d.b.n, Path> aVar, com.component.lottie.a.b.a<Integer, Integer> aVar2) {
        com.component.lottie.g.g.a(canvas, this.s, this.o);
        this.k.set(aVar.g());
        this.k.transform(matrix);
        this.n.setAlpha((int) (aVar2.g().intValue() * 2.55f));
        canvas.drawPath(this.k, this.n);
        canvas.restore();
    }

    private void e(Canvas canvas, Matrix matrix, com.component.lottie.a.b.a<com.component.lottie.d.b.n, Path> aVar, com.component.lottie.a.b.a<Integer, Integer> aVar2) {
        com.component.lottie.g.g.a(canvas, this.s, this.o);
        canvas.drawRect(this.s, this.n);
        this.p.setAlpha((int) (aVar2.g().intValue() * 2.55f));
        this.k.set(aVar.g());
        this.k.transform(matrix);
        canvas.drawPath(this.k, this.p);
        canvas.restore();
    }

    boolean e() {
        return (this.y == null || this.y.b().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z != this.E) {
            this.E = z;
            i();
        }
    }

    void a(float f) {
        this.d.a(f);
        if (this.y != null) {
            for (int i2 = 0; i2 < this.y.b().size(); i2++) {
                this.y.b().get(i2).a(f);
            }
        }
        if (this.z != null) {
            this.z.a(f);
        }
        if (this.A != null) {
            this.A.a(f);
        }
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            this.D.get(i3).a(f);
        }
    }

    private void k() {
        if (this.C != null) {
            return;
        }
        if (this.B == null) {
            this.C = Collections.emptyList();
            return;
        }
        this.C = new ArrayList();
        for (a aVar = this.B; aVar != null; aVar = aVar.B) {
            this.C.add(aVar);
        }
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.c.f();
    }

    public com.component.lottie.d.b.a f() {
        return this.c.w();
    }

    public BlurMaskFilter b(float f) {
        if (this.e == f) {
            return this.f;
        }
        this.f = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.e = f;
        return this.f;
    }

    public com.component.lottie.f.j g() {
        return this.c.x();
    }

    @Override // com.component.lottie.a.a.d
    public void a(List<com.component.lottie.a.a.d> list, List<com.component.lottie.a.a.d> list2) {
    }

    @Override // com.component.lottie.d.f
    public void a(com.component.lottie.d.e eVar, int i2, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
        if (this.A != null) {
            com.component.lottie.d.e eVarA = eVar2.a(this.A.b());
            if (eVar.c(this.A.b(), i2)) {
                list.add(eVarA.a(this.A));
            }
            if (eVar.d(b(), i2)) {
                this.A.b(eVar, eVar.b(this.A.b(), i2) + i2, list, eVarA);
            }
        }
        if (!eVar.a(b(), i2)) {
            return;
        }
        if (!"__container".equals(b())) {
            eVar2 = eVar2.a(b());
            if (eVar.c(b(), i2)) {
                list.add(eVar2.a(this));
            }
        }
        if (eVar.d(b(), i2)) {
            b(eVar, i2 + eVar.b(b(), i2), list, eVar2);
        }
    }

    void b(com.component.lottie.d.e eVar, int i2, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
    }

    @Override // com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        this.d.a(t, jVar);
    }
}
