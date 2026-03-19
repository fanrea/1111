package io.netty.handler.codec.compression;

import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import io.netty.buffer.ByteBuf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class Bzip2BitReader {
    private static final int MAX_COUNT_OF_READABLE_BYTES = 268435455;
    private long bitBuffer;
    private int bitCount;
    private ByteBuf in;

    Bzip2BitReader() {
    }

    void setByteBuf(ByteBuf byteBuf) {
        this.in = byteBuf;
    }

    int readBits(int i) {
        long unsignedByte;
        int i2;
        if (i < 0 || i > 32) {
            throw new IllegalArgumentException("count: " + i + " (expected: 0-32 )");
        }
        int i3 = this.bitCount;
        long j = this.bitBuffer;
        if (i3 < i) {
            int i4 = this.in.readableBytes();
            if (i4 == 1) {
                unsignedByte = this.in.readUnsignedByte();
                i2 = 8;
            } else if (i4 == 2) {
                unsignedByte = this.in.readUnsignedShort();
                i2 = 16;
            } else if (i4 == 3) {
                unsignedByte = this.in.readUnsignedMedium();
                i2 = 24;
            } else {
                unsignedByte = this.in.readUnsignedInt();
                i2 = 32;
            }
            j = (j << i2) | unsignedByte;
            i3 += i2;
            this.bitBuffer = j;
        }
        int i5 = i3 - i;
        this.bitCount = i5;
        return (int) ((j >>> i5) & (i != 32 ? (1 << i) - 1 : C00oOOo.f362O8oO888));
    }

    boolean readBoolean() {
        return readBits(1) != 0;
    }

    int readInt() {
        return readBits(32);
    }

    void refill() {
        this.bitBuffer = (this.bitBuffer << 8) | this.in.readUnsignedByte();
        this.bitCount += 8;
    }

    boolean isReadable() {
        return this.bitCount > 0 || this.in.isReadable();
    }

    boolean hasReadableBits(int i) {
        if (i >= 0) {
            return this.bitCount >= i || ((this.in.readableBytes() << 3) & Integer.MAX_VALUE) >= i - this.bitCount;
        }
        throw new IllegalArgumentException("count: " + i + " (expected value greater than 0)");
    }

    boolean hasReadableBytes(int i) {
        if (i < 0 || i > MAX_COUNT_OF_READABLE_BYTES) {
            throw new IllegalArgumentException("count: " + i + " (expected: 0-268435455)");
        }
        return hasReadableBits(i << 3);
    }
}
