package com.bytedance.sdk.component.b.hc.d.u;

import com.bytedance.sdk.component.b.hc.d.u.c;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class tc implements Closeable {
    private static final Logger hc = Logger.getLogger(u.class.getName());
    private int an;
    private final com.bytedance.sdk.component.b.d.c b;
    private final boolean c;
    final c.hc d;
    private boolean h;
    private final com.bytedance.sdk.component.b.d.b u;

    tc(com.bytedance.sdk.component.b.d.c cVar, boolean z) {
        this.b = cVar;
        this.c = z;
        com.bytedance.sdk.component.b.d.b bVar = new com.bytedance.sdk.component.b.d.b();
        this.u = bVar;
        this.d = new c.hc(bVar);
        this.an = 16384;
    }

    public synchronized void d() throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        if (this.c) {
            Logger logger = hc;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(com.bytedance.sdk.component.b.hc.d.b.d(">> CONNECTION %s", u.d.u()));
            }
            this.b.b(u.d.gb());
            this.b.flush();
        }
    }

    public synchronized void d(k kVar) throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        this.an = kVar.c(this.an);
        if (kVar.b() != -1) {
            this.d.d(kVar.b());
        }
        d(0, 0, (byte) 4, (byte) 1);
        this.b.flush();
    }

    public synchronized void d(int i, int i2, List<b> list) throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        this.d.d(list);
        long jHc = this.u.hc();
        int iMin = (int) Math.min(this.an - 4, jHc);
        long j = iMin;
        d(i, iMin + 4, (byte) 5, jHc == j ? (byte) 4 : (byte) 0);
        this.b.h(i2 & Integer.MAX_VALUE);
        this.b.a_(this.u, j);
        if (jHc > j) {
            hc(i, jHc - j);
        }
    }

    public synchronized void hc() throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        this.b.flush();
    }

    public synchronized void d(boolean z, int i, int i2, List<b> list) throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        d(z, i, list);
    }

    public synchronized void d(int i, hc hcVar) throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        if (hcVar.h == -1) {
            throw new IllegalArgumentException();
        }
        d(i, 4, (byte) 3, (byte) 0);
        this.b.h(hcVar.h);
        this.b.flush();
    }

    public int b() {
        return this.an;
    }

    public synchronized void d(boolean z, int i, com.bytedance.sdk.component.b.d.b bVar, int i2) throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        d(i, z ? (byte) 1 : (byte) 0, bVar, i2);
    }

    void d(int i, byte b, com.bytedance.sdk.component.b.d.b bVar, int i2) throws IOException {
        d(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.b.a_(bVar, i2);
        }
    }

    public synchronized void hc(k kVar) throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        int i = 0;
        d(0, kVar.hc() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (kVar.d(i)) {
                this.b.gb(i == 4 ? 3 : i == 7 ? 4 : i);
                this.b.h(kVar.hc(i));
            }
            i++;
        }
        this.b.flush();
    }

    public synchronized void d(boolean z, int i, int i2) throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        d(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.b.h(i);
        this.b.h(i2);
        this.b.flush();
    }

    public synchronized void d(int i, hc hcVar, byte[] bArr) throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        if (hcVar.h == -1) {
            throw u.d("errorCode.httpCode == -1", new Object[0]);
        }
        d(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.b.h(i);
        this.b.h(hcVar.h);
        if (bArr.length > 0) {
            this.b.b(bArr);
        }
        this.b.flush();
    }

    public synchronized void d(int i, long j) throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw u.d("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        d(i, 4, (byte) 8, (byte) 0);
        this.b.h((int) j);
        this.b.flush();
    }

    public void d(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = hc;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(u.d(false, i, i2, b, b2));
        }
        int i3 = this.an;
        if (i2 > i3) {
            throw u.d("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw u.d("reserved bit set: %s", Integer.valueOf(i));
        }
        d(this.b, i2);
        this.b.tt(b & 255);
        this.b.tt(b2 & 255);
        this.b.h(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.h = true;
        this.b.close();
    }

    private static void d(com.bytedance.sdk.component.b.d.c cVar, int i) throws IOException {
        cVar.tt((i >>> 16) & 255);
        cVar.tt((i >>> 8) & 255);
        cVar.tt(i & 255);
    }

    private void hc(int i, long j) throws IOException {
        while (j > 0) {
            int iMin = (int) Math.min(this.an, j);
            long j2 = iMin;
            j -= j2;
            d(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.b.a_(this.u, j2);
        }
    }

    void d(boolean z, int i, List<b> list) throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        this.d.d(list);
        long jHc = this.u.hc();
        int iMin = (int) Math.min(this.an, jHc);
        long j = iMin;
        byte b = jHc == j ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        d(i, iMin, (byte) 1, b);
        this.b.a_(this.u, j);
        if (jHc > j) {
            hc(i, jHc - j);
        }
    }
}
