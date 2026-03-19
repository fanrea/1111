package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class ChannelBufferByteInput implements ByteInput {
    private final ByteBuf buffer;

    public void close() {
    }

    ChannelBufferByteInput(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    public int available() {
        return this.buffer.readableBytes();
    }

    public int read() {
        if (this.buffer.isReadable()) {
            return this.buffer.readByte() & 255;
        }
        return -1;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        int iAvailable = available();
        if (iAvailable == 0) {
            return -1;
        }
        int iMin = Math.min(iAvailable, i2);
        this.buffer.readBytes(bArr, i, iMin);
        return iMin;
    }

    public long skip(long j) {
        long j2 = this.buffer.readableBytes();
        if (j2 < j) {
            j = j2;
        }
        this.buffer.readerIndex((int) (r0.readerIndex() + j));
        return j;
    }
}
