package com.tachikoma.lottie.model.content;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h {
    private final List<com.tachikoma.lottie.model.a> LS;
    private PointF LT;
    private boolean closed;

    public h(PointF pointF, boolean z, List<com.tachikoma.lottie.model.a> list) {
        this.LT = pointF;
        this.closed = z;
        this.LS = new ArrayList(list);
    }

    public h() {
        this.LS = new ArrayList();
    }

    private void n(float f, float f2) {
        if (this.LT == null) {
            this.LT = new PointF();
        }
        this.LT.set(f, f2);
    }

    public final PointF lq() {
        return this.LT;
    }

    public final boolean isClosed() {
        return this.closed;
    }

    public final List<com.tachikoma.lottie.model.a> lr() {
        return this.LS;
    }

    public final void a(h hVar, h hVar2, float f) {
        if (this.LT == null) {
            this.LT = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.lr().size() != hVar2.lr().size()) {
            com.tachikoma.lottie.c.R("Curves must have the same number of control points. Shape 1: " + hVar.lr().size() + "\tShape 2: " + hVar2.lr().size());
        }
        int iMin = Math.min(hVar.lr().size(), hVar2.lr().size());
        if (this.LS.size() < iMin) {
            for (int size = this.LS.size(); size < iMin; size++) {
                this.LS.add(new com.tachikoma.lottie.model.a());
            }
        } else if (this.LS.size() > iMin) {
            for (int size2 = this.LS.size() - 1; size2 >= iMin; size2--) {
                List<com.tachikoma.lottie.model.a> list = this.LS;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFLq = hVar.lq();
        PointF pointFLq2 = hVar2.lq();
        n(com.tachikoma.lottie.d.e.c(pointFLq.x, pointFLq2.x, f), com.tachikoma.lottie.d.e.c(pointFLq.y, pointFLq2.y, f));
        for (int size3 = this.LS.size() - 1; size3 >= 0; size3--) {
            com.tachikoma.lottie.model.a aVar = hVar.lr().get(size3);
            com.tachikoma.lottie.model.a aVar2 = hVar2.lr().get(size3);
            PointF pointFKs = aVar.ks();
            PointF pointFKt = aVar.kt();
            PointF pointFKu = aVar.ku();
            PointF pointFKs2 = aVar2.ks();
            PointF pointFKt2 = aVar2.kt();
            PointF pointFKu2 = aVar2.ku();
            this.LS.get(size3).k(com.tachikoma.lottie.d.e.c(pointFKs.x, pointFKs2.x, f), com.tachikoma.lottie.d.e.c(pointFKs.y, pointFKs2.y, f));
            this.LS.get(size3).l(com.tachikoma.lottie.d.e.c(pointFKt.x, pointFKt2.x, f), com.tachikoma.lottie.d.e.c(pointFKt.y, pointFKt2.y, f));
            this.LS.get(size3).m(com.tachikoma.lottie.d.e.c(pointFKu.x, pointFKu2.x, f), com.tachikoma.lottie.d.e.c(pointFKu.y, pointFKu2.y, f));
        }
    }

    public final String toString() {
        return "ShapeData{numCurves=" + this.LS.size() + "closed=" + this.closed + '}';
    }
}
