package com.kwad.lottie.model.content;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private final int[] XC;
    private final float[] bnC;

    public c(float[] fArr, int[] iArr) {
        this.bnC = fArr;
        this.XC = iArr;
    }

    public final float[] Rv() {
        return this.bnC;
    }

    public final int[] getColors() {
        return this.XC;
    }

    public final int getSize() {
        return this.XC.length;
    }

    public final void a(c cVar, c cVar2, float f) {
        if (cVar.XC.length != cVar2.XC.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.XC.length + " vs " + cVar2.XC.length + ")");
        }
        for (int i = 0; i < cVar.XC.length; i++) {
            this.bnC[i] = com.kwad.lottie.d.e.lerp(cVar.bnC[i], cVar2.bnC[i], f);
            this.XC[i] = com.kwad.lottie.d.b.a(f, cVar.XC[i], cVar2.XC[i]);
        }
    }
}
