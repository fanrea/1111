package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteOutput;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class ChannelBufferByteOutput implements ByteOutput {
    private final ByteBuf buffer;

    public void close() {
    }

    public void flush() {
    }

    ChannelBufferByteOutput(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    public void write(int i) {
        this.buffer.writeByte(i);
    }

    public void write(byte[] bArr) {
        this.buffer.writeBytes(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.buffer.writeBytes(bArr, i, i2);
    }

    ByteBuf getBuffer() {
        return this.buffer;
    }
}
