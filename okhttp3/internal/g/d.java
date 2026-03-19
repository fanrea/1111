package okhttp3.internal.g;

import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class d {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final BufferedSink AD;
    final Random DV;
    final byte[] EA;
    final byte[] EB;
    boolean EC;
    final Buffer ED = new Buffer();
    final a EE = new a();
    boolean EF;
    final boolean Es;

    d(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        }
        if (random == null) {
            throw new NullPointerException("random == null");
        }
        this.Es = z;
        this.AD = bufferedSink;
        this.DV = random;
        this.EA = z ? new byte[4] : null;
        this.EB = z ? new byte[8192] : null;
    }

    final void f(ByteString byteString) {
        synchronized (this) {
            c(9, byteString);
        }
    }

    final void g(ByteString byteString) {
        synchronized (this) {
            c(10, byteString);
        }
    }

    final void b(int i, ByteString byteString) {
        ByteString byteString2 = ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                b.bK(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        synchronized (this) {
            try {
                try {
                    c(8, byteString2);
                } finally {
                    this.EC = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void c(int i, ByteString byteString) throws IOException {
        if (this.EC) {
            throw new IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.AD.writeByte(i | 128);
        if (this.Es) {
            this.AD.writeByte(size | 128);
            this.DV.nextBytes(this.EA);
            this.AD.write(this.EA);
            byte[] byteArray = byteString.toByteArray();
            b.a(byteArray, byteArray.length, this.EA, 0L);
            this.AD.write(byteArray);
        } else {
            this.AD.writeByte(size);
            this.AD.write(byteString);
        }
        this.AD.flush();
    }

    final Sink e(int i, long j) {
        if (this.EF) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.EF = true;
        a aVar = this.EE;
        aVar.Eq = i;
        aVar.contentLength = j;
        aVar.EG = true;
        aVar.closed = false;
        return aVar;
    }

    final class a implements Sink {
        boolean EG;
        int Eq;
        boolean closed;
        long contentLength;

        a() {
        }
    }
}
