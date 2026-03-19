package com.kwad.sdk.glide.webp.decoder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class p {
    public static final p cbh = new p();
    public static final p cbi = new p(2);
    public static final p cbj = new p(4);
    private int cbk;

    private p(int i) {
        this.cbk = i;
    }

    public p() {
        this.cbk = 0;
    }

    public final int d(int i, int i2, int i3, int i4) {
        if (this.cbk <= 0) {
            this.cbk = h.d(i, i2, i3, i4);
        }
        int iHighestOneBit = Integer.highestOneBit(this.cbk);
        this.cbk = iHighestOneBit;
        return iHighestOneBit;
    }
}
