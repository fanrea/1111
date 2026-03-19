package com.bytedance.adsdk.lottie.model;

import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private final PointF b;
    private final PointF d;
    private final PointF hc;

    public d() {
        this.d = new PointF();
        this.hc = new PointF();
        this.b = new PointF();
    }

    public d(PointF pointF, PointF pointF2, PointF pointF3) {
        this.d = pointF;
        this.hc = pointF2;
        this.b = pointF3;
    }

    public void d(float f, float f2) {
        this.d.set(f, f2);
    }

    public PointF d() {
        return this.d;
    }

    public void hc(float f, float f2) {
        this.hc.set(f, f2);
    }

    public PointF hc() {
        return this.hc;
    }

    public void b(float f, float f2) {
        this.b.set(f, f2);
    }

    public PointF b() {
        return this.b;
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.b.x), Float.valueOf(this.b.y), Float.valueOf(this.d.x), Float.valueOf(this.d.y), Float.valueOf(this.hc.x), Float.valueOf(this.hc.y));
    }
}
