package io.netty.buffer;

import io.netty.util.Recycler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
abstract class PooledByteBuf<T> extends AbstractReferenceCountedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    PoolThreadCache cache;
    protected PoolChunk<T> chunk;
    protected long handle;
    protected int length;
    int maxLength;
    protected T memory;
    protected int offset;
    private final Recycler.Handle<PooledByteBuf<T>> recyclerHandle;
    private ByteBuffer tmpNioBuf;

    protected abstract ByteBuffer newInternalNioBuffer(T t);

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected PooledByteBuf(Recycler.Handle<? extends PooledByteBuf<T>> handle, int i) {
        super(i);
        this.recyclerHandle = handle;
    }

    void init(PoolChunk<T> poolChunk, long j, int i, int i2, int i3, PoolThreadCache poolThreadCache) {
        this.chunk = poolChunk;
        this.handle = j;
        this.memory = poolChunk.memory;
        this.offset = i;
        this.length = i2;
        this.maxLength = i3;
        this.tmpNioBuf = null;
        this.cache = poolThreadCache;
    }

    void initUnpooled(PoolChunk<T> poolChunk, int i) {
        this.chunk = poolChunk;
        this.handle = 0L;
        this.memory = poolChunk.memory;
        this.offset = 0;
        this.maxLength = i;
        this.length = i;
        this.tmpNioBuf = null;
        this.cache = null;
    }

    final void reuse(int i) {
        maxCapacity(i);
        setRefCnt(1);
        setIndex0(0, 0);
        discardMarks();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.length;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf capacity(int i) {
        ensureAccessible();
        if (this.chunk.unpooled) {
            if (i == this.length) {
                return this;
            }
        } else {
            int i2 = this.length;
            if (i <= i2) {
                if (i < i2) {
                    int i3 = this.maxLength;
                    if (i > (i3 >>> 1)) {
                        if (i3 > 512) {
                            this.length = i;
                            setIndex(Math.min(readerIndex(), i), Math.min(writerIndex(), i));
                            return this;
                        }
                        if (i > i3 - 16) {
                            this.length = i;
                            setIndex(Math.min(readerIndex(), i), Math.min(writerIndex(), i));
                            return this;
                        }
                    }
                }
                return this;
            }
            if (i <= this.maxLength) {
                this.length = i;
                return this;
            }
        }
        this.chunk.arena.reallocate(this, i, true);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.chunk.arena.parent;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    protected final ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer byteBufferNewInternalNioBuffer = newInternalNioBuffer(this.memory);
        this.tmpNioBuf = byteBufferNewInternalNioBuffer;
        return byteBufferNewInternalNioBuffer;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected final void deallocate() {
        long j = this.handle;
        if (j >= 0) {
            this.handle = -1L;
            this.memory = null;
            this.chunk.arena.free(this.chunk, j, this.maxLength, this.cache);
            recycle();
        }
    }

    private void recycle() {
        this.recyclerHandle.recycle(this);
    }

    protected final int idx(int i) {
        return this.offset + i;
    }
}
