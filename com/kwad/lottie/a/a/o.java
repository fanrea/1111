package com.kwad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.kwad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class o implements d, i, j, l, a.InterfaceC0568a {
    private final com.kwad.lottie.f bjz;
    private final Matrix bka = new Matrix();
    private final Path blk = new Path();
    private final com.kwad.lottie.model.layer.a bln;
    private final com.kwad.lottie.a.b.a<Float, Float> bmb;
    private final com.kwad.lottie.a.b.a<Float, Float> bmc;
    private final com.kwad.lottie.a.b.o bmd;
    private c bme;
    private final String name;

    public o(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, com.kwad.lottie.model.content.g gVar) {
        this.bjz = fVar;
        this.bln = aVar;
        this.name = gVar.getName();
        com.kwad.lottie.a.b.a<Float, Float> aVarRj = gVar.RQ().Rj();
        this.bmb = aVarRj;
        aVar.a(aVarRj);
        aVarRj.b(this);
        com.kwad.lottie.a.b.a<Float, Float> aVarRj2 = gVar.RR().Rj();
        this.bmc = aVarRj2;
        aVar.a(aVarRj2);
        aVarRj2.b(this);
        com.kwad.lottie.a.b.o oVarRs = gVar.RS().Rs();
        this.bmd = oVarRs;
        oVarRs.a(aVar);
        oVarRs.a(this);
    }

    @Override // com.kwad.lottie.a.a.i
    public final void a(ListIterator<b> listIterator) {
        if (this.bme != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.bme = new c(this.bjz, this.bln, "Repeater", arrayList, null);
    }

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.name;
    }

    @Override // com.kwad.lottie.a.a.b
    public final void b(List<b> list, List<b> list2) {
        this.bme.b(list, list2);
    }

    @Override // com.kwad.lottie.a.a.l
    public final Path getPath() {
        Path path = this.bme.getPath();
        this.blk.reset();
        float fFloatValue = this.bmb.getValue().floatValue();
        float fFloatValue2 = this.bmc.getValue().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.bka.set(this.bmd.D(i + fFloatValue2));
            this.blk.addPath(path, this.bka);
        }
        return this.blk;
    }

    @Override // com.kwad.lottie.a.a.d
    public final void a(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.bmb.getValue().floatValue();
        float fFloatValue2 = this.bmc.getValue().floatValue();
        float fFloatValue3 = this.bmd.QY().getValue().floatValue() / 100.0f;
        float fFloatValue4 = this.bmd.QZ().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.bka.set(matrix);
            float f = i2;
            this.bka.preConcat(this.bmd.D(f + fFloatValue2));
            this.bme.a(canvas, this.bka, (int) (i * com.kwad.lottie.d.e.lerp(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.kwad.lottie.a.a.d
    public final void a(RectF rectF, Matrix matrix) {
        this.bme.a(rectF, matrix);
    }

    @Override // com.kwad.lottie.a.b.a.InterfaceC0568a
    public final void Qz() {
        this.bjz.invalidateSelf();
    }

    @Override // com.kwad.lottie.model.f
    public final void a(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
        com.kwad.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        if (this.bmd.b(t, cVar)) {
            return;
        }
        if (t == com.kwad.lottie.i.bkJ) {
            this.bmb.a(cVar);
        } else if (t == com.kwad.lottie.i.bkK) {
            this.bmc.a(cVar);
        }
    }
}
