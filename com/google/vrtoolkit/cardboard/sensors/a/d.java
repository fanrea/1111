package com.google.vrtoolkit.cardboard.sensors.a;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d {
    static final /* synthetic */ boolean a = true;
    private boolean cG;
    private boolean cH;
    private long s;
    private float w;
    private int y;
    private double[] bI = new double[16];
    private c bJ = new c();
    private c bK = new c();
    private c bL = new c();
    private c bM = new c();
    private c bN = new c();
    private c bO = new c();
    private c bP = new c();
    private c bQ = new c();
    private c bR = new c();
    private g bS = new g();
    private g bT = new g();
    private g bU = new g();
    private g bV = new g();
    private g bW = new g();
    private g bX = new g();
    private g bY = new g();
    private final g bZ = new g();

    /* renamed from: ca, reason: collision with root package name */
    private double f761ca = 0.0d;
    private double cb = 0.0d;
    private boolean cc = false;
    private boolean cd = true;
    private c ce = new c();
    private c cf = new c();
    private g cg = new g();
    private c ch = new c();
    private c ci = new c();
    private c cj = new c();
    private c ck = new c();
    private c cl = new c();
    private c cm = new c();

    /* renamed from: cn, reason: collision with root package name */
    private c f762cn = new c();
    private c co = new c();
    private g cp = new g();
    private g cq = new g();
    private g cr = new g();
    private g cs = new g();
    private g ct = new g();
    private g cu = new g();
    private g cv = new g();
    private g cw = new g();
    private c cx = new c();
    private c cy = new c();
    private c cz = new c();
    private c cA = new c();
    private c cB = new c();
    private c cC = new c();
    private c cD = new c();
    private c cE = new c();
    private c cF = new c();
    private e cI = new e();

    public d() {
        a();
    }

    public final synchronized void a() {
        this.s = 0L;
        this.bJ.b();
        this.bK.b();
        this.bL.a();
        this.bL.a(25.0d);
        this.bM.a();
        this.bM.a(1.0d);
        this.bN.a();
        this.bN.a(0.0625d);
        this.bO.a();
        this.bO.a(0.5625d);
        this.bP.a();
        this.bQ.a();
        this.bR.a();
        this.bS.a();
        this.bT.a();
        this.bU.a();
        this.bV.a();
        this.bW.a();
        this.bX.a(0.0d, 0.0d, 9.81d);
        this.bY.a(0.0d, 1.0d, 0.0d);
        this.cG = false;
        this.cH = false;
    }

    public final boolean b() {
        return this.cG;
    }

    public final double[] c(double d) {
        g gVar = this.cg;
        gVar.a(this.bZ);
        gVar.a(-d);
        c cVar = this.ce;
        f.a(gVar, cVar);
        c cVar2 = this.cf;
        c.b(cVar, this.bJ, cVar2);
        return f(cVar2);
    }

    public final synchronized void a(g gVar, long j) {
        if (this.s != 0) {
            float f = (j - r0) * 1.0E-9f;
            if (f > 0.04f) {
                f = this.cd ? this.w : 0.01f;
            } else {
                a(f);
            }
            this.bV.a(gVar);
            this.bV.a(-f);
            f.a(this.bV, this.bK);
            this.ci.a(this.bJ);
            c.b(this.bK, this.bJ, this.ci);
            this.bJ.a(this.ci);
            c();
            this.cj.a(this.bM);
            this.cj.b(f * f);
            this.bL.b(this.cj);
        }
        this.s = j;
        this.bZ.a(gVar);
    }

    private void b(double d) {
        double dAbs = Math.abs(d - this.f761ca);
        this.f761ca = d;
        double d2 = (dAbs * 0.5d) + (this.cb * 0.5d);
        this.cb = d2;
        double dMin = Math.min(7.0d, ((d2 / 0.15d) * 6.25d) + 0.75d);
        this.bO.a(dMin * dMin);
    }

    public final synchronized void b(g gVar) {
        this.bT.a(gVar);
        b(this.bT.c());
        if (this.cG) {
            a(this.bJ, this.bS);
            for (int i = 0; i < 3; i++) {
                g gVar2 = this.cr;
                gVar2.a();
                gVar2.a(i, 1.0E-7d);
                f.a(gVar2, this.ck);
                c.b(this.ck, this.bJ, this.cl);
                a(this.cl, this.cp);
                g.b(this.bS, this.cp, this.cq);
                this.cq.a(1.0E7d);
                this.bQ.a(i, this.cq);
            }
            this.bQ.d(this.cm);
            c.b(this.bL, this.cm, this.f762cn);
            c.b(this.bQ, this.f762cn, this.co);
            c.a(this.co, this.bO, this.bP);
            this.bP.e(this.cm);
            this.bQ.d(this.f762cn);
            c.b(this.f762cn, this.cm, this.co);
            c.b(this.bL, this.co, this.bR);
            c.a(this.bR, this.bS, this.bW);
            c.b(this.bR, this.bQ, this.cm);
            this.f762cn.b();
            this.f762cn.c(this.cm);
            c.b(this.f762cn, this.bL, this.cm);
            this.bL.a(this.cm);
            f.a(this.bW, this.bK);
            c cVar = this.bK;
            c cVar2 = this.bJ;
            c.b(cVar, cVar2, cVar2);
            c();
            return;
        }
        this.cI.a(this.bX, this.bT, this.bJ);
        this.cG = true;
    }

    private double[] f(c cVar) {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.bI[(i2 * 4) + i] = cVar.d(i, i2);
            }
        }
        double[] dArr = this.bI;
        dArr[11] = 0.0d;
        dArr[7] = 0.0d;
        dArr[3] = 0.0d;
        dArr[14] = 0.0d;
        dArr[13] = 0.0d;
        dArr[12] = 0.0d;
        dArr[15] = 1.0d;
        return dArr;
    }

    private void a(float f) {
        if (!this.cc) {
            this.w = f;
            this.y = 1;
            this.cc = true;
        } else {
            this.w = (this.w * 0.95f) + (f * 0.050000012f);
            int i = this.y + 1;
            this.y = i;
            if (i > 10.0f) {
                this.cd = true;
            }
        }
    }

    private void c() {
        this.bK.d(this.cC);
        c.b(this.bL, this.cC, this.cD);
        c.b(this.bK, this.cD, this.bL);
        this.bK.b();
    }

    private void a(c cVar, g gVar) {
        c.a(cVar, this.bX, this.bU);
        this.cI.a(this.bU, this.bT, this.cE);
        this.cI.a(this.cE, gVar);
    }
}
