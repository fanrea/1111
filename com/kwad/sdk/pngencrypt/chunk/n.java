package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class n extends k {
    private String cjf;
    private int cjg;
    private int[] cjh;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i;
        int iG;
        int iG2;
        int iG3;
        int iG4;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= dVar.data.length) {
                i3 = -1;
                break;
            } else if (dVar.data[i3] == 0) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 <= 0 || i3 > dVar.data.length - 2) {
            throw new PngjException("bad sPLT chunk: no separator found");
        }
        this.cjf = b.d(dVar.data, 0, i3);
        this.cjg = com.kwad.sdk.pngencrypt.n.g(dVar.data, i3 + 1);
        int i4 = i3 + 2;
        int length = (dVar.data.length - i4) / (this.cjg == 8 ? 6 : 10);
        this.cjh = new int[length * 5];
        int i5 = i4;
        int i6 = 0;
        while (i2 < length) {
            if (this.cjg == 8) {
                int i7 = i5 + 1;
                iG = com.kwad.sdk.pngencrypt.n.g(dVar.data, i5);
                int i8 = i7 + 1;
                iG2 = com.kwad.sdk.pngencrypt.n.g(dVar.data, i7);
                int i9 = i8 + 1;
                iG3 = com.kwad.sdk.pngencrypt.n.g(dVar.data, i8);
                i = i9 + 1;
                iG4 = com.kwad.sdk.pngencrypt.n.g(dVar.data, i9);
            } else {
                int iH = com.kwad.sdk.pngencrypt.n.h(dVar.data, i5);
                int i10 = i5 + 2;
                int iH2 = com.kwad.sdk.pngencrypt.n.h(dVar.data, i10);
                int i11 = i10 + 2;
                int iH3 = com.kwad.sdk.pngencrypt.n.h(dVar.data, i11);
                int i12 = i11 + 2;
                int iH4 = com.kwad.sdk.pngencrypt.n.h(dVar.data, i12);
                i = i12 + 2;
                iG = iH;
                iG2 = iH2;
                iG3 = iH3;
                iG4 = iH4;
            }
            int iH5 = com.kwad.sdk.pngencrypt.n.h(dVar.data, i);
            int[] iArr = this.cjh;
            int i13 = i6 + 1;
            iArr[i6] = iG;
            int i14 = i13 + 1;
            iArr[i13] = iG2;
            int i15 = i14 + 1;
            iArr[i14] = iG3;
            int i16 = i15 + 1;
            iArr[i15] = iG4;
            iArr[i16] = iH5;
            i2++;
            i6 = i16 + 1;
            i5 = i + 2;
        }
    }

    public final String ane() {
        return this.cjf;
    }
}
