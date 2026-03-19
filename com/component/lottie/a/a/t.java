package com.component.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.component.lottie.a.b.a;
import com.component.lottie.af;
import com.component.lottie.ba;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class t implements f, k, l, p, a.InterfaceC0322a {
    private final Matrix a = new Matrix();
    private final Path b = new Path();
    private final af c;
    private final com.component.lottie.d.c.a d;
    private final String e;
    private final boolean f;
    private final com.component.lottie.a.b.a<Float, Float> g;
    private final com.component.lottie.a.b.a<Float, Float> h;
    private final com.component.lottie.a.b.s i;
    private e j;

    public t(af afVar, com.component.lottie.d.c.a aVar, com.component.lottie.d.b.l lVar) {
        this.c = afVar;
        this.d = aVar;
        this.e = lVar.a();
        this.f = lVar.e();
        this.g = lVar.b().a();
        aVar.a(this.g);
        this.g.a(this);
        this.h = lVar.c().a();
        aVar.a(this.h);
        this.h.a(this);
        this.i = lVar.d().j();
        this.i.a(aVar);
        this.i.a(this);
    }

    @Override // com.component.lottie.a.a.k
    public void a(ListIterator<d> listIterator) {
        if (this.j != null) {
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
        this.j = new e(this.c, this.d, "Repeater", this.f, arrayList, null);
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.e;
    }

    @Override // com.component.lottie.a.a.d
    public void a(List<d> list, List<d> list2) {
        this.j.a(list, list2);
    }

    @Override // com.component.lottie.a.a.p
    public Path e() {
        Path pathE = this.j.e();
        this.b.reset();
        float fFloatValue = this.g.g().floatValue();
        float fFloatValue2 = this.h.g().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.a.set(this.i.b(i + fFloatValue2));
            this.b.addPath(pathE, this.a);
        }
        return this.b;
    }

    @Override // com.component.lottie.a.a.f
    public void a(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.g.g().floatValue();
        float fFloatValue2 = this.h.g().floatValue();
        float fFloatValue3 = this.i.b().g().floatValue() / 100.0f;
        float fFloatValue4 = this.i.c().g().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.a.set(matrix);
            float f = i2;
            this.a.preConcat(this.i.b(f + fFloatValue2));
            this.j.a(canvas, this.a, (int) (i * com.component.lottie.g.f.a(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.component.lottie.a.a.f
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.j.a(rectF, matrix, z);
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        this.c.invalidateSelf();
    }

    @Override // com.component.lottie.d.f
    public void a(com.component.lottie.d.e eVar, int i, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
        com.component.lottie.g.f.a(eVar, i, list, eVar2, this);
    }

    @Override // com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        if (this.i.a(t, jVar)) {
            return;
        }
        if (t == ba.u) {
            this.g.a((com.component.lottie.h.j<Float>) jVar);
        } else if (t == ba.v) {
            this.h.a((com.component.lottie.h.j<Float>) jVar);
        }
    }
}
