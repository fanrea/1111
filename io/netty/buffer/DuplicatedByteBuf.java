package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DuplicatedByteBuf extends AbstractDerivedByteBuf {
    private final ByteBuf buffer;

    public DuplicatedByteBuf(ByteBuf byteBuf) {
        super(byteBuf.maxCapacity());
        if (byteBuf instanceof DuplicatedByteBuf) {
            this.buffer = ((DuplicatedByteBuf) byteBuf).buffer;
        } else {
            this.buffer = byteBuf;
        }
        setIndex(byteBuf.readerIndex(), byteBuf.writerIndex());
        markReaderIndex();
        markWriterIndex();
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
        return this.buffer.capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i) {
        this.buffer.capacity(i);
        return this;
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
        return this.buffer.arrayOffset();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return this.buffer.hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.buffer.memoryAddress();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i) {
        return this.buffer.getByte(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i) {
        return this.buffer.getByte(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i) {
        return this.buffer.getShort(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i) {
        return this.buffer.getShort(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i) {
        return this.buffer.getShortLE(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i) {
        return this.buffer.getUnsignedMedium(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMedium(int i) {
        return this.buffer.getUnsignedMedium(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getUnsignedMediumLE(int i) {
        return this.buffer.getUnsignedMediumLE(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i) {
        return this.buffer.getInt(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i) {
        return this.buffer.getInt(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i) {
        return this.buffer.getIntLE(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i) {
        return this.buffer.getLong(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i) {
        return this.buffer.getLong(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLongLE(int i) {
        return this.buffer.getLongLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i, int i2) {
        return this.buffer.copy(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i, int i2) {
        return this.buffer.slice(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        this.buffer.getBytes(i, byteBuf, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        this.buffer.getBytes(i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        this.buffer.getBytes(i, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i, int i2) {
        this.buffer.setByte(i, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i, int i2) {
        this.buffer.setByte(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i, int i2) {
        this.buffer.setShort(i, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i, int i2) {
        this.buffer.setShort(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShortLE(int i, int i2) {
        this.buffer.setShortLE(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i, int i2) {
        this.buffer.setMedium(i, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i, int i2) {
        this.buffer.setMedium(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMediumLE(int i, int i2) {
        this.buffer.setMediumLE(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i, int i2) {
        this.buffer.setInt(i, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i, int i2) {
        this.buffer.setInt(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setIntLE(int i, int i2) {
        this.buffer.setIntLE(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i, long j) {
        this.buffer.setLong(i, j);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLong(int i, long j) {
        this.buffer.setLong(i, j);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setLongLE(int i, long j) {
        this.buffer.setLongLE(i, j);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        this.buffer.setBytes(i, bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        this.buffer.setBytes(i, byteBuf, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        this.buffer.setBytes(i, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) {
        this.buffer.getBytes(i, outputStream, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        return this.buffer.getBytes(i, gatheringByteChannel, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, InputStream inputStream, int i2) {
        return this.buffer.setBytes(i, inputStream, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        return this.buffer.setBytes(i, scatteringByteChannel, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.buffer.nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i, int i2) {
        return this.buffer.nioBuffers(i, i2);
    }

    @Override // io.netty.buffer.AbstractDerivedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i, int i2) {
        return nioBuffer(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        return this.buffer.forEachByte(i, i2, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        return this.buffer.forEachByteDesc(i, i2, byteProcessor);
    }
}
