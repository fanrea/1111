package com.bytedance.adsdk.lottie.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private float d;
    private int hc;

    public void d(float f) {
        float f2 = this.d + f;
        this.d = f2;
        int i = this.hc + 1;
        this.hc = i;
        if (i == Integer.MAX_VALUE) {
            this.d = f2 / 2.0f;
            this.hc = i / 2;
        }
    }
}
