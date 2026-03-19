package com.tachikoma.lottie.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d {
    private float NA;
    private int NB;

    public final void m(float f) {
        this.NA += f;
        this.NB++;
        int i = this.NB;
        if (i == Integer.MAX_VALUE) {
            this.NA /= 2.0f;
            this.NB = i / 2;
        }
    }
}
