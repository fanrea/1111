package com.kwad.lottie.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    private float bpJ;
    private int n;

    public final void H(float f) {
        float f2 = this.bpJ + f;
        this.bpJ = f2;
        int i = this.n + 1;
        this.n = i;
        if (i == Integer.MAX_VALUE) {
            this.bpJ = f2 / 2.0f;
            this.n = i / 2;
        }
    }
}
