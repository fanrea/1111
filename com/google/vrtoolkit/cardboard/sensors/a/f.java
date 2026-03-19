package com.google.vrtoolkit.cardboard.sensors.a;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f {
    private static g cJ = new g();
    private static g cK = new g();
    private static g bF = new g();
    private static g bB = new g();
    private static g bC = new g();
    private static c bM = new c();
    private static c bN = new c();
    private static g cL = new g();
    private static g cM = new g();

    public static void a(g gVar, c cVar) {
        double dCos;
        double d;
        double d2;
        double dA = g.a(gVar, gVar);
        double dSqrt = Math.sqrt(dA);
        double d3 = 0.5d;
        if (dA < 1.0E-8d) {
            d2 = dA * 0.1666666716337204d;
        } else {
            if (dA >= 1.0E-6d) {
                double d4 = 1.0d / dSqrt;
                double dSin = Math.sin(dSqrt) * d4;
                dCos = d4 * d4 * (1.0d - Math.cos(dSqrt));
                d = dSin;
                a(gVar, d, dCos, cVar);
            }
            d3 = 0.5d - (0.0416666679084301d * dA);
            double d5 = dA * 0.1666666716337204d;
            d2 = d5 * (1.0d - d5);
        }
        d = 1.0d - d2;
        dCos = d3;
        a(gVar, d, dCos, cVar);
    }

    private static void a(g gVar, double d, double d2, c cVar) {
        double d3 = gVar.a * gVar.a;
        double d4 = gVar.b * gVar.b;
        double d5 = gVar.c * gVar.c;
        cVar.a(0, 0, 1.0d - ((d4 + d5) * d2));
        cVar.a(1, 1, 1.0d - ((d5 + d3) * d2));
        cVar.a(2, 2, 1.0d - ((d3 + d4) * d2));
        double d6 = gVar.c * d;
        double d7 = gVar.a * gVar.b * d2;
        cVar.a(0, 1, d7 - d6);
        cVar.a(1, 0, d7 + d6);
        double d8 = gVar.b * d;
        double d9 = gVar.a * gVar.c * d2;
        cVar.a(0, 2, d9 + d8);
        cVar.a(2, 0, d9 - d8);
        double d10 = gVar.a * d;
        double d11 = gVar.b * gVar.c * d2;
        cVar.a(1, 2, d11 - d10);
        cVar.a(2, 1, d11 + d10);
    }
}
