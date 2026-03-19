package com.component.lottie.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    private float a;
    private int b;

    public void a(float f) {
        this.a += f;
        this.b++;
        if (this.b == Integer.MAX_VALUE) {
            this.a /= 2.0f;
            this.b /= 2;
        }
    }

    public float a() {
        if (this.b == 0) {
            return 0.0f;
        }
        return this.a / this.b;
    }
}
