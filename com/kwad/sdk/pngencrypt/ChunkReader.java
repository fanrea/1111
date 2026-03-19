package com.kwad.sdk.pngencrypt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode cgv;
    private final com.kwad.sdk.pngencrypt.chunk.d cgw;
    private boolean cgz;
    protected int cgx = 0;
    private int cgy = 0;
    protected ErrorBehaviour cgA = ErrorBehaviour.STRICT;

    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    protected abstract void a(int i, byte[] bArr, int i2, int i3);

    protected abstract void ami();

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            new PngjException("Bad chunk paramenters: " + chunkReaderMode);
        }
        this.cgv = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.cgw = dVar;
        dVar.bx(j);
        this.cgz = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d amh() {
        return this.cgw;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            new PngjException("negative length??");
        }
        if (this.cgx == 0 && this.cgy == 0 && this.cgz) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.cgw;
            dVar.f(dVar.ciD, 0, 4);
        }
        int i4 = this.cgw.len - this.cgx;
        if (i4 > i2) {
            i4 = i2;
        }
        if (i4 > 0 || this.cgy == 0) {
            if (this.cgz && this.cgv != ChunkReaderMode.BUFFER && i4 > 0) {
                this.cgw.f(bArr, i, i4);
            }
            if (this.cgv == ChunkReaderMode.BUFFER) {
                if (this.cgw.data != bArr && i4 > 0) {
                    System.arraycopy(bArr, i, this.cgw.data, this.cgx, i4);
                }
            } else if (this.cgv == ChunkReaderMode.PROCESS) {
                a(this.cgx, bArr, i, i4);
            }
            this.cgx += i4;
            i += i4;
            i2 -= i4;
        }
        if (this.cgx == this.cgw.len) {
            int i5 = 4 - this.cgy;
            if (i5 <= i2) {
                i2 = i5;
            }
            if (i2 > 0) {
                if (bArr != this.cgw.ciF) {
                    System.arraycopy(bArr, i, this.cgw.ciF, this.cgy, i2);
                }
                int i6 = this.cgy + i2;
                this.cgy = i6;
                if (i6 == 4) {
                    if (this.cgz) {
                        if (this.cgv == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.cgw;
                            dVar2.f(dVar2.data, 0, this.cgw.len);
                        }
                        this.cgw.dp(this.cgA == ErrorBehaviour.STRICT);
                    }
                    ami();
                }
            }
            i3 = i2;
        }
        if (i4 > 0 || i3 > 0) {
            return i4 + i3;
        }
        return -1;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.cgy == 4;
    }

    public final void dn(boolean z) {
        this.cgz = false;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.cgw;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChunkReader chunkReader = (ChunkReader) obj;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.cgw;
        if (dVar == null) {
            if (chunkReader.cgw != null) {
                return false;
            }
        } else if (!dVar.equals(chunkReader.cgw)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.cgw.toString();
    }
}
