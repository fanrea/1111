package com.tachikoma.lottie.model;

import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private final PointF KB;
    private final PointF KC;
    private final PointF KD;

    public a() {
        this.KB = new PointF();
        this.KC = new PointF();
        this.KD = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.KB = pointF;
        this.KC = pointF2;
        this.KD = pointF3;
    }

    public final void k(float f, float f2) {
        this.KB.set(f, f2);
    }

    public final PointF ks() {
        return this.KB;
    }

    public final void l(float f, float f2) {
        this.KC.set(f, f2);
    }

    public final PointF kt() {
        return this.KC;
    }

    public final void m(float f, float f2) {
        this.KD.set(f, f2);
    }

    public final PointF ku() {
        return this.KD;
    }
}
