package com.component.lottie.d.b;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class n {
    private final List<com.component.lottie.d.a> a;
    private PointF b;
    private boolean c;

    public n(PointF pointF, boolean z, List<com.component.lottie.d.a> list) {
        this.b = pointF;
        this.c = z;
        this.a = new ArrayList(list);
    }

    public n() {
        this.a = new ArrayList();
    }

    public void a(float f, float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f, f2);
    }

    public PointF a() {
        return this.b;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.c;
    }

    public List<com.component.lottie.d.a> c() {
        return this.a;
    }

    public void a(n nVar, n nVar2, float f) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.c = nVar.b() || nVar2.b();
        if (nVar.c().size() != nVar2.c().size()) {
            com.component.lottie.g.c.b("Curves must have the same number of control points. Shape 1: " + nVar.c().size() + "\tShape 2: " + nVar2.c().size());
        }
        int iMin = Math.min(nVar.c().size(), nVar2.c().size());
        if (this.a.size() < iMin) {
            for (int size = this.a.size(); size < iMin; size++) {
                this.a.add(new com.component.lottie.d.a());
            }
        } else if (this.a.size() > iMin) {
            for (int size2 = this.a.size() - 1; size2 >= iMin; size2--) {
                this.a.remove(this.a.size() - 1);
            }
        }
        PointF pointFA = nVar.a();
        PointF pointFA2 = nVar2.a();
        a(com.component.lottie.g.f.a(pointFA.x, pointFA2.x, f), com.component.lottie.g.f.a(pointFA.y, pointFA2.y, f));
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            com.component.lottie.d.a aVar = nVar.c().get(size3);
            com.component.lottie.d.a aVar2 = nVar2.c().get(size3);
            PointF pointFA3 = aVar.a();
            PointF pointFB = aVar.b();
            PointF pointFC = aVar.c();
            PointF pointFA4 = aVar2.a();
            PointF pointFB2 = aVar2.b();
            PointF pointFC2 = aVar2.c();
            this.a.get(size3).a(com.component.lottie.g.f.a(pointFA3.x, pointFA4.x, f), com.component.lottie.g.f.a(pointFA3.y, pointFA4.y, f));
            this.a.get(size3).b(com.component.lottie.g.f.a(pointFB.x, pointFB2.x, f), com.component.lottie.g.f.a(pointFB.y, pointFB2.y, f));
            this.a.get(size3).c(com.component.lottie.g.f.a(pointFC.x, pointFC2.x, f), com.component.lottie.g.f.a(pointFC.y, pointFC2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
    }
}
