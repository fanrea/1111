package com.bytedance.adsdk.lottie.model.hc;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k {
    private boolean b;
    private final List<com.bytedance.adsdk.lottie.model.d> d;
    private PointF hc;

    public k(PointF pointF, boolean z, List<com.bytedance.adsdk.lottie.model.d> list) {
        this.hc = pointF;
        this.b = z;
        this.d = new ArrayList(list);
    }

    public k() {
        this.d = new ArrayList();
    }

    public void d(float f, float f2) {
        if (this.hc == null) {
            this.hc = new PointF();
        }
        this.hc.set(f, f2);
    }

    public PointF d() {
        return this.hc;
    }

    public void d(boolean z) {
        this.b = z;
    }

    public boolean hc() {
        return this.b;
    }

    public List<com.bytedance.adsdk.lottie.model.d> b() {
        return this.d;
    }

    public void d(k kVar, k kVar2, float f) {
        if (this.hc == null) {
            this.hc = new PointF();
        }
        this.b = kVar.hc() || kVar2.hc();
        if (kVar.b().size() != kVar2.b().size()) {
            com.bytedance.adsdk.lottie.u.u.hc("Curves must have the same number of control points. Shape 1: " + kVar.b().size() + "\tShape 2: " + kVar2.b().size());
        }
        int iMin = Math.min(kVar.b().size(), kVar2.b().size());
        if (this.d.size() < iMin) {
            for (int size = this.d.size(); size < iMin; size++) {
                this.d.add(new com.bytedance.adsdk.lottie.model.d());
            }
        } else if (this.d.size() > iMin) {
            for (int size2 = this.d.size() - 1; size2 >= iMin; size2--) {
                List<com.bytedance.adsdk.lottie.model.d> list = this.d;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFD = kVar.d();
        PointF pointFD2 = kVar2.d();
        d(com.bytedance.adsdk.lottie.u.gb.d(pointFD.x, pointFD2.x, f), com.bytedance.adsdk.lottie.u.gb.d(pointFD.y, pointFD2.y, f));
        for (int size3 = this.d.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.lottie.model.d dVar = kVar.b().get(size3);
            com.bytedance.adsdk.lottie.model.d dVar2 = kVar2.b().get(size3);
            PointF pointFD3 = dVar.d();
            PointF pointFHc = dVar.hc();
            PointF pointFB = dVar.b();
            PointF pointFD4 = dVar2.d();
            PointF pointFHc2 = dVar2.hc();
            PointF pointFB2 = dVar2.b();
            this.d.get(size3).d(com.bytedance.adsdk.lottie.u.gb.d(pointFD3.x, pointFD4.x, f), com.bytedance.adsdk.lottie.u.gb.d(pointFD3.y, pointFD4.y, f));
            this.d.get(size3).hc(com.bytedance.adsdk.lottie.u.gb.d(pointFHc.x, pointFHc2.x, f), com.bytedance.adsdk.lottie.u.gb.d(pointFHc.y, pointFHc2.y, f));
            this.d.get(size3).b(com.bytedance.adsdk.lottie.u.gb.d(pointFB.x, pointFB2.x, f), com.bytedance.adsdk.lottie.u.gb.d(pointFB.y, pointFB2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.d.size() + "closed=" + this.b + '}';
    }
}
