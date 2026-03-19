package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SlicedByteBuf extends AbstractDerivedByteBuf {
    private final int adjustment;
    private final ByteBuf buffer;
    private final int length;

    public SlicedByteBuf(ByteBuf byteBuf, int i, int i2) {
        super(i2);
        if (i < 0 || i > byteBuf.capacity() - i2) {
            throw new IndexOutOfBoundsException(byteBuf + ".slice(" + i + ", " + i2 + ')');
        }
        if (byteBuf instanceof SlicedByteBuf) {
            SlicedByteBuf slicedByteBuf = (SlicedByteBuf) byteBuf;
            this.buffer = slicedByteBuf.buffer;
            this.adjustment = slicedByteBuf.adjustment + i;
        } else if (byteBuf instanceof DuplicatedByteBuf) {
            this.buffer = byteBuf.unwrap();
            this.adjustment = i;
        } else {
            this.buffer = byteBuf;
            this.adjustment = i;
        }
        this.length = i2;
        writerIndex(i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.buffer.alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.buffer.order();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.length;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.buffer.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.buffer.array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return idx(this.buffer.arrayOffset());
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return this.buffer.hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.buffer.memoryAddress() + this.adjustment;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i) {
        return this.buffer.getByte(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i) {
        return this.buffer.getShort(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i) {
        return this.buffer.getShortLE(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i) {
        return this.buffer.getUnsignedMedium(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i) {
        return this.buffer.getUnsignedMediumLE(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i) {
        return this.buffer.getInt(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i) {
        return this.buffer.getIntLE(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i) {
        return this.buffer.getLong(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i) {
        return this.buffer.getLongLE(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        ByteBuf byteBufSlice = this.buffer.slice(this.adjustment, this.length);
        byteBufSlice.setIndex(readerIndex(), writerIndex());
        return byteBufSlice;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i, int i2) {
        checkIndex0(i, i2);
        return this.buffer.copy(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i, int i2) {
        checkIndex0(i, i2);
        return this.buffer.slice(idx(i), i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkIndex0(i, i3);
        this.buffer.getBytes(idx(i), byteBuf, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex0(i, i3);
        this.buffer.getBytes(idx(i), bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        checkIndex0(i, byteBuffer.remaining());
        this.buffer.getBytes(idx(i), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i, int i2) {
        this.buffer.setByte(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i, int i2) {
        this.buffer.setShort(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i, int i2) {
        this.buffer.setShortLE(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i, int i2) {
        this.buffer.setMedium(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i, int i2) {
        this.buffer.setMediumLE(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i, int i2) {
        this.buffer.setInt(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i, int i2) {
        this.buffer.setIntLE(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i, long j) {
        this.buffer.setLong(idx(i), j);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i, long j) {
        this.buffer.setLongLE(idx(i), j);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex0(i, i3);
        this.buffer.setBytes(idx(i), bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkIndex0(i, i3);
        this.buffer.setBytes(idx(i), byteBuf, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        checkIndex0(i, byteBuffer.remaining());
        this.buffer.setBytes(idx(i), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) {
        checkIndex0(i, i2);
        this.buffer.getBytes(idx(i), outputStream, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        checkIndex0(i, i2);
        return this.buffer.getBytes(idx(i), gatheringByteChannel, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, InputStream inputStream, int i2) {
        checkIndex0(i, i2);
        return this.buffer.setBytes(idx(i), inputStream, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        checkIndex0(i, i2);
        return this.buffer.setBytes(idx(i), scatteringByteChannel, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.buffer.nioBufferCount();
    }

    @Override // io.netty.buffer.AbstractDerivedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i, int i2) {
        checkIndex0(i, i2);
        return this.buffer.nioBuffer(idx(i), i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i, int i2) {
        checkIndex0(i, i2);
        return this.buffer.nioBuffers(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractDerivedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i, int i2) {
        return nioBuffer(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex0(i, i2);
        int iForEachByte = this.buffer.forEachByte(idx(i), i2, byteProcessor);
        int i3 = this.adjustment;
        if (iForEachByte >= i3) {
            return iForEachByte - i3;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex0(i, i2);
        int iForEachByteDesc = this.buffer.forEachByteDesc(idx(i), i2, byteProcessor);
        int i3 = this.adjustment;
        if (iForEachByteDesc >= i3) {
            return iForEachByteDesc - i3;
        }
        return -1;
    }

    final int idx(int i) {
        return i + this.adjustment;
    }
}
