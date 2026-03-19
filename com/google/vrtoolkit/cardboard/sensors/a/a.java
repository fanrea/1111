package com.google.vrtoolkit.cardboard.sensors.a;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private b bA;
    private g bB;
    private g bC;
    private C0392a bD;
    private C0392a bE;
    private b by;
    private b bz;

    public a() {
        a();
    }

    public final void a() {
        this.bB = new g();
        this.bC = new g();
        this.by = new b(1.0d);
        this.bz = new b(10.0d);
        this.bA = new b(0.15000000596046448d);
        this.bD = new C0392a(10);
        this.bE = new C0392a(10);
    }

    public final void a(g gVar, long j) {
        this.bz.a(gVar, j);
        g.b(gVar, this.bz.M(), this.bB);
        this.bE.a(this.bB.c() < 0.00800000037997961d);
        if (this.bE.a() && this.bD.a()) {
            c(gVar, j);
        }
    }

    public final void b(g gVar, long j) {
        this.by.a(gVar, j);
        g.b(gVar, this.by.M(), this.bC);
        this.bD.a(this.bC.c() < 0.5d);
    }

    public final void a(g gVar) {
        if (this.bA.a() < 30) {
            gVar.a();
        } else {
            gVar.a(this.bA.M());
            gVar.a(Math.min(1.0d, (this.bA.a() - 30) / 100.0d));
        }
    }

    private void c(g gVar, long j) {
        if (gVar.c() < 0.3499999940395355d) {
            double dMax = Math.max(0.0d, 1.0d - (gVar.c() / 0.3499999940395355d));
            this.bA.a(this.bz.M(), j, dMax * dMax);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    /* renamed from: com.google.vrtoolkit.cardboard.sensors.a.a$a, reason: collision with other inner class name */
    static class C0392a {
        private final int a = 10;
        private int b;

        C0392a(int i) {
        }

        final void a(boolean z) {
            if (!z) {
                this.b = 0;
            } else {
                this.b++;
            }
        }

        final boolean a() {
            return this.b >= this.a;
        }
    }
}
