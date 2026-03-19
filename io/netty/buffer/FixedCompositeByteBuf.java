package io.netty.buffer;

import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class FixedCompositeByteBuf extends AbstractReferenceCountedByteBuf {
    private static final ByteBuf[] EMPTY = {Unpooled.EMPTY_BUFFER};
    private final ByteBufAllocator allocator;
    private final Object[] buffers;
    private final int capacity;
    private final boolean direct;
    private final int nioBufferCount;
    private final ByteOrder order;

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final boolean isWritable() {
        return false;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final boolean isWritable(int i) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return null;
    }

    FixedCompositeByteBuf(ByteBufAllocator byteBufAllocator, ByteBuf... byteBufArr) {
        super(Integer.MAX_VALUE);
        if (byteBufArr.length == 0) {
            this.buffers = EMPTY;
            this.order = ByteOrder.BIG_ENDIAN;
            this.nioBufferCount = 1;
            this.capacity = 0;
            this.direct = byteBufArr[0].isDirect();
        } else {
            ByteBuf byteBuf = byteBufArr[0];
            this.buffers = new Object[byteBufArr.length];
            this.buffers[0] = byteBuf;
            int iNioBufferCount = byteBuf.nioBufferCount();
            int i = byteBuf.readableBytes();
            this.order = byteBuf.order();
            boolean z = true;
            for (int i2 = 1; i2 < byteBufArr.length; i2++) {
                ByteBuf byteBuf2 = byteBufArr[i2];
                if (byteBufArr[i2].order() != this.order) {
                    throw new IllegalArgumentException("All ByteBufs need to have same ByteOrder");
                }
                iNioBufferCount += byteBuf2.nioBufferCount();
                i += byteBuf2.readableBytes();
                if (!byteBuf2.isDirect()) {
                    z = false;
                }
                this.buffers[i2] = byteBuf2;
            }
            this.nioBufferCount = iNioBufferCount;
            this.capacity = i;
            this.direct = z;
        }
        setIndex(0, capacity());
        this.allocator = byteBufAllocator;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf discardReadBytes() {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setByte(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setByte(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setShort(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setShort(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setShortLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setMedium(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setMedium(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setMediumLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setInt(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setInt(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setIntLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setLong(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setLong(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final void _setLongLE(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i, InputStream inputStream, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int maxCapacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf capacity(int i) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return this.order;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return this.direct;
    }

    private Component findComponent(int i) {
        ByteBuf byteBuf;
        boolean z;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            Object[] objArr = this.buffers;
            if (i2 < objArr.length) {
                Component component = null;
                Object obj = objArr[i2];
                if (obj instanceof ByteBuf) {
                    byteBuf = (ByteBuf) obj;
                    z = true;
                } else {
                    component = (Component) obj;
                    byteBuf = component.buf;
                    z = false;
                }
                i3 += byteBuf.readableBytes();
                if (i < i3) {
                    if (!z) {
                        return component;
                    }
                    Component component2 = new Component(i2, i3 - byteBuf.readableBytes(), byteBuf);
                    this.buffers[i2] = component2;
                    return component2;
                }
                i2++;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private ByteBuf buffer(int i) {
        Object obj = this.buffers[i];
        if (obj instanceof ByteBuf) {
            return (ByteBuf) obj;
        }
        return ((Component) obj).buf;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final byte getByte(int i) {
        return _getByte(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final byte _getByte(int i) {
        Component componentFindComponent = findComponent(i);
        return componentFindComponent.buf.getByte(i - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final short _getShort(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 2 > componentFindComponent.endOffset) {
            if (order() == ByteOrder.BIG_ENDIAN) {
                return (short) ((_getByte(i + 1) & 255) | ((_getByte(i) & 255) << 8));
            }
            return (short) (((_getByte(i + 1) & 255) << 8) | (_getByte(i) & 255));
        }
        return componentFindComponent.buf.getShort(i - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final short _getShortLE(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 2 > componentFindComponent.endOffset) {
            if (order() == ByteOrder.BIG_ENDIAN) {
                return (short) (((_getByte(i + 1) & 255) << 8) | (_getByte(i) & 255));
            }
            return (short) ((_getByte(i + 1) & 255) | ((_getByte(i) & 255) << 8));
        }
        return componentFindComponent.buf.getShortLE(i - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final int _getUnsignedMedium(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 3 > componentFindComponent.endOffset) {
            if (order() == ByteOrder.BIG_ENDIAN) {
                return (_getByte(i + 2) & 255) | ((_getShort(i) & 65535) << 8);
            }
            return ((_getByte(i + 2) & 255) << 16) | (_getShort(i) & 65535);
        }
        return componentFindComponent.buf.getUnsignedMedium(i - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final int _getUnsignedMediumLE(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 3 > componentFindComponent.endOffset) {
            if (order() == ByteOrder.BIG_ENDIAN) {
                return ((_getByte(i + 2) & 255) << 16) | (_getShortLE(i) & 65535);
            }
            return (_getByte(i + 2) & 255) | ((_getShortLE(i) & 65535) << 8);
        }
        return componentFindComponent.buf.getUnsignedMediumLE(i - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final int _getInt(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 4 > componentFindComponent.endOffset) {
            if (order() == ByteOrder.BIG_ENDIAN) {
                return (_getShort(i + 2) & 65535) | ((_getShort(i) & 65535) << 16);
            }
            return ((_getShort(i + 2) & 65535) << 16) | (_getShort(i) & 65535);
        }
        return componentFindComponent.buf.getInt(i - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final int _getIntLE(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 4 > componentFindComponent.endOffset) {
            if (order() == ByteOrder.BIG_ENDIAN) {
                return ((_getShortLE(i + 2) & 65535) << 16) | (_getShortLE(i) & 65535);
            }
            return (_getShortLE(i + 2) & 65535) | ((_getShortLE(i) & 65535) << 16);
        }
        return componentFindComponent.buf.getIntLE(i - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final long _getLong(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 8 > componentFindComponent.endOffset) {
            if (order() == ByteOrder.BIG_ENDIAN) {
                return ((_getInt(i) & C00oOOo.f362O8oO888) << 32) | (C00oOOo.f362O8oO888 & _getInt(i + 4));
            }
            return (_getInt(i) & C00oOOo.f362O8oO888) | ((C00oOOo.f362O8oO888 & _getInt(i + 4)) << 32);
        }
        return componentFindComponent.buf.getLong(i - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected final long _getLongLE(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 8 > componentFindComponent.endOffset) {
            if (order() == ByteOrder.BIG_ENDIAN) {
                return (_getIntLE(i) & C00oOOo.f362O8oO888) | ((C00oOOo.f362O8oO888 & _getIntLE(i + 4)) << 32);
            }
            return ((_getIntLE(i) & C00oOOo.f362O8oO888) << 32) | (C00oOOo.f362O8oO888 & _getIntLE(i + 4));
        }
        return componentFindComponent.buf.getLongLE(i - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkDstIndex(i, i3, i2, bArr.length);
        if (i3 == 0) {
            return this;
        }
        Component componentFindComponent = findComponent(i);
        int i4 = componentFindComponent.index;
        int i5 = componentFindComponent.offset;
        ByteBuf byteBufBuffer = componentFindComponent.buf;
        while (true) {
            int i6 = i - i5;
            int iMin = Math.min(i3, byteBufBuffer.readableBytes() - i6);
            byteBufBuffer.getBytes(i6, bArr, i2, iMin);
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            i5 += byteBufBuffer.readableBytes();
            if (i3 <= 0) {
                return this;
            }
            i4++;
            byteBufBuffer = buffer(i4);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iRemaining = byteBuffer.remaining();
        checkIndex(i, iRemaining);
        if (iRemaining == 0) {
            return this;
        }
        try {
            Component componentFindComponent = findComponent(i);
            int i2 = componentFindComponent.index;
            int i3 = componentFindComponent.offset;
            ByteBuf byteBufBuffer = componentFindComponent.buf;
            while (true) {
                int i4 = i - i3;
                int iMin = Math.min(iRemaining, byteBufBuffer.readableBytes() - i4);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBufBuffer.getBytes(i4, byteBuffer);
                i += iMin;
                iRemaining -= iMin;
                i3 += byteBufBuffer.readableBytes();
                if (iRemaining <= 0) {
                    return this;
                }
                i2++;
                byteBufBuffer = buffer(i2);
            }
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkDstIndex(i, i3, i2, byteBuf.capacity());
        if (i3 == 0) {
            return this;
        }
        Component componentFindComponent = findComponent(i);
        int i4 = componentFindComponent.index;
        int i5 = componentFindComponent.offset;
        ByteBuf byteBufBuffer = componentFindComponent.buf;
        while (true) {
            int i6 = i - i5;
            int iMin = Math.min(i3, byteBufBuffer.readableBytes() - i6);
            byteBufBuffer.getBytes(i6, byteBuf, i2, iMin);
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            i5 += byteBufBuffer.readableBytes();
            if (i3 <= 0) {
                return this;
            }
            i4++;
            byteBufBuffer = buffer(i4);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i, i2));
        }
        long jWrite = gatheringByteChannel.write(nioBuffers(i, i2));
        if (jWrite > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jWrite;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i, OutputStream outputStream, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return this;
        }
        Component componentFindComponent = findComponent(i);
        int i3 = componentFindComponent.index;
        int i4 = componentFindComponent.offset;
        ByteBuf byteBufBuffer = componentFindComponent.buf;
        while (true) {
            int i5 = i - i4;
            int iMin = Math.min(i2, byteBufBuffer.readableBytes() - i5);
            byteBufBuffer.getBytes(i5, outputStream, iMin);
            i += iMin;
            i2 -= iMin;
            i4 += byteBufBuffer.readableBytes();
            if (i2 <= 0) {
                return this;
            }
            i3++;
            byteBufBuffer = buffer(i3);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        ByteBuf byteBufBuffer = alloc().buffer(i2);
        try {
            byteBufBuffer.writeBytes(this, i, i2);
            return byteBufBuffer;
        } catch (Throwable th) {
            byteBufBuffer.release();
            throw th;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return this.nioBufferCount;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        if (this.buffers.length == 1) {
            ByteBuf byteBufBuffer = buffer(0);
            if (byteBufBuffer.nioBufferCount() == 1) {
                return byteBufBuffer.nioBuffer(i, i2);
            }
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i2).order(order());
        for (ByteBuffer byteBuffer : nioBuffers(i, i2)) {
            byteBufferOrder.put(byteBuffer);
        }
        byteBufferOrder.flip();
        return byteBufferOrder;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int i, int i2) {
        if (this.buffers.length == 1) {
            return buffer(0).internalNioBuffer(i, i2);
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers(int i, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return EmptyArrays.EMPTY_BYTE_BUFFERS;
        }
        RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance(this.buffers.length);
        try {
            Component componentFindComponent = findComponent(i);
            int i3 = componentFindComponent.index;
            int i4 = componentFindComponent.offset;
            ByteBuf byteBufBuffer = componentFindComponent.buf;
            while (true) {
                int i5 = i - i4;
                int iMin = Math.min(i2, byteBufBuffer.readableBytes() - i5);
                int iNioBufferCount = byteBufBuffer.nioBufferCount();
                if (iNioBufferCount == 0) {
                    throw new UnsupportedOperationException();
                }
                if (iNioBufferCount == 1) {
                    recyclableArrayListNewInstance.add(byteBufBuffer.nioBuffer(i5, iMin));
                } else {
                    Collections.addAll(recyclableArrayListNewInstance, byteBufBuffer.nioBuffers(i5, iMin));
                }
                i += iMin;
                i2 -= iMin;
                i4 += byteBufBuffer.readableBytes();
                if (i2 > 0) {
                    i3++;
                    byteBufBuffer = buffer(i3);
                } else {
                    return (ByteBuffer[]) recyclableArrayListNewInstance.toArray(new ByteBuffer[recyclableArrayListNewInstance.size()]);
                }
            }
        } finally {
            recyclableArrayListNewInstance.recycle();
        }
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

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected final void deallocate() {
        for (int i = 0; i < this.buffers.length; i++) {
            buffer(i).release();
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final String toString() {
        return super.toString().substring(0, r0.length() - 1) + ", components=" + this.buffers.length + ')';
    }

    static final class Component {
        private final ByteBuf buf;
        private final int endOffset;
        private final int index;
        private final int offset;

        Component(int i, int i2, ByteBuf byteBuf) {
            this.index = i;
            this.offset = i2;
            this.endOffset = i2 + byteBuf.readableBytes();
            this.buf = byteBuf;
        }
    }
}
