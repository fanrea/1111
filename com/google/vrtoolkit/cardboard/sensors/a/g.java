package com.google.vrtoolkit.cardboard.sensors.a;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g {
    public double a;
    public double b;
    public double c;

    public final void a(double d, double d2, double d3) {
        this.a = d;
        this.b = d2;
        this.c = d3;
    }

    public final void a(int i, double d) {
        if (i == 0) {
            this.a = d;
        } else if (i == 1) {
            this.b = d;
        } else {
            this.c = d;
        }
    }

    public final void a() {
        this.c = 0.0d;
        this.b = 0.0d;
        this.a = 0.0d;
    }

    public final void a(g gVar) {
        this.a = gVar.a;
        this.b = gVar.b;
        this.c = gVar.c;
    }

    public final void a(double d) {
        this.a *= d;
        this.b *= d;
        this.c *= d;
    }

    public final void b() {
        double dC = c();
        if (dC != 0.0d) {
            a(1.0d / dC);
        }
    }

    public static double a(g gVar, g gVar2) {
        return (gVar.a * gVar2.a) + (gVar.b * gVar2.b) + (gVar.c * gVar2.c);
    }

    public final double c() {
        double d = this.a;
        double d2 = this.b;
        double d3 = (d * d) + (d2 * d2);
        double d4 = this.c;
        return Math.sqrt(d3 + (d4 * d4));
    }

    public static void a(g gVar, g gVar2, g gVar3) {
        gVar3.a(gVar.a + gVar2.a, gVar.b + gVar2.b, gVar.c + gVar2.c);
    }

    public static void b(g gVar, g gVar2, g gVar3) {
        gVar3.a(gVar.a - gVar2.a, gVar.b - gVar2.b, gVar.c - gVar2.c);
    }

    public static void c(g gVar, g gVar2, g gVar3) {
        double d = gVar.b;
        double d2 = gVar2.c;
        double d3 = gVar.c;
        double d4 = gVar2.b;
        double d5 = gVar2.a;
        double d6 = gVar.a;
        gVar3.a((d * d2) - (d3 * d4), (d3 * d5) - (d2 * d6), (d6 * d4) - (d * d5));
    }

    public static void b(g gVar, g gVar2) {
        int iC = c(gVar) - 1;
        if (iC < 0) {
            iC = 2;
        }
        gVar2.a();
        gVar2.a(iC, 1.0d);
        c(gVar, gVar2, gVar2);
        gVar2.b();
    }

    private static int c(g gVar) {
        double dAbs = Math.abs(gVar.a);
        double dAbs2 = Math.abs(gVar.b);
        double dAbs3 = Math.abs(gVar.c);
        return dAbs > dAbs2 ? dAbs > dAbs3 ? 0 : 2 : dAbs2 > dAbs3 ? 1 : 2;
    }

    public final String toString() {
        return "{ " + Double.toString(this.a) + ", " + Double.toString(this.b) + ", " + Double.toString(this.c) + " }";
    }
}
