package com.bytedance.sdk.component.b.d;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class tc implements rf {
    private final Inflater b;
    private final mk c;
    private final u hc;
    private int d = 0;
    private final CRC32 u = new CRC32();

    public tc(rf rfVar) {
        if (rfVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.b = inflater;
        u uVarD = mq.d(rfVar);
        this.hc = uVarD;
        this.c = new mk(uVarD, inflater);
    }

    @Override // com.bytedance.sdk.component.b.d.rf
    public long d(b bVar, long j) throws DataFormatException, IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return 0L;
        }
        if (this.d == 0) {
            hc();
            this.d = 1;
        }
        if (this.d == 1) {
            long j2 = bVar.hc;
            long jD = this.c.d(bVar, j);
            if (jD != -1) {
                d(bVar, j2, jD);
                return jD;
            }
            this.d = 2;
        }
        if (this.d == 2) {
            b();
            this.d = 3;
            if (!this.hc.u()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void hc() throws IOException {
        this.hc.d(10L);
        byte bHc = this.hc.b().hc(3L);
        boolean z = ((bHc >> 1) & 1) == 1;
        if (z) {
            d(this.hc.b(), 0L, 10L);
        }
        d("ID1ID2", 8075, this.hc.tt());
        this.hc.gb(8L);
        if (((bHc >> 2) & 1) == 1) {
            this.hc.d(2L);
            if (z) {
                d(this.hc.b(), 0L, 2L);
            }
            long jMk = this.hc.b().mk();
            this.hc.d(jMk);
            if (z) {
                d(this.hc.b(), 0L, jMk);
            }
            this.hc.gb(jMk);
        }
        if (((bHc >> 3) & 1) == 1) {
            long jD = this.hc.d((byte) 0);
            if (jD == -1) {
                throw new EOFException();
            }
            if (z) {
                d(this.hc.b(), 0L, jD + 1);
            }
            this.hc.gb(jD + 1);
        }
        if (((bHc >> 4) & 1) == 1) {
            long jD2 = this.hc.d((byte) 0);
            if (jD2 == -1) {
                throw new EOFException();
            }
            if (z) {
                d(this.hc.b(), 0L, jD2 + 1);
            }
            this.hc.gb(jD2 + 1);
        }
        if (z) {
            d("FHCRC", this.hc.mk(), (short) this.u.getValue());
            this.u.reset();
        }
    }

    private void b() throws IOException {
        d("CRC", this.hc.mq(), (int) this.u.getValue());
        d("ISIZE", this.hc.mq(), (int) this.b.getBytesWritten());
    }

    @Override // com.bytedance.sdk.component.b.d.rf
    public jh d() {
        return this.hc.d();
    }

    @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.c.close();
    }

    private void d(b bVar, long j, long j2) {
        e eVar = bVar.d;
        while (j >= eVar.b - eVar.hc) {
            j -= eVar.b - eVar.hc;
            eVar = eVar.an;
        }
        while (j2 > 0) {
            int iMin = (int) Math.min(eVar.b - r6, j2);
            this.u.update(eVar.d, (int) (eVar.hc + j), iMin);
            j2 -= iMin;
            eVar = eVar.an;
            j = 0;
        }
    }

    private void d(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
