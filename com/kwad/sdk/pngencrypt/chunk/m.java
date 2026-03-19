package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class m extends p {
    private int cjd;
    private int[] cje;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.cjd = 0;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        hm(dVar.len / 3);
        int i = 0;
        int i2 = 0;
        while (i < this.cjd) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            e(i, dVar.data[i2] & 255, dVar.data[i3] & 255, dVar.data[i4] & 255);
            i++;
            i2 = i4 + 1;
        }
    }

    private void hm(int i) {
        this.cjd = i;
        if (i <= 0 || i > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.cjd);
        }
        int[] iArr = this.cje;
        if (iArr == null || iArr.length != i) {
            this.cje = new int[i];
        }
    }

    private void e(int i, int i2, int i3, int i4) {
        this.cje[i] = (i2 << 16) | (i3 << 8) | i4;
    }
}
