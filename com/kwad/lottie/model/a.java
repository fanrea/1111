package com.kwad.lottie.model;

import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private final PointF bmT;
    private final PointF bmU;
    private final PointF bmV;

    public a() {
        this.bmT = new PointF();
        this.bmU = new PointF();
        this.bmV = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.bmT = pointF;
        this.bmU = pointF2;
        this.bmV = pointF3;
    }

    public final void i(float f, float f2) {
        this.bmT.set(f, f2);
    }

    public final PointF Ra() {
        return this.bmT;
    }

    public final void j(float f, float f2) {
        this.bmU.set(f, f2);
    }

    public final PointF Rb() {
        return this.bmU;
    }

    public final void k(float f, float f2) {
        this.bmV.set(f, f2);
    }

    public final PointF Rc() {
        return this.bmV;
    }
}
