package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o implements Closeable {
    protected ErrorBehaviour cgM = ErrorBehaviour.STRICT;
    public final k chM;
    public final boolean cii;
    protected final c cij;
    protected final a cik;
    protected final w cil;
    protected int cim;
    private i<? extends Object> cin;

    public o(InputStream inputStream, boolean z) {
        this.cim = -1;
        a aVar = new a(inputStream);
        this.cik = aVar;
        boolean z2 = true;
        aVar.dm(true);
        c cVarAmR = amR();
        this.cij = cVarAmR;
        try {
            if (aVar.b(cVarAmR, 36) != 36) {
                new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)");
            }
            this.chM = cVarAmR.amr();
            if (cVarAmR.ams() == null) {
                z2 = false;
            }
            this.cii = z2;
            bw(5024024L);
            bu(901001001L);
            bv(2024024L);
            this.cil = new w(cVarAmR.cgS);
            a(m.amK());
            this.cim = -1;
        } catch (RuntimeException e) {
            this.cik.close();
            this.cij.close();
            throw e;
        }
    }

    private void amN() {
        while (this.cij.cgR < 4) {
            if (this.cik.a(this.cij) <= 0) {
                new PngjException("Premature ending reading first chunks");
            }
        }
    }

    public final w amO() {
        if (this.cij.amp()) {
            amN();
        }
        return this.cil;
    }

    private void a(i<? extends Object> iVar) {
        this.cin = iVar;
    }

    public final void amP() {
        amQ();
        if (this.cij.amp()) {
            amN();
        }
        end();
    }

    private void bu(long j) {
        this.cij.bu(901001001L);
    }

    private void bw(long j) {
        this.cij.bw(5024024L);
    }

    private void bv(long j) {
        this.cij.bv(2024024L);
    }

    public final void end() {
        try {
            if (this.cij.amp()) {
                amN();
            }
            if (this.cij.amq() != null && !this.cij.amq().isDone()) {
                this.cij.amq().amx();
            }
            while (!this.cij.isDone() && this.cik.a(this.cij) > 0) {
            }
        } finally {
            close();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.pngencrypt.a.a.closeQuietly(this.cij);
        com.kwad.sdk.pngencrypt.a.a.closeQuietly(this.cik);
    }

    private void amQ() {
        this.cij.m460do(false);
    }

    private static c amR() {
        return new c(false);
    }

    public final String toString() {
        return this.chM.toString() + " interlaced=" + this.cii;
    }
}
