package com.component.lottie.d.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    private final float[] a;
    private final int[] b;

    public d(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.b = iArr;
    }

    public float[] a() {
        return this.a;
    }

    public int[] b() {
        return this.b;
    }

    public int c() {
        return this.b.length;
    }

    public void a(d dVar, d dVar2, float f) {
        if (dVar.b.length != dVar2.b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + dVar.b.length + " vs " + dVar2.b.length + ")");
        }
        for (int i = 0; i < dVar.b.length; i++) {
            this.a[i] = com.component.lottie.g.f.a(dVar.a[i], dVar2.a[i], f);
            this.b[i] = com.component.lottie.g.b.a(f, dVar.b[i], dVar2.b[i]);
        }
    }
}
