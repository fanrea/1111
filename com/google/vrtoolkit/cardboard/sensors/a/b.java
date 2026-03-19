package com.google.vrtoolkit.cardboard.sensors.a;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static final double a = 1.0d / TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);
    private final double b;
    private final g bF = new g();
    private final g bG = new g();
    private long d;
    private int e;

    public b(double d) {
        this.b = 1.0d / (d * 6.283185307179586d);
    }

    public final int a() {
        return this.e;
    }

    public final void a(g gVar, long j) {
        a(gVar, j, 1.0d);
    }

    public final void a(g gVar, long j, double d) {
        int i = this.e + 1;
        this.e = i;
        if (i == 1) {
            this.bF.a(gVar);
            this.d = j;
            return;
        }
        double d2 = d * (j - this.d) * a;
        double d3 = d2 / (this.b + d2);
        this.bF.a(1.0d - d3);
        this.bG.a(gVar);
        this.bG.a(d3);
        g gVar2 = this.bG;
        g gVar3 = this.bF;
        g.a(gVar2, gVar3, gVar3);
        this.d = j;
    }

    public final g M() {
        return this.bF;
    }
}
