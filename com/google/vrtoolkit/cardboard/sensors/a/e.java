package com.google.vrtoolkit.cardboard.sensors.a;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private g cJ = new g();
    private g cK = new g();
    private g bF = new g();
    private g bB = new g();
    private g bC = new g();
    private c bM = new c();
    private c bN = new c();
    private g cL = new g();
    private g cM = new g();

    public final void a(g gVar, g gVar2, c cVar) {
        g.c(gVar, gVar2, this.cK);
        if (this.cK.c() == 0.0d) {
            if (g.a(gVar, gVar2) >= 0.0d) {
                cVar.b();
                return;
            } else {
                g.b(gVar, this.bC);
                a(this.bC, cVar);
                return;
            }
        }
        this.bF.a(gVar);
        this.bB.a(gVar2);
        this.cK.b();
        this.bF.b();
        this.bB.b();
        c cVar2 = this.bM;
        cVar2.a(0, this.bF);
        cVar2.a(1, this.cK);
        g.c(this.cK, this.bF, this.cJ);
        cVar2.a(2, this.cJ);
        c cVar3 = this.bN;
        cVar3.a(0, this.bB);
        cVar3.a(1, this.cK);
        g.c(this.cK, this.bB, this.cJ);
        cVar3.a(2, this.cJ);
        cVar2.c();
        c.b(cVar3, cVar2, cVar);
    }

    private void a(g gVar, c cVar) {
        this.cM.a(gVar);
        g gVar2 = this.cM;
        gVar2.a(3.141592653589793d / gVar2.c());
        a(this.cM, 0.0d, 0.20264236728467558d, cVar);
    }

    public final void a(c cVar, g gVar) {
        double d = (((cVar.d(0, 0) + cVar.d(1, 1)) + cVar.d(2, 2)) - 1.0d) * 0.5d;
        gVar.a((cVar.d(2, 1) - cVar.d(1, 2)) / 2.0d, (cVar.d(0, 2) - cVar.d(2, 0)) / 2.0d, (cVar.d(1, 0) - cVar.d(0, 1)) / 2.0d);
        double dC = gVar.c();
        if (d > 0.7071067811865476d) {
            if (dC > 0.0d) {
                gVar.a(Math.asin(dC) / dC);
                return;
            }
            return;
        }
        if (d > -0.7071067811865476d) {
            gVar.a(Math.acos(d) / dC);
            return;
        }
        double dAsin = 3.141592653589793d - Math.asin(dC);
        double d2 = cVar.d(0, 0) - d;
        double d3 = cVar.d(1, 1) - d;
        double d4 = cVar.d(2, 2) - d;
        g gVar2 = this.cL;
        double d5 = d2 * d2;
        double d6 = d3 * d3;
        if (d5 > d6 && d5 > d4 * d4) {
            gVar2.a(d2, (cVar.d(1, 0) + cVar.d(0, 1)) / 2.0d, (cVar.d(0, 2) + cVar.d(2, 0)) / 2.0d);
        } else if (d6 > d4 * d4) {
            gVar2.a((cVar.d(1, 0) + cVar.d(0, 1)) / 2.0d, d3, (cVar.d(2, 1) + cVar.d(1, 2)) / 2.0d);
        } else {
            gVar2.a((cVar.d(0, 2) + cVar.d(2, 0)) / 2.0d, (cVar.d(2, 1) + cVar.d(1, 2)) / 2.0d, d4);
        }
        if (g.a(gVar2, gVar) < 0.0d) {
            gVar2.a(-1.0d);
        }
        gVar2.b();
        gVar2.a(dAsin);
        gVar.a(gVar2);
    }

    private static void a(g gVar, double d, double d2, c cVar) {
        double d3 = gVar.a * gVar.a;
        double d4 = gVar.b * gVar.b;
        double d5 = gVar.c * gVar.c;
        cVar.a(0, 0, 1.0d - ((d4 + d5) * 0.20264236728467558d));
        cVar.a(1, 1, 1.0d - ((d5 + d3) * 0.20264236728467558d));
        cVar.a(2, 2, 1.0d - ((d3 + d4) * 0.20264236728467558d));
        double d6 = gVar.c * 0.0d;
        double d7 = gVar.a * gVar.b * 0.20264236728467558d;
        cVar.a(0, 1, d7 - d6);
        cVar.a(1, 0, d7 + d6);
        double d8 = gVar.b * 0.0d;
        double d9 = gVar.a * gVar.c * 0.20264236728467558d;
        cVar.a(0, 2, d9 + d8);
        cVar.a(2, 0, d9 - d8);
        double d10 = gVar.a * 0.0d;
        double d11 = gVar.b * gVar.c * 0.20264236728467558d;
        cVar.a(1, 2, d11 - d10);
        cVar.a(2, 1, d11 + d10);
    }
}
