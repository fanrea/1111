package io.netty.handler.codec.marshalling;

import java.io.IOException;
import org.jboss.marshalling.ByteInput;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class LimitingByteInput implements ByteInput {
    private static final TooBigObjectException EXCEPTION = new TooBigObjectException();
    private final ByteInput input;
    private final long limit;
    private long read;

    public void close() {
    }

    LimitingByteInput(ByteInput byteInput, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("The limit MUST be > 0");
        }
        this.input = byteInput;
        this.limit = j;
    }

    public int available() {
        return readable(this.input.available());
    }

    public int read() throws TooBigObjectException {
        if (readable(1) > 0) {
            int i = this.input.read();
            this.read++;
            return i;
        }
        throw EXCEPTION;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws TooBigObjectException {
        int i3 = readable(i2);
        if (i3 > 0) {
            int i4 = this.input.read(bArr, i, i3);
            this.read += i4;
            return i4;
        }
        throw EXCEPTION;
    }

    public long skip(long j) throws TooBigObjectException {
        int i = readable((int) j);
        if (i > 0) {
            long jSkip = this.input.skip(i);
            this.read += jSkip;
            return jSkip;
        }
        throw EXCEPTION;
    }

    private int readable(int i) {
        return (int) Math.min(i, this.limit - this.read);
    }

    static final class TooBigObjectException extends IOException {
        private static final long serialVersionUID = 1;

        TooBigObjectException() {
        }
    }
}
