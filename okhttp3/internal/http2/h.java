package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;
import okio.Buffer;
import okio.BufferedSink;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class h implements Closeable {
    private static final Logger logger = Logger.getLogger(c.class.getName());
    private final BufferedSink AD;
    private final boolean BZ;
    private boolean closed;
    private final Buffer CX = new Buffer();
    final b.C0855b CZ = new b.C0855b(this.CX);
    private int CY = 16384;

    public h(BufferedSink bufferedSink, boolean z) {
        this.AD = bufferedSink;
        this.BZ = z;
    }

    public final synchronized void hc() {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (this.BZ) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(okhttp3.internal.c.format(">> CONNECTION %s", c.BI.hex()));
            }
            this.AD.write(c.BI.toByteArray());
            this.AD.flush();
        }
    }

    public final synchronized void a(l lVar) {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.CY = lVar.bH(this.CY);
        if (lVar.hg() != -1) {
            this.CZ.bB(lVar.hg());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.AD.flush();
    }

    public final synchronized void flush() {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.AD.flush();
    }

    public final synchronized void b(boolean z, int i, List<a> list) {
        if (this.closed) {
            throw new IOException("closed");
        }
        c(z, i, list);
    }

    public final synchronized void d(int i, ErrorCode errorCode) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        a(i, 4, (byte) 3, (byte) 0);
        this.AD.writeInt(errorCode.httpCode);
        this.AD.flush();
    }

    public final synchronized void b(l lVar) {
        if (this.closed) {
            throw new IOException("closed");
        }
        int i = 0;
        a(0, lVar.size() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (lVar.isSet(i)) {
                this.AD.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                this.AD.writeInt(lVar.get(i));
            }
            i++;
        }
        this.AD.flush();
    }

    public final synchronized void b(boolean z, int i, int i2) {
        if (this.closed) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.AD.writeInt(i);
        this.AD.writeInt(i2);
        this.AD.flush();
    }

    public final synchronized void a(int i, ErrorCode errorCode, byte[] bArr) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw c.b("errorCode.httpCode == -1", new Object[0]);
        }
        a(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.AD.writeInt(i);
        this.AD.writeInt(errorCode.httpCode);
        if (bArr.length > 0) {
            this.AD.write(bArr);
        }
        this.AD.flush();
    }

    public final synchronized void c(int i, long j) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw c.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        a(0, 4, (byte) 8, (byte) 0);
        this.AD.writeInt((int) j);
        this.AD.flush();
    }

    private void a(int i, int i2, byte b, byte b2) throws IOException {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(c.a(false, i, i2, b, b2));
        }
        int i3 = this.CY;
        if (i2 > i3) {
            throw c.b("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw c.b("reserved bit set: %s", Integer.valueOf(i));
        }
        a(this.AD, i2);
        this.AD.writeByte(b & 255);
        this.AD.writeByte(b2 & 255);
        this.AD.writeInt(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.closed = true;
        this.AD.close();
    }

    private static void a(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    private void d(int i, long j) throws IOException {
        while (j > 0) {
            int iMin = (int) Math.min(this.CY, j);
            long j2 = iMin;
            j -= j2;
            a(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.AD.write(this.CX, j2);
        }
    }

    private void c(boolean z, int i, List<a> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.CZ.i(list);
        long size = this.CX.size();
        int iMin = (int) Math.min(this.CY, size);
        long j = iMin;
        byte b = size == j ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        a(i, iMin, (byte) 1, b);
        this.AD.write(this.CX, j);
        if (size > j) {
            d(i, size - j);
        }
    }
}
