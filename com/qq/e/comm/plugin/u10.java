package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class u10 {
    public static final u10 e;
    public static final u10 f;
    public static final u10 g;
    public static final u10 h;
    public static final u10 i;
    public static final u10 j;
    final float[] a;
    final float[] b;
    final float[] c = new float[3];
    boolean d = true;

    static {
        u10 u10Var = new u10();
        e = u10Var;
        b(u10Var);
        e(u10Var);
        u10 u10Var2 = new u10();
        f = u10Var2;
        d(u10Var2);
        e(u10Var2);
        u10 u10Var3 = new u10();
        g = u10Var3;
        a(u10Var3);
        e(u10Var3);
        u10 u10Var4 = new u10();
        h = u10Var4;
        b(u10Var4);
        c(u10Var4);
        u10 u10Var5 = new u10();
        i = u10Var5;
        d(u10Var5);
        c(u10Var5);
        u10 u10Var6 = new u10();
        j = u10Var6;
        a(u10Var6);
        c(u10Var6);
    }

    u10() {
        float[] fArr = new float[3];
        this.a = fArr;
        float[] fArr2 = new float[3];
        this.b = fArr2;
        a(fArr);
        a(fArr2);
        l();
    }

    public float e() {
        return this.a[0];
    }

    public float i() {
        return this.a[1];
    }

    public float c() {
        return this.a[2];
    }

    public float d() {
        return this.b[0];
    }

    public float h() {
        return this.b[1];
    }

    public float b() {
        return this.b[2];
    }

    public float g() {
        return this.c[0];
    }

    public float a() {
        return this.c[1];
    }

    public float f() {
        return this.c[2];
    }

    public boolean j() {
        return this.d;
    }

    private void l() {
        float[] fArr = this.c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    void k() {
        int length = this.c.length;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < length; i2++) {
            float f3 = this.c[i2];
            if (f3 > 0.0f) {
                f2 += f3;
            }
        }
        if (f2 != 0.0f) {
            int length2 = this.c.length;
            for (int i3 = 0; i3 < length2; i3++) {
                float[] fArr = this.c;
                float f4 = fArr[i3];
                if (f4 > 0.0f) {
                    fArr[i3] = f4 / f2;
                }
            }
        }
    }

    private static void e(u10 u10Var) {
        float[] fArr = u10Var.a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private static void d(u10 u10Var) {
        float[] fArr = u10Var.b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void c(u10 u10Var) {
        float[] fArr = u10Var.a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    private static void b(u10 u10Var) {
        float[] fArr = u10Var.b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void a(u10 u10Var) {
        float[] fArr = u10Var.b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    private static void a(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }
}
