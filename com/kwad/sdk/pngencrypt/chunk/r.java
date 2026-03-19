package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class r extends p {
    private int cjj;
    private int cjk;
    private int cjl;
    private int hour;
    private int min;
    private int year;

    public r(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 7) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.year = com.kwad.sdk.pngencrypt.n.h(dVar.data, 0);
        this.cjj = com.kwad.sdk.pngencrypt.n.g(dVar.data, 2);
        this.cjk = com.kwad.sdk.pngencrypt.n.g(dVar.data, 3);
        this.hour = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
        this.min = com.kwad.sdk.pngencrypt.n.g(dVar.data, 5);
        this.cjl = com.kwad.sdk.pngencrypt.n.g(dVar.data, 6);
    }
}
