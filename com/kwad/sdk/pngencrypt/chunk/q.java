package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class q extends t {
    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        String strD;
        int i = 0;
        while (i < dVar.data.length && dVar.data[i] != 0) {
            i++;
        }
        this.key = b.d(dVar.data, 0, i);
        int i2 = i + 1;
        if (i2 < dVar.data.length) {
            byte[] bArr = dVar.data;
            strD = b.d(bArr, i2, bArr.length - i2);
        } else {
            strD = "";
        }
        this.cjr = strD;
    }
}
