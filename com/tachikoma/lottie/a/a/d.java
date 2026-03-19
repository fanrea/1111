package com.tachikoma.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.tachikoma.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements e, m, a.InterfaceC0799a, com.tachikoma.lottie.model.e {
    private final com.tachikoma.lottie.g Gt;
    private final Matrix Hh;
    private final RectF IB;
    private final List<c> IN;
    private final boolean IO;
    private List<m> IQ;
    private com.tachikoma.lottie.a.b.o IR;
    private final Path Iz;
    private final String name;

    private static List<c> a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, List<com.tachikoma.lottie.model.content.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            c cVarA = list.get(i).a(gVar, aVar);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return arrayList;
    }

    private static com.tachikoma.lottie.model.a.l h(List<com.tachikoma.lottie.model.content.b> list) {
        for (int i = 0; i < list.size(); i++) {
            com.tachikoma.lottie.model.content.b bVar = list.get(i);
            if (bVar instanceof com.tachikoma.lottie.model.a.l) {
                return (com.tachikoma.lottie.model.a.l) bVar;
            }
        }
        return null;
    }

    public d(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, com.tachikoma.lottie.model.content.j jVar) {
        this(gVar, aVar, jVar.getName(), jVar.isHidden(), a(gVar, aVar, jVar.getItems()), h(jVar.getItems()));
    }

    d(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, String str, boolean z, List<c> list, com.tachikoma.lottie.model.a.l lVar) {
        this.Hh = new Matrix();
        this.Iz = new Path();
        this.IB = new RectF();
        this.name = str;
        this.Gt = gVar;
        this.IO = z;
        this.IN = list;
        if (lVar != null) {
            this.IR = lVar.kO();
            this.IR.a(aVar);
            this.IR.a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    @Override // com.tachikoma.lottie.a.b.a.InterfaceC0799a
    public final void jO() {
        this.Gt.invalidateSelf();
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.name;
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final void b(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.IN.size());
        arrayList.addAll(list);
        for (int size = this.IN.size() - 1; size >= 0; size--) {
            c cVar = this.IN.get(size);
            cVar.b(arrayList, this.IN.subList(0, size));
            arrayList.add(cVar);
        }
    }

    final List<m> jP() {
        if (this.IQ == null) {
            this.IQ = new ArrayList();
            for (int i = 0; i < this.IN.size(); i++) {
                c cVar = this.IN.get(i);
                if (cVar instanceof m) {
                    this.IQ.add((m) cVar);
                }
            }
        }
        return this.IQ;
    }

    final Matrix jQ() {
        com.tachikoma.lottie.a.b.o oVar = this.IR;
        if (oVar != null) {
            return oVar.getMatrix();
        }
        this.Hh.reset();
        return this.Hh;
    }

    @Override // com.tachikoma.lottie.a.a.m
    public final Path getPath() {
        this.Hh.reset();
        com.tachikoma.lottie.a.b.o oVar = this.IR;
        if (oVar != null) {
            this.Hh.set(oVar.getMatrix());
        }
        this.Iz.reset();
        if (this.IO) {
            return this.Iz;
        }
        for (int size = this.IN.size() - 1; size >= 0; size--) {
            c cVar = this.IN.get(size);
            if (cVar instanceof m) {
                this.Iz.addPath(((m) cVar).getPath(), this.Hh);
            }
        }
        return this.Iz;
    }

    @Override // com.tachikoma.lottie.a.a.e
    public final void a(Canvas canvas, Matrix matrix, int i) {
        if (this.IO) {
            return;
        }
        this.Hh.set(matrix);
        com.tachikoma.lottie.a.b.o oVar = this.IR;
        if (oVar != null) {
            this.Hh.preConcat(oVar.getMatrix());
            i = (int) (((((this.IR.ko() == null ? 100 : this.IR.ko().getValue().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.IN.size() - 1; size >= 0; size--) {
            c cVar = this.IN.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(canvas, this.Hh, i);
            }
        }
    }

    @Override // com.tachikoma.lottie.a.a.e
    public final void a(RectF rectF, Matrix matrix, boolean z) {
        this.Hh.set(matrix);
        com.tachikoma.lottie.a.b.o oVar = this.IR;
        if (oVar != null) {
            this.Hh.preConcat(oVar.getMatrix());
        }
        this.IB.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.IN.size() - 1; size >= 0; size--) {
            c cVar = this.IN.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(this.IB, this.Hh, z);
                rectF.union(this.IB);
            }
        }
    }

    @Override // com.tachikoma.lottie.model.e
    public final void a(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2) {
        if (dVar.j(getName(), i)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.ad(getName());
                if (dVar.l(getName(), i)) {
                    list.add(dVar2.a(this));
                }
            }
            if (dVar.m(getName(), i)) {
                int iK = i + dVar.k(getName(), i);
                for (int i2 = 0; i2 < this.IN.size(); i2++) {
                    c cVar = this.IN.get(i2);
                    if (cVar instanceof com.tachikoma.lottie.model.e) {
                        ((com.tachikoma.lottie.model.e) cVar).a(dVar, iK, list, dVar2);
                    }
                }
            }
        }
    }

    @Override // com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        com.tachikoma.lottie.a.b.o oVar = this.IR;
        if (oVar != null) {
            oVar.b(t, cVar);
        }
    }
}
