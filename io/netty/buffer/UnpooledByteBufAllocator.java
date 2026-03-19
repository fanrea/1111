package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class UnpooledByteBufAllocator extends AbstractByteBufAllocator {
    public static final UnpooledByteBufAllocator DEFAULT = new UnpooledByteBufAllocator(PlatformDependent.directBufferPreferred());

    @Override // io.netty.buffer.ByteBufAllocator
    public final boolean isDirectBufferPooled() {
        return false;
    }

    public UnpooledByteBufAllocator(boolean z) {
        super(z);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected final ByteBuf newHeapBuffer(int i, int i2) {
        return PlatformDependent.hasUnsafe() ? new UnpooledUnsafeHeapByteBuf(this, i, i2) : new UnpooledHeapByteBuf(this, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected final ByteBuf newDirectBuffer(int i, int i2) {
        ByteBuf unpooledDirectByteBuf;
        if (PlatformDependent.hasUnsafe()) {
            unpooledDirectByteBuf = new UnpooledUnsafeDirectByteBuf(this, i, i2);
        } else {
            unpooledDirectByteBuf = new UnpooledDirectByteBuf(this, i, i2);
        }
        return toLeakAwareBuffer(unpooledDirectByteBuf);
    }
}
