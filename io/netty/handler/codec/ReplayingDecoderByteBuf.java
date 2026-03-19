package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ByteProcessor;
import io.netty.util.Signal;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class ReplayingDecoderByteBuf extends ByteBuf {
    static final ReplayingDecoderByteBuf EMPTY_BUFFER;
    private static final Signal REPLAY = ReplayingDecoder.REPLAY;
    private ByteBuf buffer;
    private SwappedByteBuf swapped;
    private boolean terminated;

    @Override // io.netty.buffer.ByteBuf
    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isWritable() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isWritable(int i) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int maxWritableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writableBytes() {
        return 0;
    }

    static {
        ReplayingDecoderByteBuf replayingDecoderByteBuf = new ReplayingDecoderByteBuf(Unpooled.EMPTY_BUFFER);
        EMPTY_BUFFER = replayingDecoderByteBuf;
        replayingDecoderByteBuf.terminate();
    }

    ReplayingDecoderByteBuf() {
    }

    ReplayingDecoderByteBuf(ByteBuf byteBuf) {
        setCumulation(byteBuf);
    }

    final void setCumulation(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    final void terminate() {
        this.terminated = true;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int capacity() {
        if (this.terminated) {
            return this.buffer.capacity();
        }
        return Integer.MAX_VALUE;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf capacity(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int maxCapacity() {
        return capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.buffer.alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return this.buffer.isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public final byte[] array() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf clear() {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public final int compareTo(ByteBuf byteBuf) {
        reject();
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf copy() {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.copy(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf discardReadBytes() {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf ensureWritable(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int ensureWritable(int i, boolean z) {
        reject();
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf duplicate() {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean getBoolean(int i) {
        checkIndex(i, 1);
        return this.buffer.getBoolean(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final byte getByte(int i) {
        checkIndex(i, 1);
        return this.buffer.getByte(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final short getUnsignedByte(int i) {
        checkIndex(i, 1);
        return this.buffer.getUnsignedByte(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.getBytes(i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, byte[] bArr) {
        checkIndex(i, bArr.length);
        this.buffer.getBytes(i, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkIndex(i, i3);
        this.buffer.getBytes(i, byteBuf, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuf byteBuf, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuf byteBuf) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        reject();
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, OutputStream outputStream, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getInt(int i) {
        checkIndex(i, 4);
        return this.buffer.getInt(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getIntLE(int i) {
        checkIndex(i, 4);
        return this.buffer.getIntLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final long getUnsignedInt(int i) {
        checkIndex(i, 4);
        return this.buffer.getUnsignedInt(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final long getUnsignedIntLE(int i) {
        checkIndex(i, 4);
        return this.buffer.getUnsignedIntLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final long getLong(int i) {
        checkIndex(i, 8);
        return this.buffer.getLong(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final long getLongLE(int i) {
        checkIndex(i, 8);
        return this.buffer.getLongLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getMedium(int i) {
        checkIndex(i, 3);
        return this.buffer.getMedium(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getMediumLE(int i) {
        checkIndex(i, 3);
        return this.buffer.getMediumLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getUnsignedMedium(int i) {
        checkIndex(i, 3);
        return this.buffer.getUnsignedMedium(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getUnsignedMediumLE(int i) {
        checkIndex(i, 3);
        return this.buffer.getUnsignedMediumLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final short getShort(int i) {
        checkIndex(i, 2);
        return this.buffer.getShort(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final short getShortLE(int i) {
        checkIndex(i, 2);
        return this.buffer.getShortLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getUnsignedShort(int i) {
        checkIndex(i, 2);
        return this.buffer.getUnsignedShort(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getUnsignedShortLE(int i) {
        checkIndex(i, 2);
        return this.buffer.getUnsignedShortLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final char getChar(int i) {
        checkIndex(i, 2);
        return this.buffer.getChar(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final float getFloat(int i) {
        checkIndex(i, 4);
        return this.buffer.getFloat(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final double getDouble(int i) {
        checkIndex(i, 8);
        return this.buffer.getDouble(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int hashCode() {
        reject();
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int indexOf(int i, int i2, byte b) {
        if (i == i2) {
            return -1;
        }
        if (Math.max(i, i2) > this.buffer.writerIndex()) {
            throw REPLAY;
        }
        return this.buffer.indexOf(i, i2, b);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int bytesBefore(byte b) {
        int iBytesBefore = this.buffer.bytesBefore(b);
        if (iBytesBefore >= 0) {
            return iBytesBefore;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int bytesBefore(int i, byte b) {
        return bytesBefore(this.buffer.readerIndex(), i, b);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int bytesBefore(int i, int i2, byte b) {
        int iWriterIndex = this.buffer.writerIndex();
        if (i >= iWriterIndex) {
            throw REPLAY;
        }
        if (i <= iWriterIndex - i2) {
            return this.buffer.bytesBefore(i, i2, b);
        }
        int iBytesBefore = this.buffer.bytesBefore(i, iWriterIndex - i, b);
        if (iBytesBefore >= 0) {
            return iBytesBefore;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int forEachByte(ByteProcessor byteProcessor) {
        int iForEachByte = this.buffer.forEachByte(byteProcessor);
        if (iForEachByte >= 0) {
            return iForEachByte;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        int iWriterIndex = this.buffer.writerIndex();
        if (i >= iWriterIndex) {
            throw REPLAY;
        }
        if (i <= iWriterIndex - i2) {
            return this.buffer.forEachByte(i, i2, byteProcessor);
        }
        int iForEachByte = this.buffer.forEachByte(i, iWriterIndex - i, byteProcessor);
        if (iForEachByte >= 0) {
            return iForEachByte;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int forEachByteDesc(ByteProcessor byteProcessor) {
        if (this.terminated) {
            return this.buffer.forEachByteDesc(byteProcessor);
        }
        reject();
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        if (i + i2 > this.buffer.writerIndex()) {
            throw REPLAY;
        }
        return this.buffer.forEachByteDesc(i, i2, byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf markReaderIndex() {
        this.buffer.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf markWriterIndex() {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return this.buffer.order();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (byteOrder == order()) {
            return this;
        }
        SwappedByteBuf swappedByteBuf = this.swapped;
        if (swappedByteBuf != null) {
            return swappedByteBuf;
        }
        SwappedByteBuf swappedByteBuf2 = new SwappedByteBuf(this);
        this.swapped = swappedByteBuf2;
        return swappedByteBuf2;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isReadable() {
        if (this.terminated) {
            return this.buffer.isReadable();
        }
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isReadable(int i) {
        if (this.terminated) {
            return this.buffer.isReadable(i);
        }
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readableBytes() {
        if (this.terminated) {
            return this.buffer.readableBytes();
        }
        return Integer.MAX_VALUE - this.buffer.readerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean readBoolean() {
        checkReadableBytes(1);
        return this.buffer.readBoolean();
    }

    @Override // io.netty.buffer.ByteBuf
    public final byte readByte() {
        checkReadableBytes(1);
        return this.buffer.readByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public final short readUnsignedByte() {
        checkReadableBytes(1);
        return this.buffer.readUnsignedByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(byte[] bArr, int i, int i2) {
        checkReadableBytes(i2);
        this.buffer.readBytes(bArr, i, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(byte[] bArr) {
        checkReadableBytes(bArr.length);
        this.buffer.readBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(ByteBuffer byteBuffer) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(ByteBuf byteBuf, int i, int i2) {
        checkReadableBytes(i2);
        this.buffer.readBytes(byteBuf, i, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(ByteBuf byteBuf, int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(ByteBuf byteBuf) {
        checkReadableBytes(byteBuf.writableBytes());
        this.buffer.readBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readBytes(GatheringByteChannel gatheringByteChannel, int i) {
        reject();
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(int i) {
        checkReadableBytes(i);
        return this.buffer.readBytes(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readSlice(int i) {
        checkReadableBytes(i);
        return this.buffer.readSlice(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(OutputStream outputStream, int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readerIndex() {
        return this.buffer.readerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readerIndex(int i) {
        this.buffer.readerIndex(i);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readInt() {
        checkReadableBytes(4);
        return this.buffer.readInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readIntLE() {
        checkReadableBytes(4);
        return this.buffer.readIntLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long readUnsignedInt() {
        checkReadableBytes(4);
        return this.buffer.readUnsignedInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long readUnsignedIntLE() {
        checkReadableBytes(4);
        return this.buffer.readUnsignedIntLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long readLong() {
        checkReadableBytes(8);
        return this.buffer.readLong();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long readLongLE() {
        checkReadableBytes(8);
        return this.buffer.readLongLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readMedium() {
        checkReadableBytes(3);
        return this.buffer.readMedium();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readMediumLE() {
        checkReadableBytes(3);
        return this.buffer.readMediumLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readUnsignedMedium() {
        checkReadableBytes(3);
        return this.buffer.readUnsignedMedium();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readUnsignedMediumLE() {
        checkReadableBytes(3);
        return this.buffer.readUnsignedMediumLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public final short readShort() {
        checkReadableBytes(2);
        return this.buffer.readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public final short readShortLE() {
        checkReadableBytes(2);
        return this.buffer.readShortLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readUnsignedShort() {
        checkReadableBytes(2);
        return this.buffer.readUnsignedShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readUnsignedShortLE() {
        checkReadableBytes(2);
        return this.buffer.readUnsignedShortLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public final char readChar() {
        checkReadableBytes(2);
        return this.buffer.readChar();
    }

    @Override // io.netty.buffer.ByteBuf
    public final float readFloat() {
        checkReadableBytes(4);
        return this.buffer.readFloat();
    }

    @Override // io.netty.buffer.ByteBuf
    public final double readDouble() {
        checkReadableBytes(8);
        return this.buffer.readDouble();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf resetReaderIndex() {
        this.buffer.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf resetWriterIndex() {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBoolean(int i, boolean z) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setByte(int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, byte[] bArr) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuf byteBuf, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuf byteBuf) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i, InputStream inputStream, int i2) {
        reject();
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setZero(int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        reject();
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setIndex(int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setInt(int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setIntLE(int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setLong(int i, long j) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setLongLE(int i, long j) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setMedium(int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setMediumLE(int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setShort(int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setShortLE(int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setChar(int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setFloat(int i, float f) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setDouble(int i, double d) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf skipBytes(int i) {
        checkReadableBytes(i);
        this.buffer.skipBytes(i);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf slice() {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf slice(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.slice(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return this.buffer.nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer() {
        reject();
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.nioBuffer(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers() {
        reject();
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.nioBuffers(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int i, int i2) {
        checkIndex(i, i2);
        return this.buffer.internalNioBuffer(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final String toString(int i, int i2, Charset charset) {
        checkIndex(i, i2);
        return this.buffer.toString(i, i2, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public final String toString(Charset charset) {
        reject();
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public final String toString() {
        return StringUtil.simpleClassName(this) + "(ridx=" + readerIndex() + ", widx=" + writerIndex() + ')';
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBoolean(boolean z) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeByte(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(byte[] bArr, int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(byte[] bArr) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(ByteBuffer byteBuffer) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(ByteBuf byteBuf, int i, int i2) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(ByteBuf byteBuf, int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(ByteBuf byteBuf) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writeBytes(InputStream inputStream, int i) {
        reject();
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writeBytes(ScatteringByteChannel scatteringByteChannel, int i) {
        reject();
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeInt(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeIntLE(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeLong(long j) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeLongLE(long j) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeMedium(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeMediumLE(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeZero(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writerIndex() {
        return this.buffer.writerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writerIndex(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeShort(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeShortLE(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeChar(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeFloat(float f) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeDouble(double d) {
        reject();
        return this;
    }

    private void checkIndex(int i, int i2) {
        if (i + i2 > this.buffer.writerIndex()) {
            throw REPLAY;
        }
    }

    private void checkReadableBytes(int i) {
        if (this.buffer.readableBytes() < i) {
            throw REPLAY;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf discardSomeReadBytes() {
        reject();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.buffer.refCnt();
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf retain() {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf retain(int i) {
        reject();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf touch() {
        this.buffer.touch();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf touch(Object obj) {
        this.buffer.touch(obj);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release() {
        reject();
        return false;
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release(int i) {
        reject();
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        reject();
        return this;
    }

    private static void reject() {
        throw new UnsupportedOperationException("not a replayable operation");
    }
}
