package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class PngChunk {
    protected final com.kwad.sdk.pngencrypt.k chM;
    public final boolean ciM;
    public final boolean ciN;
    public final boolean ciO;
    protected d ciP;
    private boolean ciQ = false;
    protected int ciR = -1;
    public final String id;

    protected abstract void a(d dVar);

    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }

        public final boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public final boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public final boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public final boolean isOk(int i, boolean z) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i < 4 : this == BEFORE_PLTE_AND_IDAT ? i < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z ? i < 4 : i < 4 && i > 2 : this == AFTER_IDAT && i > 4;
        }
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.id = str;
        this.chM = kVar;
        this.ciM = b.hW(str);
        this.ciN = b.hX(str);
        this.ciO = b.hY(str);
    }

    final void he(int i) {
        this.ciR = i;
    }

    final void b(d dVar) {
        this.ciP = dVar;
    }

    private int amW() {
        d dVar = this.ciP;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    private long amU() {
        d dVar = this.ciP;
        if (dVar != null) {
            return dVar.amU();
        }
        return -1L;
    }

    public String toString() {
        return "chunk id= " + this.id + " (len=" + amW() + " offset=" + amU() + ")";
    }
}
