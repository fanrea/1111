package com.component.lottie.d.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.component.lottie.af;
import com.component.lottie.ba;
import com.component.lottie.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends a {
    private com.component.lottie.a.b.a<Float, Float> g;
    private final List<a> h;
    private final RectF i;
    private final RectF j;
    private final Paint k;
    private Boolean l;
    private Boolean m;
    private boolean n;

    public d(af afVar, g gVar, List<g> list, t tVar) {
        a aVar;
        super(afVar, gVar);
        this.h = new ArrayList();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new Paint();
        this.n = true;
        com.component.lottie.d.a.b bVarU = gVar.u();
        if (bVarU != null) {
            this.g = bVarU.a();
            a(this.g);
            this.g.a(this);
        } else {
            this.g = null;
        }
        com.component.lottie.b.b bVar = new com.component.lottie.b.b(tVar.j().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (true) {
            if (size >= 0) {
                g gVar2 = list.get(size);
                a aVarA = a.a(this, gVar2, afVar, tVar);
                if (aVarA != null) {
                    bVar.d(aVarA.c().e(), aVarA);
                    if (aVar2 != null) {
                        aVar2.a(aVarA);
                        aVar2 = null;
                    } else {
                        this.h.add(0, aVarA);
                        switch (e.a[gVar2.l().ordinal()]) {
                            case 1:
                            case 2:
                                aVar2 = aVarA;
                                break;
                        }
                    }
                }
                size--;
            } else {
                for (int i = 0; i < bVar.b(); i++) {
                    a aVar3 = (a) bVar.a(bVar.b(i));
                    if (aVar3 != null && (aVar = (a) bVar.a(aVar3.c().m())) != null) {
                        aVar3.b(aVar);
                    }
                }
                return;
            }
        }
    }

    public void b(boolean z) {
        this.n = z;
    }

    @Override // com.component.lottie.d.c.a
    public void a(boolean z) {
        super.a(z);
        Iterator<a> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }

    @Override // com.component.lottie.d.c.a
    void b(Canvas canvas, Matrix matrix, int i) {
        boolean zClipRect;
        com.component.lottie.c.a("CompositionLayer#draw");
        this.j.set(0.0f, 0.0f, this.c.h(), this.c.i());
        matrix.mapRect(this.j);
        boolean z = this.b.j() && this.h.size() > 1 && i != 255;
        if (z) {
            this.k.setAlpha(i);
            com.component.lottie.g.g.a(canvas, this.j, this.k);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            if (!(!this.n && "__container".equals(this.c.f())) && !this.j.isEmpty()) {
                zClipRect = canvas.clipRect(this.j);
            } else {
                zClipRect = true;
            }
            if (zClipRect) {
                this.h.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.component.lottie.c.b("CompositionLayer#draw");
    }

    @Override // com.component.lottie.d.c.a, com.component.lottie.a.a.f
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.h.get(size).a(this.i, this.a, true);
            rectF.union(this.i);
        }
    }

    @Override // com.component.lottie.d.c.a
    public void a(float f) {
        super.a(f);
        if (this.g != null) {
            f = ((this.g.g().floatValue() * this.c.a().i()) - this.c.a().g()) / (this.b.C().p() + 0.01f);
        }
        if (this.g == null) {
            f -= this.c.c();
        }
        if (this.c.b() != 0.0f && !"__container".equals(this.c.f())) {
            f /= this.c.b();
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            this.h.get(size).a(f);
        }
    }

    public boolean h() {
        if (this.m == null) {
            for (int size = this.h.size() - 1; size >= 0; size--) {
                a aVar = this.h.get(size);
                if (aVar instanceof i) {
                    if (aVar.e()) {
                        this.m = true;
                        return true;
                    }
                } else if ((aVar instanceof d) && ((d) aVar).h()) {
                    this.m = true;
                    return true;
                }
            }
            this.m = false;
        }
        return this.m.booleanValue();
    }

    public boolean i() {
        if (this.l == null) {
            if (d()) {
                this.l = true;
                return true;
            }
            for (int size = this.h.size() - 1; size >= 0; size--) {
                if (this.h.get(size).d()) {
                    this.l = true;
                    return true;
                }
            }
            this.l = false;
        }
        return this.l.booleanValue();
    }

    @Override // com.component.lottie.d.c.a
    protected void b(com.component.lottie.d.e eVar, int i, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.h.get(i2).a(eVar, i, list, eVar2);
        }
    }

    @Override // com.component.lottie.d.c.a, com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        super.a((d) t, (com.component.lottie.h.j<d>) jVar);
        if (t == ba.E) {
            if (jVar == null) {
                if (this.g != null) {
                    this.g.a((com.component.lottie.h.j<Float>) null);
                }
            } else {
                this.g = new com.component.lottie.a.b.t(jVar);
                this.g.a(this);
                a(this.g);
            }
        }
    }
}
