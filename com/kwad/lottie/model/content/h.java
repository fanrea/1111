package com.kwad.lottie.model.content;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h {
    private final List<com.kwad.lottie.model.a> boc;
    private PointF bod;
    private boolean closed;

    public h(PointF pointF, boolean z, List<com.kwad.lottie.model.a> list) {
        ArrayList arrayList = new ArrayList();
        this.boc = arrayList;
        this.bod = pointF;
        this.closed = z;
        arrayList.addAll(list);
    }

    public h() {
        this.boc = new ArrayList();
    }

    private void l(float f, float f2) {
        if (this.bod == null) {
            this.bod = new PointF();
        }
        this.bod.set(f, f2);
    }

    public final PointF RT() {
        return this.bod;
    }

    public final boolean isClosed() {
        return this.closed;
    }

    public final List<com.kwad.lottie.model.a> RU() {
        return this.boc;
    }

    public final void a(h hVar, h hVar2, float f) {
        if (this.bod == null) {
            this.bod = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.RU().size() != hVar2.RU().size()) {
            com.kwad.lottie.c.df("Curves must have the same number of control points. Shape 1: " + hVar.RU().size() + "\tShape 2: " + hVar2.RU().size());
        }
        if (this.boc.isEmpty()) {
            int iMin = Math.min(hVar.RU().size(), hVar2.RU().size());
            for (int i = 0; i < iMin; i++) {
                this.boc.add(new com.kwad.lottie.model.a());
            }
        }
        PointF pointFRT = hVar.RT();
        PointF pointFRT2 = hVar2.RT();
        l(com.kwad.lottie.d.e.lerp(pointFRT.x, pointFRT2.x, f), com.kwad.lottie.d.e.lerp(pointFRT.y, pointFRT2.y, f));
        for (int size = this.boc.size() - 1; size >= 0; size--) {
            com.kwad.lottie.model.a aVar = hVar.RU().get(size);
            com.kwad.lottie.model.a aVar2 = hVar2.RU().get(size);
            PointF pointFRa = aVar.Ra();
            PointF pointFRb = aVar.Rb();
            PointF pointFRc = aVar.Rc();
            PointF pointFRa2 = aVar2.Ra();
            PointF pointFRb2 = aVar2.Rb();
            PointF pointFRc2 = aVar2.Rc();
            this.boc.get(size).i(com.kwad.lottie.d.e.lerp(pointFRa.x, pointFRa2.x, f), com.kwad.lottie.d.e.lerp(pointFRa.y, pointFRa2.y, f));
            this.boc.get(size).j(com.kwad.lottie.d.e.lerp(pointFRb.x, pointFRb2.x, f), com.kwad.lottie.d.e.lerp(pointFRb.y, pointFRb2.y, f));
            this.boc.get(size).k(com.kwad.lottie.d.e.lerp(pointFRc.x, pointFRc2.x, f), com.kwad.lottie.d.e.lerp(pointFRc.y, pointFRc2.y, f));
        }
    }

    public final String toString() {
        return "ShapeData{numCurves=" + this.boc.size() + "closed=" + this.closed + '}';
    }
}
