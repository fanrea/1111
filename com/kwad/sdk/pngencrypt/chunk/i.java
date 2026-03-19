package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i extends p {
    private int chx;
    private int chy;
    private int ciS;
    private int ciT;
    private int ciU;
    private int ciV;
    private int ciW;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            anb();
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 13) {
            throw new PngjException("Bad IDHR len " + dVar.len);
        }
        ByteArrayInputStream byteArrayInputStreamAmT = dVar.amT();
        this.chy = com.kwad.sdk.pngencrypt.n.n(byteArrayInputStreamAmT);
        this.chx = com.kwad.sdk.pngencrypt.n.n(byteArrayInputStreamAmT);
        this.ciS = com.kwad.sdk.pngencrypt.n.m(byteArrayInputStreamAmT);
        this.ciT = com.kwad.sdk.pngencrypt.n.m(byteArrayInputStreamAmT);
        this.ciU = com.kwad.sdk.pngencrypt.n.m(byteArrayInputStreamAmT);
        this.ciV = com.kwad.sdk.pngencrypt.n.m(byteArrayInputStreamAmT);
        this.ciW = com.kwad.sdk.pngencrypt.n.m(byteArrayInputStreamAmT);
    }

    private int amE() {
        return this.chy;
    }

    private void hf(int i) {
        this.chy = i;
    }

    private int amD() {
        return this.chx;
    }

    private void hg(int i) {
        this.chx = i;
    }

    private int amX() {
        return this.ciS;
    }

    private void hh(int i) {
        this.ciS = i;
    }

    private int amY() {
        return this.ciT;
    }

    private void hi(int i) {
        this.ciT = i;
    }

    private void hj(int i) {
        this.ciU = 0;
    }

    private void hk(int i) {
        this.ciV = 0;
    }

    private int amZ() {
        return this.ciW;
    }

    private void hl(int i) {
        this.ciW = 0;
    }

    public final boolean ana() {
        return amZ() == 1;
    }

    private void anb() {
        hf(this.chM.chy);
        hg(this.chM.chx);
        hh(this.chM.chQ);
        int i = this.chM.chS ? 4 : 0;
        if (this.chM.chU) {
            i++;
        }
        if (!this.chM.chT) {
            i += 2;
        }
        hi(i);
        hj(0);
        hk(0);
        hl(0);
    }

    public final com.kwad.sdk.pngencrypt.k anc() {
        and();
        return new com.kwad.sdk.pngencrypt.k(amE(), amD(), amX(), (amY() & 4) != 0, amY() == 0 || amY() == 4, (amY() & 1) != 0);
    }

    private void and() {
        if (this.chy <= 0 || this.chx <= 0 || this.ciU != 0 || this.ciV != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i = this.ciS;
        if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i2 = this.ciW;
        if (i2 < 0 || i2 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i3 = this.ciT;
        if (i3 != 0) {
            if (i3 != 6 && i3 != 2) {
                if (i3 == 3) {
                    if (i == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i3 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            if (i != 8 && i != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }
}
