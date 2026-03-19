package com.tachikoma.lottie.model.content;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c {
    private final float[] Lq;
    private final int[] Lr;

    public c(float[] fArr, int[] iArr) {
        this.Lq = fArr;
        this.Lr = iArr;
    }

    public final float[] kR() {
        return this.Lq;
    }

    public final int[] getColors() {
        return this.Lr;
    }

    public final int getSize() {
        return this.Lr.length;
    }

    public final void a(c cVar, c cVar2, float f) {
        if (cVar.Lr.length != cVar2.Lr.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.Lr.length + " vs " + cVar2.Lr.length + ")");
        }
        for (int i = 0; i < cVar.Lr.length; i++) {
            this.Lq[i] = com.tachikoma.lottie.d.e.c(cVar.Lq[i], cVar2.Lq[i], f);
            this.Lr[i] = com.tachikoma.lottie.d.b.a(f, cVar.Lr[i], cVar2.Lr[i]);
        }
    }
}
