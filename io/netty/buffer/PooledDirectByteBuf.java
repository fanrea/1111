package io.netty.buffer;

import io.netty.util.Recycler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class PooledDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final Recycler<PooledDirectByteBuf> RECYCLER = new Recycler<PooledDirectByteBuf>() { // from class: io.netty.buffer.PooledDirectByteBuf.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        /* renamed from: newObject */
        public final PooledDirectByteBuf newObject2(Recycler.Handle<PooledDirectByteBuf> handle) {
            return new PooledDirectByteBuf(handle, 0);
        }
    };

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return 1;
    }

    static PooledDirectByteBuf newInstance(int i) {
        PooledDirectByteBuf pooledDirectByteBuf = RECYCLER.get();
        pooledDirectByteBuf.reuse(i);
        return pooledDirectByteBuf;
    }

    private PooledDirectByteBuf(Recycler.Handle<PooledDirectByteBuf> handle, int i) {
        super(handle, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public final ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final byte _getByte(int i) {
        return ((ByteBuffer) this.memory).get(idx(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final short _getShort(int i) {
        return ((ByteBuffer) this.memory).getShort(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final short _getShortLE(int i) {
        return ByteBufUtil.swapShort(_getShort(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final int _getUnsignedMedium(int i) {
        int iIdx = idx(i);
        return (((ByteBuffer) this.memory).get(iIdx + 2) & 255) | ((((ByteBuffer) this.memory).get(iIdx) & 255) << 16) | ((((ByteBuffer) this.memory).get(iIdx + 1) & 255) << 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final int _getUnsignedMediumLE(int i) {
        int iIdx = idx(i);
        return ((((ByteBuffer) this.memory).get(iIdx + 2) & 255) << 16) | (((ByteBuffer) this.memory).get(iIdx) & 255) | ((((ByteBuffer) this.memory).get(iIdx + 1) & 255) << 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final int _getInt(int i) {
        return ((ByteBuffer) this.memory).getInt(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final int _getIntLE(int i) {
        return ByteBufUtil.swapInt(_getInt(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final long _getLong(int i) {
        return ((ByteBuffer) this.memory).getLong(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final long _getLongLE(int i) {
        return ByteBufUtil.swapLong(_getLong(i));
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkDstIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            getBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else if (byteBuf.nioBufferCount() > 0) {
            ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers(i2, i3);
            for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
                int iRemaining = byteBuffer.remaining();
                getBytes(i, byteBuffer);
                i += iRemaining;
            }
        } else {
            byteBuf.setBytes(i2, this, i, i3);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        getBytes(i, bArr, i2, i3, false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getBytes(int i, byte[] bArr, int i2, int i3, boolean z) {
        ByteBuffer byteBufferDuplicate;
        checkDstIndex(i, i3, i2, bArr.length);
        if (z) {
            byteBufferDuplicate = internalNioBuffer();
        } else {
            byteBufferDuplicate = ((ByteBuffer) this.memory).duplicate();
        }
        int iIdx = idx(i);
        byteBufferDuplicate.clear().position(iIdx).limit(iIdx + i3);
        byteBufferDuplicate.get(bArr, i2, i3);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(byte[] bArr, int i, int i2) {
        checkReadableBytes(i2);
        getBytes(this.readerIndex, bArr, i, i2, true);
        this.readerIndex += i2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        getBytes(i, byteBuffer, false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getBytes(int i, ByteBuffer byteBuffer, boolean z) {
        ByteBuffer byteBufferDuplicate;
        checkIndex(i);
        int iMin = Math.min(capacity() - i, byteBuffer.remaining());
        if (z) {
            byteBufferDuplicate = internalNioBuffer();
        } else {
            byteBufferDuplicate = ((ByteBuffer) this.memory).duplicate();
        }
        int iIdx = idx(i);
        byteBufferDuplicate.clear().position(iIdx).limit(iIdx + iMin);
        byteBuffer.put(byteBufferDuplicate);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        checkReadableBytes(iRemaining);
        getBytes(this.readerIndex, byteBuffer, true);
        this.readerIndex += iRemaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        getBytes(i, outputStream, i2, false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getBytes(int i, OutputStream outputStream, int i2, boolean z) throws IOException {
        ByteBuffer byteBufferDuplicate;
        checkIndex(i, i2);
        if (i2 == 0) {
            return;
        }
        byte[] bArr = new byte[i2];
        if (z) {
            byteBufferDuplicate = internalNioBuffer();
        } else {
            byteBufferDuplicate = ((ByteBuffer) this.memory).duplicate();
        }
        byteBufferDuplicate.clear().position(idx(i));
        byteBufferDuplicate.get(bArr);
        outputStream.write(bArr);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf readBytes(OutputStream outputStream, int i) throws IOException {
        checkReadableBytes(i);
        getBytes(this.readerIndex, outputStream, i, true);
        this.readerIndex += i;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        return getBytes(i, gatheringByteChannel, i2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2, boolean z) {
        ByteBuffer byteBufferDuplicate;
        checkIndex(i, i2);
        if (i2 == 0) {
            return 0;
        }
        if (z) {
            byteBufferDuplicate = internalNioBuffer();
        } else {
            byteBufferDuplicate = ((ByteBuffer) this.memory).duplicate();
        }
        int iIdx = idx(i);
        byteBufferDuplicate.clear().position(iIdx).limit(iIdx + i2);
        return gatheringByteChannel.write(byteBufferDuplicate);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int readBytes(GatheringByteChannel gatheringByteChannel, int i) {
        checkReadableBytes(i);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i, true);
        this.readerIndex += bytes;
        return bytes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setByte(int i, int i2) {
        ((ByteBuffer) this.memory).put(idx(i), (byte) i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setShort(int i, int i2) {
        ((ByteBuffer) this.memory).putShort(idx(i), (short) i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setShortLE(int i, int i2) {
        _setShort(i, ByteBufUtil.swapShort((short) i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setMedium(int i, int i2) {
        int iIdx = idx(i);
        ((ByteBuffer) this.memory).put(iIdx, (byte) (i2 >>> 16));
        ((ByteBuffer) this.memory).put(iIdx + 1, (byte) (i2 >>> 8));
        ((ByteBuffer) this.memory).put(iIdx + 2, (byte) i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setMediumLE(int i, int i2) {
        int iIdx = idx(i);
        ((ByteBuffer) this.memory).put(iIdx, (byte) i2);
        ((ByteBuffer) this.memory).put(iIdx + 1, (byte) (i2 >>> 8));
        ((ByteBuffer) this.memory).put(iIdx + 2, (byte) (i2 >>> 16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setInt(int i, int i2) {
        ((ByteBuffer) this.memory).putInt(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setIntLE(int i, int i2) {
        _setInt(i, ByteBufUtil.swapInt(i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setLong(int i, long j) {
        ((ByteBuffer) this.memory).putLong(idx(i), j);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setLongLE(int i, long j) {
        _setLong(i, ByteBufUtil.swapLong(j));
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkSrcIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            setBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else if (byteBuf.nioBufferCount() > 0) {
            ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers(i2, i3);
            for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
                int iRemaining = byteBuffer.remaining();
                setBytes(i, byteBuffer);
                i += iRemaining;
            }
        } else {
            byteBuf.getBytes(i2, this, i, i3);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        checkSrcIndex(i, i3, i2, bArr.length);
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        int iIdx = idx(i);
        byteBufferInternalNioBuffer.clear().position(iIdx).limit(iIdx + i3);
        byteBufferInternalNioBuffer.put(bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        checkIndex(i, byteBuffer.remaining());
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        if (byteBuffer == byteBufferInternalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        int iIdx = idx(i);
        byteBufferInternalNioBuffer.clear().position(iIdx).limit(iIdx + byteBuffer.remaining());
        byteBufferInternalNioBuffer.put(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        checkIndex(i, i2);
        byte[] bArr = new byte[i2];
        int i3 = inputStream.read(bArr);
        if (i3 <= 0) {
            return i3;
        }
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        byteBufferInternalNioBuffer.clear().position(idx(i));
        byteBufferInternalNioBuffer.put(bArr, 0, i3);
        return i3;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        checkIndex(i, i2);
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        int iIdx = idx(i);
        byteBufferInternalNioBuffer.clear().position(iIdx).limit(iIdx + i2);
        try {
            return scatteringByteChannel.read(byteBufferInternalNioBuffer);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        ByteBuf byteBufDirectBuffer = alloc().directBuffer(i2, maxCapacity());
        byteBufDirectBuffer.writeBytes(this, i, i2);
        return byteBufDirectBuffer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        int iIdx = idx(i);
        return ((ByteBuffer) ((ByteBuffer) this.memory).duplicate().position(iIdx).limit(iIdx + i2)).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers(int i, int i2) {
        return new ByteBuffer[]{nioBuffer(i, i2)};
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int i, int i2) {
        checkIndex(i, i2);
        int iIdx = idx(i);
        return (ByteBuffer) internalNioBuffer().clear().position(iIdx).limit(iIdx + i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }
}
