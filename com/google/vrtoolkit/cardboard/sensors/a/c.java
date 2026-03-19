package com.google.vrtoolkit.cardboard.sensors.a;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    public double[] bH = new double[9];

    private void a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double[] dArr = this.bH;
        dArr[0] = d;
        dArr[1] = d2;
        dArr[2] = d3;
        dArr[3] = d4;
        dArr[4] = d5;
        dArr[5] = d6;
        dArr[6] = d7;
        dArr[7] = d8;
        dArr[8] = d9;
    }

    public final void a(c cVar) {
        double[] dArr = this.bH;
        double[] dArr2 = cVar.bH;
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        dArr[2] = dArr2[2];
        dArr[3] = dArr2[3];
        dArr[4] = dArr2[4];
        dArr[5] = dArr2[5];
        dArr[6] = dArr2[6];
        dArr[7] = dArr2[7];
        dArr[8] = dArr2[8];
    }

    public final void a() {
        double[] dArr = this.bH;
        dArr[0] = 0.0d;
        dArr[1] = 0.0d;
        dArr[2] = 0.0d;
        dArr[3] = 0.0d;
        dArr[4] = 0.0d;
        dArr[5] = 0.0d;
        dArr[6] = 0.0d;
        dArr[7] = 0.0d;
        dArr[8] = 0.0d;
    }

    public final void b() {
        double[] dArr = this.bH;
        dArr[0] = 1.0d;
        dArr[1] = 0.0d;
        dArr[2] = 0.0d;
        dArr[3] = 0.0d;
        dArr[4] = 1.0d;
        dArr[5] = 0.0d;
        dArr[6] = 0.0d;
        dArr[7] = 0.0d;
        dArr[8] = 1.0d;
    }

    public final void a(double d) {
        double[] dArr = this.bH;
        dArr[0] = d;
        dArr[4] = d;
        dArr[8] = d;
    }

    public final double d(int i, int i2) {
        return this.bH[(i * 3) + i2];
    }

    public final void a(int i, int i2, double d) {
        this.bH[(i * 3) + i2] = d;
    }

    public final void a(int i, g gVar) {
        this.bH[i] = gVar.a;
        this.bH[i + 3] = gVar.b;
        this.bH[i + 6] = gVar.c;
    }

    public final void b(double d) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.bH;
            dArr[i] = dArr[i] * d;
        }
    }

    public final void b(c cVar) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.bH;
            dArr[i] = dArr[i] + cVar.bH[i];
        }
    }

    public final void c(c cVar) {
        for (int i = 0; i < 9; i++) {
            double[] dArr = this.bH;
            dArr[i] = dArr[i] - cVar.bH[i];
        }
    }

    public final void c() {
        double[] dArr = this.bH;
        double d = dArr[1];
        dArr[1] = dArr[3];
        dArr[3] = d;
        double d2 = dArr[2];
        dArr[2] = dArr[6];
        dArr[6] = d2;
        double d3 = dArr[5];
        dArr[5] = dArr[7];
        dArr[7] = d3;
    }

    public final void d(c cVar) {
        double[] dArr = this.bH;
        double d = dArr[1];
        double d2 = dArr[2];
        double d3 = dArr[5];
        double[] dArr2 = cVar.bH;
        dArr2[0] = dArr[0];
        dArr2[1] = dArr[3];
        dArr2[2] = dArr[6];
        dArr2[3] = d;
        dArr2[4] = dArr[4];
        dArr2[5] = dArr[7];
        dArr2[6] = d2;
        dArr2[7] = d3;
        dArr2[8] = dArr[8];
    }

    public static void a(c cVar, c cVar2, c cVar3) {
        double[] dArr = cVar3.bH;
        double[] dArr2 = cVar.bH;
        double d = dArr2[0];
        double[] dArr3 = cVar2.bH;
        dArr[0] = d + dArr3[0];
        dArr[1] = dArr2[1] + dArr3[1];
        dArr[2] = dArr2[2] + dArr3[2];
        dArr[3] = dArr2[3] + dArr3[3];
        dArr[4] = dArr2[4] + dArr3[4];
        dArr[5] = dArr2[5] + dArr3[5];
        dArr[6] = dArr2[6] + dArr3[6];
        dArr[7] = dArr2[7] + dArr3[7];
        dArr[8] = dArr2[8] + dArr3[8];
    }

    public static void b(c cVar, c cVar2, c cVar3) {
        double[] dArr = cVar.bH;
        double d = dArr[0];
        double[] dArr2 = cVar2.bH;
        double d2 = dArr2[0];
        double d3 = dArr[1];
        double d4 = dArr2[3];
        double d5 = dArr[2];
        double d6 = dArr2[6];
        double d7 = (d * d2) + (d3 * d4) + (d5 * d6);
        double d8 = dArr2[1];
        double d9 = dArr2[4];
        double d10 = dArr2[7];
        double d11 = (d * d8) + (d3 * d9) + (d5 * d10);
        double d12 = dArr2[2];
        double d13 = dArr2[5];
        double d14 = dArr2[8];
        double d15 = (d * d12) + (d3 * d13) + (d5 * d14);
        double d16 = dArr[3];
        double d17 = dArr[4];
        double d18 = dArr[5];
        double d19 = (d16 * d2) + (d17 * d4) + (d18 * d6);
        double d20 = (d16 * d8) + (d17 * d9) + (d18 * d10);
        double d21 = (d16 * d12) + (d17 * d13) + (d18 * d14);
        double d22 = dArr[6];
        double d23 = dArr[7];
        double d24 = dArr[8];
        cVar3.a(d7, d11, d15, d19, d20, d21, (d2 * d22) + (d4 * d23) + (d6 * d24), (d8 * d22) + (d9 * d23) + (d10 * d24), (d22 * d12) + (d23 * d13) + (d24 * d14));
    }

    public static void a(c cVar, g gVar, g gVar2) {
        double d = (cVar.bH[0] * gVar.a) + (cVar.bH[1] * gVar.b) + (cVar.bH[2] * gVar.c);
        double d2 = (cVar.bH[3] * gVar.a) + (cVar.bH[4] * gVar.b) + (cVar.bH[5] * gVar.c);
        double d3 = (cVar.bH[6] * gVar.a) + (cVar.bH[7] * gVar.b) + (cVar.bH[8] * gVar.c);
        gVar2.a = d;
        gVar2.b = d2;
        gVar2.c = d3;
    }

    private double N() {
        return ((d(0, 0) * ((d(1, 1) * d(2, 2)) - (d(2, 1) * d(1, 2)))) - (d(0, 1) * ((d(1, 0) * d(2, 2)) - (d(1, 2) * d(2, 0))))) + (d(0, 2) * ((d(1, 0) * d(2, 1)) - (d(1, 1) * d(2, 0))));
    }

    public final boolean e(c cVar) {
        double dN = N();
        if (dN == 0.0d) {
            return false;
        }
        double d = 1.0d / dN;
        double[] dArr = this.bH;
        double d2 = dArr[4];
        double d3 = dArr[8];
        double d4 = dArr[7];
        double d5 = dArr[5];
        double d6 = dArr[1];
        double d7 = dArr[2];
        double d8 = dArr[3];
        double d9 = dArr[6];
        double d10 = dArr[0];
        cVar.a(((d2 * d3) - (d4 * d5)) * d, (-((d6 * d3) - (d7 * d4))) * d, ((d6 * d5) - (d7 * d2)) * d, (-((d8 * d3) - (d5 * d9))) * d, ((d3 * d10) - (d7 * d9)) * d, (-((d5 * d10) - (d7 * d8))) * d, ((d8 * d4) - (d9 * d2)) * d, (-((d4 * d10) - (d9 * d6))) * d, ((d10 * d2) - (d8 * d6)) * d);
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < 9; i++) {
            sb.append(Double.toString(this.bH[i]));
            if (i < 8) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        return sb.toString();
    }
}
