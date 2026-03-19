package okhttp3.internal.g;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class c {
    final byte[] EA = new byte[4];
    final byte[] EB = new byte[8192];
    final boolean Es;
    final a Et;
    int Eu;
    long Ev;
    long Ew;
    boolean Ex;
    boolean Ey;
    boolean Ez;
    boolean closed;
    final BufferedSource source;

    public interface a {
        void H(String str);

        void b(int i, String str);

        void d(ByteString byteString);

        void e(ByteString byteString);

        void hu();
    }

    c(boolean z, BufferedSource bufferedSource, a aVar) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.Es = z;
        this.source = bufferedSource;
        this.Et = aVar;
    }

    final void hy() throws IOException {
        hz();
        if (this.Ey) {
            hA();
        } else {
            hB();
        }
    }

    /* JADX WARN: Finally extract failed */
    private void hz() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.source.getTimeout().getTimeoutNanos();
        this.source.getTimeout().clearTimeout();
        try {
            int i = this.source.readByte() & 255;
            this.source.getTimeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            this.Eu = i & 15;
            this.Ex = (i & 128) != 0;
            this.Ey = (i & 8) != 0;
            if (this.Ey && !this.Ex) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z = (i & 64) != 0;
            boolean z2 = (i & 32) != 0;
            boolean z3 = (i & 16) != 0;
            if (z || z2 || z3) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            this.Ez = ((this.source.readByte() & 255) & 128) != 0;
            boolean z4 = this.Ez;
            boolean z5 = this.Es;
            if (z4 == z5) {
                throw new ProtocolException(z5 ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            this.Ev = r0 & 127;
            long j = this.Ev;
            if (j == 126) {
                this.Ev = this.source.readShort() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            } else if (j == 127) {
                this.Ev = this.source.readLong();
                if (this.Ev < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.Ev) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            this.Ew = 0L;
            if (this.Ey && this.Ev > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (this.Ez) {
                this.source.readFully(this.EA);
            }
        } catch (Throwable th) {
            this.source.getTimeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void hA() throws IOException {
        String utf8;
        Buffer buffer = new Buffer();
        long j = this.Ew;
        long j2 = this.Ev;
        if (j < j2) {
            if (!this.Es) {
                while (true) {
                    long j3 = this.Ew;
                    long j4 = this.Ev;
                    if (j3 >= j4) {
                        break;
                    }
                    int i = this.source.read(this.EB, 0, (int) Math.min(j4 - j3, this.EB.length));
                    if (i == -1) {
                        throw new EOFException();
                    }
                    long j5 = i;
                    b.a(this.EB, j5, this.EA, this.Ew);
                    buffer.write(this.EB, 0, i);
                    this.Ew += j5;
                }
            } else {
                this.source.readFully(buffer, j2);
            }
        }
        switch (this.Eu) {
            case 8:
                short s = 1005;
                long size = buffer.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s = buffer.readShort();
                    utf8 = buffer.readUtf8();
                    String strBJ = b.bJ(s);
                    if (strBJ != null) {
                        throw new ProtocolException(strBJ);
                    }
                } else {
                    utf8 = "";
                }
                this.Et.b(s, utf8);
                this.closed = true;
                return;
            case 9:
                this.Et.e(buffer.readByteString());
                return;
            case 10:
                a aVar = this.Et;
                buffer.readByteString();
                aVar.hu();
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.Eu));
        }
    }

    private void hB() throws IOException {
        int i = this.Eu;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
        Buffer buffer = new Buffer();
        a(buffer);
        if (i == 1) {
            this.Et.H(buffer.readUtf8());
        } else {
            this.Et.d(buffer.readByteString());
        }
    }

    private void hC() throws IOException {
        while (!this.closed) {
            hz();
            if (!this.Ey) {
                return;
            } else {
                hA();
            }
        }
    }

    private void a(Buffer buffer) throws IOException {
        long j;
        while (!this.closed) {
            if (this.Ew == this.Ev) {
                if (this.Ex) {
                    return;
                }
                hC();
                if (this.Eu != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.Eu));
                }
                if (this.Ex && this.Ev == 0) {
                    return;
                }
            }
            long j2 = this.Ev - this.Ew;
            if (this.Ez) {
                j = this.source.read(this.EB, 0, (int) Math.min(j2, this.EB.length));
                if (j == -1) {
                    throw new EOFException();
                }
                b.a(this.EB, j, this.EA, this.Ew);
                buffer.write(this.EB, 0, (int) j);
            } else {
                j = this.source.read(buffer, j2);
                if (j == -1) {
                    throw new EOFException();
                }
            }
            this.Ew += j;
        }
        throw new IOException("closed");
    }
}
