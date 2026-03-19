package com.component.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.component.lottie.a.b.a;
import com.component.lottie.af;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e implements f, p, a.InterfaceC0322a, com.component.lottie.d.f {
    private final Paint a;
    private final RectF b;
    private final Matrix c;
    private final Path d;
    private final RectF e;
    private final String f;
    private final boolean g;
    private final List<d> h;
    private final af i;
    private List<p> j;
    private com.component.lottie.a.b.s k;

    private static List<d> a(af afVar, com.component.lottie.d.c.a aVar, List<com.component.lottie.d.b.c> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            d dVarA = list.get(i).a(afVar, aVar);
            if (dVarA != null) {
                arrayList.add(dVarA);
            }
        }
        return arrayList;
    }

    static com.component.lottie.d.a.l a(List<com.component.lottie.d.b.c> list) {
        for (int i = 0; i < list.size(); i++) {
            com.component.lottie.d.b.c cVar = list.get(i);
            if (cVar instanceof com.component.lottie.d.a.l) {
                return (com.component.lottie.d.a.l) cVar;
            }
        }
        return null;
    }

    public e(af afVar, com.component.lottie.d.c.a aVar, com.component.lottie.d.b.p pVar) {
        this(afVar, aVar, pVar.a(), pVar.c(), a(afVar, aVar, pVar.b()), a(pVar.b()));
    }

    e(af afVar, com.component.lottie.d.c.a aVar, String str, boolean z, List<d> list, com.component.lottie.d.a.l lVar) {
        this.a = new com.component.lottie.a.a();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = str;
        this.i = afVar;
        this.g = z;
        this.h = list;
        if (lVar != null) {
            this.k = lVar.j();
            this.k.a(aVar);
            this.k.a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            d dVar = list.get(size);
            if (dVar instanceof k) {
                arrayList.add((k) dVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((k) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        this.i.invalidateSelf();
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.f;
    }

    @Override // com.component.lottie.a.a.d
    public void a(List<d> list, List<d> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.h.size());
        arrayList.addAll(list);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            d dVar = this.h.get(size);
            dVar.a(arrayList, this.h.subList(0, size));
            arrayList.add(dVar);
        }
    }

    List<p> c() {
        if (this.j == null) {
            this.j = new ArrayList();
            for (int i = 0; i < this.h.size(); i++) {
                d dVar = this.h.get(i);
                if (dVar instanceof p) {
                    this.j.add((p) dVar);
                }
            }
        }
        return this.j;
    }

    Matrix d() {
        if (this.k != null) {
            return this.k.d();
        }
        this.c.reset();
        return this.c;
    }

    @Override // com.component.lottie.a.a.p
    public Path e() {
        this.c.reset();
        if (this.k != null) {
            this.c.set(this.k.d());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            d dVar = this.h.get(size);
            if (dVar instanceof p) {
                this.d.addPath(((p) dVar).e(), this.c);
            }
        }
        return this.d;
    }

    @Override // com.component.lottie.a.a.f
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (this.g) {
            return;
        }
        this.c.set(matrix);
        if (this.k != null) {
            this.c.preConcat(this.k.d());
            i = (int) (((((this.k.a() == null ? 100 : this.k.a().g().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.i.j() && f() && i != 255;
        if (z) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(this.b, this.c, true);
            this.a.setAlpha(i);
            com.component.lottie.g.g.a(canvas, this.b, this.a);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            d dVar = this.h.get(size);
            if (dVar instanceof f) {
                ((f) dVar).a(canvas, this.c, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    private boolean f() {
        int i = 0;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            if ((this.h.get(i2) instanceof f) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.component.lottie.a.a.f
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.c.set(matrix);
        if (this.k != null) {
            this.c.preConcat(this.k.d());
        }
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            d dVar = this.h.get(size);
            if (dVar instanceof f) {
                ((f) dVar).a(this.e, this.c, z);
                rectF.union(this.e);
            }
        }
    }

    @Override // com.component.lottie.d.f
    public void a(com.component.lottie.d.e eVar, int i, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
        if (!eVar.a(b(), i) && !"__container".equals(b())) {
            return;
        }
        if (!"__container".equals(b())) {
            eVar2 = eVar2.a(b());
            if (eVar.c(b(), i)) {
                list.add(eVar2.a(this));
            }
        }
        if (eVar.d(b(), i)) {
            int iB = i + eVar.b(b(), i);
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                d dVar = this.h.get(i2);
                if (dVar instanceof com.component.lottie.d.f) {
                    ((com.component.lottie.d.f) dVar).a(eVar, iB, list, eVar2);
                }
            }
        }
    }

    @Override // com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        if (this.k != null) {
            this.k.a(t, jVar);
        }
    }
}
