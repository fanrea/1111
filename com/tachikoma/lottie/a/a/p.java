package com.tachikoma.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.tachikoma.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class p implements e, j, k, m, a.InterfaceC0799a {
    private final com.tachikoma.lottie.g Gt;
    private final com.tachikoma.lottie.model.layer.a IC;
    private final boolean IO;
    private final com.tachikoma.lottie.a.b.a<Float, Float> Ju;
    private final com.tachikoma.lottie.a.b.a<Float, Float> Jv;
    private final com.tachikoma.lottie.a.b.o Jw;
    private d Jx;
    private final String name;
    private final Matrix Hh = new Matrix();
    private final Path Iz = new Path();

    public p(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, com.tachikoma.lottie.model.content.g gVar2) {
        this.Gt = gVar;
        this.IC = aVar;
        this.name = gVar2.getName();
        this.IO = gVar2.isHidden();
        this.Ju = gVar2.ln().kB();
        aVar.a(this.Ju);
        this.Ju.b(this);
        this.Jv = gVar2.lo().kB();
        aVar.a(this.Jv);
        this.Jv.b(this);
        this.Jw = gVar2.lp().kO();
        this.Jw.a(aVar);
        this.Jw.a(this);
    }

    @Override // com.tachikoma.lottie.a.a.j
    public final void a(ListIterator<c> listIterator) {
        if (this.Jx != null) {
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
        this.Jx = new d(this.Gt, this.IC, "Repeater", this.IO, arrayList, null);
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.name;
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final void b(List<c> list, List<c> list2) {
        this.Jx.b(list, list2);
    }

    @Override // com.tachikoma.lottie.a.a.m
    public final Path getPath() {
        Path path = this.Jx.getPath();
        this.Iz.reset();
        float fFloatValue = this.Ju.getValue().floatValue();
        float fFloatValue2 = this.Jv.getValue().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.Hh.set(this.Jw.h(i + fFloatValue2));
            this.Iz.addPath(path, this.Hh);
        }
        return this.Iz;
    }

    @Override // com.tachikoma.lottie.a.a.e
    public final void a(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.Ju.getValue().floatValue();
        float fFloatValue2 = this.Jv.getValue().floatValue();
        float fFloatValue3 = this.Jw.kp().getValue().floatValue() / 100.0f;
        float fFloatValue4 = this.Jw.kq().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.Hh.set(matrix);
            float f = i2;
            this.Hh.preConcat(this.Jw.h(f + fFloatValue2));
            this.Jx.a(canvas, this.Hh, (int) (i * com.tachikoma.lottie.d.e.c(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.tachikoma.lottie.a.a.e
    public final void a(RectF rectF, Matrix matrix, boolean z) {
        this.Jx.a(rectF, matrix, z);
    }

    @Override // com.tachikoma.lottie.a.b.a.InterfaceC0799a
    public final void jO() {
        this.Gt.invalidateSelf();
    }

    @Override // com.tachikoma.lottie.model.e
    public final void a(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2) {
        com.tachikoma.lottie.d.e.a(dVar, i, list, dVar2, this);
    }

    @Override // com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        if (this.Jw.b(t, cVar)) {
            return;
        }
        if (t == com.tachikoma.lottie.k.HZ) {
            this.Ju.a(cVar);
        } else if (t == com.tachikoma.lottie.k.Ia) {
            this.Jv.a(cVar);
        }
    }
}
