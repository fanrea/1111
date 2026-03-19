package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c extends b {
    protected k cgO;
    protected k cgP;
    protected e cgQ;
    protected int cgR = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e cgS = null;
    private long cgU = 0;
    private boolean cgV = true;
    private boolean cgW = false;
    private Set<String> cgX = new HashSet();
    private long cgY = 0;
    private long cgZ = 0;
    private long cha = 0;
    private ChunkLoadBehaviour chc = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean cgT = false;
    private g chb = new com.kwad.sdk.pngencrypt.chunk.a();

    public c(boolean z) {
    }

    private void hS(String str) {
        if (str.equals("IHDR")) {
            if (this.cgR < 0) {
                this.cgR = 0;
                return;
            } else {
                new PngjException("unexpected chunk " + str);
                return;
            }
        }
        if (str.equals("PLTE")) {
            int i = this.cgR;
            if (i == 0 || i == 1) {
                this.cgR = 2;
                return;
            } else {
                new PngjException("unexpected chunk here " + str);
                return;
            }
        }
        if (str.equals("IDAT")) {
            int i2 = this.cgR;
            if (i2 >= 0 && i2 <= 4) {
                this.cgR = 4;
                return;
            } else {
                new PngjException("unexpected chunk " + str);
                return;
            }
        }
        if (str.equals("IEND")) {
            if (this.cgR >= 4) {
                this.cgR = 6;
                return;
            } else {
                new PngjException("unexpected chunk " + str);
                return;
            }
        }
        int i3 = this.cgR;
        if (i3 <= 1) {
            this.cgR = 1;
        } else if (i3 <= 3) {
            this.cgR = 3;
        } else {
            this.cgR = 5;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean O(int i, String str) {
        if (super.O(i, str)) {
            return true;
        }
        if (this.cgY > 0 && i + amk() > this.cgY) {
            new PngjException("Maximum total bytes to read exceeeded: " + this.cgY + " offset:" + amk() + " len=" + i);
        }
        if (this.cgX.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.hW(str)) {
            return false;
        }
        long j = this.cgZ;
        if (j > 0 && i > j) {
            return true;
        }
        long j2 = this.cha;
        if (j2 > 0 && i > j2 - this.cgU) {
            return true;
        }
        int i2 = AnonymousClass1.chd[this.chc.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return true;
            }
        } else if (!com.kwad.sdk.pngencrypt.chunk.b.hY(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: com.kwad.sdk.pngencrypt.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] chd;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            chd = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                chd[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private int amo() {
        return this.cgR;
    }

    public final boolean amp() {
        return amo() < 4;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.amh().id.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.amh());
            k kVarAnc = iVar.anc();
            this.cgO = kVarAnc;
            this.cgP = kVarAnc;
            if (iVar.ana()) {
                this.cgQ = new e(this.cgP);
            }
            this.cgS = new com.kwad.sdk.pngencrypt.chunk.e(this.cgO);
        }
        if (chunkReader.cgv == ChunkReader.ChunkReaderMode.BUFFER && hT(chunkReader.amh().id)) {
            this.cgU += chunkReader.amh().len;
        }
        if (chunkReader.cgv == ChunkReader.ChunkReaderMode.BUFFER || this.cgW) {
            try {
                this.cgS.a(this.chb.a(chunkReader.amh(), amr()), this.cgR);
            } catch (PngjException e) {
                throw e;
            }
        }
    }

    private static boolean hT(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.hW(str);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final DeflatedChunksSet hQ(String str) {
        return new j(str, this.cgT, amt(), this.cgQ);
    }

    public final j amq() {
        DeflatedChunksSet deflatedChunksSetAml = aml();
        if (deflatedChunksSetAml instanceof j) {
            return (j) deflatedChunksSetAml;
        }
        return null;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean hR(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i, int i2) {
        return super.b(bArr, i, i2);
    }

    public final k amr() {
        return this.cgO;
    }

    public final e ams() {
        return this.cgQ;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final void c(int i, String str, long j) {
        hS(str);
        super.c(i, str, j);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.cgR != 6) {
            this.cgR = 6;
        }
        super.close();
    }

    public final void bu(long j) {
        this.cgY = j;
    }

    public final void bv(long j) {
        this.cgZ = j;
    }

    public final void bw(long j) {
        this.cha = j;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean amj() {
        return this.cgV;
    }

    /* renamed from: do, reason: not valid java name */
    public final void m460do(boolean z) {
        this.cgV = false;
    }

    private k amt() {
        return this.cgP;
    }
}
