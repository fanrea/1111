package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class f implements Closeable {
    static final Logger logger = Logger.getLogger(c.class.getName());
    private final boolean BZ;
    private final a CG;
    final b.a CH;
    private final BufferedSource source;

    interface b {
        void a(int i, ByteString byteString);

        void a(boolean z, int i, List<okhttp3.internal.http2.a> list);

        void a(boolean z, int i, BufferedSource bufferedSource, int i2);

        void a(boolean z, l lVar);

        void b(int i, List<okhttp3.internal.http2.a> list);

        void b(boolean z, int i, int i2);

        void c(int i, long j);

        void d(int i, ErrorCode errorCode);
    }

    public f(BufferedSource bufferedSource, boolean z) {
        this.source = bufferedSource;
        this.BZ = z;
        this.CG = new a(this.source);
        this.CH = new b.a(4096, this.CG);
    }

    public final void a(b bVar) throws IOException {
        if (this.BZ) {
            if (!a(true, bVar)) {
                throw c.c("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        ByteString byteString = this.source.readByteString(c.BI.size());
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(okhttp3.internal.c.format("<< CONNECTION %s", byteString.hex()));
        }
        if (!c.BI.equals(byteString)) {
            throw c.c("Expected a connection header but was %s", byteString.utf8());
        }
    }

    public final boolean a(boolean z, b bVar) throws IOException {
        try {
            this.source.require(9L);
            int iA = a(this.source);
            if (iA < 0 || iA > 16384) {
                throw c.c("FRAME_SIZE_ERROR: %s", Integer.valueOf(iA));
            }
            byte b2 = (byte) (this.source.readByte() & 255);
            if (z && b2 != 4) {
                throw c.c("Expected a SETTINGS frame but was %s", Byte.valueOf(b2));
            }
            byte b3 = (byte) (this.source.readByte() & 255);
            int i = this.source.readInt() & Integer.MAX_VALUE;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(c.a(true, i, iA, b2, b3));
            }
            switch (b2) {
                case 0:
                    b(bVar, iA, b3, i);
                    return true;
                case 1:
                    a(bVar, iA, b3, i);
                    return true;
                case 2:
                    a(bVar, iA, i);
                    return true;
                case 3:
                    b(bVar, iA, i);
                    return true;
                case 4:
                    c(bVar, iA, b3, i);
                    return true;
                case 5:
                    d(bVar, iA, b3, i);
                    return true;
                case 6:
                    e(bVar, iA, b3, i);
                    return true;
                case 7:
                    c(bVar, iA, i);
                    return true;
                case 8:
                    d(bVar, iA, i);
                    return true;
                default:
                    this.source.skip(iA);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw c.c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        if ((b2 & 32) != 0) {
            a(bVar, i2);
            i -= 5;
        }
        bVar.a(z, i2, a(a(i, b2, s), s, b2, i2));
    }

    private List<okhttp3.internal.http2.a> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.CG;
        aVar.left = i;
        aVar.length = i;
        aVar.CK = s;
        aVar.CI = b2;
        aVar.CJ = i2;
        this.CH.gL();
        return this.CH.gM();
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            throw c.c("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        bVar.a(z, i2, this.source, a(i, b2, s));
        this.source.skip(s);
    }

    private void a(b bVar, int i, int i2) throws IOException {
        if (i != 5) {
            throw c.c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw c.c("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        a(bVar, i2);
    }

    private void a(b bVar, int i) throws IOException {
        this.source.readInt();
        this.source.readByte();
    }

    private void b(b bVar, int i, int i2) throws IOException {
        if (i != 4) {
            throw c.c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw c.c("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i3 = this.source.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i3);
        if (errorCodeFromHttp2 == null) {
            throw c.c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i3));
        }
        bVar.d(i2, errorCodeFromHttp2);
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            throw c.c("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i != 0) {
                throw c.c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            return;
        }
        if (i % 6 != 0) {
            throw c.c("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        l lVar = new l();
        for (int i3 = 0; i3 < i; i3 += 6) {
            short s = this.source.readShort();
            int i4 = this.source.readInt();
            if (s != 1) {
                if (s == 2) {
                    if (i4 != 0 && i4 != 1) {
                        throw c.c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                } else if (s == 3) {
                    s = 4;
                } else if (s == 4) {
                    s = 7;
                    if (i4 < 0) {
                        throw c.c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                } else if (s == 5 && (i4 < 16384 || i4 > 16777215)) {
                    throw c.c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i4));
                }
            }
            lVar.Y(s, i4);
        }
        bVar.a(false, lVar);
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw c.c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        bVar.b(this.source.readInt() & Integer.MAX_VALUE, a(a(i - 4, b2, s), s, b2, i2));
    }

    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            throw c.c("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw c.c("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.b((b2 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private void c(b bVar, int i, int i2) throws IOException {
        if (i < 8) {
            throw c.c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw c.c("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i3 = this.source.readInt();
        int i4 = this.source.readInt();
        int i5 = i - 8;
        if (ErrorCode.fromHttp2(i4) == null) {
            throw c.c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i4));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i5 > 0) {
            byteString = this.source.readByteString(i5);
        }
        bVar.a(i3, byteString);
    }

    private void d(b bVar, int i, int i2) throws IOException {
        if (i != 4) {
            throw c.c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long j = this.source.readInt() & 2147483647L;
        if (j == 0) {
            throw c.c("windowSizeIncrement was 0", Long.valueOf(j));
        }
        bVar.c(i2, j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.source.close();
    }

    static final class a implements Source {
        byte CI;
        int CJ;
        short CK;
        int left;
        int length;
        private final BufferedSource source;

        public a(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }
    }

    private static int a(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw c.c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
