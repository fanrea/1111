package com.component.lottie.d;

import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private final PointF a;
    private final PointF b;
    private final PointF c;

    public a() {
        this.a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.a = pointF;
        this.b = pointF2;
        this.c = pointF3;
    }

    public void a(float f, float f2) {
        this.a.set(f, f2);
    }

    public PointF a() {
        return this.a;
    }

    public void b(float f, float f2) {
        this.b.set(f, f2);
    }

    public PointF b() {
        return this.b;
    }

    public void c(float f, float f2) {
        this.c.set(f, f2);
    }

    public void a(a aVar) {
        c(aVar.c.x, aVar.c.y);
        a(aVar.a.x, aVar.a.y);
        b(aVar.b.x, aVar.b.y);
    }

    public PointF c() {
        return this.c;
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.c.x), Float.valueOf(this.c.y), Float.valueOf(this.a.x), Float.valueOf(this.a.y), Float.valueOf(this.b.x), Float.valueOf(this.b.y));
    }
}
