package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class Bzip2BitWriter {
    private long bitBuffer;
    private int bitCount;

    Bzip2BitWriter() {
    }

    final void writeBits(ByteBuf byteBuf, int i, long j) {
        if (i < 0 || i > 32) {
            throw new IllegalArgumentException("count: " + i + " (expected: 0-32)");
        }
        int i2 = this.bitCount;
        long j2 = ((j << (64 - i)) >>> i2) | this.bitBuffer;
        int i3 = i2 + i;
        if (i3 >= 32) {
            byteBuf.writeInt((int) (j2 >>> 32));
            j2 <<= 32;
            i3 -= 32;
        }
        this.bitBuffer = j2;
        this.bitCount = i3;
    }

    final void writeBoolean(ByteBuf byteBuf, boolean z) {
        int i = this.bitCount + 1;
        long j = this.bitBuffer | (z ? 1 << (64 - i) : 0L);
        if (i == 32) {
            byteBuf.writeInt((int) (j >>> 32));
            i = 0;
            j = 0;
        }
        this.bitBuffer = j;
        this.bitCount = i;
    }

    final void writeUnary(ByteBuf byteBuf, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("value: " + i + " (expected 0 or more)");
        }
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                writeBoolean(byteBuf, true);
                i = i2;
            } else {
                writeBoolean(byteBuf, false);
                return;
            }
        }
    }

    final void writeInt(ByteBuf byteBuf, int i) {
        writeBits(byteBuf, 32, i);
    }

    final void flush(ByteBuf byteBuf) {
        int i = this.bitCount;
        if (i > 0) {
            long j = this.bitBuffer;
            int i2 = 64 - i;
            if (i <= 8) {
                byteBuf.writeByte((int) ((j >>> i2) << (8 - i)));
                return;
            }
            if (i <= 16) {
                byteBuf.writeShort((int) ((j >>> i2) << (16 - i)));
            } else if (i <= 24) {
                byteBuf.writeMedium((int) ((j >>> i2) << (24 - i)));
            } else {
                byteBuf.writeInt((int) ((j >>> i2) << (32 - i)));
            }
        }
    }
}
