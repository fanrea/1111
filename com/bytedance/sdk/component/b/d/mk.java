package com.bytedance.sdk.component.b.d;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class mk implements rf {
    private int b;
    private boolean c;
    private final u d;
    private final Inflater hc;

    mk(u uVar, Inflater inflater) {
        if (uVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.d = uVar;
        this.hc = inflater;
    }

    @Override // com.bytedance.sdk.component.b.d.rf
    public long d(b bVar, long j) throws DataFormatException, IOException {
        boolean zHc;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zHc = hc();
            try {
                e eVarU = bVar.u(1);
                int iInflate = this.hc.inflate(eVarU.d, eVarU.b, (int) Math.min(j, 8192 - eVarU.b));
                if (iInflate > 0) {
                    eVarU.b += iInflate;
                    long j2 = iInflate;
                    bVar.hc += j2;
                    return j2;
                }
                if (!this.hc.finished() && !this.hc.needsDictionary()) {
                }
                b();
                if (eVarU.hc != eVarU.b) {
                    return -1L;
                }
                bVar.d = eVarU.hc();
                cb.d(eVarU);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zHc);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean hc() throws IOException {
        if (!this.hc.needsInput()) {
            return false;
        }
        b();
        if (this.hc.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.d.u()) {
            return true;
        }
        e eVar = this.d.b().d;
        this.b = eVar.b - eVar.hc;
        this.hc.setInput(eVar.d, eVar.hc, this.b);
        return false;
    }

    private void b() throws IOException {
        int i = this.b;
        if (i == 0) {
            return;
        }
        int remaining = i - this.hc.getRemaining();
        this.b -= remaining;
        this.d.gb(remaining);
    }

    @Override // com.bytedance.sdk.component.b.d.rf
    public jh d() {
        return this.d.d();
    }

    @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.hc.end();
        this.c = true;
        this.d.close();
    }
}
