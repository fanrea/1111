package com.bytedance.adsdk.lottie.an;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private float d;
    private float hc;

    public c(float f, float f2) {
        this.d = f;
        this.hc = f2;
    }

    public c() {
        this(1.0f, 1.0f);
    }

    public float d() {
        return this.d;
    }

    public float hc() {
        return this.hc;
    }

    public void d(float f, float f2) {
        this.d = f;
        this.hc = f2;
    }

    public boolean hc(float f, float f2) {
        return this.d == f && this.hc == f2;
    }

    public String toString() {
        return d() + "x" + hc();
    }
}
