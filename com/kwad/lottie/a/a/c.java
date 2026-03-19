package com.kwad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.kwad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements d, l, a.InterfaceC0568a, com.kwad.lottie.model.f {
    private final com.kwad.lottie.f bjz;
    private final Matrix bka;
    private com.kwad.lottie.a.b.o blA;
    private final Path blk;
    private final RectF blm;
    private final List<b> bly;
    private List<l> blz;
    private final String name;

    private static List<b> a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, List<com.kwad.lottie.model.content.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            b bVarA = list.get(i).a(fVar, aVar);
            if (bVarA != null) {
                arrayList.add(bVarA);
            }
        }
        return arrayList;
    }

    private static com.kwad.lottie.model.a.l aa(List<com.kwad.lottie.model.content.b> list) {
        for (int i = 0; i < list.size(); i++) {
            com.kwad.lottie.model.content.b bVar = list.get(i);
            if (bVar instanceof com.kwad.lottie.model.a.l) {
                return (com.kwad.lottie.model.a.l) bVar;
            }
        }
        return null;
    }

    public c(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, com.kwad.lottie.model.content.j jVar) {
        this(fVar, aVar, jVar.getName(), a(fVar, aVar, jVar.getItems()), aa(jVar.getItems()));
    }

    c(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, String str, List<b> list, com.kwad.lottie.model.a.l lVar) {
        this.bka = new Matrix();
        this.blk = new Path();
        this.blm = new RectF();
        this.name = str;
        this.bjz = fVar;
        this.bly = list;
        if (lVar != null) {
            com.kwad.lottie.a.b.o oVarRs = lVar.Rs();
            this.blA = oVarRs;
            oVarRs.a(aVar);
            this.blA.a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof i) {
                arrayList.add((i) bVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((i) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    @Override // com.kwad.lottie.a.b.a.InterfaceC0568a
    public final void Qz() {
        this.bjz.invalidateSelf();
    }

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.name;
    }

    @Override // com.kwad.lottie.a.a.b
    public final void b(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.bly.size());
        arrayList.addAll(list);
        for (int size = this.bly.size() - 1; size >= 0; size--) {
            b bVar = this.bly.get(size);
            bVar.b(arrayList, this.bly.subList(0, size));
            arrayList.add(bVar);
        }
    }

    final List<l> QA() {
        if (this.blz == null) {
            this.blz = new ArrayList();
            for (int i = 0; i < this.bly.size(); i++) {
                b bVar = this.bly.get(i);
                if (bVar instanceof l) {
                    this.blz.add((l) bVar);
                }
            }
        }
        return this.blz;
    }

    final Matrix QB() {
        com.kwad.lottie.a.b.o oVar = this.blA;
        if (oVar != null) {
            return oVar.getMatrix();
        }
        this.bka.reset();
        return this.bka;
    }

    @Override // com.kwad.lottie.a.a.l
    public final Path getPath() {
        this.bka.reset();
        com.kwad.lottie.a.b.o oVar = this.blA;
        if (oVar != null) {
            this.bka.set(oVar.getMatrix());
        }
        this.blk.reset();
        for (int size = this.bly.size() - 1; size >= 0; size--) {
            b bVar = this.bly.get(size);
            if (bVar instanceof l) {
                this.blk.addPath(((l) bVar).getPath(), this.bka);
            }
        }
        return this.blk;
    }

    @Override // com.kwad.lottie.a.a.d
    public final void a(Canvas canvas, Matrix matrix, int i) {
        this.bka.set(matrix);
        com.kwad.lottie.a.b.o oVar = this.blA;
        if (oVar != null) {
            this.bka.preConcat(oVar.getMatrix());
            i = (int) ((((this.blA.QX().getValue().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.bly.size() - 1; size >= 0; size--) {
            b bVar = this.bly.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(canvas, this.bka, i);
            }
        }
    }

    @Override // com.kwad.lottie.a.a.d
    public final void a(RectF rectF, Matrix matrix) {
        this.bka.set(matrix);
        com.kwad.lottie.a.b.o oVar = this.blA;
        if (oVar != null) {
            this.bka.preConcat(oVar.getMatrix());
        }
        this.blm.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.bly.size() - 1; size >= 0; size--) {
            b bVar = this.bly.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(this.blm, this.bka);
                if (rectF.isEmpty()) {
                    rectF.set(this.blm);
                } else {
                    rectF.set(Math.min(rectF.left, this.blm.left), Math.min(rectF.top, this.blm.top), Math.max(rectF.right, this.blm.right), Math.max(rectF.bottom, this.blm.bottom));
                }
            }
        }
    }

    @Override // com.kwad.lottie.model.f
    public final void a(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
        if (eVar.q(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.dp(getName());
                if (eVar.s(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.t(getName(), i)) {
                int iR = i + eVar.r(getName(), i);
                for (int i2 = 0; i2 < this.bly.size(); i2++) {
                    b bVar = this.bly.get(i2);
                    if (bVar instanceof com.kwad.lottie.model.f) {
                        ((com.kwad.lottie.model.f) bVar).a(eVar, iR, list, eVar2);
                    }
                }
            }
        }
    }

    @Override // com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        com.kwad.lottie.a.b.o oVar = this.blA;
        if (oVar != null) {
            oVar.b(t, cVar);
        }
    }
}
