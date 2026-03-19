package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private InputStream bRR;
    private byte[] buf;
    private int cgs;
    private boolean cgt;
    private long cgu;
    private boolean eof;
    private int offset;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    private a(InputStream inputStream, int i) {
        this.eof = false;
        this.cgt = true;
        this.cgu = 0L;
        this.bRR = inputStream;
        this.buf = new byte[16384];
    }

    public final int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    private int a(f fVar, int i) throws IOException {
        amg();
        if (i <= 0 || i >= this.cgs) {
            i = this.cgs;
        }
        if (i > 0) {
            int iB = fVar.b(this.buf, this.offset, i);
            if (iB > 0) {
                this.offset += iB;
                this.cgs -= iB;
            }
            if (iB > 0) {
                return iB;
            }
            if (!fVar.isDone()) {
                new PngjException("This should not happen!");
            }
            return -1;
        }
        if (!this.eof) {
            new PngjException("This should not happen");
        }
        return fVar.isDone() ? -1 : 0;
    }

    public final int b(f fVar, int i) throws IOException {
        int i2 = 36;
        while (i2 > 0) {
            int iA = a(fVar, i2);
            if (iA <= 0) {
                return iA;
            }
            i2 -= iA;
        }
        return 36;
    }

    private void amg() throws IOException {
        if (this.cgs > 0 || this.eof) {
            return;
        }
        try {
            this.offset = 0;
            int i = this.bRR.read(this.buf);
            this.cgs = i;
            if (i == 0) {
                new PngjException("This should not happen: stream.read(buf) returned 0");
            } else if (i < 0) {
                close();
            } else {
                this.cgu += i;
            }
        } catch (IOException e) {
            new PngjException(e);
        }
    }

    public final void dm(boolean z) {
        this.cgt = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.cgs = 0;
        this.offset = 0;
        InputStream inputStream = this.bRR;
        if (inputStream != null && this.cgt) {
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(inputStream);
        }
        this.bRR = null;
    }
}
