package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] cgB;
    private final int cgC;
    private byte[] cgD;
    private int cgE;
    protected boolean cgF;
    protected boolean cgG;
    private int cgH;
    private long cgI;
    private DeflatedChunksSet cgJ;
    private ChunkReader cgK;
    private long cgL;
    private ErrorBehaviour cgM;
    protected boolean closed;

    private static String amm() {
        return "IHDR";
    }

    private static String amn() {
        return "IEND";
    }

    protected boolean O(int i, String str) {
        return false;
    }

    protected boolean amj() {
        return true;
    }

    protected abstract DeflatedChunksSet hQ(String str);

    protected boolean hR(String str) {
        return false;
    }

    public b() {
        this(n.amL());
    }

    private b(byte[] bArr) {
        this.cgD = new byte[8];
        this.cgE = 0;
        this.cgF = false;
        this.cgG = false;
        this.closed = false;
        this.cgH = 0;
        this.cgI = 0L;
        this.cgM = ErrorBehaviour.STRICT;
        this.cgB = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.cgC = length;
        this.cgF = length <= 0;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int b(byte[] bArr, int i, int i2) {
        if (this.closed) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            new PngjException("This should not happen. Bad length: " + i2);
        }
        if (this.cgF) {
            ChunkReader chunkReader = this.cgK;
            if (chunkReader == null || chunkReader.isDone()) {
                int i3 = this.cgE;
                int i4 = 8 - i3;
                if (i4 <= i2) {
                    i2 = i4;
                }
                System.arraycopy(bArr, i, this.cgD, i3, i2);
                int i5 = this.cgE + i2;
                this.cgE = i5;
                int i6 = i2 + 0;
                this.cgI += i2;
                if (i5 != 8) {
                    return i6;
                }
                this.cgH++;
                c(n.i(this.cgD, 0), com.kwad.sdk.pngencrypt.chunk.b.k(this.cgD, 4), this.cgI - 8);
                this.cgE = 0;
                return i6;
            }
            int iB = this.cgK.b(bArr, i, i2);
            if (iB < 0) {
                return -1;
            }
            int i7 = iB + 0;
            this.cgI += iB;
            return i7;
        }
        int i8 = this.cgC;
        int i9 = this.cgE;
        int i10 = i8 - i9;
        if (i10 <= i2) {
            i2 = i10;
        }
        System.arraycopy(bArr, i, this.cgD, i9, i2);
        int i11 = this.cgE + i2;
        this.cgE = i11;
        if (i11 == this.cgC) {
            p(this.cgD);
            this.cgE = 0;
            this.cgF = true;
        }
        int i12 = i2 + 0;
        this.cgI += i2;
        return i12;
    }

    protected void c(int i, String str, long j) {
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.ciC.matcher(str).matches()) {
            new PngjException("Bad chunk id: " + str);
        }
        if (i < 0) {
            new PngjException("Bad chunk len: " + i);
        }
        if (str.equals("IDAT")) {
            this.cgL += i;
        }
        boolean zAmj = amj();
        boolean zO = O(i, str);
        boolean zHR = hR(str);
        DeflatedChunksSet deflatedChunksSet = this.cgJ;
        boolean zHU = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.cgJ.hU(str);
        if (zHR && !zO) {
            if (!zHU) {
                DeflatedChunksSet deflatedChunksSet2 = this.cgJ;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    new PngjException("new IDAT-like chunk when previous was not done");
                }
                this.cgJ = hQ(str);
            }
            this.cgK = new d(i, str, zAmj, j, this.cgJ) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                protected final void ami() {
                    super.ami();
                    b.this.a(this);
                }
            };
        } else {
            this.cgK = a(str, i, j, zO);
        }
        ChunkReader chunkReader = this.cgK;
        if (chunkReader == null || zAmj) {
            return;
        }
        chunkReader.dn(false);
    }

    private ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void ami() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void a(int i2, byte[] bArr, int i3, int i4) {
                new PngjException("should never happen");
            }
        };
    }

    protected void a(ChunkReader chunkReader) {
        if (this.cgH == 1 && !amm().equals(chunkReader.amh().id)) {
            String str = "Bad first chunk: " + chunkReader.amh().id + " expected: " + amm();
            if (this.cgM.c < ErrorBehaviour.SUPER_LENIENT.c) {
                new PngjException(str);
            }
        }
        amn();
        if (chunkReader.amh().id.equals(amn())) {
            this.cgG = true;
            close();
        }
    }

    private static void p(byte[] bArr) {
        if (Arrays.equals(bArr, n.amL())) {
            return;
        }
        new PngjException("Bad signature:" + Arrays.toString(bArr));
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.cgG;
    }

    public final long amk() {
        return this.cgI;
    }

    public final DeflatedChunksSet aml() {
        return this.cgJ;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.cgJ;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }
}
