package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j extends t {
    private boolean ciX;
    private String ciY;
    private String ciZ;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.ciX = false;
        this.ciY = "";
        this.ciZ = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int[] iArr = new int[3];
        int i = 0;
        int i2 = 0;
        while (i < dVar.data.length) {
            if (dVar.data[i] == 0) {
                iArr[i2] = i;
                i2++;
                if (i2 == 1) {
                    i += 2;
                }
                if (i2 == 3) {
                    break;
                }
            }
            i++;
        }
        if (i2 != 3) {
            new PngjException("Bad formed PngChunkITXT chunk");
        }
        this.key = b.d(dVar.data, 0, iArr[0]);
        int i3 = iArr[0] + 1;
        boolean z = dVar.data[i3] != 0;
        this.ciX = z;
        int i4 = i3 + 1;
        if (z && dVar.data[i4] != 0) {
            new PngjException("Bad formed PngChunkITXT chunk - bad compression method ");
        }
        this.ciY = b.d(dVar.data, i4, iArr[1] - i4);
        byte[] bArr = dVar.data;
        int i5 = iArr[1];
        this.ciZ = b.e(bArr, i5 + 1, (iArr[2] - i5) - 1);
        int i6 = iArr[2] + 1;
        if (this.ciX) {
            byte[] bArr2 = dVar.data;
            this.cjr = b.r(b.b(bArr2, i6, bArr2.length - i6, false));
        } else {
            byte[] bArr3 = dVar.data;
            this.cjr = b.e(bArr3, i6, bArr3.length - i6);
        }
    }
}
