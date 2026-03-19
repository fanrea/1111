package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class EmptyByteBuf extends ByteBuf {
    private static final ByteBuffer EMPTY_BYTE_BUFFER = ByteBuffer.allocateDirect(0);
    private static final long EMPTY_BYTE_BUFFER_ADDRESS;
    private final ByteBufAllocator alloc;
    private final ByteOrder order;
    private final String str;
    private EmptyByteBuf swapped;

    @Override // io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int bytesBefore(byte b) {
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int capacity() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf clear() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf copy() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf discardReadBytes() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf discardSomeReadBytes() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf duplicate() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int forEachByte(ByteProcessor byteProcessor) {
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int forEachByteDesc(ByteProcessor byteProcessor) {
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int hashCode() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isReadable() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isReadable(int i) {
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
    public final ByteBuf markReaderIndex() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf markWriterIndex() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int maxCapacity() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int maxWritableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readerIndex() {
        return 0;
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return 1;
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release() {
        return false;
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release(int i) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf resetReaderIndex() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf resetWriterIndex() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf retain() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf retain(int i) {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf slice() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final String toString(Charset charset) {
        return "";
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf touch() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writerIndex() {
        return 0;
    }

    static {
        long jDirectBufferAddress = 0;
        try {
            if (PlatformDependent.hasUnsafe()) {
                jDirectBufferAddress = PlatformDependent.directBufferAddress(EMPTY_BYTE_BUFFER);
            }
        } catch (Throwable unused) {
        }
        EMPTY_BYTE_BUFFER_ADDRESS = jDirectBufferAddress;
    }

    public EmptyByteBuf(ByteBufAllocator byteBufAllocator) {
        this(byteBufAllocator, ByteOrder.BIG_ENDIAN);
    }

    private EmptyByteBuf(ByteBufAllocator byteBufAllocator, ByteOrder byteOrder) {
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        this.alloc = byteBufAllocator;
        this.order = byteOrder;
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append(byteOrder == ByteOrder.BIG_ENDIAN ? "BE" : "LE");
        this.str = sb.toString();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf capacity(int i) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return this.order;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (byteOrder == order()) {
            return this;
        }
        EmptyByteBuf emptyByteBuf = this.swapped;
        if (emptyByteBuf != null) {
            return emptyByteBuf;
        }
        EmptyByteBuf emptyByteBuf2 = new EmptyByteBuf(alloc(), byteOrder);
        this.swapped = emptyByteBuf2;
        return emptyByteBuf2;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readerIndex(int i) {
        return checkIndex(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writerIndex(int i) {
        return checkIndex(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setIndex(int i, int i2) {
        checkIndex(i);
        checkIndex(i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf ensureWritable(int i) {
        if (i >= 0) {
            if (i == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("minWritableBytes: " + i + " (expected: >= 0)");
    }

    @Override // io.netty.buffer.ByteBuf
    public final int ensureWritable(int i, boolean z) {
        if (i >= 0) {
            return i == 0 ? 0 : 1;
        }
        throw new IllegalArgumentException("minWritableBytes: " + i + " (expected: >= 0)");
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean getBoolean(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final byte getByte(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final short getUnsignedByte(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final short getShort(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final short getShortLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getUnsignedShort(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getUnsignedShortLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getMedium(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getMediumLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getUnsignedMedium(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getUnsignedMediumLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getInt(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getIntLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long getUnsignedInt(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long getUnsignedIntLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long getLong(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long getLongLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final char getChar(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final float getFloat(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final double getDouble(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuf byteBuf) {
        return checkIndex(i, byteBuf.writableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuf byteBuf, int i2) {
        return checkIndex(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        return checkIndex(i, i3);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, byte[] bArr) {
        return checkIndex(i, bArr.length);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        return checkIndex(i, i3);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        return checkIndex(i, byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, OutputStream outputStream, int i2) {
        return checkIndex(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        checkIndex(i, i2);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBoolean(int i, boolean z) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setByte(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setShort(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setShortLE(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setMedium(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setMediumLE(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setInt(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setIntLE(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setLong(int i, long j) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setLongLE(int i, long j) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setChar(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setFloat(int i, float f) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setDouble(int i, double d) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuf byteBuf) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuf byteBuf, int i2) {
        return checkIndex(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        return checkIndex(i, i3);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, byte[] bArr) {
        return checkIndex(i, bArr.length);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        return checkIndex(i, i3);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        return checkIndex(i, byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i, InputStream inputStream, int i2) {
        checkIndex(i, i2);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        checkIndex(i, i2);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setZero(int i, int i2) {
        return checkIndex(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean readBoolean() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final byte readByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final short readUnsignedByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final short readShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final short readShortLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readUnsignedShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readUnsignedShortLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readMedium() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readMediumLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readUnsignedMedium() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readUnsignedMediumLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readIntLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long readUnsignedInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long readUnsignedIntLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long readLong() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long readLongLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final char readChar() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final float readFloat() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final double readDouble() {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(int i) {
        return checkLength(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readSlice(int i) {
        return checkLength(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(ByteBuf byteBuf) {
        return checkLength(byteBuf.writableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(ByteBuf byteBuf, int i) {
        return checkLength(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(ByteBuf byteBuf, int i, int i2) {
        return checkLength(i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(byte[] bArr) {
        return checkLength(bArr.length);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(byte[] bArr, int i, int i2) {
        return checkLength(i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(ByteBuffer byteBuffer) {
        return checkLength(byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(OutputStream outputStream, int i) {
        return checkLength(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readBytes(GatheringByteChannel gatheringByteChannel, int i) {
        checkLength(i);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf skipBytes(int i) {
        return checkLength(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBoolean(boolean z) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeByte(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeShort(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeShortLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeMedium(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeMediumLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeInt(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeIntLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeLong(long j) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeLongLE(long j) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeChar(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeFloat(float f) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeDouble(double d) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(ByteBuf byteBuf) {
        throw new IndexOutOfBoundsException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(ByteBuf byteBuf, int i) {
        return checkLength(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(ByteBuf byteBuf, int i, int i2) {
        return checkLength(i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(byte[] bArr) {
        return checkLength(bArr.length);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(byte[] bArr, int i, int i2) {
        return checkLength(i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeBytes(ByteBuffer byteBuffer) {
        return checkLength(byteBuffer.remaining());
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writeBytes(InputStream inputStream, int i) {
        checkLength(i);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writeBytes(ScatteringByteChannel scatteringByteChannel, int i) {
        checkLength(i);
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writeZero(int i) {
        return checkLength(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int indexOf(int i, int i2, byte b) {
        checkIndex(i);
        checkIndex(i2);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int bytesBefore(int i, byte b) {
        checkLength(i);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int bytesBefore(int i, int i2, byte b) {
        checkIndex(i, i2);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex(i, i2);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex(i, i2);
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf copy(int i, int i2) {
        return checkIndex(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf slice(int i, int i2) {
        return checkIndex(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer() {
        return EMPTY_BYTE_BUFFER;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        return nioBuffer();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers() {
        return new ByteBuffer[]{EMPTY_BYTE_BUFFER};
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers(int i, int i2) {
        checkIndex(i, i2);
        return nioBuffers();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int i, int i2) {
        return EMPTY_BYTE_BUFFER;
    }

    @Override // io.netty.buffer.ByteBuf
    public final byte[] array() {
        return EmptyArrays.EMPTY_BYTES;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return EMPTY_BYTE_BUFFER_ADDRESS != 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        if (hasMemoryAddress()) {
            return EMPTY_BYTE_BUFFER_ADDRESS;
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final String toString(int i, int i2, Charset charset) {
        checkIndex(i, i2);
        return toString(charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean equals(Object obj) {
        return (obj instanceof ByteBuf) && !((ByteBuf) obj).isReadable();
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public final int compareTo(ByteBuf byteBuf) {
        return byteBuf.isReadable() ? -1 : 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public final String toString() {
        return this.str;
    }

    private ByteBuf checkIndex(int i) {
        if (i == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    private ByteBuf checkIndex(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("length: " + i2);
        }
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    private ByteBuf checkLength(int i) {
        if (i >= 0) {
            if (i == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("length: " + i + " (expected: >= 0)");
    }
}
