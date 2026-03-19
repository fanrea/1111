package com.bytedance.adsdk.lottie.model.hc;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private final float[] d;
    private final int[] hc;

    public c(float[] fArr, int[] iArr) {
        this.d = fArr;
        this.hc = iArr;
    }

    public float[] d() {
        return this.d;
    }

    public int[] hc() {
        return this.hc;
    }

    public int b() {
        return this.hc.length;
    }

    public void d(c cVar, c cVar2, float f) {
        if (cVar.hc.length != cVar2.hc.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.hc.length + " vs " + cVar2.hc.length + ")");
        }
        for (int i = 0; i < cVar.hc.length; i++) {
            this.d[i] = com.bytedance.adsdk.lottie.u.gb.d(cVar.d[i], cVar2.d[i], f);
            this.hc[i] = com.bytedance.adsdk.lottie.u.b.d(f, cVar.hc[i], cVar2.hc[i]);
        }
    }

    public c d(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = d(fArr[i]);
        }
        return new c(fArr, iArr);
    }

    private int d(float f) {
        int iBinarySearch = Arrays.binarySearch(this.d, f);
        if (iBinarySearch >= 0) {
            return this.hc[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.hc[0];
        }
        int[] iArr = this.hc;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.d;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.bytedance.adsdk.lottie.u.b.d((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}
