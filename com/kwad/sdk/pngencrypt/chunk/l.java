package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import com.kwai.video.player.KsMediaMeta;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class l extends p {
    private long cja;
    private long cjb;
    private int cjc;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long jI = com.kwad.sdk.pngencrypt.n.i(dVar.data, 0);
        this.cja = jI;
        if (jI < 0) {
            this.cja = jI + KsMediaMeta.AV_CH_WIDE_RIGHT;
        }
        long jI2 = com.kwad.sdk.pngencrypt.n.i(dVar.data, 4);
        this.cjb = jI2;
        if (jI2 < 0) {
            this.cjb = jI2 + KsMediaMeta.AV_CH_WIDE_RIGHT;
        }
        this.cjc = com.kwad.sdk.pngencrypt.n.g(dVar.data, 8);
    }
}
