package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.util.zip.DataFormatException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet che;
    protected boolean chf;
    protected boolean chg;
    protected byte[] chh;
    protected int chi;

    public d(int i, String str, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.chf = false;
        this.chg = false;
        this.chi = -1;
        this.che = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected final void a(int i, byte[] bArr, int i2, int i3) throws DataFormatException {
        if (this.chg && i < 4) {
            while (i < 4 && i3 > 0) {
                this.chh[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.che.c(bArr, i2, i3);
            if (this.chf) {
                System.arraycopy(bArr, i2, amh().data, this.cgx, i3);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected void ami() {
        int i;
        if (!this.chg || this.chi < 0 || (i = n.i(this.chh, 0)) == this.chi) {
            return;
        }
        new PngjException("bad chunk sequence for fDAT chunk " + i + " expected " + this.chi);
    }

    public final void gT(int i) {
        this.chi = i;
    }
}
