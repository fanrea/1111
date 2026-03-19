package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class s extends p {
    private int cjm;
    private int cjn;
    private int cjo;
    private int cjp;
    private int[] cjq;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.cjq = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (this.chM.chT) {
            this.cjm = com.kwad.sdk.pngencrypt.n.h(dVar.data, 0);
            return;
        }
        if (this.chM.chU) {
            int length = dVar.data.length;
            this.cjq = new int[length];
            for (int i = 0; i < length; i++) {
                this.cjq[i] = dVar.data[i] & 255;
            }
            return;
        }
        this.cjn = com.kwad.sdk.pngencrypt.n.h(dVar.data, 0);
        this.cjo = com.kwad.sdk.pngencrypt.n.h(dVar.data, 2);
        this.cjp = com.kwad.sdk.pngencrypt.n.h(dVar.data, 4);
    }
}
